package br.com.application.tips.classifiers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Somatorio {

	public static double calc(String s){
		String[] stVec = s.split(" ");
		int indice = 0;

		ArrayList<String>  p = ler("ListaP.txt");
		ArrayList<String>  sp = ler("ListaSP.txt");
		
		for (String word : stVec) {            
			if (sp.contains(word)) {
				indice--;
			} else if (p.contains(word)) {
				indice++;
			}            
		}

		if (indice > 0) {
			System.out.println("Positive");
			return 1;
		} else if (indice < 0) {
			System.out.println("Negative");
		} else {
			System.out.println("Undefined");
		}
		
		return 0;
		
	}

	public static void main(String[] args) {

		int indice = 0;

		ArrayList<String>  p = ler("ListaP.txt");
		ArrayList<String>  sp = ler("ListaSP.txt");
		ArrayList<String>  words = ler("Words.txt");


		for (String word : words) {            
			if (sp.contains(word)) {
				indice++;
			} else if (p.contains(word)) {
				indice--;
			}            
		}

		if (indice > 0) {
			System.out.println("Positive");
		} else if (indice < 0) {
			System.out.println("Negative");
		} else {
			System.out.println("Undefined");
		}


	}

	public static ArrayList<String> ler(String file) {
		ArrayList<String> words = new ArrayList();

		try {

			FileReader in = new FileReader(file);
			BufferedReader reader = new BufferedReader(in);

			while(reader.ready()){
				words.add(reader.readLine());
			}

			in.close();
			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}


		return words;

	}

}