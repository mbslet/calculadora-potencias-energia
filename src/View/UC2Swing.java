package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.UC2;

import java.awt.FlowLayout;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.GridLayout;
import java.awt.Font;

public class UC2Swing extends JFrame {

	private JPanel contentPane;
	private JTextField CampoC1;
	private JTextField CampoC2;

	private GraphPanel graficoCorrente;
	private GraphPanel graficoTensao;
	private GraphPanel graficoPotInst;
	private JTextField Campo3;
	private JTextField Campo4;
	private JTextField CampoPotAtiva;
	private JTextField CampoPotRelativa;
	private JTextField CampoPotAparente;
	private JTextField CampoFatorPot;
	
	UC2 calc;
	
	/**
	 * Create the frame.
	 */
	public UC2Swing() {
		calc = new UC2();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 1000, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(3, 1, 10, 10));
		
		JPanel panelEntradaCorrente = new JPanel();
		panel.add(panelEntradaCorrente);
		panelEntradaCorrente.setLayout(new GridLayout(0, 2, 10, 0));
		
		JPanel panelGraficoCorrente = new JPanel();
		panelEntradaCorrente.add(panelGraficoCorrente);
		panelGraficoCorrente.setLayout(new GridLayout(1, 1, 0, 0));
		graficoCorrente=new GraphPanel(new ArrayList<>());
		panelGraficoCorrente.add(graficoCorrente);
		
		JPanel panelValoresCorrente = new JPanel();
		panelEntradaCorrente.add(panelValoresCorrente);
		panelValoresCorrente.setLayout(null);
		
		CampoC1 = new JTextField();
		CampoC1.setBounds(45, 131, 114, 34);
		panelValoresCorrente.add(CampoC1);
		CampoC1.setColumns(10);
		
		
		
		CampoC2 = new JTextField();
		CampoC2.setBounds(45, 179, 114, 34);
		panelValoresCorrente.add(CampoC2);
		CampoC2.setColumns(10);
		
		JLabel lblAmplitude = new JLabel("Amplitude");
		lblAmplitude.setBounds(177, 150, 106, 15);
		panelValoresCorrente.add(lblAmplitude);
		
		JLabel lblNewLabel_1 = new JLabel("Ângulo Fase de Corrente");
		lblNewLabel_1.setBounds(178, 179, 185, 32);
		panelValoresCorrente.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Enviar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double variavelAmplitudeCorrente = Double.parseDouble(CampoC1.getText());
					double variavelAnguloCorrente = Double.parseDouble(CampoC2.getText());
					calc.setAmplitude_corrente(variavelAmplitudeCorrente);
					calc.setAngulo_corrente(variavelAnguloCorrente);
					graficoCorrente.setScores(calc.F_onda_corrente());
					graficoPotInst.setScores(calc.F_onda_potencia_instantanea());
					CampoPotAtiva.setText(Double.toString(calc.F_potencia_ativa()));
					CampoPotRelativa.setText(Double.toString(calc.F_potencia_reativa()));
					CampoPotAparente.setText(Double.toString(calc.F_potencia_aparente()));
					CampoFatorPot.setText(Double.toString(calc.F_fator_potencia()));
					}
					
					catch(NumberFormatException err) {
						JOptionPane.showMessageDialog(null, err.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
					catch(IllegalArgumentException err) {
						JOptionPane.showMessageDialog(null, err.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
					
				}
				
			
				
			}
		);
		btnNewButton.setBounds(197, 242, 117, 25);
		panelValoresCorrente.add(btnNewButton);
		panelEntradaCorrente.setLayout(new GridLayout(0, 2, 10, 0));
		
		JPanel panelEntradaTensao = new JPanel();
		panel.add(panelEntradaTensao);
		panelEntradaTensao.setLayout(new GridLayout(0, 2, 10, 0));
		graficoTensao=new GraphPanel(new ArrayList<>());
		panelEntradaTensao.add(graficoTensao);
		
		JPanel panelValoresTensao = new JPanel();
		panelEntradaTensao.add(panelValoresTensao);
		panelValoresTensao.setLayout(null);
		
		Campo3 = new JTextField();
		Campo3.setColumns(10);
		Campo3.setBounds(48, 114, 114, 34);
		panelValoresTensao.add(Campo3);
		
		Campo4 = new JTextField();
		Campo4.setColumns(10);
		Campo4.setBounds(48, 160, 114, 34);
		panelValoresTensao.add(Campo4);
		
		JLabel label = new JLabel("Amplitude");
		label.setBounds(180, 123, 106, 15);
		panelValoresTensao.add(label);
		
		JLabel label_1 = new JLabel("Ângulo Fase de Tensão");
		label_1.setBounds(185, 160, 185, 32);
		panelValoresTensao.add(label_1);
		
		JButton button = new JButton("Enviar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				double variavelAmplitudeTensao = Double.parseDouble(Campo3.getText());
				double variavelAnguloTensao = Double.parseDouble(Campo4.getText());
				calc.setAmplitude_tensao(variavelAmplitudeTensao);
				calc.setAngulo_tensao(variavelAnguloTensao);
				graficoTensao.setScores(calc.F_onda_tensao());
				graficoPotInst.setScores(calc.F_onda_potencia_instantanea());
				CampoPotAtiva.setText(String.format("%.2f", calc.F_potencia_ativa()));
				CampoPotRelativa.setText(Double.toString(calc.F_potencia_reativa()));
				CampoPotAparente.setText(Double.toString(calc.F_potencia_aparente()));
				CampoFatorPot.setText(Double.toString(calc.F_fator_potencia()));
				}
				catch(NumberFormatException err) {
					JOptionPane.showMessageDialog(null, err.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
				catch(IllegalArgumentException err) {
					JOptionPane.showMessageDialog(null, err.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		button.setBounds(213, 245, 117, 25);
		panelValoresTensao.add(button);
		
		JLabel lblNewLabel_2 = new JLabel("Tensão");
		lblNewLabel_2.setBounds(165, 25, 177, 34);
		panelValoresTensao.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 20));
		panelValoresCorrente.setLayout(null);
		
		JLabel lblCorrente = new JLabel("Corrente");
		lblCorrente.setBounds(151, 45, 177, 34);
		panelValoresCorrente.add(lblCorrente);
		lblCorrente.setFont(new Font("Dialog", Font.BOLD, 20));
		
		
		JPanel panelSaida = new JPanel();
		panel.add(panelSaida);
		panelSaida.setLayout(new GridLayout(0, 2, 10, 0));
		graficoPotInst=new GraphPanel(new ArrayList<>());
		panelSaida.add(graficoPotInst);
		
		JPanel panelValoresSaida = new JPanel();
		panelSaida.add(panelValoresSaida);
		panelValoresSaida.setLayout(null);
		
		CampoPotAtiva = new JTextField();
		CampoPotAtiva.setBounds(156, 44, 162, 19);
		panelValoresSaida.add(CampoPotAtiva);
		CampoPotAtiva.setColumns(10);
		
		JLabel lblPotnciaAtiva = new JLabel("Potência Ativa");
		lblPotnciaAtiva.setBounds(12, 48, 126, 15);
		panelValoresSaida.add(lblPotnciaAtiva);
		
		CampoPotRelativa = new JTextField();
		CampoPotRelativa.setColumns(10);
		CampoPotRelativa.setBounds(156, 86, 162, 19);
		panelValoresSaida.add(CampoPotRelativa);
		
		JLabel lblPotnciaRelativa = new JLabel("Potência Relativa");
		lblPotnciaRelativa.setBounds(12, 90, 126, 15);
		panelValoresSaida.add(lblPotnciaRelativa);
		
		CampoPotAparente = new JTextField();
		CampoPotAparente.setColumns(10);
		CampoPotAparente.setBounds(156, 130, 162, 19);
		panelValoresSaida.add(CampoPotAparente);
		
		JLabel lblNewLabel = new JLabel("Potência Aparente");
		lblNewLabel.setBounds(12, 132, 142, 15);
		panelValoresSaida.add(lblNewLabel);
		
		CampoFatorPot = new JTextField();
		CampoFatorPot.setColumns(10);
		CampoFatorPot.setBounds(156, 173, 162, 19);
		panelValoresSaida.add(CampoFatorPot);
		
		JLabel lblFatorDePotncia = new JLabel("Fator de Potência");
		lblFatorDePotncia.setBounds(12, 175, 126, 15);
		panelValoresSaida.add(lblFatorDePotncia);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVoltar.setBounds(361, 275, 117, 25);
		panelValoresSaida.add(btnVoltar);
		
		
	}
}
