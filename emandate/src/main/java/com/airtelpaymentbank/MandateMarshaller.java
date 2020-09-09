package com.airtelpaymentbank;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.airtelpaymentbank.enach.emandate.model.ColltnAmt;
import com.airtelpaymentbank.enach.emandate.model.CrAccDtl;
import com.airtelpaymentbank.enach.emandate.model.Dbtr;
import com.airtelpaymentbank.enach.emandate.model.Document;
import com.airtelpaymentbank.enach.emandate.model.GrpHdr;
import com.airtelpaymentbank.enach.emandate.model.Info;
import com.airtelpaymentbank.enach.emandate.model.MaxAmt;
import com.airtelpaymentbank.enach.emandate.model.Mndt;
import com.airtelpaymentbank.enach.emandate.model.MndtAuthReq;
import com.airtelpaymentbank.enach.emandate.model.Ocrncs;
import com.airtelpaymentbank.enach.emandate.model.ReqInitPty;
import com.airtelpaymentbank.enach.emandate.util.Utils;
import com.sun.xml.bind.marshaller.NamespacePrefixMapper;
 
public class MandateMarshaller {
    public static void main(String[] args) throws FileNotFoundException, JAXBException {
        new MandateMarshaller().runMarshaller();
    }
 
    private void runMarshaller() throws JAXBException, FileNotFoundException {
        Document emp = createDocument();
         
        JAXBContext context = JAXBContext.newInstance(Document.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
         
        File file=new File("src/main/resources/mandate.xml");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        
        System.out.println(file.getAbsoluteFile());
         
        marshaller.marshal(emp, fileOutputStream);
    }
 
    private Document createDocument() {
    	MndtAuthReq mndtAuthReq=new MndtAuthReq();
		GrpHdr grpHdr=new GrpHdr();
		grpHdr.setCreDtTm(new Date());
		grpHdr.setNPCI_RefMsgId("000f0f29dc27f00000101b09c5227457f17");
		ReqInitPty reqInitPty=new ReqInitPty();
	
		Info info=new Info();
		info.setCatCode("COO1");
		info.setCatDesc("Insurance Company");
		info.setId("HDFC00001123456789");
		info.setName("LIC");
		info.setSpn_Bnk_Nm("State Bank Of India");
		info.setUtilCode(6543);
		
		reqInitPty.setInfo(info);
		grpHdr.setReqInitPty(reqInitPty);
		
		mndtAuthReq.setGrpHdr(grpHdr);
		
		Mndt Mndt=new Mndt();
		ColltnAmt colltnAmt=new ColltnAmt();
		colltnAmt.set__text(new BigDecimal(1200));
		colltnAmt.set_Ccy("INR");
		Mndt.setColltnAmt(colltnAmt);
		
		CrAccDtl crAccDtl=new CrAccDtl();
		crAccDtl.setAccNo("ACNo78912340");
		crAccDtl.setMmbId("HDFC0000001");
		crAccDtl.setNm("ABC India Limited");
		Mndt.setCrAccDtl(crAccDtl);
		
		Dbtr dbtr=new Dbtr();
		dbtr.setAccNo("ACNo123456");
		dbtr.setAcct_Type("SAVINGS");
		dbtr.setCons_Ref_No("XXX123");
		dbtr.setEmail("XX@XX.COM");
		dbtr.setMobile("+91-XXXXXXXXXX");
		dbtr.setNm("FAIROSE");
		dbtr.setPan("XXXXX9999X");
		dbtr.setPhone("+91-XXX-XXXXXXXX");
		Mndt.setDbtr(dbtr);
		
		MaxAmt maxAmt=new MaxAmt();
		maxAmt.set__text(new BigDecimal(1200));
		maxAmt.set_Ccy("INR");
		Mndt.setMaxAmt(maxAmt);
		
		Mndt.setMndt_Type("DEBIT");
		Mndt.setMndtId("UMRN");
		Mndt.setMndtReqId("000f0f29dc27f00000101b09c52b8e50037");
		Mndt.setSchm_Nm("ABC123");
		Ocrncs ocrncs=new Ocrncs();
		ocrncs.setFnlColltnDt("2018-04-05");
		ocrncs.setFrqcy("MNTH");
		ocrncs.setFrstColltnDt("2017-04-05");
		ocrncs.setSeqTp("RCUR");
		Mndt.setOcrncs(ocrncs);
		mndtAuthReq.setMndt(Mndt);
		Document emp = new Document(mndtAuthReq);
        return emp;
    }
}

