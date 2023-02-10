
package com.portfolio.Luis.Repository;

import com.portfolio.Luis.Entity.Home;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IHomeRepository extends JpaRepository<Home, Long>{
    
}
