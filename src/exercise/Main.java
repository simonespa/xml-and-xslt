package exercise;

import java.io.File;
import java.io.IOException;

import org.xml.sax.SAXException;

import parser.XMLParser;

public class Main {

	private static File xmlFile = new File("files/ex2.xml");
	// la grammatica per il file XML
	private static File xmlSchemaFile = new File("xmlSchemaEx/ex1.xsd");

	public static void main(String[] args) {
		// parse the file xml with a xml schema
		XMLParser parser = new XMLParser();
		try {
			parser.setDTDValidation(true);
			parser.parse(xmlFile);
			System.out.println("Parse ok");
		} catch (SAXException e) {
			System.out.println("Parse ko");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}