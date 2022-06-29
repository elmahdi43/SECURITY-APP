package ma.inpt.clientCommandeSercurity.commandeExecuion;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Runtime;

@Controller
public class CommandeExectionController {
	@GetMapping("/commandeExecution")
	  public String IpForm(Model model) {
	    model.addAttribute("ip", new Ip());
	    return "commandeExecution";
	  }
	
	
	
	  @PostMapping("/commandeExecution")
	  public String IpSubmit(@ModelAttribute Ip ip, Model model) throws IOException {
	    try {
	    	String comm = ip.getContent();
	 	   
	        Process process = Runtime.getRuntime().exec("ping "+	comm);
	        BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));

	        String s = null;
	        int i=0;
	        while ((s = stdInput.readLine()) != null && i < 10) {
	        	ip.setContent(s);
	        	i++;
	        }
	    }
	    catch (IOException e) {
	        System.out.println("Error executing command");
	    }
	    
	    model.addAttribute("ip", ip);
	    System.out.println("Post /");
	    return "commandeExecution";
	  }

}

