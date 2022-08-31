
package com.portfolio.Luis.Interface;

import com.portfolio.Luis.Entity.Home;
import java.util.List;


public interface IHomeService {
    
    public List<Home> getHome();
    
    public void saveHome(Home home);
    
    
    public void deleteHome (Long id);
    
    public Home findHome (Long id);
    
}
