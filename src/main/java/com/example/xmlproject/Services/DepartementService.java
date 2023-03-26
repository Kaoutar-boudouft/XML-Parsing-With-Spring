package com.example.xmlproject.Services;

import com.example.xmlproject.Model.Departement;
import com.example.xmlproject.Model.Filiere;
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
public class DepartementService extends XmlReader{

    private final FiliereService filiereService;

    public DepartementService(FiliereService filiereService) throws ParserConfigurationException, IOException, SAXException {
        this.filiereService = filiereService;
    }

    public ArrayList<Departement> getDepartements(){
        try {
            ArrayList<Departement> allDepartements = new ArrayList<Departement>();
            String xpathExpression = "/OFPPT/Departement";
            XPathExpression expr = xpath.compile(xpathExpression);
            NodeList listDepartement = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
            for (int i = 0; i<listDepartement.getLength(); i++){
                Node departementNode = listDepartement.item(i);
                if (departementNode.getNodeType() == Node.ELEMENT_NODE){
                    Element departement = (Element) departementNode;
                    ArrayList<Filiere> departementFilieres = filiereService.getFilieres(departement.getAttribute(("idDep")));
                    allDepartements.add(new Departement(departement.getAttribute("idDep"),
                            departement.getElementsByTagName("NomDepartement").item(0).getTextContent(),departementFilieres));
                }
            }
            return allDepartements;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public int getDepartementsNumber(){
        try {
            String xpathExpression = "count(/OFPPT/Departement)";
            XPathExpression expr = xpath.compile(xpathExpression);
            double count = (Double) expr.evaluate(document, XPathConstants.NUMBER);
            return (int) count;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }




}
