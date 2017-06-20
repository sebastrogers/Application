package br.com.application.tips.main;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.deeplearning4j.models.word2vec.Word2Vec;

import br.com.application.tips.classifiers.Classify;
import br.com.application.tips.classifiers.Sentences;
import br.com.application.tips.classifiers.Somatorio;
import br.com.application.tips.word2vec.*;
public class Application {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub


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






		LendoModelo object = new LendoModelo();

		ArrayList<Sentences> combinacaoDocWord2Vec = object.CombinarDocWord2Vec();

		for (Sentences temp : combinacaoDocWord2Vec) {
			//System.out.println("... " + temp.getSentenca()+ " " +temp.getSomatorio());
			for (Sentences sentences : sentencas) {
				//System.out.println(sentences.getSentenca() +" " +temp.getSentenca());

				if(temp.getSentenca().trim().equalsIgnoreCase(sentences.getSentenca().trim())){
					if(temp.getCombinaDocWord() > 0){
						sentences.setCombinaDocWord(1);
					} else{
						sentences.setCombinaDocWord(0);
					}

					//sentences.setCombinaDocWord(temp.getCombinaDocWord());
				}

			}

		}

		salvaArquivo(sentencas, "arquivo");
		
	}

	static void salvaArquivo(ArrayList<Sentences>list, String s) throws IOException {
		//FileWriter arqW = new FileWriter("src/main/resources/resultado/" + s + ".txt");
		FileWriter arqW = new FileWriter("./src/main/resources/resultado/" + s + ".txt");
		PrintWriter gravarArq = new PrintWriter(arqW);
		
		for (Sentences sentences : list) {
			gravarArq.println(sentences);
		}
		

		arqW.close();
		gravarArq.close();
	}
}
