package br.com.application.tips.classifiers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Classify {
	
	public static void main(String[] args) throws IOException {

		DynamicLMClassify classify = new DynamicLMClassify();
		
		List<String> categories = new ArrayList<String>();
		
		categories.add("positive");
		categories.add("negative");
		
		
		
		classify.trainClassifyDirectory("train", categories, 2);
		//teste..
		//classify.trainClassifyDirectory("teste", categories, 2);
		
		/**
		 * XValidatingObjectCorpus<Classified<CharSequence>> corpus = new
		 * XValidatingObjectCorpus<Classified<CharSequence>>(NUM_FOLDS);
		 * 
		 * for (String category : CATEGORIES) {
		 * 
		 * Classification c = new Classification(category); File trainCatDir =
		 * new File(TRAINING_DIR,category); for (File trainingFile :
		 * trainCatDir.listFiles()) { String text =
		 * Files.readFromFile(trainingFile,"ISO-8859-1"); Classified
		 * <CharSequence> classified = new Classified<CharSequence>(text,c);
		 * corpus.handle(classified); }
		 * 
		 * File testCatDir = new File(TESTING_DIR,category); for (File testFile
		 * : testCatDir.listFiles()) { String text =
		 * Files.readFromFile(testFile,"ISO-8859-1"); Classified
		 * <CharSequence> classified = new Classified<CharSequence>(text,c);
		 * corpus.handle(classified); } }
		 */
		String classe = classify.classify("racismo é uma realidade no brasil");
		
		System.out.println(classe);
		
	}

}
