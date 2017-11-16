package Model;

import java.util.ArrayList;

public class UC2 {
	
	
	private double angulo_tensao, angulo_corrente, amplitude_tensao, amplitude_corrente;
	private double potencia_ativa, potencia_reativa, potencia_aparente, fator_potencia;
	
	private final double frequencia_angular = 2*Math.PI*60;
	
	public double getAngulo_tensao() {
		return angulo_tensao;
	}
	

	public void setAngulo_tensao(double angulo_tensao) {
		if(angulo_tensao > 180 || angulo_tensao < -180)
			throw new IllegalArgumentException("Valor do angulo da tensao inválido");

		else
			this.angulo_tensao = angulo_tensao;
	}
	
	
	public double getAngulo_corrente() {
		return angulo_corrente;
	}
	
	
	public void setAngulo_corrente(double angulo_corrente) {
		this.angulo_corrente = angulo_corrente;
	}
	
	
	public double getAmplitude_tensao() {
		return amplitude_tensao;
	}
	
	
	public void setAmplitude_tensao(double amplitude_tensao) {
		this.amplitude_tensao = amplitude_tensao;
	}
	
	
	public double getAmplitude_corrente() {
		return amplitude_corrente;
	}
	
	
	public void setAmplitude_corrente(double amplitude_corrente) {
		this.amplitude_corrente = amplitude_corrente;
	}

	
	
	//Calculos ondas gráfico
	
	
	public ArrayList<Double> F_onda_tensao(){
		
		ArrayList<Double> listaOndaTensao = new ArrayList<>();
		double t = 0.0;
		while(t<=0.1) {
			listaOndaTensao.add(getAmplitude_tensao() * Math.cos(frequencia_angular * t + Math.toRadians(getAngulo_tensao())));
			t += 0.0005;
		}
		return listaOndaTensao;
	}
	
	public ArrayList<Double> F_onda_corrente(){
		
		ArrayList<Double> listaOndaCorrente = new ArrayList<>();
		double t = 0.0;
		while(t<=0.1) {
			listaOndaCorrente.add(getAmplitude_corrente() * Math.cos(frequencia_angular * t + Math.toRadians(getAngulo_corrente())));
			t += 0.0005;
		}
		return listaOndaCorrente;
	}
	
	
	public ArrayList<Double> F_onda_potencia_instantanea(){
		
		ArrayList<Double> listaOndaPI = new ArrayList<>();

		for(int t =0; t < F_onda_tensao().size();t++) {
			listaOndaPI.add(F_onda_tensao().get(t)*F_onda_corrente().get(t));
		}
		return listaOndaPI;
	}
	
	
	
	
	// Calculos dos resultados de saida
	

	
	
	public double F_potencia_ativa() {
		potencia_ativa = getAmplitude_tensao() * getAmplitude_corrente() * Math.cos(Math.toRadians(getAngulo_tensao() - getAngulo_corrente()));
		
		return potencia_ativa;
		
	}
	
	public double F_potencia_reativa() {
	
		potencia_reativa = getAmplitude_tensao() * getAmplitude_corrente() * Math.sin(Math.toRadians(getAngulo_tensao() - getAngulo_corrente()));
	
		return potencia_reativa;
	
	}
	
	public double F_potencia_aparente() {
		
		potencia_aparente = getAmplitude_tensao() * getAmplitude_corrente();
		
		return potencia_aparente;
	}
	
	
	public double F_fator_potencia() {
		fator_potencia = Math.cos(getAngulo_tensao() - getAngulo_corrente());
		
		return fator_potencia;

		
		
	}


	
}
	