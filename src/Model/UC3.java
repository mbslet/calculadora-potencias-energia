package Model;


import java.util.ArrayList;

public class UC3{
    private double amplitude_tensao, angulo_tensao;
    private double amplitude_H1,amplitude_H2, amplitude_H3, amplitude_H4, amplitude_H5, amplitude_H6;
    private double angulo_H1, angulo_H2, angulo_H3, angulo_H4, angulo_H5, angulo_H6;
    private double ordem_H1, ordem_H2, ordem_H3, ordem_H4, ordem_H5, ordem_H6;

    final double w = 2 * Math.PI * 60;
   

  
    public double getAmplitude_tensao() {
		return amplitude_tensao;
	}

	public void setAmplitude_tensao(double amplitude_tensao) {
		this.amplitude_tensao = amplitude_tensao;
	}

	public double getAngulo_tensao() {
		return angulo_tensao;
	}

	public void setAngulo_tensao(double angulo_tensao) {
		if(angulo_tensao > 180 || angulo_tensao < -180)
			throw new IllegalArgumentException("Valor do angulo da tensao inválido");

		else
			this.angulo_tensao = angulo_tensao;
		
	}

	public double getAmplitude_H1() {
		return amplitude_H1;
	}

	public void setAmplitude_H1(double amplitude_H1) {
		this.amplitude_H1 = amplitude_H1;
	}

	public double getAmplitude_H2() {
		return amplitude_H2;
	}

	public void setAmplitude_H2(double amplitude_H2) {
		this.amplitude_H2 = amplitude_H2;
	}

	public double getAmplitude_H3() {
		return amplitude_H3;
	}

	public void setAmplitude_H3(double amplitude_H3) {
		this.amplitude_H3 = amplitude_H3;
	}

	public double getAmplitude_H4() {
		return amplitude_H4;
	}

	public void setAmplitude_H4(double amplitude_H4) {
		this.amplitude_H4 = amplitude_H4;
	}

	public double getAmplitude_H5() {
		return amplitude_H5;
	}

	public void setAmplitude_H5(double amplitude_H5) {
		this.amplitude_H5 = amplitude_H5;
	}

	public double getAmplitude_H6() {
		return amplitude_H6;
	}

	public void setAmplitude_H6(double amplitude_H6) {
		this.amplitude_H6 = amplitude_H6;
	}

	public double getAngulo_H1() {
		return angulo_H1;
	}

	public void setAngulo_H1(double angulo_H1) {
		this.angulo_H1 = angulo_H1;
	}

	public double getAngulo_H2() {
		return angulo_H2;
	}

	public void setAngulo_H2(double angulo_H2) {
		this.angulo_H2 = angulo_H2;
	}

	public double getAngulo_H3() {
		return angulo_H3;
	}

	public void setAngulo_H3(double angulo_H3) {
		this.angulo_H3 = angulo_H3;
	}

	public double getAngulo_H4() {
		return angulo_H4;
	}

	public void setAngulo_H4(double angulo_H4) {
		this.angulo_H4 = angulo_H4;
	}

	public double getAngulo_H5() {
		return angulo_H5;
	}

	public void setAngulo_H5(double angulo_H5) {
		this.angulo_H5 = angulo_H5;
	}

	public double getAngulo_H6() {
		return angulo_H6;
	}

	public void setAngulo_H6(double angulo_H6) {
		this.angulo_H6 = angulo_H6;
	}

	public double getOrdem_H1() {
		return ordem_H1;
	}

	public void setOrdem_H1(double ordem_H1) {
		this.ordem_H1 = ordem_H1;
	}

	public double getOrdem_H2() {
		return ordem_H2;
	}

	public void setOrdem_H2(double ordem_H2) {
		this.ordem_H2 = ordem_H2;
	}

	public double getOrdem_H3() {
		return ordem_H3;
	}

	public void setOrdem_H3(double ordem_H3) {
		this.ordem_H3 = ordem_H3;
	}

	public double getOrdem_H4() {
		return ordem_H4;
	}

	public void setOrdem_H4(double ordem_H4) {
		this.ordem_H4 = ordem_H4;
	}

	public double getOrdem_H5() {
		return ordem_H5;
	}

	public void setOrdem_H5(double ordem_H5) {
		this.ordem_H5 = ordem_H5;
	}

	public double getOrdem_H6() {
		return ordem_H6;
	}

	public void setOrdem_H6(double ordem_H6) {
		this.ordem_H6 = ordem_H6;
	}

	public ArrayList<Double> f_Onda_Tensao(){
        
           ArrayList<Double> lista_Onda_Fundamental = new ArrayList<>();
           double t= 0.0;
            while(t<=0.1){
                lista_Onda_Fundamental.add(getAmplitude_tensao()*(Math.cos((w*t+ Math.toRadians(getAngulo_tensao())))));
                t += 0.0005;
            }
            
            return (lista_Onda_Fundamental);
        }
    
    public ArrayList<Double> Formas_Harmonicas1(){
        ArrayList<Double> H1 = new ArrayList<>();

        double t = 0.0;
        while(t <= 0.1) {
            H1.add(getAmplitude_H1()*Math.cos((getOrdem_H1()*w*t) + getAngulo_H1()));
            t += 0.0005;
        }
        return (H1);
    }
     public ArrayList<Double> Formas_Harmonicas2(){
        ArrayList<Double> H2 = new ArrayList<>();

        double t = 0.0;
        while(t <= 0.1) {
            H2.add(getAmplitude_H2()*Math.cos((getOrdem_H2()*w*t) + getAngulo_H2()));
            t += 0.0005;
        }
        return (H2);
    }
    
     public ArrayList<Double> Formas_Harmonicas3(){
         ArrayList<Double> H3 = new ArrayList<>();

         double t = 0.0;
         while(t <= 0.1) {
             H3.add(getAmplitude_H3()*Math.cos((getOrdem_H3()*w*t) + getAngulo_H3()));
             t += 0.0005;
         }
         return (H3);
     }
    
     public ArrayList<Double> Formas_Harmonicas4(){
         ArrayList<Double> H4 = new ArrayList<>();

         double t = 0.0;
         while(t <= 0.1) {
             H4.add(getAmplitude_H4()*Math.cos((getOrdem_H4()*w*t) + getAngulo_H4()));
             t += 0.0005;
         }
         return (H4);
     }
    
     public ArrayList<Double> Formas_Harmonicas5(){
         ArrayList<Double> H5 = new ArrayList<>();

         double t = 0.0;
         while(t <= 0.1) {
             H5.add(getAmplitude_H5()*Math.cos((getOrdem_H5()*w*t) + getAngulo_H5()));
             t += 0.0005;
         }
         return (H5);
     }
     public ArrayList<Double> Formas_Harmonicas6(){
         ArrayList<Double> H6 = new ArrayList<>();

         double t = 0.0;
         while(t <= 0.1) {
             H6.add(getAmplitude_H6()*Math.cos((getOrdem_H6()*w*t) + getAngulo_H6()));
             t += 0.0005;
         }
         return (H6);
     }
    
    public ArrayList<Double> Forma_Distorcida_Resultante (){
        ArrayList<Double> lista_DistResultante = new ArrayList<>();

        double t = 0.0;
        while(t <= 0.1) {
            lista_DistResultante.add(getAmplitude_tensao()*Math.cos((w*t) + getAngulo_tensao())+
                    getAmplitude_H1()*Math.cos((getOrdem_H1()*w*t) + getAngulo_H1()) +
                    getAmplitude_H2()*Math.cos((getOrdem_H2()*w*t) + getAngulo_H2()) +
                    getAmplitude_H3()*Math.cos((getOrdem_H3()*w*t) + getAngulo_H3()) +
                    getAmplitude_H4()*Math.cos((getOrdem_H4()*w*t) + getAngulo_H4()) +
                    getAmplitude_H5()*Math.cos((getOrdem_H5()*w*t) + getAngulo_H5()) +
                    getAmplitude_H6()*Math.cos((getOrdem_H6()*w*t) + getAngulo_H6())          
            );
        }
        return (lista_DistResultante);
    }
    
    
}



		
		
