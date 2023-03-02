package com.lovit.boutique.LovitBoutique.controladores;

import com.lovit.boutique.LovitBoutique.modelo.Producto;
import com.lovit.boutique.LovitBoutique.modelo.Tipo;
import com.lovit.boutique.LovitBoutique.repositorios.ProductoRepositorio;
import com.lovit.boutique.LovitBoutique.repositorios.TipoRepositorio;
import com.lovit.boutique.LovitBoutique.servicio.AlmacenServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminControlador {

    @Autowired
    private ProductoRepositorio productoRepositorio;

    @Autowired
    private TipoRepositorio tipoRepositorio;

    @Autowired
    private AlmacenServicio servicio;


    @GetMapping("")
    public ModelAndView verPaginaDeInicio(@PageableDefault(sort = "titulo", size = 5) Pageable pageable) {
        Page<Producto> productos = productoRepositorio.findAll(pageable);
        return new ModelAndView("admin/index").addObject("productos", productos);
    }

    @GetMapping("/prueba")
    public ModelAndView prueba() {
        return new ModelAndView("admin/prueba");
    }


    @GetMapping("/productos/nuevo")
    public ModelAndView mostrarFormularioDeNuevoProducto() {
        List<Tipo> tipos = tipoRepositorio.findAll(Sort.by("titulo"));
        return new ModelAndView("admin/nuevo-producto")
                .addObject("producto", new Producto())
                .addObject("tipos",tipos);
    }

    @PostMapping("/productos/nuevo")
    public ModelAndView registrarProducto(@Validated Producto producto, BindingResult bindingResult) {
        if(bindingResult.hasErrors() || producto.getPortada().isEmpty()) {
            if(producto.getPortada().isEmpty()) {
                bindingResult.rejectValue("portada","MultipartNotEmpty");
            }

            List<Tipo> tipos = tipoRepositorio.findAll(Sort.by("titulo"));
            return new ModelAndView("admin/nuevo-producto")
                    .addObject("producto",producto)
                    .addObject("tipos",tipos);
        }

        String rutaPortada = servicio.almacenarArchivo(producto.getPortada());
        producto.setRutaPortada(rutaPortada);

        productoRepositorio.save(producto);
        return new ModelAndView("redirect:/admin");
    }

    @GetMapping("/productos/{id}/editar")
    public ModelAndView mostrarFormilarioDeEditarProducto(@PathVariable Integer id) {
        Producto producto = productoRepositorio.getOne(id);
        List<Tipo> tipos = tipoRepositorio.findAll(Sort.by("titulo"));

        return new ModelAndView("admin/editar-producto")
                .addObject("producto",producto)
                .addObject("tipos",tipos);
    }

    @PostMapping("/productos/{id}/editar")
    public ModelAndView actualizarProducto(@PathVariable Integer id,@Validated Producto producto,BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            List<Tipo> tipos = tipoRepositorio.findAll(Sort.by("titulo"));
            return new ModelAndView("admin/editar-producto")
                    .addObject("producto",producto)
                    .addObject("tipos",tipos);
        }

        Producto productoBD = productoRepositorio.getOne(id);
        productoBD.setTitulo(producto.getTitulo());
        productoBD.setDescripcion(producto.getDescripcion());
        productoBD.setLargo(producto.getLargo());
        productoBD.setAncho(producto.getAncho());
        productoBD.setPeso(producto.getPeso());
        productoBD.setPrecio(producto.getPrecio());
        productoBD.setColor(producto.getColor());
        productoBD.setMinimoVenta(producto.getMinimoVenta());
        productoBD.setFechaRegistro(producto.getFechaRegistro());
        productoBD.setTipos(producto.getTipos());

        if(!producto.getPortada().isEmpty()) {
            servicio.eliminarArchivo(productoBD.getRutaPortada());
            String rutaPortada = servicio.almacenarArchivo(producto.getPortada());
            producto.setRutaPortada(rutaPortada);
        }

        productoRepositorio.save(productoBD);
        return new ModelAndView("redirect:/admin");
    }

    @PostMapping("/productos/{id}/eliminar")
    public String eliminarProducto(@PathVariable Integer id) {
        Producto producto = productoRepositorio.getOne(id);
        productoRepositorio.delete(producto);
        servicio.eliminarArchivo(producto.getRutaPortada());

        return "redirect:/admin";
    }




}
