package ma.inpt.clientCommandeSercurity;



import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AppController {
	@GetMapping("")
	public String viewHomePage() {
		return "home";
	}
	
	
	
	
	
	
	
//	@RequestMapping(value = "/clients/save", method = RequestMethod.POST	)
//    public String saveClient(@ModelAttribute("client") Client cl,Model model, @RequestParam("files") MultipartFile[] files) {
//        repo.save(cl);
//        StringBuilder fileNames = new StringBuilder();
//        
//        for (MultipartFile file : files) {
//        	Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
//        	fileNames.append(file.getOriginalFilename());
//        	try {
//        			Files.write(fileNameAndPath, file.getBytes());
//        	}catch(IOException e) {
//        		e.printStackTrace();
//        	}
//        }
//        model.addAttribute("msg", "Seccessfuly uploaded file"+fileNames.toString());
//        System.out.println("Post / ");
//        return "redirect:/clients";
//    }
//	
}
