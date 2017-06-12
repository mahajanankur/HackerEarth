package com.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WebServer extends Thread {
	
	/**
	 * This method is invoked on HTTP GET/sleep?timeout=20&connid=1
	 * 
	 * @param paramMap
	 * @param clientSocket
	 * 
	 * You can use the following method to write to a socket - 
	 * PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);
	 * 
	 * You need to write to the output after the specified "timeout" amount of seconds. 
	 * 
	 * You will need to close the clientSocket in order to respond to the client
	 * 
	 * NOTE - Your implementation needs to be able to handle multiple client connecting simultaneously.
	 */
	public void implementSleepRequest(Map<String, String> paramMap, Socket clientSocket) {
		/*
		 * You need to Retrieve connid and timeout from paramsMap and implement
		 * the handling for the GET /sleep method
		 */

		// Your code goes here.
	}

	/**
	 * This method is called when the request is GET /server­status
	 * 
	 * Returns the status of all the connections currently connected and their
	 * time left to sleep
	 * @param clientSocket 
	 */
	//
	public void implementGetServerStatusRequest(Socket clientSocket) {
		
		// Your code goes here.
	}

	/**
	 * This method is called when the request is POST /kill
	 * 
	 * Kills a given connection id
	 * 
	 * @param requestBody
	 * @param clientSocket
	 */
	public void implementKillConnectionRequest(String requestBody, Socket clientSocket) {
		/*
		 * You need to retrieve connid from the requestBody and kill the
		 * corresponding connection.
		 */
		
		// Your code goes here.
	}

	public void callMethod(WebServerRequestBody webServerRequestBody, Socket clientSocket) {
		if (WebServerUtils.isPostRequest(webServerRequestBody)) {
			if (webServerRequestBody.getRequestUri() != null && webServerRequestBody.getRequestUri().contains("kill")) {
				implementKillConnectionRequest(webServerRequestBody.getRequestBody(), clientSocket);
			}
		} else if (WebServerUtils.isGetRequest(webServerRequestBody)) {
			if (webServerRequestBody.getRequestUri() != null
					&& webServerRequestBody.getRequestUri().contains("sleep")) {
				implementSleepRequest(webServerRequestBody.getRequestParams(), clientSocket);
			} else if (webServerRequestBody.getRequestUri() != null
					&& webServerRequestBody.getRequestUri().contains("server­status")) {
				implementGetServerStatusRequest(clientSocket);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		WebServer webServer = new WebServer();
		int port = 8084;
		ServerSocket server = new ServerSocket(port);
		while (true) {
			// Create the Web server
			// Parse the Web request and populate the WebServerRequestBody
			// object
			/*
			 * WebServerRequestBody.java is present in the same folder which
			 * getter methods for the following attributes 
			 * private String method;
			 * private Map<String, String> requestParams; 
			 * private String requestBody; 
			 * private String requestUri;
			 * 
			 */
			
			Socket clientSocket = server.accept();
			InputStream input = clientSocket.getInputStream();
			WebServerRequestBody webServerRequestBody = WebServerUtils.parseRequest(input);
			
			// Handle the Web request
			webServer.callMethod(webServerRequestBody, clientSocket);
		}
		
	}

}