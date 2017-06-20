package br.com.application.tips.classifiers;

public class Sentences {
	
	@Override
	public String toString() {
		return "'" +sentenca + "'," +dynamic + "," + +knn + "," + +naivebayes + "," + +somatorio + "," + combinaDocWord +",?";
		/*return "Sentences [sentenca=" + sentenca + ", dynamic=" + dynamic + ", knn=" + knn + ", naivebayes="
				+ naivebayes + ", somatorio=" + somatorio + ", combinaDocWord=" + combinaDocWord + "]"; */
	}
	String sentenca;
	double dynamic;
	double knn;
	double naivebayes;
	double somatorio;
	double combinaDocWord;
	
	public Sentences() {
		sentenca = " ";
		dynamic = -1;
		knn = -1;
		naivebayes = -1;
		somatorio = -1;
		combinaDocWord = -1;
	}
		
	public double getCombinaDocWord() {
		return combinaDocWord;
	}

	public void setCombinaDocWord(double combinaDocWord) {
		this.combinaDocWord = combinaDocWord;
	}

	public String getSentenca() {
		return sentenca;
	}
	public void setSentenca(String sentenca) {
		this.sentenca = sentenca;
	}
	public double getDynamic() {
		return dynamic;
	}
	public void setDynamic(double dynamic) {
		this.dynamic = dynamic;
	}
	public double getKnn() {
		return knn;
	}
	public void setKnn(double knn) {
		this.knn = knn;
	}
	public double getNaivebayes() {
		return naivebayes;
	}
	public void setNaivebayes(double naivebayes) {
		this.naivebayes = naivebayes;
	}
	public double getSomatorio() {
		return somatorio;
	}
	public void setSomatorio(double somatorio) {
		this.somatorio = somatorio;
	}
	
	

}
