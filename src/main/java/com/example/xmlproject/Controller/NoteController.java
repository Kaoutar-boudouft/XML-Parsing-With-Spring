package com.example.xmlproject.Controller;

import com.example.xmlproject.Model.Etudiant;
import com.example.xmlproject.Model.Module;
import com.example.xmlproject.Model.Note;
import com.example.xmlproject.Services.EtudiantService;
import com.example.xmlproject.Services.ModuleService;
import com.example.xmlproject.Model.NoteFilterRequest;
import com.example.xmlproject.Services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/Departements")
public class NoteController {

    private final NoteService noteService;
    private final ModuleService moduleService;
    private final EtudiantService etudiantService;

    @Autowired
    public NoteController(NoteService noteService, ModuleService moduleService, EtudiantService etudiantService) {
        this.noteService = noteService;
        this.moduleService = moduleService;
        this.etudiantService = etudiantService;
    }

    @GetMapping(path = "{idDep}/Filieres/{idFiliere}/Notes")
    public String getNotes(@PathVariable("idDep") String idDep, @PathVariable("idFiliere") String idFiliere, Model model){
       ArrayList<Note> notes = noteService.getNotes(idDep,idFiliere);
       ArrayList<Module> modules = moduleService.getModules(idDep,idFiliere);
       ArrayList<Etudiant> etudiants = etudiantService.getEtudiants(idDep,idFiliere);
        model.addAttribute("mod","");
        model.addAttribute("etu","");
        model.addAttribute("notex","");
        model.addAttribute("notes",notes);
        model.addAttribute("modules",modules);
        model.addAttribute("etudiants",etudiants);
        return "ListNotes";
    }

    @PostMapping(  "{idDep}/Filieres/{idFiliere}/Notes/Filtrer")
    public String filterNote(@ModelAttribute NoteFilterRequest noteFilterRequest,
                             @PathVariable("idDep") String idDep, @PathVariable("idFiliere") String idFiliere, Model model){
        if (!noteFilterRequest.validateRequest()){
            return "redirect:/Departements/{idDep}/Filieres/{idFiliere}/Notes";
        }
     ArrayList<Note> notes = noteService.filterNote(idDep,idFiliere,noteFilterRequest);
        ArrayList<Module> modules = moduleService.getModules(idDep,idFiliere);
        ArrayList<Etudiant> etudiants = etudiantService.getEtudiants(idDep,idFiliere);
        model.addAttribute("mod",noteFilterRequest.getModule());
        model.addAttribute("etu",noteFilterRequest.getEtudiant());
        model.addAttribute("notex",noteFilterRequest.getNote());
        model.addAttribute("notes",notes);
        model.addAttribute("modules",modules);
        model.addAttribute("etudiants",etudiants);
        return "ListNotes";
    }

}
