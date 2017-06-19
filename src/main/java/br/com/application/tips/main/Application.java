package br.com.application.tips.main;

import java.io.IOException;
import java.util.ArrayList;

import org.deeplearning4j.models.word2vec.Word2Vec;

import br.com.application.tips.classifiers.Classify;
import br.com.application.tips.classifiers.Sentences;
import br.com.application.tips.classifiers.Somatorio;
import br.com.application.tips.word2vec.*;
public class Application {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		/*
		Classify c = new Classify();
		ArrayList<Sentences> sentencas = new ArrayList<>();
		ArrayList<String> list = Somatorio.ler("baseArtigoNOVO.txt");
		for (String string : list) {			
			Sentences aux = new Sentences();
			aux.setSentenca(string);
						
			double dynamic = c.dynamic(string);
			aux.setDynamic(dynamic);
			
			double knn = c.knn(string);
			aux.setKnn(knn);
			
			double naiveBayes = c.naivebayes(string);
			aux.setNaivebayes(naiveBayes);
			
			double somatorio = Somatorio.calc(string);
			aux.setSomatorio(somatorio);
						
			sentencas.add(aux);
		}
		
		System.out.println(sentencas);
		
		
		*/
		
		
		
		
		LendoModelo object = new LendoModelo();
		
		ArrayList<Sentences> combinacaoDocWord2Vec = object.CombinarDocWord2Vec();
		
		for (Sentences temp : combinacaoDocWord2Vec) {
			System.out.println("... " + temp.getSentenca()+ " " +temp.getSomatorio());
		}
	
	}
	
}
