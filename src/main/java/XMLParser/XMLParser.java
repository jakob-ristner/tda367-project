package XMLParser;


import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;

public class XMLParser {
    public XMLParser()  {
        try {
            File xmlFile = new File("src/main/java/XMLParser/eventIds");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFile);
            document.getDocumentElement().normalize();
            System.out.println("Root " + document.getDocumentElement().getNodeName());
            NodeList nodeList = document.getElementsByTagName("event");
            System.out.println("......................................");

            for (int i = 0; i < nodeList.getLength(); i++) {
               Node node = nodeList.item(i);
                System.out.println("\nCurrent element: " + node.getNodeName());

                if (node.getNodeType() == Node.ELEMENT_NODE){
                    System.out.println("dddddddddddddddddddddddd");
                    Element element = (Element) node;
                    System.out.println(element.getAttribute("id"));

                    System.out.println(element.getElementsByTagName(""));
                }
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }



}
