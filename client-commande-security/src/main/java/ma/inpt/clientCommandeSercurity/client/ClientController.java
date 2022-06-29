package ma.inpt.clientCommandeSercurity.client;


import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;





@Controller
public class ClientController {
	
	public static String uploadDirectory = System.getProperty("user.dir")+"/uploads";
	@Autowired
	private ClientRepository repo ;
	
	@GetMapping("/clients")
	public String listClients(Model model) {
		List<Client> listclients = repo.findAll();
		model.addAttribute("listclients", listclients);
		model.addAttribute("client", new Client());
		System.out.println("Get /clients");
		return "clients";
	}
	
	@RequestMapping(value = "/clients/save", method = RequestMethod.POST)
    public RedirectView saveClient(@ModelAttribute("client") Client cl, @RequestParam("image") MultipartFile multipartFile) throws IOException {
		 String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
	        cl.setPhotos(fileName);
	         
	        Client savedClient = repo.save(cl);
	 
	        String uploadDir = "user-photos/" + savedClient.getId()+"/";
	 
	        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
        
	        
        
        System.out.println(uploadDir+fileName);
        return new RedirectView("redirect:/clients");
    }
	
	@RequestMapping("/clients/{id}")
    public ModelAndView showEditClientPage(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("clients");
        Client cl = repo.findById(id).get();
        mav.addObject("client", cl);
        System.out.println("Update / ");
        return mav;
        
    }
    @RequestMapping("/clients/delete/{id}")
    public String deleteClient(@PathVariable(name = "id") Long id) {
        repo.deleteById(id);
        System.out.println("Delete / ");
        return "redirect:/clients";
    }
}
