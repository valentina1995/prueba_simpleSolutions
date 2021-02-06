package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.InputVerifier;

import controler.*;
import model.*;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Font;

public class register {

	private JFrame frame;
	private JTextField textNameCycle;
	private JTextField textCtdCasos;
	private JTextField textCtdExit;
	private JTextField textCtdDefct;
	private JTextField textCTdPend;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					register window = new register();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Operations oper = new Operations();
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 450, 388);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Lleno el ComboBox con los datos de la base de datos
		JComboBox comboBoxApp = new JComboBox();

		comboBoxApp.setBounds(10, 40, 195, 28);
		frame.getContentPane().add(comboBoxApp);
		oper.consultarTodosApp(comboBoxApp);
		
		
		//Declaro el comboBox de versiones existentes y lo lleno
		JComboBox comboBoxVer = new JComboBox();
		comboBoxVer.setBounds(10, 88, 195, 28);
		frame.getContentPane().add(comboBoxVer);
		
		comboBoxApp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBoxVer.removeAllItems();
				String selectApp = (String)comboBoxApp.getSelectedItem();
				int idApp = oper.consultarIdApp(selectApp);
				oper.consultarVersion(idApp, comboBoxVer);
			}
		});
		

		
		JLabel lblNewLabel = new JLabel("Nombre del ciclo");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(20, 139, 120, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblCtdCasos = new JLabel("Casos exitosos");
		lblCtdCasos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCtdCasos.setBounds(20, 216, 120, 20);
		frame.getContentPane().add(lblCtdCasos);
		

		
		JLabel lblCtdExit = new JLabel("Cantidad de casos de uso");
		lblCtdExit.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCtdExit.setBounds(20, 180, 120, 20);
		frame.getContentPane().add(lblCtdExit);
		
		JLabel lblCtdDefct = new JLabel("Casos con defectos");
		lblCtdDefct.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCtdDefct.setBounds(20, 247, 120, 20);
		frame.getContentPane().add(lblCtdDefct);
		
		JLabel lblCTdPend = new JLabel("Casos pendientes");
		lblCTdPend.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCTdPend.setBounds(20, 278, 120, 20);
		frame.getContentPane().add(lblCTdPend);
		
		JLabel lblPorcExito = new JLabel("");
		lblPorcExito.setHorizontalAlignment(SwingConstants.CENTER);
		lblPorcExito.setBounds(272, 177, 130, 20);
		frame.getContentPane().add(lblPorcExito);
		
		JLabel lblPorInci = new JLabel("");
		lblPorInci.setHorizontalAlignment(SwingConstants.CENTER);
		lblPorInci.setBounds(272, 247, 130,20);
		frame.getContentPane().add(lblPorInci);
		
		textNameCycle = new JTextField();
		textNameCycle.setBounds(160, 139, 115, 20);
		frame.getContentPane().add(textNameCycle);
		textNameCycle.setColumns(10);
		
		
		textCtdCasos = new JTextField();
		textCtdCasos.setBounds(160, 178, 38, 20);
		textCtdCasos.setColumns(10);
		//textCtdCasos.setInputVerifier(new MyInputVerifier());
		frame.getContentPane().add(textCtdCasos);
		
		textCtdExit = new JTextField();
		textCtdExit.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(!(textCtdCasos.getText().isEmpty() || textCtdExit.getText().isEmpty())) {
					float ctdCasos = Float.parseFloat(textCtdCasos.getText());
					float ctdExit = Float.parseFloat(textCtdExit.getText());
					float por =ctdExit/ctdCasos;
					lblPorcExito.setText(String.format("%.2f", por*100));
				}else {
					JOptionPane.showConfirmDialog(lblPorcExito, "Ingrese el valor total y cantidad de exitosos, en caso de que ninguno fuera exitoso coloque 0");
				}
			}
		});
		textCtdExit.setBounds(160, 216, 38, 20);
		textCtdExit.setColumns(10);
		//textCtdExit.setInputVerifier(new MyInputVerifier());
		frame.getContentPane().add(textCtdExit);
		
		
		textCtdDefct = new JTextField();
		textCtdDefct.setColumns(10);
		textCtdDefct.setBounds(160, 247, 38, 20);
		//textCtdDefct.setInputVerifier(new MyInputVerifier());
		frame.getContentPane().add(textCtdDefct);
		
		textCTdPend = new JTextField();
		textCTdPend.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(!(textCTdPend.getText().isEmpty() || textCtdDefct.getText().isEmpty() || textCtdCasos.getText().isEmpty())) {
					float ctdCasos = Float.parseFloat(textCtdCasos.getText());
					float ctdPend = Float.parseFloat(textCTdPend.getText());
					float CtdDefct = Float.parseFloat(textCtdDefct.getText());
					float por =(ctdPend+CtdDefct)/ctdCasos;
					lblPorInci.setText(String.format("%.2f", por*100));
				}else {
					JOptionPane.showConfirmDialog(lblPorInci, "Ingrese el valor total y cantidad de casos erroneos, en caso de que ninguno tuviera incidencias coloque 0");
				}
			}
		});
		textCTdPend.setColumns(10);
		textCTdPend.setBounds(160, 278, 38, 20);
		frame.getContentPane().add(textCTdPend);
		//textCTdPend.setInputVerifier(new MyInputVerifier());


		
		
		
		JLabel lblNewLabel_2 = new JLabel("% Casos exitosos");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(272, 216, 130, 20);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("% Casos con incidencias");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(272, 281, 130, 20);
		frame.getContentPane().add(lblNewLabel_3);

		
		//Botón guardar
		JButton btnRegister = new JButton("Guardar");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					cycle temp;
					String id_ver = (String) comboBoxVer.getSelectedItem();
					String selectApp = (String)comboBoxApp.getSelectedItem();
					int idApp = oper.consultarIdApp(selectApp);
					int id_vers = oper.consultarIdVer(id_ver, idApp);
					String name = textNameCycle.getText();
					int ctdCasos = Integer.parseInt(textCtdCasos.getText());
					int ctdExit = Integer.parseInt(textCtdExit.getText());
					int ctdDefect = Integer.parseInt(textCtdDefct.getText());
					int ctdPend = Integer.parseInt(textCTdPend.getText());
					float porExit = (float)ctdExit/ctdCasos;
					float porInc = (float)(ctdPend+ctdDefect)/ctdCasos;
					temp = new cycle(id_vers, name,ctdCasos,ctdExit,ctdDefect,ctdPend, porExit, porInc);
					System.out.println(temp.toString());
					if(validate(temp)){
						if(oper.crearCycle(temp)) {
							JOptionPane.showMessageDialog(null, "Guardado exitoso");
						}
					}else {
						JOptionPane.showMessageDialog(null, "Datos incompletos,llene todos los campos");
					}
					
			}
		});
		btnRegister.setForeground(new Color(105, 105, 105));
		btnRegister.setBounds(160, 315, 89, 23);
		frame.getContentPane().add(btnRegister);
		
		JLabel lblNewLabel_1 = new JLabel("Registre los resultados de las pruebas");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 17));
		lblNewLabel_1.setBounds(10, 11, 414, 28);
		frame.getContentPane().add(lblNewLabel_1);
		
		

			
		;
		
		
	}
	
	public boolean validate(cycle data) {
		for (int i = 0; i < 8;i++) {
			if(data.toString().isEmpty()) {
				return false;
			}
			
		}
		
		return true;
		
	}
	
	

}


