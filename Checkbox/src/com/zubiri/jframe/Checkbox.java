package com.zubiri.jframe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Checkbox extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Checkbox frame = new Checkbox();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Checkbox() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblElijaSuOpcin = new JLabel("Elija su opción");
		lblElijaSuOpcin.setBounds(52, 29, 101, 15);
		contentPane.add(lblElijaSuOpcin);
		
		JCheckBox chckbxPrimera = new JCheckBox("Primera");
		chckbxPrimera.setBounds(174, 25, 129, 23);
		contentPane.add(chckbxPrimera);
		
		JCheckBox chckbxSegunda = new JCheckBox("Segunda");
		chckbxSegunda.setBounds(174, 52, 129, 23);
		contentPane.add(chckbxSegunda);
		
		JCheckBox chckbxTercera = new JCheckBox("Tercera");
		chckbxTercera.setBounds(174, 79, 129, 23);
		contentPane.add(chckbxTercera);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(chckbxPrimera.isSelected()==true){
					System.out.println("La opción una ha sido seleccionada");
				}
				else if(chckbxSegunda.isSelected()==true){
					System.out.println("La opción dos ha sido seleccionada");
				}
				else if(chckbxTercera.isSelected()==true){
					System.out.println("La opción tres ha sido seleccionada");
				}
			}
		});
		btnOk.setBounds(47, 138, 117, 25);
		contentPane.add(btnOk);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Operación Abortada");
			}
		});
		btnCancel.setBounds(198, 138, 117, 25);
		contentPane.add(btnCancel);
	}
}
