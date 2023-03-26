package com.example.xmlproject.Services;

import com.example.xmlproject.Model.Module;
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
public class ModuleService extends XmlReader{

    final private ProfesseursService professeursService;

    public ModuleService(ProfesseursService professeursService) throws ParserConfigurationException, IOException, SAXException {
        this.professeursService = professeursService;
    }


    public ArrayList<Module> getModules(String idDep, String idFiliere) {
        try {
            ArrayList<Module> modules = new ArrayList<Module>();
            String xpathExpression = "/OFPPT/Departement[@idDep="+"'"+idDep+"'"+"]/Filiere[@idFiliere="+"'"+idFiliere+"'"+"]/Modules/Module";
            XPathExpression expr = xpath.compile(xpathExpression);
            NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);

            for (int i = 0 ;i<nodes.getLength();i++){
                Node moduleNode = nodes.item(i);
                if (moduleNode.getNodeType() == Node.ELEMENT_NODE){
                    Element module = (Element) moduleNode;
                    modules.add(new Module(module.getAttribute("idMod"),
                            professeursService.getProfesseur(idDep,idFiliere,module.getAttribute("refProf")),
                            module.getElementsByTagName("ModuleLabel").item(0).getTextContent(),
                            module.getElementsByTagName("MasseHorraire").item(0).getTextContent().replace("PT","")
                    ));
                }
            }
            return modules;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public String getModule(String idDep, String idFiliere, String idMod){
        try {
            String moduleNom ="";
            String xpathExpression = "/OFPPT/Departement[@idDep="+"'"+idDep+"'"+"]/Filiere[@idFiliere="+"'"+idFiliere+"'"+"]/Modules/Module[@idMod="+"'"+idMod+"'"+"]";
            XPathExpression expr = xpath.compile(xpathExpression);
            NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);

            Node moduleNode = nodes.item(0);
            if (moduleNode.getNodeType() == Node.ELEMENT_NODE){
                Element module = (Element) moduleNode;
                moduleNom = module.getElementsByTagName("ModuleLabel").item(0).getTextContent();
            }
            return moduleNom;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public int getModulesNumber(){
        try {
            String xpathExpression = "count(/OFPPT/Departement/Filiere/Modules/Module)";
            XPathExpression expr = xpath.compile(xpathExpression);
            double count = (Double) expr.evaluate(document, XPathConstants.NUMBER);
            return (int) count;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
