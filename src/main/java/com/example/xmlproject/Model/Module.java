package com.example.xmlproject.Model;

public class Module {

    private String idMod,refProf,ModuleLabel,MasseHorraire;

    public Module() {}

    public Module(String idMod, String refProf, String moduleLabel, String masseHorraire) {
        this.idMod = idMod;
        this.refProf = refProf;
        ModuleLabel = moduleLabel;
        MasseHorraire = masseHorraire;
    }

    public String getIdMod() {
        return idMod;
    }

    public void setIdMod(String idMod) {
        this.idMod = idMod;
    }

    public String getRefProf() {
        return refProf;
    }

    public void setRefProf(String refProf) {
        this.refProf = refProf;
    }

    public String getModuleLabel() {
        return ModuleLabel;
    }

    public void setModuleLabel(String moduleLabel) {
        ModuleLabel = moduleLabel;
    }

    public String getMasseHorraire() {
        return MasseHorraire;
    }

    public void setMasseHorraire(String masseHorraire) {
        MasseHorraire = masseHorraire;
    }
}
