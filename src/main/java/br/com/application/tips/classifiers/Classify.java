package br.com.application.tips.classifiers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Classify {

	public double knn(String s) throws IOException{

		KNNClassify classify = new KNNClassify();

		List<String> categories = new ArrayList<String>();

		categories.add("positive");
		categories.add("negative");



		classify.trainClassifyDirectory("train", categories, 2);
		String classe = classify.classify(s);

		System.out.println(classe);
		if(classe.equals("positive")){
			return 1;
		}

		return 0;
	}
	
	public double naivebayes(String s) throws IOException{
		
		NaiveBayesClassify classify = new NaiveBayesClassify();
		
		List<String> categories = new ArrayList<String>();
		
		categories.add("positive");
		categories.add("negative");
		
		
		
		classify.trainClassifyDirectory("train", categories, 2);
		String classe = classify.classify(s);
		
		System.out.println(classe);
		if(classe.equals("positive")){
			return 1;
		}
		
		return 0;
	}

	public double dynamic(String s) throws IOException{

		DynamicLMClassify classify = new DynamicLMClassify();

		List<String> categories = new ArrayList<String>();

		categories.add("positive");
		categories.add("negative");



		classify.trainClassifyDirectory("train", categories, 2);
		String classe = classify.classify(s);

		System.out.println(classe);
		if(classe.equals("positive")){
			return 1;
		}

		return 0;
	}

}
