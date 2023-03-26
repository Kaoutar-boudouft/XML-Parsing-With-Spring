package com.example.xmlproject.Controller;

import com.example.xmlproject.Model.Departement;
import com.example.xmlproject.Model.Filiere;
import com.example.xmlproject.Services.DepartementService;
import com.example.xmlproject.Services.FiliereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/Departements")
public class FiliereController {

    private final FiliereService filiereService;

    @Autowired
    public FiliereController(FiliereService filiereService) {
        this.filiereService = filiereService;
    }

    @GetMapping(path = "{idDep}/Filieres/{idFiliere}")
    public String getFiliere(@PathVariable("idDep") String idDep,@PathVariable("idFiliere") String idFiliere,Model model){
        Filiere filiere = filiereService.getFiliere(idDep,idFiliere);
        model.addAttribute("filiere",filiere);
        model.addAttribute("idDep",idDep);
        return "DetailsFiliere";
    }


}
