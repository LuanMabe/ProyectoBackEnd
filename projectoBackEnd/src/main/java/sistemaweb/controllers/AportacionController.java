package sistemaweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import sistemaweb.services.AportacionService;

@Controller
@RequestMapping("/")
public class AportacionController {
    
    @Autowired
    private AportacionService aportacionService;
    
    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("empleadoList",this.aportacionService.consultar());
        return "index";
    }
    
}