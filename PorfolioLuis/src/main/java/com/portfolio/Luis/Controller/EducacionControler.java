
package com.portfolio.Luis.Controller;

import com.portfolio.Luis.Entity.Educacion;
import com.portfolio.Luis.Interface.IEducacionService;
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
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins="http://localhost:4200")
public class EducacionControler {
    
    @Autowired IEducacionService ieducacionService;
    
    @GetMapping("educacion/traer")
    public List <Educacion> getEducacion(){
        return ieducacionService.getEducacion();
            
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("/educacion/crear")
    public void createEducacion(@RequestBody Educacion educacion) {
    ieducacionService.saveEducacion(educacion);
    
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/educacion/borrar/{id}")
    public String deleteEducacion(@PathVariable Long id){
    ieducacionService.deleteEducacion(id);
    return "La persona fue eliminada correctamente";
    }
    @PreAuthorize("hasRole('ADMIN')")
   @PutMapping("/educacion/editar/{id}")
    public Educacion editEducacion(@PathVariable("id") long id, @RequestBody Educacion educacion) {
        educacion.setId(id);
        ieducacionService.saveEducacion(educacion);
        return educacion;
    }
    @GetMapping(path = {"/educacion/{id}"})
    public Educacion findEducacion(@PathVariable("id") Long id) {
        return ieducacionService.findEducacion(id);
    }
    
}
