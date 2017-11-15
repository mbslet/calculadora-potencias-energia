package Model;

import static java.lang.Math.cos;
import java.util.ArrayList;

public class UC3{
    private double amplitude_tensao, angulo_tensao;
    private double amplitude_H1,amplitude_H2, amplitude_H3, amplitude_H4, amplitude_H5, amplitude_H6;
    private double angulo_H1, angulo_H2, angulo_H3, angulo_H4, angulo_H5, angulo_H6;
    private double ordem_H1, ordem_H2, ordem_H3, ordem_H4, ordem_H5, ordem_H6;

    
   

  
    public double getAmplitude_tensao() {
		return amplitude_tensao;
	}

	public void setAmplitude_tensao(double amplitude_tensao) {
		this.amplitude_tensao = amplitude_tensao;
	}

	public double getAngulode_tensao() {
		return angulode_tensao;
	}

	public void setAngulo_tensao(double angulode_tensao) {
		this.angulo_tensao = angulode_tensao;
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

	public ArrayList<Double> formadeOndaTensao(){
        
           ArrayList<Double> lista_OndaTensao = new ArrayList<>();
           double t= 0.0;
            while(t<=0.1){
                lista_OndaTensao.add(getAmplitude_tensao()*(Math.cos((w*t+ Math.toRadians(getAngulo_tensao())));
                t += 0.0005;
            }
            
            return (lista_OndaTensao);
        }
    
    public ArrayList<Double> ondasHarmonicas1(){
        ArrayList<Double> harm1 = new ArrayList<>();

        for (double i = 0; i < 101; i = (float) (i + 0.4)) {
            harm1.add(getAmplitudeHarm1()*cos((getOrdemHarm1()*2*3.14*60*i) + getAnguloHarm1()));
        }
        return (harm1);
    }
    public ArrayList<Double> ondasHarmonicas2(){
        ArrayList<Double> harm2 = new ArrayList<>();

        for (double i = 0; i < 101; i = (float) (i + 0.4)) {
            harm2.add(getAmplitudeHarm2()*cos((getOrdemHarm2()*2*3.14*60*i) + getAnguloHarmo2()));
        }
        return (harm2);
    }
    
    public ArrayList<Double> ondasHarmonicas3(){
        ArrayList<Double> harm3 = new ArrayList<>();

        for (double i = 0; i < 101; i = (float) (i + 0.4)) {
            harm3.add(getAmplitudeHarm3()*cos((getOrdemHarm3()*2*3.14*60*i) + getAnguloHarm3()));
        }
        return (harm3);
    }
    
    public ArrayList<Double> ondasHarmonicas4(){
        ArrayList<Double> harm4 = new ArrayList<>();

        for (double i = 0; i < 101; i = (float) (i + 0.4)) {
            harm4.add(getAmplitudeHarm4()*(math.cos((getOrdemHarm4()*2*3.14*60*i) + getAnguloHarm4()));
        }
        return (harm4);
    }
    
    public ArrayList<Double> ondasHarmonicas5(){
        ArrayList<Double> harm5 = new ArrayList<>();

        for (double i = 0; i < 101; i = (float) (i + 0.4)) {
            harm5.add(getAmplitudeHarm5()*cos((getOrdemHarm5()*2*3.14*60*i) + getAnguloHarm5()));
        }
        return (harm5);
    }
    public ArrayList<Double> ondasHarmonicas6(){
        ArrayList<Double> harm6 = new ArrayList<>();

        for (double i = 0; i < 101; i = (float) (i + 0.4)) {
            harm6.add(getAmplitudeHarm6()*cos((getOrdemHarm6()*2*3.14*60*i) + getAnguloHarm6()));
        }
        return (harm6);
    }
    
    public ArrayList<Double> ondaDistorcida (){
        ArrayList<Double> soma = new ArrayList<>();

        for (double i = 0; i < 101; i = (float) (i + 0.4)) {
            soma.add(getAmpTensao()*cos((2*3.14*60*i) + getAngulodeTensao())+
                    getAmplitudeHarm1()*cos((getOrdemHarm1()*2*3.14*60*i) + getAnguloHarm1()) +
                    getAmplitudeHarm2()*cos((getOrdemHarm2()*2*3.14*60*i) + getAnguloHarm2()) +
                    getAmplitudeHarm3()*cos((getOrdemHarm3()*2*3.14*60*i) + getAnguloHarm3()) +
                    getAmplitudeHarm4()*cos((getOrdemHarm4()*2*3.14*60*i) + getAnguloHarm4()) +
                    getAmplitudeHarm5()*cos((getOrdemHarm5()*2*3.14*60*i) + getAnguloHarm5()) +
                    getAmplitudeHarm6()*cos((getOrdemHarm6()*2*3.14*60*i) + getAnguloHarm6())          
            );
        }
        return (soma);
    }
    
    public String serie(){
        String Harmonicos = "",harm1= "",harm2 = "",harm3= "",
                harm4 ="",harm5="",harm6 ="", soma = "";
        if(getAmplitudeTensao() != 0){
            Harmonicos = getAmplitudeTensao()+"cos(ωt + "+getAngulodeTensao()+")  ";
        }
        if(getAmplitudeHarm1() !=0){
            harm1 = "+"+getAmplitudeHarm1()+"cos("+getOrdemHarm1()+"ωt + "+getAnguloHarm1()+")  ";
        }
        if(getAmplitudeHarm2() !=0){
            harm2 = "+"+getAmplitudeHarm2()+"cos("+getOrdemHarm2()+"ωt + "+getAnguloHarm2()+")  ";
        }
        if(getAmplitudeHarm3() !=0){
            harm3 = "+"+getAmplitudeHarm3()+"cos("+getOrdemHarm3()+"ωt + "+getAnguloHarm3()+")  ";
        }
        if(getAmplitudeHarm4() !=0){
            harm4 = "+"+getAmplitudeHarm4()+"cos("+getOrdemHarm4()+"ωt + "+getAnguloHarm4()+")  ";
        }
        if(getAmplitudeHarm5() !=0){
            harm5 = "+"+getAmplitudeHarm5()+"cos("+getOrdemHarm5()+"ωt + "+getAnguloHarm5()+")  ";
        }
        if(getAmplitudeHarm6() !=0){
            harm6 = "+"+getAmplitudeHarm6()+"cos("+getOrdemHarm6()+"ωt + "+getAnguloHarm6()+")  ";
        }
        
        resultante = "f(t)= "+harmonicos+harm1+harm2+harm3+harm4+harm5+harm6;
         
        return (soma);
    }
}



	public List<Double> F_onda_fundamental(){
	int h;
		for(double t = 0; t < 250; t = (float) (t + 0.01)) {
			listaOndaFundamental.add(getAmplitude_tensao() * Math.cos((frequencia_angular * t) + getAngulo_tensao()));
			
			}
		return listaOndaFundamental;
		}
	}
		
		
		
