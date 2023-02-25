import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Main {
	
	JFrame window;
	JLabel counterLabel;
	Font font1 = new Font("Arial", Font.PLAIN, 70);	
	Timer timer;	
	int second, minute;
	String ddSecond, ddMinute;	
	DecimalFormat dFormat = new DecimalFormat("00");
	

	public static void main(String[] args) {
		
		new Main();		
	}
	
	public Main() {
		
		window = new JFrame();
		window.setSize(800,600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLayout(null);
		
		counterLabel = new JLabel("");
		counterLabel.setBounds(300, 230, 200, 100);
		counterLabel.setHorizontalAlignment(JLabel.CENTER);
		counterLabel.setFont(new Font ("Ink Free",Font.PLAIN,50));
		counterLabel.setBorder(BorderFactory.createBevelBorder(1));
		
		window.add(counterLabel);
		window.setVisible(true);
		

		counterLabel.setText("00:00");
		second =0;
		minute =0;
		normalTimer();
		timer.start();
		
							
	}
    

	public void normalTimer() {
		
		timer = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				second++;
				
				ddSecond = dFormat.format(second);
				ddMinute = dFormat.format(minute);				
				counterLabel.setText(ddMinute + ":" + ddSecond);
				
				if(second==60) {
					second=0;
					minute++;
					
					ddSecond = dFormat.format(second);
					ddMinute = dFormat.format(minute);
					counterLabel.setText(ddMinute + ":" + ddSecond);
				}
			}
		});
	}

}

