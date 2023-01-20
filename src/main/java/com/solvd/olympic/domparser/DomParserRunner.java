package com.solvd.olympic.domparser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DomParserRunner {

    public static void main(String[] args) {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse("src/main/resources/athletes.xml");
            NodeList athleteList = doc.getElementsByTagName("athlete");
            for(int i=0; i<athleteList.getLength(); i++){
                Node e = athleteList.item(i);
                if(e.getNodeType()==Node.ELEMENT_NODE){
                    Element athlete = (Element) e;
                    String id = athlete.getAttribute("id");
                    NodeList nameList = athlete.getChildNodes();
                    for(int j=0;j<nameList.getLength();j++){
                        Node n = nameList.item(j);
                        if(n.getNodeType()==Node.ELEMENT_NODE){
                            Element name = (Element) n;
                            System.out.println("Athlete " + id + ": " + name.getTagName() + " = " + name.getTextContent());
                        }
                    }

                }
            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}
