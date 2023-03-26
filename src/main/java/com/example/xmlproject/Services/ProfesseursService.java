package com.example.xmlproject.Services;

import com.example.xmlproject.Model.Professeur;
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
public class ProfesseursService extends XmlReader{

    public ProfesseursService() throws ParserConfigurationException, IOException, SAXException {
    }

    public ArrayList<Professeur> getProfesseurs(String idDep, String idFiliere) {
        try {
            ArrayList<Professeur> professeurs = new ArrayList<Professeur>();
            String xpathExpression = "/OFPPT/Departement[@idDep="+"'"+idDep+"'"+"]/Filiere[@idFiliere="+"'"+idFiliere+"'"+"]/Professeurs/Professeur";
            XPathExpression expr = xpath.compile(xpathExpression);
            NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
            for (int i = 0 ;i<nodes.getLength();i++){
                ArrayList<String> emails = new ArrayList<String>();
                ArrayList<String> telephones = new ArrayList<String>();
                Node professeurNode = nodes.item(i);
                if (professeurNode.getNodeType() == Node.ELEMENT_NODE){
                    Element professeur = (Element) professeurNode;
                    NodeList allEmails = professeur.getElementsByTagName("Email");
                    for (int j = 0 ;j<allEmails.getLength();j++){
                        String email = allEmails.item(j).getAttributes().item(0).getTextContent()+" : "+allEmails.item(j).getTextContent();
                        emails.add(email);
                    }
                    NodeList allPhones = professeur.getElementsByTagName("Telephone");
                    for (int j = 0 ;j<allPhones.getLength();j++){
                        String phone = allPhones.item(j).getAttributes().item(0).getTextContent()+" : "+allPhones.item(j).getTextContent();
                        telephones.add(phone);
                    }
                    professeurs.add(new Professeur(professeur.getAttribute("idProf"),
                            professeur.getElementsByTagName("Nom").item(0).getTextContent(),
                            professeur.getElementsByTagName("Prenom").item(0).getTextContent(),
                            professeur.getElementsByTagName("ResVille").item(0).getTextContent(),
                            professeur.getElementsByTagName("DOB").item(0).getAttributes().item(0).getTextContent(),
                            LocalDate.parse(professeur.getElementsByTagName("DOB").item(0).getTextContent()),
                            emails,telephones,
                            Float.parseFloat(professeur.getElementsByTagName("Salaire").item(0).getTextContent())
                    ));
                }
            }
            return professeurs;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public String getProfesseur(String idDep, String idFiliere, String idProf){
        try {
            String profNom ="";
            String xpathExpression = "/OFPPT/Departement[@idDep="+"'"+idDep+"'"+"]/Filiere[@idFiliere="+"'"+idFiliere+"'"+"]/Professeurs/Professeur[@idProf="+"'"+idProf+"'"+"]";
            XPathExpression expr = xpath.compile(xpathExpression);
            NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);

            Node professeurNode = nodes.item(0);
            if (professeurNode.getNodeType() == Node.ELEMENT_NODE){
                Element professeur = (Element) professeurNode;
                profNom = professeur.getElementsByTagName("Nom").item(0).getTextContent()
                        +" "+professeur.getElementsByTagName("Prenom").item(0).getTextContent();
            }
            return profNom;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public int getProfesseursNumber(){
        try {
            String xpathExpression = "count(/OFPPT/Departement/Filiere/Professeurs/Professeur)";
            XPathExpression expr = xpath.compile(xpathExpression);
            double count = (Double) expr.evaluate(document, XPathConstants.NUMBER);
            return (int) count;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
