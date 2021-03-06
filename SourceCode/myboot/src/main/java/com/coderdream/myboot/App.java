package com.coderdream.myboot;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@EnableAutoConfiguration
public class App {

	@RequestMapping("/")
	@ResponseBody
	String home() {
		return "Hello World!";
	}

	@RequestMapping(value = "/test/send")
	@ResponseBody
	public Map<String, String> sendPost(HttpServletRequest request) {
		Map<String, String> maps = new HashMap<String, String>();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		maps.put("username", username);
		maps.put("password", password);
		return maps;
	}

	@RequestMapping(value = "/test/sendpost/file", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> sendPostFile(@RequestParam("files") MultipartFile[] files, HttpServletRequest request) {
		Map<String, String> maps = new HashMap<String, String>();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		maps.put("username", username);
		maps.put("password", password);

		try {
			for (MultipartFile file : files) {
				String fileName = file.getOriginalFilename();
				fileName = new String(fileName.getBytes(), "UTF-8");
				InputStream is = file.getInputStream();
				if (fileName != null && !("".equals(fileName))) {
					File directory = new File("D://test//httpclient//file");
					if (!directory.exists()) {
						directory.mkdirs();
					}
					String filePath = ("D://test//httpclient//file") + File.separator + fileName;
					FileOutputStream fos = new FileOutputStream(filePath);
					byte[] buffer = new byte[1024];
					while (is.read(buffer) > 0) {
						fos.write(buffer, 0, buffer.length);
					}
					fos.flush();
					fos.close();
					maps.put("file--" + fileName, "uploadSuccess");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return maps;
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(App.class, args);
	}
}