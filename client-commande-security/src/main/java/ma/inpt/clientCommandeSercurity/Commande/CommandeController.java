package ma.inpt.clientCommandeSercurity.Commande;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ma.inpt.clientCommandeSercurity.client.Client;
import ma.inpt.clientCommandeSercurity.client.ClientRepository;





@Controller
public class CommandeController {
	@Autowired
	private CommandeRepository commandeRepo;
	
	@Autowired
	private ClientRepository clientRepo;
	
 // ------------------------------Commande crud----------------------------------
    
    
    @GetMapping("/commandes")
    public String viewCommandePage(Model model) {
    	List<Commande> listcommandes = commandeRepo.findAll();
    	List<Client> listclients = clientRepo.findAll();
        model.addAttribute("listcommandes", listcommandes);
        model.addAttribute("listclients", listclients);
        model.addAttribute("commande", new Commande());
        System.out.println("Get /commande ");
        
        return "commandes";
    }
    
    
    // Search Interface. 
    @GetMapping("/search")
    public String viewSearchPage(Model model, @Param("keyword") String keyword) {
    	
    	
    	
    	List<Commande> listcommandes = commandeRepo.findAllByClient_Prenom(keyword);
    	
        model.addAttribute("listcommandes", listcommandes);
        
        
        System.out.println("Get /commande ");
        
        return "search";
    }
    
    

    @PostMapping("/commandes/save")
	public String saveCommande(Commande commande) {
		commandeRepo.save(commande);
		return "redirect:/commandes";
	}
    @RequestMapping("/commandes/edit/{id}")
    public ModelAndView showEditCommandePage(@PathVariable(name = "id") Long id_commande) {
        ModelAndView mav = new ModelAndView("commandes");
        Commande com = commandeRepo.findById(id_commande).get()	;
        mav.addObject("client", com);
        System.out.println("Update / ");
        
        return mav;
        
    }
    @RequestMapping("/commandes/delete/{id}")
    public String deleteClient(@PathVariable(name = "id") Long id_commande) {
        commandeRepo.deleteById( id_commande);
        System.out.println("Delete / ");
        return "redirect:/commandes";
    }
    
    
    @GetMapping("/idClients")
	public String getClients(Model model) {
		List<Client> listclients = clientRepo.findAll();
		model.addAttribute("listclients", listclients);
		return "idClients";
		
	}
	
	@GetMapping("/idDetails/{id}")
	public String getClientByID(Model model, @PathVariable(name = "id") Long id ) {
		String prenom = "El Mahdi";
		List<Commande> listcommandesById = commandeRepo.findAllByClient_id(id);
		model.addAttribute("listCommandesById", listcommandesById);
		
		
		
		return "idDetails";
		
	}
}
