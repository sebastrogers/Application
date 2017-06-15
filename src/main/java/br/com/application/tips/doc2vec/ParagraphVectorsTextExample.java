package br.com.application.tips.doc2vec;

import org.datavec.api.util.ClassPathResource;
import org.deeplearning4j.models.paragraphvectors.ParagraphVectors;
import org.deeplearning4j.models.word2vec.VocabWord;
import org.deeplearning4j.models.word2vec.wordstore.inmemory.AbstractCache;
import org.deeplearning4j.text.documentiterator.LabelsSource;
import org.deeplearning4j.text.sentenceiterator.BasicLineIterator;
import org.deeplearning4j.text.sentenceiterator.SentenceIterator;
import org.deeplearning4j.text.tokenization.tokenizer.preprocessor.CommonPreprocessor;
import org.deeplearning4j.text.tokenization.tokenizerfactory.DefaultTokenizerFactory;
import org.deeplearning4j.text.tokenization.tokenizerfactory.TokenizerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;

/**
 * @author sebastiao
 */
public class ParagraphVectorsTextExample {

	private static final Logger log = LoggerFactory.getLogger(ParagraphVectorsTextExample.class);

	public static void main(String[] args) throws Exception {
		ClassPathResource resource = new ClassPathResource("\\PreconceitoStopwords.txt");
		File file = resource.getFile();
		SentenceIterator iter = new BasicLineIterator(file);

		AbstractCache<VocabWord> cache = new AbstractCache<>();

		TokenizerFactory t = new DefaultTokenizerFactory();
		t.setTokenPreProcessor(new CommonPreprocessor());

		/*
             if you don't have LabelAwareIterator handy, you can use synchronized labels generator
              it will be used to label each document/sequence/line with it's own label.
              But if you have LabelAwareIterator ready, you can can provide it, for your in-house labels
		 */
		LabelsSource source = new LabelsSource("DOC_");

		ParagraphVectors vec = new ParagraphVectors.Builder()
				.minWordFrequency(1)
				//.iterations(1)
				.epochs(5) 				//verificar essa medida
				.layerSize(100)
				.learningRate(0.025)
				.labelsSource(source)
				.windowSize(5)
				.iterate(iter)
				.trainWordVectors(false)
				.vocabCache(cache)
				.tokenizerFactory(t)
				.sampling(0)
				.build();

		vec.fit();
		/*
		ArrayList<String> wordsListSaida = new ArrayList<String>();
		for (String word : wordsList) {
			
			String aux = word;
			String[] auxV = aux.split(" ");
			
			for (String string : stopwords) {
				for (int i = 0; i < auxV.length; i++) {
					if (auxV[i].equalsIgnoreCase(string)) {
						auxV[i] = "";
					}
				}				
			}
		*/
		
		// 0 - 5786 - Sent.
		//5787 - 5853 - Sentimento
		double similarity1 = vec.similarity("DOC_0", "DOC_5832");
		log.info("0/5832 ('sentença 1 .'/'preocupado .') similarity: " + similarity1);
		// 0 - estados unidos america casos racismo escolas proliferam dando origem testemunhos criancas
		
		
				
		//double similarity3 = vec.similarity("DOC_3", "DOC_4");
		//log.info("6348/3721 ('This is my case .'/'This is my way .') similarity: " + similarity3);

		
		
	}
}