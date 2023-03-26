package com.example.xmlproject.Services;

import com.example.xmlproject.Model.Note;
import com.example.xmlproject.Model.NoteFilterRequest;
import org.springframework.stereotype.Service;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import java.io.IOException;
import java.util.ArrayList;

@Service
public class NoteService extends XmlReader{
    final private ModuleService moduleService;
    final private EtudiantService etudiantService;

    public NoteService(ModuleService moduleService, EtudiantService etudiantService) throws ParserConfigurationException, IOException, SAXException {
        this.moduleService = moduleService;
        this.etudiantService = etudiantService;
    }

    public ArrayList<Note> getNotes(String idDep, String idFiliere) {
        try {
            ArrayList<Note> notes = new ArrayList<Note>();
            String xpathExpression = "/OFPPT/Departement[@idDep="+"'"+idDep+"'"+"]/Filiere[@idFiliere="+"'"+idFiliere+"'"+"]/Notes/Note";
            XPathExpression expr = xpath.compile(xpathExpression);
            NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
            for (int i = 0 ;i<nodes.getLength();i++){
                Node noteNode = nodes.item(i);
                if (noteNode.getNodeType() == Node.ELEMENT_NODE){
                    Element note = (Element) noteNode;
                    notes.add(new Note(moduleService.getModule(idDep,idFiliere,note.getAttribute("ModuleRef")),
                            etudiantService.getEtudiant(idDep,idFiliere,note.getAttribute("EtudiantRef")),
                            Float.parseFloat(note.getTextContent())
                    ));
                }
            }
            return notes;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Note> filterNote(String idDep, String idFiliere, NoteFilterRequest noteFilterRequest){
        try {
            ArrayList<Note> notes = new ArrayList<Note>();
            String xpathExpression = "/OFPPT/Departement[@idDep="+"'"+idDep+"'"+"]/Filiere[@idFiliere="+"'"+idFiliere+"'"+"]/Notes/"+
                    ((noteFilterRequest.getModule().equals("all") ? "Note" : ("Note[@ModuleRef="+"'"+noteFilterRequest.getModule()+"'"))+
                            (noteFilterRequest.getEtudiant().equals("all") ? ' ' :
                                    (noteFilterRequest.getModule().equals("all") ? ("[@EtudiantRef="+"'"+noteFilterRequest.getEtudiant()+"'") : (" and @EtudiantRef="+"'"+noteFilterRequest.getEtudiant()+"'")))
                    + (noteFilterRequest.getNote().equals("all") ? ']' :( (noteFilterRequest.getModule().equals("all") && (noteFilterRequest.getEtudiant().equals("all")) ? ("[text()"+(noteFilterRequest.getNote())+"'10'"+"]") : (" and text()"+(noteFilterRequest.getNote())+"'10'"+"]")))

                    ));
            XPathExpression expr = xpath.compile(xpathExpression);
            NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
            for (int i = 0 ;i<nodes.getLength();i++){
                Node noteNode = nodes.item(i);
                if (noteNode.getNodeType() == Node.ELEMENT_NODE){
                    Element note = (Element) noteNode;
                    notes.add(new Note(moduleService.getModule(idDep,idFiliere,note.getAttribute("ModuleRef")),
                            etudiantService.getEtudiant(idDep,idFiliere,note.getAttribute("EtudiantRef")),
                            Float.parseFloat(note.getTextContent())
                    ));
                }
            }
            return notes;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
