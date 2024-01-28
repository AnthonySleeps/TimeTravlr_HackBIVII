import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Queue;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class TimeTravlr {
	private ArrayList<TimeImage> imageList = new ArrayList<TimeImage>();
	
	
	public TimeTravlr(ArrayList<TimeImage> imageFiles) {
		imageList.add(new TimeImage("i2jojai", 1920));
		
		drawFrame();
	}
	
	public TimeTravlr() {
		
		drawFrame();
	}
	
	
	public void drawFrame() {
		JFrame frame = new JFrame();
		
		JButton startButton = new JButton("Start");
       startButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               Timer timer = new Timer(30000, new ActionListener() {
               	int time = 30;
                   @Override
                   	
                   public void actionPerformed(ActionEvent e) {
                   	
                       for (int x = time; x >= 0; x--) {
                       	time --;
                           frame.repaint();
                       }
//                        System.out.println("frame is repainted");
                      
                   }
               });
               timer.start();
           }
       });
		
		
		frame.setName("TimeTravlr!");
		//ProductionLine clonedLine = line.clone();
//works here		System.out.println(line.getInputQueue());
		frame.setSize(800,1200);
// empty here		System.out.println(line.getInputQueue());
		frame.setBackground(Color.ORANGE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.add(startButton);
		frame.add(panel, BorderLayout.PAGE_START);
// empty here		System.out.println(line.getInputQueue());
		frame.add(new GamePanel());
		frame.setVisible(true);
		
		
	}
}
class GamePanel extends JComponent {
	public GamePanel() {
		
	}
}











