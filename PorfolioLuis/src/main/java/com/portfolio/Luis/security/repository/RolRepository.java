

package com.portfolio.Luis.security.repository;

import com.portfolio.Luis.security.entity.Rol;
import com.portfolio.Luis.security.enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol>findByRolNombre(RolNombre rolNombre);
    
}
