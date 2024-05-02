package AuthMicroservice.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class navController {
	@GetMapping("/auth")
	public String auth() {
		return "AddAuth";
	}

}
