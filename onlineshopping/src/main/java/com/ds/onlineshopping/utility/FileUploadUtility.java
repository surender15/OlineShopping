package com.ds.onlineshopping.utility;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility {

	
	private static final String ABS_PATH ="/home/surender/projects/spring/OnlineShopping/onlineshopping/src/main/resources/static/images/";
	private static String REAL_PATH="";
	
	private static final Logger logger= LoggerFactory.getLogger(FileUploadUtility.class);
	public static void uploadFile(HttpServletRequest request, MultipartFile file, String code) {
		
		//get the real path
		REAL_PATH=request.getSession().getServletContext().getRealPath("/images/");
		//REAL_PATH -- where our Tomcat server diployed our application 
		
		logger.info(REAL_PATH);
		/*
		 * 
		 * Make sure all the directories exist
		 * Other wise create thhe directories
		 * */
		if(!new File(ABS_PATH).exists())
			new File(ABS_PATH).mkdir();
		if(!new File(REAL_PATH).exists())
			new File(REAL_PATH).mkdir();
		
		try {
			
			//serverupload 
			file.transferTo(new File(REAL_PATH+code+".jpg"));
			
			file.transferTo(new File(ABS_PATH+code+".jpg"));
			
			
		} 
		catch(IOException e)
		{
			
		}
	}
	
}
