package source;

import java.io.File;
import java.io.IOException;

import org.xml.sax.SAXException;

/**
 * 
 * @author Simone Spaccarotella
 */
public class InternalModelGenerator {
	// il file XSLT che fa da foglio di stile
	private static File transformFile = new File("files/xhtml2xml.xslt");
	// il file XHTML annotato
	private static File annotatedPage = new File("files/annotated.html");
	// il file XML da parserizzare
	private static File internalModelFile = new File("files/internalModel.xml");
	// la grammatica per il file XML
	private static File xmlSchemaFile = new File("files/hrestSchema.xsd");
	
	
	public static void main(String[] args) {
		/*
		// creates a new transformer object from the "xhtml2xml.xslt"
		TransformerFactory xformFactory = TransformerFactory.newInstance();
		Transformer transformer = null;
		try {
			transformer = xformFactory.newTransformer(new StreamSource(transformFile));
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		}
		// transforms the page and save it in an XML file
		StreamResult result = new StreamResult(internalModelFile);
		StreamSource source = new StreamSource(annotatedPage);
		try {
			transformer.transform(source, result);
			System.out.println("Transform ok");
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		*/
		// parse the file xml with a xml schema
		XMLParser parser = new XMLParser();
		parser.setXMLSchema(xmlSchemaFile);
		try {
			parser.parse(internalModelFile);
			System.out.println("Parse ok");
		} catch (SAXException e) {
			System.out.println("Parse ko");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}