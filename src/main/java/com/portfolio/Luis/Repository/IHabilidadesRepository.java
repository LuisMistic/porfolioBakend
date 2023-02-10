
package com.portfolio.Luis.Repository;

import com.portfolio.Luis.Entity.Habilidades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IHabilidadesRepository extends JpaRepository<Habilidades, Long>{
    
    
}
