package com.example.xmlproject.Services;

import com.example.xmlproject.Model.Etudiant;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

@Service
public class EtudiantService extends XmlReader{

    public EtudiantService() throws ParserConfigurationException, IOException, SAXException {
    }

    public ArrayList<Etudiant> getEtudiants(String idDep, String idFiliere) {
        try {
            ArrayList<Etudiant> etudiants = new ArrayList<Etudiant>();
            String xpathExpression = "/OFPPT/Departement[@idDep="+"'"+idDep+"'"+"]/Filiere[@idFiliere="+"'"+idFiliere+"'"+"]/Etudiants/Etudiant";
            XPathExpression expr = xpath.compile(xpathExpression);
            NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);

            for (int i = 0 ;i<nodes.getLength();i++){
                Node etudiantsNode = nodes.item(i);
                if (etudiantsNode.getNodeType() == Node.ELEMENT_NODE){
                    Element etudiant = (Element) etudiantsNode;
                    etudiants.add(new Etudiant(etudiant.getAttribute("idStu"),
                            etudiant.getElementsByTagName("Nom").item(0).getTextContent(),
                            etudiant.getElementsByTagName("Prenom").item(0).getTextContent(),
                            etudiant.getElementsByTagName("ResVille").item(0).getTextContent(),
                            etudiant.getElementsByTagName("EtudiantEmail").item(0).getTextContent(),
                            etudiant.getElementsByTagName("EtudiantTelephone").item(0).getTextContent(),
                            etudiant.getElementsByTagName("AnneBacalaureat").item(0).getTextContent(),
                            etudiant.getElementsByTagName("DOB").item(0).getAttributes().item(0).getTextContent(),
                            LocalDate.parse(etudiant.getElementsByTagName("DOB").item(0).getTextContent())
                           ));
                }
            }
            return etudiants;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public String getEtudiant(String idDep, String idFiliere, String idStu){
        try {
            String etudiantNom ="";
            String xpathExpression = "/OFPPT/Departement[@idDep="+"'"+idDep+"'"+"]/Filiere[@idFiliere="+"'"+idFiliere+"'"+"]/Etudiants/Etudiant[@idStu="+"'"+idStu+"'"+"]";
            XPathExpression expr = xpath.compile(xpathExpression);
            NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);

            Node etudiantNode = nodes.item(0);
            if (etudiantNode.getNodeType() == Node.ELEMENT_NODE){
                Element etudiant = (Element) etudiantNode;
                etudiantNom = etudiant.getElementsByTagName("Nom").item(0).getTextContent()+
                " "+ etudiant.getElementsByTagName("Prenom").item(0).getTextContent();
            }
            return etudiantNom;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public int getEtudiantsNumber(){
        try {
            String xpathExpression = "count(/OFPPT/Departement/Filiere/Etudiants/Etudiant)";
            XPathExpression expr = xpath.compile(xpathExpression);
            double count = (Double) expr.evaluate(document, XPathConstants.NUMBER);
            return (int) count;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
