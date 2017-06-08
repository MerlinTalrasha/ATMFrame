package cn.njxzc.homework;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class About extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			About dialog = new About();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public About() {
		setBounds(100, 100, 338, 303);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ATM System");
		lblNewLabel.setFont(new Font("ËÎÌו", Font.BOLD, 28));
		lblNewLabel.setBounds(82, 66, 216, 69);
		getContentPane().add(lblNewLabel);
		
		JLabel lblProjectByTalrasha = new JLabel("Project by TalRasha");
		lblProjectByTalrasha.setBounds(163, 145, 135, 15);
		getContentPane().add(lblProjectByTalrasha);
	}

}
