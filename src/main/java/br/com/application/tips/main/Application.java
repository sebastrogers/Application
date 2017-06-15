package br.com.application.tips.main;

import java.io.IOException;
import java.util.ArrayList;

import br.com.application.tips.word2vec.*;
public class Application {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		LendoModelo object = new LendoModelo();
		
		ArrayList<Integer> combinacaoDocWord2Vec = object.CombinarDocWord2Vec();
		
		for (int temp : combinacaoDocWord2Vec) {
			System.out.println("... " + temp);
		}
	}

}
