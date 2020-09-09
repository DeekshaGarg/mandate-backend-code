package com.airtelpaymentbank.enach.npcimockserver.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;

import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.airtelpaymentbank.enach.npcimockserver.model.Dummy;

@RestController
public class DummyController {
	
	private static String UPLOADED_FOLDER = "G://temp//";

	@Autowired
	private RestTemplate restTemplate;

	// Java method to create SHA-25 checksum
	public static String getSHA256Hash(String data) {
		String result = null;
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(data.getBytes("UTF_8"));
			return bytesToHex(hash); // make it printable
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	/**
	 * Use javax.xml.bind.DatatypeConverter class in JDK to convert byte array to a
	 * hexadecimal string. Note that this generates hexadecimal in lower case.
	 * 
	 * @param hash
	 * @return
	 */
	private static String bytesToHex(byte[] hash) {
		return DatatypeConverter.printHexBinary(hash).toLowerCase();
	}

	@PostMapping(value = "/some-method", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public void someMethod() {

	}

	public void someMethodProducer() {
		
		Dummy request = new Dummy();
		
		try {
            Path path = Paths.get(UPLOADED_FOLDER +"someFile.xml");
            byte[] bytes=Files.readAllBytes(path);
            request.setMandateReqDoc(bytes);

        } catch (IOException e) {
            e.printStackTrace();
        }
		
		
		String debtorAccountNumber = "1234AA";
		String collectionAmount = "1200";
		String data = debtorAccountNumber + "|" + collectionAmount;

		request.setCheckSumVal(getSHA256Hash(data));
		request.setAuthMode("NetBanking");
		request.setMerchantID("Merchant Id same as ReqInitPty");
		request.setSPID("Service Provider");
		request.setBankID("Participant ID of the Bank");

		restTemplate.postForObject("http://localhost:8080/some-method", request, String.class);

	}

}
