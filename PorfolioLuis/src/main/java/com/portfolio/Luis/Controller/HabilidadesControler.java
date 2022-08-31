package com.portfolio.Luis.Controller;

import com.portfolio.Luis.Entity.Habilidades;
import com.portfolio.Luis.Interface.IHabilidadesService;
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
@CrossOrigin(origins = "http://localhost:4200")
public class HabilidadesControler {

    @Autowired
    IHabilidadesService ihabilidadesService;

    @GetMapping("habilidades/traer")
    public List<Habilidades> getHabilidades() {
        return ihabilidadesService.getHabilidades();

    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/habilidades/crear")
    public void createHabilidades(@RequestBody Habilidades habilidades) {
        ihabilidadesService.saveHabilidades(habilidades);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/habilidades/borrar/{id}")
    public String deleteHabilidades(@PathVariable Long id) {
        ihabilidadesService.deleteHabilidades(id);
        return "La persona fue eliminada correctamente";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/habilidades/editar/{id}")
    public Habilidades editHabilidades(@PathVariable("id") long id, @RequestBody Habilidades habilidades) {
        habilidades.setId(id);
        ihabilidadesService.saveHabilidades(habilidades);
        return habilidades;
    }
    @GetMapping(path = {"/habilidades/{id}"})
    public Habilidades findHabilidades(@PathVariable("id") Long id) {
        return ihabilidadesService.findHabilidades(id);
    }
}
