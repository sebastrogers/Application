package br.com.application.tips.main;

import java.io.IOException;
import java.util.ArrayList;

import br.com.application.tips.classifiers.Sentences;
import br.com.application.tips.word2vec.*;
public class Application {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		
		
		
		LendoModelo object = new LendoModelo();
		
		ArrayList<Sentences> combinacaoDocWord2Vec = object.CombinarDocWord2Vec();
		
		for (Sentences temp : combinacaoDocWord2Vec) {
			System.out.println("... " + temp.getSentenca()+ " " +temp.getSomatorio());
		}
	}

}
