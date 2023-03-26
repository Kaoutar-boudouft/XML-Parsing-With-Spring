package com.example.xmlproject.Controller;

import com.example.xmlproject.Model.Departement;
import com.example.xmlproject.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/")
public class HomeController {

    private final DepartementService departementService;
    private final FiliereService filiereService;
    private final ModuleService moduleService;
    private final EtudiantService etudiantService;
    private final ProfesseursService professeursService;

    @Autowired
    public HomeController(DepartementService departementService, FiliereService filiereService, ModuleService moduleService, EtudiantService etudiantService, ProfesseursService professeursService) {
        this.departementService = departementService;
        this.filiereService = filiereService;
        this.moduleService = moduleService;
        this.etudiantService = etudiantService;
        this.professeursService = professeursService;
    }

    @GetMapping
    public String Home(Model model){
         ArrayList<Departement> departements = departementService.getDepartements();
         int depCount = departementService.getDepartementsNumber();
         int filCount = filiereService.getFilieresNumber();
         int ModCount = moduleService.getModulesNumber();
         int etuCount = etudiantService.getEtudiantsNumber();
         int profCount = professeursService.getProfesseursNumber();
         model.addAttribute("departements",departements);
         model.addAttribute("depCount",depCount);
         model.addAttribute("filCount",filCount);
         model.addAttribute("ModCount",ModCount);
         model.addAttribute("etuCount",etuCount);
         model.addAttribute("profCount",profCount);
         return "index";
    }
}
