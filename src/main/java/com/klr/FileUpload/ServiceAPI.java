package com.klr.FileUpload;

import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/serviceApi")
public class ServiceAPI {

	@SuppressWarnings({ "finally", "unchecked" })
	@RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
	public String updateAdminData(@RequestParam("file") MultipartFile file, @RequestParam("jsonUpload") String body) {

		try {
			File tempFile = File.createTempFile("temp", ".txt");
			tempFile.deleteOnExit();
			file.transferTo(tempFile);
			
			FileReader fr = new FileReader(tempFile);
			int i;
			while ((i = fr.read()) != -1)
				System.out.print((char) i);
			fr.close();
			tempFile.delete();
			JSONParser parser = new JSONParser(body);
			HashMap< String, String> requestMap = new HashMap<String, String>();
			requestMap = (HashMap<String, String>) parser.parse();
			for (String key: requestMap.keySet()) {
				System.out.println(key + " ==> " + requestMap.get(key));
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			return "OK";
		}
	}
}