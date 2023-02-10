
package com.portfolio.Luis.Repository;

import com.portfolio.Luis.Entity.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProyectoRepository extends JpaRepository<Proyecto, Long>{
    
}
