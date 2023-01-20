package com.solvd.olympic.domparser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.IOException;

public class DomParserRunner {

    public static void write() throws ParserConfigurationException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        // root elements
        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("athletes");
        doc.appendChild(rootElement);

        //First athlete
        Element athlete = doc.createElement("athlete");
        // add staff to root
        rootElement.appendChild(athlete);
        // add xml attribute
        athlete.setAttribute("id", "1");

        //Name
        Element name = doc.createElement("athlete_name");
        name.setTextContent("Kim Woo-Jin");
        athlete.appendChild(name);

        //Age
        Element age = doc.createElement("age");
        age.setTextContent("30");
        athlete.appendChild(age);

        //Sport_id
        Element sportId = doc.createElement("sportId");
        sportId.setTextContent("1");
        athlete.appendChild(sportId);

        //Country_id
        Element countryId = doc.createElement("countryId");
        countryId.setTextContent("1");
        athlete.appendChild(countryId);

        //Coach_id
        Element coachId = doc.createElement("coachId");
        coachId.setTextContent("1");
        athlete.appendChild(coachId);

        //Competition_id
        Element competitionId = doc.createElement("competitionId");
        competitionId.setTextContent("1");
        athlete.appendChild(competitionId);

        //Second athlete
        Element athleteTwo = doc.createElement("athlete");
        rootElement.appendChild(athleteTwo);
        athleteTwo.setAttribute("id", "2");

        Element nameTwo = doc.createElement("athlete_name");
        nameTwo.setTextContent("Mete Gazos");
        athleteTwo.appendChild(nameTwo);

        Element ageTwo = doc.createElement("age");
        ageTwo.setTextContent("23");
        athleteTwo.appendChild(ageTwo);

        Element sportIdTwo = doc.createElement("sportId");
        sportIdTwo.setTextContent("1");
        athleteTwo.appendChild(sportIdTwo);

        Element countryIdTwo = doc.createElement("countryId");
        countryIdTwo.setTextContent("2");
        athleteTwo.appendChild(countryIdTwo);

        Element coachIdTwo = doc.createElement("coachId");
        coachIdTwo.setTextContent("1");
        athleteTwo.appendChild(coachIdTwo);

        Element competitionIdTwo = doc.createElement("competitionId");
        competitionIdTwo.setTextContent("1");
        athleteTwo.appendChild(competitionIdTwo);

        // write dom document to a file
        try (FileOutputStream output = new FileOutputStream("src/main/resources/athletes.xml")) {
            writeXml(doc, output);
        } catch (IOException | TransformerException e) {
            e.printStackTrace();
        }
    }

    private static void writeXml(Document doc, FileOutputStream output) throws TransformerException {

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        // pretty print XML
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(output);

        transformer.transform(source, result);
    }

    public static void read(){
        //Read XML
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

    public static void main(String[] args) throws ParserConfigurationException {
        write();
        read();
    }
}
