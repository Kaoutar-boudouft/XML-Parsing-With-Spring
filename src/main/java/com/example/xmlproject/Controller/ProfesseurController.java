package com.example.xmlproject.Controller;

import com.example.xmlproject.Model.Professeur;
import com.example.xmlproject.Services.ProfesseursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/Departements")
public class ProfesseurController {

    private final ProfesseursService professeursService;

    @Autowired
    public ProfesseurController(ProfesseursService professeursService) {
        this.professeursService = professeursService;
    }

    @GetMapping(path = "{idDep}/Filieres/{idFiliere}/Professeurs")
    public String getProfesseurs(@PathVariable("idDep") String idDep, @PathVariable("idFiliere") String idFiliere, Model model){
        ArrayList<Professeur> professeurs = professeursService.getProfesseurs(idDep,idFiliere);
        model.addAttribute("professeurs",professeurs);
        return "ListProfesseurs";
    }


}
