package com.example.xmlproject.Services;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;

abstract class XmlReader {
    final protected XPathFactory xpathFactory = XPathFactory.newInstance();
    final protected XPath xpath = xpathFactory.newXPath();
    final protected File xmlDoc = new File("src/main/resources/static/XmlFiles/OFPPTXmlUsingXsd.xml");
    final protected DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
    protected Document document;

    public XmlReader() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        document = documentBuilder.parse(xmlDoc);
    }
}
