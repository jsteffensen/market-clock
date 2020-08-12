package com.c2_systems.clock;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.TimeZone;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class App extends JFrame {


    	 private JTextField displayField;  // set by timer listener

    	    public App() {

    	    	System.setProperty("user.timezone", "America/New_York");
    	        TimeZone.setDefault(null);
    	        
    	        displayField = new JTextField(5);
    	        displayField.setEditable(false);
    	        displayField.setFont(new Font("sansserif", Font.PLAIN, 48));

    	        JPanel content = new JPanel();
    	        content.setLayout(new FlowLayout());
    	        content.add(displayField); 
    	        
    	        this.setContentPane(content);
    	        this.setTitle("Market Clock");
    	        this.pack();
    	        this.setLocationRelativeTo(null);
    	        this.setResizable(false);

    	        javax.swing.Timer t = new javax.swing.Timer(100, new ClockListener());
    	        
    	        t.start();
    	    }
    	    
    	    /////////////////////////////////////////////// inner class ClockListener
    	    class ClockListener implements ActionListener {
    	    	public void actionPerformed(ActionEvent e) {

    	            Calendar now = Calendar.getInstance();
    	            int h = now.get(Calendar.HOUR_OF_DAY);
    	            
    	            int m = now.get(Calendar.MINUTE);
    	            int s = now.get(Calendar.SECOND);
    	            
    	            String paddedHour = String.format("%02d", h);
    	            String paddedMinute = String.format("%02d", m);
    	            String paddedSecond = String.format("%02d", s);
    	            
    	            displayField.setText(paddedHour + ":" + paddedMinute + ":" + paddedSecond);

    	    	}
    	    }
    	    
    	    //================================================================= main
    	    public static void main(String[] args) {
    	        JFrame clock = new App();
    	        clock.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	        clock.setVisible(true);
    	    }
    	
}
