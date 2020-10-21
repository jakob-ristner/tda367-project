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

    /**
     * This is a DOM-pparser and gets all the nodes for the XML at once
     * It creates 3 lists of different data types that is later used in EventFactory
     */
    public XMLParser()  {

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
                    ItemEventData itemEventData = new ItemEventData();

                    itemEventData.setId(parseInt(element.getAttribute("id")));
                    itemEventData.setEventType(parseInt(getElement("eventType")));
                    itemEventData.setEventText(getElement("eventText"));
                    itemEventData.setStamina(parseInt(getElement("stamina")));
                    itemEventData.setStrength(parseInt(getElement("strength")));
                    itemEventData.setSpeed(parseInt(getElement("speed")));
                    itemEventData.setSanity(parseInt(getElement("sanity")));
                    itemEventData.setItemName(getElement("itemName"));



                    itemEventList.add(itemEventData);
                    eventDataList.add(itemEventData);

                }else if (parseInt(getElement("eventType")) == -2){
                    RollEventData rollEventData = new RollEventData();

                    rollEventData.setId(parseInt(element.getAttribute("id")));
                    rollEventData.setEventType(parseInt(getElement("eventType")));
                    rollEventData.setEventText(getElement("eventText"));
                    rollEventData.setEventThreshold(parseInt(getElement("eventThreshold")));
                    rollEventData.setStat(parseInt((getElement("statToRollOn"))));
                    rollEventData.setStatChange(parseInt(getElement("statChange")));



                    rollEventList.add(rollEventData);
                    eventDataList.add(rollEventData);

                }else if (parseInt(getElement("eventType")) == -3){
                    MoveEventData moveEventData = new MoveEventData();

                    moveEventData.setId(parseInt(element.getAttribute("id")));
                    moveEventData.setEventType(parseInt(getElement("eventType")));
                    moveEventData.setEventText(getElement("eventText"));
                    moveEventData.setEventThreshold(parseInt(getElement("eventThreshold")));
                    moveEventData.setStat(parseInt((getElement("statToRollOn"))));
                    moveEventData.setStatChange(parseInt(getElement("statChange")));
                    moveEventData.setDeltaFloor(parseInt(getElement("floorDelta")));
                    moveEventData.setDeltaY(parseInt(getElement("deltaY")));
                    moveEventData.setDeltaX(parseInt(getElement("deltaX")));
                    moveEventData.setPositiveEvent(Boolean.parseBoolean(getElement("positiveEvent")));






                    moveEventList.add(moveEventData);
                    eventDataList.add(moveEventData);
                }
            }

            //printList();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }


    }
/*
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

 */

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
