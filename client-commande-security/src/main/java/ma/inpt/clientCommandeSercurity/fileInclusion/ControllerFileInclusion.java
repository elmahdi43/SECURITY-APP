package ma.inpt.clientCommandeSercurity.fileInclusion;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerFileInclusion {

		@GetMapping({"/fi"})
		public String getFileInclusion() {
			
			return "fi";
		}
}
