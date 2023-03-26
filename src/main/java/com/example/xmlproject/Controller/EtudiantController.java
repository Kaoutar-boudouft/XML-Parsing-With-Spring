package com.example.xmlproject.Controller;

import com.example.xmlproject.Model.Etudiant;
import com.example.xmlproject.Services.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/Departements")
public class EtudiantController {

    private final EtudiantService etudiantService;

    @Autowired
    public EtudiantController(EtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

    @GetMapping(path = "{idDep}/Filieres/{idFiliere}/Etudiants")
    public String getEtudiants(@PathVariable("idDep") String idDep, @PathVariable("idFiliere") String idFiliere, Model model){
        ArrayList<Etudiant> etudiants = etudiantService.getEtudiants(idDep,idFiliere);
        model.addAttribute("etudiants",etudiants);
        return "ListEtudiants";
    }
}
