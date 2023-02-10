
package com.portfolio.Luis.Repository;

import com.portfolio.Luis.Entity.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository 
public interface IExperienciaRepository extends JpaRepository<Experiencia, Long>{
    
}
