

package com.lalithsoftware.finally;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.*;

import java.io.File;

public class RouteFinderMain {
    public static void main(String[] args) {
        try {
            // Parse the XML file
            File file = new File(args[1]);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);

            doc.getDocumentElement().normalize();

            // Get all elements with tag "employee"
            NodeList nList = doc.getElementsByTagName("employee");

            for (int i = 0; i < nList.getLength(); i++) {
                Element element = (Element) nList.item(i);
                
                String id = element.getElementsByTagName("id").item(0).getTextContent();
                String name = element.getElementsByTagName("name").item(0).getTextContent();
                
                System.out.println("ID: " + id + ", Name: " + name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
