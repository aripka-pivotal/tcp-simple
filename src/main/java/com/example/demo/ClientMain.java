package com.example.demo;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientMain {

	public static void main(String[] args) throws Exception {
		String sentence;
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		Socket clientSocket = new Socket(args[0], Integer.parseInt(args[1]));
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
		sentence = inFromUser.readLine();
		outToServer.writeBytes(sentence + '\n');
		outToServer.writeBytes("exit" + "\n");
		clientSocket.close();

	}

}
