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
    private ArrayList<EventData> eventDataList = new ArrayList<>();

    private Element element;

    public XMLParser()  {

        String eventText;
        String itemName;
        int eventType;
        int id;
        int stamina;
        int strength;
        int speed;
        int sanity;
        int stat;
        int statChange;
        int eventThreshold;
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
                    itemName = getElement("itemName");


                    itemEventList.add(new ItemEventData(stamina,strength,speed,sanity,eventText,id,eventType, itemName));
                    eventDataList.add(new ItemEventData(stamina,strength,speed,sanity,eventText,id,eventType, itemName));
                }
                if (parseInt(getElement("eventType")) == -2){
                    id = parseInt(element.getAttribute("id"));
                    eventThreshold = Integer.parseInt(getElement("eventThreshold"));
                    eventType = parseInt(getElement("eventType"));
                    eventText = getElement("eventText");
                    stat = parseInt((getElement("statToRollOn"))); /**/
                    statChange = parseInt(getElement("statChange"));


                    rollEventList.add(new RollEventData(statChange,stat,eventThreshold,eventText,id,eventType));
                    eventDataList.add(new RollEventData(statChange,stat,eventThreshold,eventText,id,eventType));
                }
                if (parseInt(getElement("eventType")) == -3){
                    id = parseInt(element.getAttribute("id"));
                    eventType = parseInt(getElement("eventType"));
                    eventText = getElement("eventText");
                    eventThreshold = Integer.parseInt(getElement("eventThreshold"));
                    deltaX = parseInt(getElement("deltaX"));
                    deltaY = parseInt(getElement("deltaY"));
                    deltaFloor = parseInt(getElement("floorDelta"));
                    stat = stat = parseInt((getElement("statToRollOn")));;
                    statChange = parseInt(getElement("statChange"));

                    moveEventList.add(new MoveEventData(stat,statChange,eventText,eventType,id,deltaX,deltaY,deltaFloor,eventThreshold));
                    eventDataList.add(new MoveEventData(stat,statChange,eventText,eventType,id,deltaX,deltaY,deltaFloor,eventThreshold));
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
        System.out.println(rollEventList.get(0).getStat());
        System.out.println(rollEventList.get(0).getStatChange());
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

        ItemEventData itemEventData = (ItemEventData) eventDataList.get(0);
    }

    private String getElement(String str){
        return element.getElementsByTagName(str).item(0).getTextContent();


    }

    public ArrayList<EventData> getEventDataList() {
        return eventDataList;
    }

    public ArrayList<MoveEventData> getMoveEventList() {
        return moveEventList;
    }

    public ArrayList<RollEventData> getRollEventList() {
        return rollEventList;
    }

    public ArrayList<ItemEventData> getItemEventList() {
        return itemEventList;
    }
}
