package View;

import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Helper.Helper;
import Model.Clinic;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class UpdateClinicGUI extends JFrame {

	/**
	 * 
	 */
	private JPanel contentPane;
	private JTextField fld_clinicName;
	private static Clinic clinic;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateClinicGUI frame = new UpdateClinicGUI(clinic);
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
	public UpdateClinicGUI(Clinic clinic) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Polikinlik Adı");
		lblNewLabel.setBounds(36, 24, 195, 40);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		contentPane.add(lblNewLabel);
		
		fld_clinicName = new JTextField();
		fld_clinicName.setBounds(35, 76, 320, 33);
		fld_clinicName.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 26));
		fld_clinicName.setText(clinic.getName());
		fld_clinicName.setColumns(10);
		contentPane.add(fld_clinicName);
		
		JButton btn_updateClinic = new JButton("Düzenle");
		btn_updateClinic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Helper.confirm("sure")) {
					try {
					clinic.updateClinic(clinic.getId(), fld_clinicName.getText());
					Helper.showMsg("success");
					dispose();
					
				}catch (SQLException e1) {
					e1.printStackTrace();
					
				}
		   }
		}
				
		});
		btn_updateClinic.setBounds(36, 136, 319, 51);
		btn_updateClinic.setFont(new Font("Tahoma", Font.PLAIN, 25));
		contentPane.add(btn_updateClinic);
		
}
}