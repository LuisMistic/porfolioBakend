
package com.portfolio.Luis.Interface;

import com.portfolio.Luis.Entity.Habilidades;
import java.util.List;




public interface IHabilidadesService {
     public List<Habilidades> getHabilidades();
    
    public void saveHabilidades(Habilidades habilidades);
    
    
    public void deleteHabilidades (Long id);
    
    public Habilidades findHabilidades (Long id);
}
