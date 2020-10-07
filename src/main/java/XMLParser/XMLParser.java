package XMLParser;


import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class XMLParser {
    private ArrayList<MoveEventData> moveEventList = new ArrayList<>();
    private ArrayList<RollEventData> rollEventList = new ArrayList<>();
    private ArrayList<ItemEventData> itemEventList = new ArrayList<>();


    private Element element;

    public XMLParser()  {

        String eventText;
        String eventType;
        int id;
        int stamina;
        int strength;
        int speed;
        int sanity;
        double eventThreshold;
        int deltaX;
        int deltaY;
        int deltaFloor;


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
               element = (Element) node;

                if ( parseInt(getElement("eventType")) == 1){
                    id = parseInt(element.getAttribute("id"));
                    eventType = getElement("eventType");
                    eventText = getElement("eventText");
                    stamina = parseInt(getElement("stamina"));
                    strength = parseInt(getElement("strength"));
                    speed = parseInt(getElement("speed"));
                    sanity = parseInt(getElement("sanity"));


                    itemEventList.add(new ItemEventData(stamina,strength,speed,sanity,eventText,id,eventType));
                }
                if (parseInt(getElement("eventType")) == 3){
                    id = parseInt(element.getAttribute("id"));
                    eventType = getElement("eventType");
                    eventText = getElement("eventText");
                    eventThreshold = Double.parseDouble(getElement("eventThreshold"));
                    deltaX = parseInt(getElement("deltaX"));
                    deltaY = parseInt(getElement("deltaY"));
                    deltaFloor = parseInt(getElement("floorDelta"));

                    moveEventList.add(new MoveEventData(eventText,eventType,id,deltaX,deltaY,deltaFloor,eventThreshold));
                }

                if (parseInt(getElement("eventType")) == 2){
                    id = parseInt(element.getAttribute("id"));
                    eventThreshold = Double.parseDouble(getElement("eventThreshold"));
                    eventType = getElement("eventType");
                    eventText = getElement("eventText");
                    stamina = parseInt(getElement("stamina"));
                    strength = parseInt(getElement("strength"));
                    speed = parseInt(getElement("speed"));
                    sanity = parseInt(getElement("sanity"));

                    rollEventList.add(new RollEventData(stamina,strength,speed,sanity,eventThreshold,eventText,id,eventType));
                }


                /*

                if (node.getNodeType() == Node.ELEMENT_NODE){
                    System.out.println("dddddddddddddddddddddddd");
                    Element element = (Element) node;
                    System.out.println(element.getAttribute("id"));
                    System.out.println(element.getElementsByTagName("eventType").item(0).getTextContent());

                    if (element.getElementsByTagName("eventType").toString().equals("Item")){
                        System.out.println("lllllllllllllllllllllllllllllll");
                    }
                }

                 */



            }

            printList();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }


    }

    private void printList(){
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println(moveEventList.get(0).getDeltaFloor());
        System.out.println(moveEventList.get(0).getDeltaX());
        System.out.println(moveEventList.get(0).getDeltaY());
        System.out.println(moveEventList.get(0).getEventThreshold());
        System.out.println("--------------------------------------------------------");
        System.out.println(rollEventList.get(0).getEventThreshold());
        System.out.println(rollEventList.get(0).getSanity());
        System.out.println(rollEventList.get(0).getSpeed());
        System.out.println(rollEventList.get(0).getStamina());
        System.out.println(rollEventList.get(0).getStrength());
        System.out.println("--------------------------------------------------------");
        System.out.println(itemEventList.get(0).getSanity());
        System.out.println(itemEventList.get(0).getSpeed());
        System.out.println(itemEventList.get(0).getStamina());
        System.out.println(itemEventList.get(0).getStrength());
    }

    private String getElement(String str){
        return element.getElementsByTagName(str).item(0).getTextContent();


    }



}
