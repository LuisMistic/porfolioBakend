
package com.portfolio.Luis.Controller;

import com.portfolio.Luis.Entity.Proyecto;
import com.portfolio.Luis.Interface.IProyectoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins="http://localhost:4200")
public class ProyectoControler {
    
     @Autowired IProyectoService iproyectoService;
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("proyecto/traer")
    public List <Proyecto> getProyecto(){
        return iproyectoService.getProyecto();
            
    }
    
    @PostMapping ("/proyecto/crear")
    public void createProyecto(@RequestBody Proyecto proyecto) {
    iproyectoService.saveProyecto(proyecto);
    
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/proyecto/borrar/{id}")
    public String deleteProyecto(@PathVariable Long id){
    iproyectoService.deleteProyecto(id);
    return "La persona fue eliminada correctamente";
    }
       @PreAuthorize("hasRole('ADMIN')")
       @PutMapping("/proyecto/editar/{id}")
    public Proyecto editProyecto(@PathVariable("id") long id, @RequestBody Proyecto proyecto) {
        proyecto.setId(id);
        iproyectoService.saveProyecto(proyecto);
        return proyecto;
    }
      @GetMapping(path = {"/proyecto/{id}"})
    public Proyecto findProyecto(@PathVariable("id") Long id) {
        return iproyectoService.findProyecto(id);
    }
}