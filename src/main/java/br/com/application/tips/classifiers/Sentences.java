package br.com.application.tips.classifiers;

public class Sentences {
	String sentenca;
	double dynamic;
	double knn;
	double naivebayes;
	double somatorio;
	
	public Sentences() {
		sentenca = " ";
		dynamic = 0;
		knn = 0;
		naivebayes = 0;
		somatorio = 0;
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
