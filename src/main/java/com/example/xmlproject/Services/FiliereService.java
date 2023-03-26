package com.example.xmlproject.Services;

import com.example.xmlproject.Model.Etudiant;
import com.example.xmlproject.Model.Filiere;
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
public class FiliereService extends XmlReader {

    public FiliereService() throws ParserConfigurationException, IOException, SAXException {
    }

    public ArrayList<Filiere> getFilieres(String idDep) {
        try {
            ArrayList<Filiere> filieres = new ArrayList<Filiere>();
            String xpathExpression = "/OFPPT/Departement[@idDep="+"'"+idDep+"'"+"]/Filiere";
            XPathExpression expr = xpath.compile(xpathExpression);
            NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);

            for (int i = 0 ;i<nodes.getLength();i++){
                Node filiereNode = nodes.item(i);
                if (filiereNode.getNodeType() == Node.ELEMENT_NODE){
                    Element filiere = (Element) filiereNode;
                    filieres.add(new Filiere(filiere.getAttribute("idFiliere"),
                            filiere.getElementsByTagName("FiliereLabel").item(0).getTextContent()
                    ));
                }
            }
            return filieres;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public Filiere getFiliere(String idDep, String idFiliere) {
       try {
           Filiere result = null;
           String xpathExpression = "/OFPPT/Departement[@idDep="+"'"+idDep+"'"+"]/Filiere[@idFiliere="+"'"+idFiliere+"'"+"]";
           XPathExpression expr = xpath.compile(xpathExpression);
           NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
               Node filiereNode = nodes.item(0);
               if (filiereNode.getNodeType() == Node.ELEMENT_NODE){
                   Element filiere = (Element) filiereNode;
                   result = new Filiere(filiere.getAttribute("idFiliere"),
                           filiere.getElementsByTagName("FiliereLabel").item(0).getTextContent());
               }
               return result;
       } catch (Exception e) {
           System.out.println(e.getMessage());
           throw new RuntimeException(e);
       }
    }

    public int getFilieresNumber(){
        try {
            String xpathExpression = "count(/OFPPT/Departement/Filiere)";
            XPathExpression expr = xpath.compile(xpathExpression);
            double count = (Double) expr.evaluate(document, XPathConstants.NUMBER);
            return (int) count;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

}
