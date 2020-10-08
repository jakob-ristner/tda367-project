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
        int eventType;
        int id;
        int stamina;
        int strength;
        int speed;
        int sanity;
        String stat;
        int statChange;
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
            NodeList nodeList = document.getElementsByTagName("event");

            for (int i = 0; i < nodeList.getLength(); i++) {

               element = (Element) nodeList.item(i);

                if ( parseInt(getElement("eventType")) == -1){
                    id = parseInt(element.getAttribute("id"));
                    eventType = parseInt(getElement("eventType"));
                    eventText = getElement("eventText");
                    stamina = parseInt(getElement("stamina"));
                    strength = parseInt(getElement("strength"));
                    speed = parseInt(getElement("speed"));
                    sanity = parseInt(getElement("sanity"));


                    itemEventList.add(new ItemEventData(stamina,strength,speed,sanity,eventText,id,eventType));
                }
                if (parseInt(getElement("eventType")) == -2){
                    id = parseInt(element.getAttribute("id"));
                    eventThreshold = Double.parseDouble(getElement("eventThreshold"));
                    eventType = parseInt(getElement("eventType"));
                    eventText = getElement("eventText");
                    stat = element.getElementsByTagName("statToRollOn").item(0).getTextContent();
                    statChange = parseInt(getElement("statChange"));


                    rollEventList.add(new RollEventData(statChange,stat,eventThreshold,eventText,id,eventType));
                }
                if (parseInt(getElement("eventType")) == -3){
                    id = parseInt(element.getAttribute("id"));
                    eventType = parseInt(getElement("eventType"));
                    eventText = getElement("eventText");
                    eventThreshold = Double.parseDouble(getElement("eventThreshold"));
                    deltaX = parseInt(getElement("deltaX"));
                    deltaY = parseInt(getElement("deltaY"));
                    deltaFloor = parseInt(getElement("floorDelta"));
                    stat = element.getElementsByTagName("statToRollOn").item(0).getTextContent();
                    statChange = parseInt(getElement("statChange"));

                    moveEventList.add(new MoveEventData(stat,statChange,eventText,eventType,id,deltaX,deltaY,deltaFloor,eventThreshold));
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
        System.out.println(itemEventList.get(0).getEventType());
        System.out.println(itemEventList.get(0).getEventText());
        System.out.println(itemEventList.get(0).getId());
        System.out.println(itemEventList.get(0).getSanity());
        System.out.println(itemEventList.get(0).getSpeed());
        System.out.println(itemEventList.get(0).getStamina());
        System.out.println(itemEventList.get(0).getStrength());
        System.out.println("--------------------------------------------------------");
        System.out.println(rollEventList.get(0).getEventType());
        System.out.println(rollEventList.get(0).getEventText());
        System.out.println(rollEventList.get(0).getId());
        System.out.println(rollEventList.get(0).getEventThreshold());
        System.out.println(moveEventList.get(0).getStat());
        System.out.println(moveEventList.get(0).getStatChange());
        System.out.println("--------------------------------------------------------");
        System.out.println(moveEventList.get(0).getEventType());
        System.out.println(moveEventList.get(0).getEventText());
        System.out.println(moveEventList.get(0).getId());
        System.out.println(moveEventList.get(0).getEventThreshold());
        System.out.println(moveEventList.get(0).getDeltaFloor());
        System.out.println(moveEventList.get(0).getDeltaX());
        System.out.println(moveEventList.get(0).getDeltaY());
        System.out.println(moveEventList.get(0).getStat());
        System.out.println(moveEventList.get(0).getStatChange());


    }

    private String getElement(String str){
        return element.getElementsByTagName(str).item(0).getTextContent();


    }



}
