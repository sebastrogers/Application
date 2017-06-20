package br.com.application.tips.word2vec;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.deeplearning4j.models.embeddings.loader.WordVectorSerializer;
import org.deeplearning4j.models.word2vec.Word2Vec;

import br.com.application.tips.classifiers.Sentences;
import br.com.application.tips.classifiers.Somatorio;
import ch.qos.logback.core.read.ListAppender;

public class LendoModelo {

	public ArrayList<Sentences> CombinarDocWord2Vec() throws IOException {
		
		int resultado = 0;	
		// LENDO MODELO TREINADO
		
		Word2Vec vec = WordVectorSerializer.loadFullModel("pathToSaveModelPreconceitoNOVO5.txt");
		
		ArrayList<String> p = Somatorio.ler("ListaP.txt");
		ArrayList<String> sp = Somatorio.ler("ListaSP.txt");


		ArrayList<String> sentencas = ler("baseArtigoNOVO.txt");
		System.out.println(sentencas.size());
		vec.hasWord("estados");
		ArrayList<Sentences> resultados = new ArrayList<>();
		
		
		try {
			double[] somatorio = new double[100];
			for (int j = 0; j < 100; j++) {				
				String[] stVec = sentencas.get(j).split(" ");
				StringBuilder texto = new StringBuilder();

				// System.out.println("----------------------------------------------");
				// System.out.println("sentenca: " + sentencas.get(j));
				// System.out.println("----------------------------------------------");

				texto.append("---------------------------------------------- \n");
				texto.append("sentenca: " + j+" " +sentencas.get(j) + "\n");
				texto.append("---------------------------------------------- \n");

				System.out.println(sentencas.get(j));
				Sentences sentences = new Sentences();
				sentences.setSentenca(sentencas.get(j));
				double similaridade = 0;
				

				for (int i = 0; i < stVec.length; i++) {
					
					if (stVec[i] != null && !stVec[i].equals(" ")) {
						if (!isNumeric(stVec[i])) {

							double cosSim = 0;
							for (String word : p) {

								System.out.println(stVec[i] + "-" + word);
								cosSim = vec.similarity(stVec[i], word);

								// System.out.println("Palavra + sentimento
								// negativo");
								// System.out.println(stVec[i] + " + " + word +
								// ": "
								// + cosSim);
								// System.out.println("-----------------------------------------");

								texto.append("Palavra + sentimento negativo \n");
								texto.append(stVec[i] + " + " + word + ": " + cosSim + "\n");
								texto.append("----------------------------------------- \n");
								somatorio[j] = cosSim + somatorio[j];
								similaridade += cosSim;
								
								
							}

							for (String word : sp) {

								// System.out.println("Palavra + sentimento
								// positivo");
								cosSim = vec.similarity(stVec[i], word);
								// System.out.println(stVec[i] + " + " + word +
								// ": "
								// +
								// cosSim);
								// System.out.println("-----------------------------------------");

								texto.append("Palavra + sentimento positivo \n");
								texto.append(stVec[i] + " + " + word + ": " + cosSim + "\n");
								texto.append("----------------------------------------- \n");
								somatorio[j] = cosSim + somatorio[j];
								similaridade += cosSim;
							}
							sentences.setSomatorio(similaridade);
							resultados.add(sentences);
						}

						texto.append("\n \n");
						// System.out.println();
						// System.out.println();
						salvaArquivo(texto.toString(), sentencas.get(j));
					}
					
				}
				
				
			}
					
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return resultados;
		
	}

	public static boolean isNumeric(String str) {
		for (char c : str.toCharArray()) {
			if (Character.isDigit(c)) {
				return true;
			}
		}

		return false;

	}

	static void salvaArquivo(String string, String s) throws IOException {
		//FileWriter arqW = new FileWriter("src/main/resources/resultado/" + s + ".txt");
		FileWriter arqW = new FileWriter("./src/main/resources/resultado/" + s + ".txt");
		PrintWriter gravarArq = new PrintWriter(arqW);

		gravarArq.println(string);

		arqW.close();
		gravarArq.close();
	}

	public static ArrayList<String> ler(String file) {
		ArrayList<String> words = new ArrayList();

		try {

			FileReader in = new FileReader(file);
			BufferedReader reader = new BufferedReader(in);

			while (reader.ready()) {
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