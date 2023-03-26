package com.example.xmlproject.Model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class NoteFilterRequest {
    private final String module;
    private final String etudiant;
    private final String note;

    public Boolean validateRequest(){
        if (this.module.equals("all") && this.etudiant.equals("all") && this.note.equals("all")){
            return false;
        }
        return true;
    }

}
