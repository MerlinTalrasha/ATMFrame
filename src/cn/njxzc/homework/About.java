package cn.njxzc.homework;

import java.awt.AWTEvent;
import java.awt.Dimension;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.KeyEvent;

public class About extends JDialog {

	public About() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
        toolkit.addAWTEventListener(new AWTEventListener(){
                @Override 
                public void eventDispatched(AWTEvent e){
                    if (e.getID() == KeyEvent.KEY_PRESSED) {
                        KeyEvent evt = (KeyEvent) e;
                        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
                            dispose();
                        }
                    }
                }
        	},AWTEvent.KEY_EVENT_MASK);
		setResizable(false);
		setTitle("\u5173\u4E8E");
		setSize(338, 303);
		Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
		int height = this.getHeight()/2;
		int width = this.getWidth()/2;
		int x = screensize.width/2;
		int y = screensize.height/2;
		setLocation(x-width, y-height);

		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ATM System");
		lblNewLabel.setFont(new Font("����", Font.BOLD, 28));
		lblNewLabel.setBounds(75, 79, 216, 69);
		getContentPane().add(lblNewLabel);
		
		JLabel lblProjectByTalrasha = new JLabel("Project by TalRasha");
		lblProjectByTalrasha.setBounds(162, 158, 135, 15);
		getContentPane().add(lblProjectByTalrasha);
	}

}