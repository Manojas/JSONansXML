package com.mindtree.json.services;

import java.io.File;
import java.sql.Connection;
import java.sql.Statement;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.*;

import com.mindtree.json.utility.GetConnection;

public class XmlToDatabase {

	public String xmlToDatabase() {
		// TODO Auto-generated method stub
		try {
			Connection con = GetConnection.getConnection();

			Statement st = con.createStatement();

			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(new File("D:/xmlToDatabase.xml"));

			doc.getDocumentElement().normalize();

			System.out.println("Root element of the doc is " + doc.getDocumentElement().getNodeName());

			NodeList listOfPersons = doc.getElementsByTagName("player");

			for (int s = 0; s < listOfPersons.getLength(); s++) {

				Node firstPersonNode = listOfPersons.item(s);

				if (firstPersonNode.getNodeType() == Node.ELEMENT_NODE) {

					Element firstPersonElement = (Element) firstPersonNode;

					NodeList idList = firstPersonElement.getElementsByTagName("id");
					Element idElement = (Element) idList.item(0);

					NodeList textFNList = idElement.getChildNodes();
					String id = ((Node) textFNList.item(0)).getNodeValue().trim();

					NodeList ageList = firstPersonElement.getElementsByTagName("age");
					Element ageElement = (Element) ageList.item(0);

					NodeList textFNList1 = ageElement.getChildNodes();
					String age = ((Node) textFNList1.item(0)).getNodeValue().trim();

					NodeList nameList = firstPersonElement.getElementsByTagName("name");
					Element nameElement = (Element) nameList.item(0);

					NodeList textLNList = nameElement.getChildNodes();
					String name = ((Node) textLNList.item(0)).getNodeValue().trim();

					int i = st.executeUpdate("insert into player3 values('" + id + "','" + age + "','" + name + "')");
				}
			}
			System.out.println("Data is successfully inserted!");
		} catch (Exception err) {
			System.out.println(" " + err.getMessage());
		}
		return null;
	}

}
