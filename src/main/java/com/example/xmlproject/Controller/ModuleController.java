package com.example.xmlproject.Controller;

import com.example.xmlproject.Model.Module;
import com.example.xmlproject.Services.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/Departements")
public class ModuleController {
    private final ModuleService moduleService;

    @Autowired
    public ModuleController(ModuleService moduleService) {
        this.moduleService = moduleService;
    }

    @GetMapping(path = "{idDep}/Filieres/{idFiliere}/Modules")
    public String getModules(@PathVariable("idDep") String idDep, @PathVariable("idFiliere") String idFiliere, Model model){
        ArrayList<Module> modules = moduleService.getModules(idDep,idFiliere);
        model.addAttribute("modules",modules);
        return "ListModules";
    }

}
