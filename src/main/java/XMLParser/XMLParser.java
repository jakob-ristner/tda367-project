package XMLParser;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class XMLParser {
    private final ArrayList<MoveEventData> moveEventList = new ArrayList<>();
    private final ArrayList<RollEventData> rollEventList = new ArrayList<>();
    private final ArrayList<ItemEventData> itemEventList = new ArrayList<>();

    private Element element;

    /**
     * This is a DOM-pparser and gets all the nodes for the XML at once
     * It creates 3 lists of different data types that is later used in EventFactory
     */
    public XMLParser() {

        try {
            File xmlFile = new File("src/main/java/XMLParser/eventIds");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFile);
            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName("event");

            for (int i = 0; i < nodeList.getLength(); i++) {

                element = (Element) nodeList.item(i);

                if (parseInt(getElement("eventType")) == -1) {
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

                } else if (parseInt(getElement("eventType")) == -2) {
                    RollEventData rollEventData = new RollEventData();

                    rollEventData.setId(parseInt(element.getAttribute("id")));
                    rollEventData.setEventType(parseInt(getElement("eventType")));
                    rollEventData.setEventText(getElement("eventText"));
                    rollEventData.setEventThreshold(parseInt(getElement("eventThreshold")));
                    rollEventData.setStat(parseInt((getElement("statToRollOn"))));
                    rollEventData.setStatChange(parseInt(getElement("statChange")));

                    rollEventList.add(rollEventData);

                } else if (parseInt(getElement("eventType")) == -3) {
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
                }
            }


        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }


    }


    private String getElement(String str) {
        return element.getElementsByTagName(str).item(0).getTextContent();


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
