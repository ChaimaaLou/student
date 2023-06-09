package Controller;

import java.sql.SQLException;

import Entity.User;
import service.authservice;

public class authController {
    
    private authservice authService;
    
    public authController(authservice authService) {
        this.authService = authService;
    }
    
    public boolean authenticate(String username, String password) throws Exception  {
        User authEntity = new User(username, password);
        return authService.authenticate(authEntity);
    }
}
