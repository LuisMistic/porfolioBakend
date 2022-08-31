package com.portfolio.Luis.Controller;

import com.portfolio.Luis.Entity.Persona;
import com.portfolio.Luis.Interface.IPersonaService;
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
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaControler {

    @Autowired
    IPersonaService ipersonaService;

    
    @GetMapping("personas/traer")
    public List<Persona> getPersona() {
        return ipersonaService.getPersona();

    }
  
    @PostMapping("/personas/crear")
    public void createPersona(@RequestBody Persona persona) {
        ipersonaService.savePersona(persona);
        
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id) {
        ipersonaService.deletePersona(id);
        return "La persona fue eliminada correctamente";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/personas/editar/{id}")
    public Persona editPersona(@PathVariable("id") long id, @RequestBody Persona persona) {
        persona.setId(id);
        ipersonaService.savePersona(persona);
        return persona;
    }
     @GetMapping(path = {"/persona/{id}"})
    public Persona findPersona(@PathVariable("id") Long id) {
        return ipersonaService.findPersona(id);
    }

}
