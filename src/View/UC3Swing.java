package View;

import Model.UC3;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Font;

public class UC3Swing extends JFrame {
	
	UC3 c3;

	private GraphPanel graficoFundamental;
	private GraphPanel graficoNHarmonico1;
	private GraphPanel graficoNHarmonico2;
	private GraphPanel graficoNHarmonico3;
	private GraphPanel graficoNHarmonico4;
	private GraphPanel graficoNHarmonico5;
	private GraphPanel graficoNHarmonico6;
	private GraphPanel graficoResultante;
	
	private JPanel contentPane;
	
	private JTextField AmplitudeFundamental;
	private JTextField AnguloFundamental;
	private JTextField AmplitudeH1, AmplitudeH2, AmplitudeH3, AmplitudeH4, AmplitudeH5, AmplitudeH6;
	private JTextField AnguloH1, AnguloH2, AnguloH3, AnguloH4, AnguloH5, AnguloH6;
	private JTextField OrdemH1, OrdemH2, OrdemH3, OrdemH4, OrdemH5, OrdemH6;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public UC3Swing() {
		
		
		
		c3 = new UC3();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 1500, 1500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelUC3 = new JPanel();
		contentPane.add(panelUC3, BorderLayout.CENTER);
		panelUC3.setLayout(new GridLayout(4, 1, 10, 10));
		
		JPanel panelEntradaOndaFundamental = new JPanel();
		panelUC3.add(panelEntradaOndaFundamental);
		panelEntradaOndaFundamental.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panelGraficoFundamental = new JPanel();
		panelEntradaOndaFundamental.add(panelGraficoFundamental);
		panelGraficoFundamental.setLayout(new GridLayout(1, 1, 0, 0));
		graficoFundamental=new GraphPanel(new ArrayList<>());
		panelGraficoFundamental.add(graficoFundamental);
		graficoFundamental.setLayout(null);
		
		JLabel lblComponenteFunadamental = new JLabel("Componente Funadamental");
		lblComponenteFunadamental.setBounds(215, 220, 302, 15);
		graficoFundamental.add(lblComponenteFunadamental);
		
		JPanel panelValoresUC3 = new JPanel();
		panelEntradaOndaFundamental.add(panelValoresUC3);
		panelValoresUC3.setLayout(null);
		
		AmplitudeFundamental = new JTextField();
		AmplitudeFundamental.setBounds(23, 47, 75, 26);
		panelValoresUC3.add(AmplitudeFundamental);
		AmplitudeFundamental.setColumns(10);
		
		JLabel lblAmplitude = new JLabel("Amplitude");
		lblAmplitude.setBounds(135, 49, 99, 15);
		panelValoresUC3.add(lblAmplitude);
		
		AnguloFundamental = new JTextField();
		AnguloFundamental.setColumns(10);
		AnguloFundamental.setBounds(23, 86, 75, 26);
		panelValoresUC3.add(AnguloFundamental);
		
		JLabel lblAnguloFase = new JLabel("Angulo Fase");
		lblAnguloFase.setBounds(135, 88, 99, 15);
		panelValoresUC3.add(lblAnguloFase);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					double variavelAmplitudeFundamental = Double.parseDouble(AmplitudeFundamental.getText());
					double variavelAnguloFundamental = Double.parseDouble(AnguloFundamental.getText());
					
					c3.setAmplitude_tensao(variavelAmplitudeFundamental);
					c3.setAmplitude_tensao(variavelAnguloFundamental);
					graficoFundamental.setScores(c3.f_Onda_Tensao());
					}
					catch(NumberFormatException err) {
						JOptionPane.showMessageDialog(null, err.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
					catch(IllegalArgumentException err) {
						JOptionPane.showMessageDialog(null, err.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
					
				}
				
				
			
		});
		btnEnviar.setBounds(57, 190, 87, 25);
		panelValoresUC3.add(btnEnviar);
		
		JRadioButton rdbtnmpares = new JRadioButton("Ímpares");
		rdbtnmpares.setBounds(489, 87, 87, 23);
		panelValoresUC3.add(rdbtnmpares);
		
		JRadioButton rdbtnPares = new JRadioButton("Pares");
		rdbtnPares.setBounds(580, 87, 75, 23);
		panelValoresUC3.add(rdbtnPares);
		
		JLabel lblNewLabel_1 = new JLabel(" Harmônicos:");
		lblNewLabel_1.setBounds(530, 52, 99, 15);
		panelValoresUC3.add(lblNewLabel_1);
	
		JComboBox N_Harmonicos = new JComboBox<Double>();
		for (int i = 1; i < 7; i++){
            N_Harmonicos.addItem(i);
            
		}

		
		N_Harmonicos.setBounds(580, 172, 38, 24);
		panelValoresUC3.add(N_Harmonicos);
		
		JLabel lblOrdemHarmnica = new JLabel("Número de Harmônica:");
		lblOrdemHarmnica.setBounds(509, 145, 182, 15);
		panelValoresUC3.add(lblOrdemHarmnica);
	
		
		JPanel panel_Part2 = new JPanel();
		panelUC3.add(panel_Part2);
		panel_Part2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelHarmonicoTotal = new JPanel();
		panel_Part2.add(panelHarmonicoTotal);
		panelHarmonicoTotal.setLayout(new GridLayout(2, 3, 0, 0));
		
		JPanel panel_HarmonicoCima = new JPanel();
		panelHarmonicoTotal.add(panel_HarmonicoCima);
		panel_HarmonicoCima.setLayout(new GridLayout(0, 3, 0, 0));
		
		
		JPanel panel_NHarmonicos1 = new JPanel();
		panel_HarmonicoCima.add(panel_NHarmonicos1);
		panel_NHarmonicos1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_graficoH1 = new JPanel();
		panel_NHarmonicos1.add(panel_graficoH1);
		panel_graficoH1.setLayout(null);
		graficoNHarmonico1=new GraphPanel(new ArrayList<>());
		graficoNHarmonico1.setBounds(0, -37, 496, 232);
		panel_graficoH1.add(graficoNHarmonico1);
		
		
		JLabel lblNmeroDeHarmnicos = new JLabel("Número de Harmônicos: 1");
		lblNmeroDeHarmnicos.setBounds(157, 96, 275, 15);
		graficoNHarmonico1.add(lblNmeroDeHarmnicos);
		
		
		
		JPanel panel_NHarmonicos2 = new JPanel();
		panel_HarmonicoCima.add(panel_NHarmonicos2);
		panel_NHarmonicos2.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_graficoH2 = new JPanel();
		panel_NHarmonicos2.add(panel_graficoH2);
		panel_graficoH2.setLayout(null);
		graficoNHarmonico2=new GraphPanel(new ArrayList<>());
		graficoNHarmonico2.setBounds(0, -22, 496, 199);
		panel_graficoH2.add(graficoNHarmonico2);
		
		
		JLabel lblNmeroDeHarmnicos2 = new JLabel("Número de Harmônicos: 2");
		lblNmeroDeHarmnicos2.setBounds(157, 96, 275, 15);
		graficoNHarmonico2.add(lblNmeroDeHarmnicos2);
		
		JPanel panel_NHarmonicos3 = new JPanel();
		panel_HarmonicoCima.add(panel_NHarmonicos3);
		panel_NHarmonicos3.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_graficoH3 = new JPanel();
		panel_NHarmonicos3.add(panel_graficoH3);
		panel_graficoH3.setLayout(null);
		graficoNHarmonico3=new GraphPanel(new ArrayList<>());
		graficoNHarmonico3.setBounds(0, -35, 496, 227);
		panel_graficoH3.add(graficoNHarmonico3);
		
		
		JLabel lblNmeroDeHarmnicos3 = new JLabel("Número de Harmônicos: 3");
		lblNmeroDeHarmnicos3.setBounds(157, 96, 275, 15);
		graficoNHarmonico3.add(lblNmeroDeHarmnicos3);
		
		JPanel panelHarmonicoBaixo = new JPanel();
		panelHarmonicoTotal.add(panelHarmonicoBaixo);
		panelHarmonicoBaixo.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panel_NHarmonicosDados1 = new JPanel();
		panelHarmonicoBaixo.add(panel_NHarmonicosDados1);
		panel_NHarmonicosDados1.setLayout(null);
		
		AmplitudeH1 = new JTextField();
		AmplitudeH1.setBounds(12, 22, 92, 33);
		panel_NHarmonicosDados1.add(AmplitudeH1);
		AmplitudeH1.setColumns(10);
		
		JLabel lblAmplitude_1 = new JLabel("Amplitude");
		lblAmplitude_1.setBounds(113, 25, 103, 26);
		panel_NHarmonicosDados1.add(lblAmplitude_1);
		
		AnguloH1 = new JTextField();
		AnguloH1.setColumns(10);
		AnguloH1.setBounds(214, 22, 92, 33);
		panel_NHarmonicosDados1.add(AnguloH1);
		
		JLabel lblnguloDeFase = new JLabel("Ângulo de Fase");
		lblnguloDeFase.setBounds(324, 31, 138, 15);
		panel_NHarmonicosDados1.add(lblnguloDeFase);
		
		OrdemH1 = new JTextField();
		OrdemH1.setColumns(10);
		OrdemH1.setBounds(12, 78, 92, 33);
		panel_NHarmonicosDados1.add(OrdemH1);
		
		JLabel lblOrdemDeFase = new JLabel("Ordem Harmônica");
		lblOrdemDeFase.setBounds(113, 87, 132, 15);
		panel_NHarmonicosDados1.add(lblOrdemDeFase);
		
		JButton button_H1 = new JButton("Enviar");
		button_H1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					double variavelAmplitudeH1 = Double.parseDouble(AmplitudeH1.getText());
					double variavelAnguloH1 = Double.parseDouble(AnguloH1.getText());
					double variavelOrdemH1 = Double.parseDouble(OrdemH1.getText());
					
					c3.setAmplitude_H1(variavelAmplitudeH1);
					c3.setAngulo_H1(variavelAnguloH1);
					c3.setOrdem_H1(variavelOrdemH1);
					
					graficoNHarmonico1.setScores(c3.Formas_Harmonicas1());
					graficoResultante.setScores(c3.Forma_Distorcida_Resultante());
				}
					
					
					catch(NumberFormatException err) {
						JOptionPane.showMessageDialog(null, err.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				
					
				}
				
				
			
		});
		button_H1.setBounds(413, 98, 83, 25);
		panel_NHarmonicosDados1.add(button_H1);
		
		JPanel panel_NHarmonicosDados2 = new JPanel();
		panelHarmonicoBaixo.add(panel_NHarmonicosDados2);
		panel_NHarmonicosDados2.setLayout(null);
		
		AmplitudeH2 = new JTextField();
		AmplitudeH2.setBounds(12, 22, 92, 33);
		panel_NHarmonicosDados2.add(AmplitudeH2);
		AmplitudeH2.setColumns(10);
		
		JLabel lblAmplitude_2 = new JLabel("Amplitude");
		lblAmplitude_2.setBounds(113, 25, 103, 26);
		panel_NHarmonicosDados2.add(lblAmplitude_2);
		
		AnguloH2 = new JTextField();
		AnguloH2.setColumns(10);
		AnguloH2.setBounds(214, 22, 92, 33);
		panel_NHarmonicosDados2.add(AnguloH2);
		
		JLabel lblnguloDeFase_2 = new JLabel("Ângulo de Fase");
		lblnguloDeFase_2.setBounds(324, 31, 138, 15);
		panel_NHarmonicosDados2.add(lblnguloDeFase_2);
		
		OrdemH2 = new JTextField();
		OrdemH2.setColumns(10);
		OrdemH2.setBounds(12, 78, 92, 33);
		panel_NHarmonicosDados2.add(OrdemH2);
		
		JLabel lblOrdemDeFase_2 = new JLabel("Ordem Harmônica");
		lblOrdemDeFase_2.setBounds(113, 87, 132, 15);
		panel_NHarmonicosDados2.add(lblOrdemDeFase_2);
		
		JButton button_H2 = new JButton("Enviar");
		button_H2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double variavelAmplitudeH2 = Double.parseDouble(AmplitudeH2.getText());
					double variavelAnguloH2 = Double.parseDouble(AnguloH2.getText());
					double variavelOrdemH2 = Double.parseDouble(OrdemH2.getText());
					
					c3.setAmplitude_H2(variavelAmplitudeH2);
					c3.setAngulo_H2(variavelAnguloH2);
					c3.setOrdem_H2(variavelOrdemH2);
					
					graficoNHarmonico2.setScores(c3.Formas_Harmonicas2());
					graficoResultante.setScores(c3.Forma_Distorcida_Resultante());
				}
					
					
					catch(NumberFormatException err) {
						JOptionPane.showMessageDialog(null, err.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
			
					
					
				}
			
		});
		button_H2.setBounds(413, 98, 83, 25);
		panel_NHarmonicosDados2.add(button_H2);
		
		JPanel panel_NHarmonicosDados3 = new JPanel();
		panelHarmonicoBaixo.add(panel_NHarmonicosDados3);
		panel_NHarmonicosDados3.setLayout(null);
		
		AmplitudeH3 = new JTextField();
		AmplitudeH3.setBounds(12, 22, 92, 33);
		panel_NHarmonicosDados3.add(AmplitudeH3);
		AmplitudeH3.setColumns(10);
		
		JLabel lblAmplitude_3 = new JLabel("Amplitude");
		lblAmplitude_3.setBounds(113, 25, 103, 26);
		panel_NHarmonicosDados3.add(lblAmplitude_3);
		
		AnguloH3 = new JTextField();
		AnguloH3.setColumns(10);
		AnguloH3.setBounds(214, 22, 92, 33);
		panel_NHarmonicosDados3.add(AnguloH3);
		
		JLabel lblnguloDeFase_3 = new JLabel("Ângulo de Fase");
		lblnguloDeFase_3.setBounds(324, 31, 138, 15);
		panel_NHarmonicosDados3.add(lblnguloDeFase_3);
		
		OrdemH3 = new JTextField();
		OrdemH3.setColumns(10);
		OrdemH3.setBounds(12, 78, 92, 33);
		panel_NHarmonicosDados3.add(OrdemH3);
		
		JLabel lblOrdemDeFase_3 = new JLabel("Ordem Harmônica");
		lblOrdemDeFase_3.setBounds(113, 87, 132, 15);
		panel_NHarmonicosDados3.add(lblOrdemDeFase_3);
		
		
		
		JPanel panel_part3 = new JPanel();
		panelUC3.add(panel_part3);
		panel_part3.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel_HarmonicoCima_Continuacao = new JPanel();
		panel_part3.add(panel_HarmonicoCima_Continuacao);
		panel_HarmonicoCima_Continuacao.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panel_NHarmonicos4 = new JPanel();
		panel_HarmonicoCima_Continuacao.add(panel_NHarmonicos4);
		panel_NHarmonicos4.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_graficoH4 = new JPanel();
		panel_NHarmonicos4.add(panel_graficoH4);
		panel_graficoH4.setLayout(null);
		graficoNHarmonico4=new GraphPanel(new ArrayList<>());
		graficoNHarmonico4.setBounds(0, -36, 496, 233);
		panel_graficoH4.add(graficoNHarmonico4);
		
		
		JLabel lblNmeroDeHarmnicos4 = new JLabel("Número de Harmônicos: 4");
		lblNmeroDeHarmnicos4.setBounds(157, 96, 275, 15);
		graficoNHarmonico4.add(lblNmeroDeHarmnicos4);
		
		JPanel panel_NHarmonicos5 = new JPanel();
		panel_HarmonicoCima_Continuacao.add(panel_NHarmonicos5);
		panel_NHarmonicos5.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_graficoH5 = new JPanel();
		panel_NHarmonicos5.add(panel_graficoH5);
		panel_graficoH5.setLayout(null);
		graficoNHarmonico5=new GraphPanel(new ArrayList<>());
		graficoNHarmonico5.setBounds(0, -64, 496, 247);
		panel_graficoH5.add(graficoNHarmonico5);
		
		
		JLabel lblNmeroDeHarmnicos5 = new JLabel("Número de Harmônicos: 5");
		lblNmeroDeHarmnicos5.setBounds(157, 96, 275, 15);
		graficoNHarmonico5.add(lblNmeroDeHarmnicos5);
		
		JPanel panel_NHarmonicos6 = new JPanel();
		panel_HarmonicoCima_Continuacao.add(panel_NHarmonicos6);
		panel_NHarmonicos6.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_graficoH6 = new JPanel();
		panel_NHarmonicos6.add(panel_graficoH6);
		panel_graficoH6.setLayout(null);
		graficoNHarmonico6=new GraphPanel(new ArrayList<>());
		graficoNHarmonico6.setBounds(0, -32, 496, 216);
		panel_graficoH6.add(graficoNHarmonico6);
		
		
		JLabel lblNmeroDeHarmnicos6 = new JLabel("Número de Harmônicos: 6");
		lblNmeroDeHarmnicos6.setBounds(157, 96, 275, 15);
		graficoNHarmonico6.add(lblNmeroDeHarmnicos6);
		JPanel panel_HarmonicoBaixo_Continuacao = new JPanel();
		panel_part3.add(panel_HarmonicoBaixo_Continuacao);
		panel_HarmonicoBaixo_Continuacao.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panel_NHarmonicosDados4 = new JPanel();
		panel_HarmonicoBaixo_Continuacao.add(panel_NHarmonicosDados4);
		panel_NHarmonicosDados4.setLayout(null);
		
		AmplitudeH4 = new JTextField();
		AmplitudeH4.setBounds(12, 22, 92, 33);
		panel_NHarmonicosDados4.add(AmplitudeH4);
		AmplitudeH4.setColumns(10);
		
		JLabel lblAmplitude_4 = new JLabel("Amplitude");
		lblAmplitude_4.setBounds(113, 25, 103, 26);
		panel_NHarmonicosDados4.add(lblAmplitude_4);
		
		AnguloH4 = new JTextField();
		AnguloH4.setColumns(10);
		AnguloH4.setBounds(214, 22, 92, 33);
		panel_NHarmonicosDados4.add(AnguloH4);
		
		JLabel lblnguloDeFase_4 = new JLabel("Ângulo de Fase");
		lblnguloDeFase_4.setBounds(324, 31, 138, 15);
		panel_NHarmonicosDados4.add(lblnguloDeFase_4);
		
		OrdemH4 = new JTextField();
		OrdemH4.setColumns(10);
		OrdemH4.setBounds(12, 78, 92, 33);
		panel_NHarmonicosDados4.add(OrdemH4);
		
		JLabel lblOrdemDeFase_4 = new JLabel("Ordem Harmônica");
		lblOrdemDeFase_4.setBounds(113, 87, 132, 15);
		panel_NHarmonicosDados4.add(lblOrdemDeFase_4);
		
		JButton button_H4 = new JButton("Enviar");
		button_H4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double variavelAmplitudeH4 = Double.parseDouble(AmplitudeH4.getText());
					double variavelAnguloH4 = Double.parseDouble(AnguloH4.getText());
					double variavelOrdemH4 = Double.parseDouble(OrdemH4.getText());
					
					c3.setAmplitude_H4(variavelAmplitudeH4);
					c3.setAngulo_H4(variavelAnguloH4);
					c3.setOrdem_H4(variavelOrdemH4);
					
					graficoNHarmonico4.setScores(c3.Formas_Harmonicas4());
					graficoResultante.setScores(c3.Forma_Distorcida_Resultante());
				}
					
					
					catch(NumberFormatException err) {
						JOptionPane.showMessageDialog(null, err.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
			
			}
		});
		button_H4.setBounds(407, 87, 77, 25);
		panel_NHarmonicosDados4.add(button_H4);
		
		JPanel panel_NHarmonicosDados5 = new JPanel();
		panel_HarmonicoBaixo_Continuacao.add(panel_NHarmonicosDados5);
		panel_NHarmonicosDados5.setLayout(null);
		
		AmplitudeH5 = new JTextField();
		AmplitudeH5.setBounds(12, 22, 92, 33);
		panel_NHarmonicosDados5.add(AmplitudeH5);
		AmplitudeH5.setColumns(10);
		
		JLabel lblAmplitude_5 = new JLabel("Amplitude");
		lblAmplitude_5.setBounds(113, 25, 103, 26);
		panel_NHarmonicosDados5.add(lblAmplitude_5);
		
		AnguloH5 = new JTextField();
		AnguloH5.setColumns(10);
		AnguloH5.setBounds(214, 22, 92, 33);
		panel_NHarmonicosDados5.add(AnguloH5);
		
		JLabel lblnguloDeFase_5 = new JLabel("Ângulo de Fase");
		lblnguloDeFase_5.setBounds(324, 31, 138, 15);
		panel_NHarmonicosDados5.add(lblnguloDeFase_5);
		
		OrdemH5 = new JTextField();
		OrdemH5.setColumns(10);
		OrdemH5.setBounds(12, 78, 92, 33);
		panel_NHarmonicosDados5.add(OrdemH5);
		
		JLabel lblOrdemDeFase_5 = new JLabel("Ordem Harmônica");
		lblOrdemDeFase_5.setBounds(113, 87, 132, 15);
		panel_NHarmonicosDados5.add(lblOrdemDeFase_5);
		
		JButton button_H5 = new JButton("Enviar");
		button_H5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double variavelAmplitudeH5 = Double.parseDouble(AmplitudeH5.getText());
					double variavelAnguloH5 = Double.parseDouble(AnguloH5.getText());
					double variavelOrdemH5 = Double.parseDouble(OrdemH5.getText());
					
					c3.setAmplitude_H5(variavelAmplitudeH5);
					c3.setAngulo_H5(variavelAnguloH5);
					c3.setOrdem_H5(variavelOrdemH5);
					
					graficoNHarmonico5.setScores(c3.Formas_Harmonicas5());
					graficoResultante.setScores(c3.Forma_Distorcida_Resultante());
				}
					
					
					catch(NumberFormatException err) {
						JOptionPane.showMessageDialog(null, err.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
			
			}
		});
		button_H5.setBounds(392, 87, 92, 25);
		panel_NHarmonicosDados5.add(button_H5);
		
		JPanel panel_NHarmonicosDados6 = new JPanel();
		panel_HarmonicoBaixo_Continuacao.add(panel_NHarmonicosDados6);
		panel_NHarmonicosDados6.setLayout(null);
		
		AmplitudeH6 = new JTextField();
		AmplitudeH6.setBounds(0, 25, 92, 33);
		panel_NHarmonicosDados6.add(AmplitudeH6);
		AmplitudeH6.setColumns(10);
		
		JButton button_H3 = new JButton("Enviar");
		button_H3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double variavelAmplitudeH3 = Double.parseDouble(AmplitudeH3.getText());
					double variavelAnguloH3 = Double.parseDouble(AnguloH3.getText());
					double variavelOrdemH3 = Double.parseDouble(OrdemH3.getText());
					
					c3.setAmplitude_H3(variavelAmplitudeH3);
					c3.setAngulo_H3(variavelAnguloH3);
					c3.setOrdem_H3(variavelOrdemH3);
					
					graficoNHarmonico3.setScores(c3.Formas_Harmonicas3());
					graficoResultante.setScores(c3.Forma_Distorcida_Resultante());
				}
					
					
					catch(NumberFormatException err) {
						JOptionPane.showMessageDialog(null, err.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
			
			}
		});
		button_H3.setBounds(413, 98, 83, 25);
		panel_NHarmonicosDados3.add(button_H3);
		
		JLabel lblAmplitude_6 = new JLabel("Amplitude");
		lblAmplitude_6.setBounds(113, 25, 103, 26);
		panel_NHarmonicosDados6.add(lblAmplitude_6);
		
		AnguloH6 = new JTextField();
		AnguloH6.setColumns(10);
		AnguloH6.setBounds(214, 22, 92, 33);
		panel_NHarmonicosDados6.add(AnguloH6);
		
		JLabel lblnguloDeFase_6 = new JLabel("Ângulo de Fase");
		lblnguloDeFase_6.setBounds(324, 31, 138, 15);
		panel_NHarmonicosDados6.add(lblnguloDeFase_6);
		
		OrdemH6 = new JTextField();
		OrdemH6.setColumns(10);
		OrdemH6.setBounds(12, 78, 92, 33);
		panel_NHarmonicosDados6.add(OrdemH6);
		
		JLabel lblOrdemDeFase_6 = new JLabel("Ordem Harmônica");
		lblOrdemDeFase_6.setBounds(113, 87, 132, 15);
		panel_NHarmonicosDados6.add(lblOrdemDeFase_6);
		
		JButton button_H6 = new JButton("Enviar");
		button_H6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double variavelAmplitudeH6 = Double.parseDouble(AmplitudeH6.getText());
					double variavelAnguloH6 = Double.parseDouble(AnguloH6.getText());
					double variavelOrdemH6 = Double.parseDouble(OrdemH6.getText());
					
					c3.setAmplitude_H6(variavelAmplitudeH6);
					c3.setAngulo_H6(variavelAnguloH6);
					c3.setOrdem_H6(variavelOrdemH6);
					
					graficoNHarmonico6.setScores(c3.Formas_Harmonicas6());
					graficoResultante.setScores(c3.Forma_Distorcida_Resultante());
				}
					
					
					catch(NumberFormatException err) {
						JOptionPane.showMessageDialog(null, err.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
			
			}
		});
		button_H6.setBounds(392, 82, 92, 25);
		panel_NHarmonicosDados6.add(button_H6);
		
		JPanel panel_Resultado = new JPanel();
		panelUC3.add(panel_Resultado);
		panel_Resultado.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_GraficoResultado = new JPanel();
		panel_Resultado.add(panel_GraficoResultado);
		panel_GraficoResultado.setLayout(new GridLayout(1, 0, 0, 0));
		graficoResultante=new GraphPanel(new ArrayList<>());
		panel_GraficoResultado.add(graficoResultante);
		graficoResultante.setLayout(null);
		
		JPanel panel = new JPanel();
		panel_Resultado.add(panel);
		panel.setLayout(null);
		
		JTextArea SerieFourier = new JTextArea();
		SerieFourier.setEditable(false);
		SerieFourier.setBounds(100, 100, 581, 80);
		panel.add(SerieFourier);
		
		JLabel lblNewLabel = new JLabel("Série de Fourier Amplitude - Fase");
		lblNewLabel.setFont(new Font("DejaVu Serif Condensed", Font.ITALIC, 16));
		lblNewLabel.setBounds(221, 31, 345, 57);
		panel.add(lblNewLabel);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
			
			
		});
		btnVoltar.setBounds(616, 210, 117, 25);
		panel.add(btnVoltar);
		
		
		 
	}
	
}
