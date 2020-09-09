package com.airtelpaymentbank;

import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

import com.airtelpaymentbank.enach.emandate.model.Document;

public class MandateUnmarshaller {

	public static void main(String[] args) throws JAXBException, SAXException {
        new MandateUnmarshaller().runEmployeeUnmarshaller();
    }

	private void runEmployeeUnmarshaller() throws JAXBException, SAXException {
		JAXBContext context=JAXBContext.newInstance(Document.class);
		SchemaFactory sf=SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema=sf.newSchema(new File("src/main/resources/MandateRequest.xsd"));
		Unmarshaller unmarshaller=context.createUnmarshaller();
		unmarshaller.setSchema(schema); 
		unmarshaller.setEventHandler(new MandateValidationEventHandler());
		Document doc = (Document) unmarshaller.unmarshal(new File("src/main/resources/mandate.xml"));
		System.out.println("==============Unmarshalled==============");
        System.out.println(doc.getMndtAuthReq().getMndt().getMndtId());
	}
	
}
class MandateValidationEventHandler implements ValidationEventHandler {
    @Override
    public boolean handleEvent(ValidationEvent event) {
         System.out.println("\nEVENT");
            System.out.println("SEVERITY:  " + event.getSeverity());
            System.out.println("MESSAGE:  " + event.getMessage());
            System.out.println("LINKED EXCEPTION:  " + event.getLinkedException());
            System.out.println("LOCATOR");
            System.out.println("    LINE NUMBER:  " + event.getLocator().getLineNumber());
            System.out.println("    COLUMN NUMBER:  " + event.getLocator().getColumnNumber());
            System.out.println("    OFFSET:  " + event.getLocator().getOffset());
            System.out.println("    OBJECT:  " + event.getLocator().getObject());
            System.out.println("    NODE:  " + event.getLocator().getNode());
            System.out.println("    URL:  " + event.getLocator().getURL());
            return true;
    }
}
