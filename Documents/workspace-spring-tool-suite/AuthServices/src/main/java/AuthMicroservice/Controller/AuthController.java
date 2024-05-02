package AuthMicroservice.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import AuthMicroservice.Service.AuthService;
import AuthMicroservice.entity.Auth;

@Controller
public class AuthController {
	 @Autowired
	    private AuthService authService;
	 
	
	 @PostMapping("/auth/add")
	    public String addAuth(Auth auth) {
	        authService.saveAuth(auth);
	        return "redirect:localhost:8080/home"; // Redirect to the home page after successful submission
	    }
	    

}

