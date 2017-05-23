package com.example.demo;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);

		String clientSentence = null;
		ServerSocket welcomeSocket = new ServerSocket(8080);

		while (true) {
			Socket connectionSocket = welcomeSocket.accept();
			try {
				BufferedReader inFromClient = new BufferedReader(
						new InputStreamReader(connectionSocket.getInputStream()));

				while (true) {

					clientSentence = inFromClient.readLine();
					System.out.println("Received: " + clientSentence);
					if (clientSentence.equals("exit") || clientSentence.equals("shutdown")) {
						connectionSocket.close();
						break;
					}
				}
				
				if(clientSentence.equals("shutdown")){
					welcomeSocket.close();
					break;
				}
			
			} finally {
				
			}
		}
	}
}
