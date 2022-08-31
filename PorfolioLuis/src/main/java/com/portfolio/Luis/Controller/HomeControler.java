package com.portfolio.Luis.Controller;


import com.portfolio.Luis.Entity.Home;
import com.portfolio.Luis.Interface.IHomeService;

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

public class HomeControler {
    @Autowired IHomeService ihomeService;
    
    @GetMapping("home/traer")
    public List <Home> getHome(){
        return ihomeService.getHome();
            
    }
    
    @PostMapping ("/home/crear")
    public void createHome(@RequestBody Home home) {
    ihomeService.saveHome(home);
    
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/home/borrar/{id}")
    public String deleteHome(@PathVariable Long id){
    ihomeService.deleteHome(id);
    return "La persona fue eliminada correctamente";
    }
     @PreAuthorize("hasRole('ADMIN')")
     @PutMapping("/home/editar/{id}")
    public Home editHome(@PathVariable("id") long id, @RequestBody Home home) {
        home.setId(id);
        ihomeService.saveHome(home);
        return home;
    }
    @GetMapping(path = {"/home/{id}"})
    public Home findHome(@PathVariable("id") Long id) {
        return ihomeService.findHome(id);
    }
    
}
