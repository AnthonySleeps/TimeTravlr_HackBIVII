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
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.Random;

public class TimeTravlr {
	private ArrayList<TimeImage> imageList = new ArrayList<TimeImage>();
	private Random rand = new Random();
	private TimeImage randImage;
	
	public TimeTravlr(ArrayList<TimeImage> imageFiles) {
		imageList.add(new TimeImage("images.zip/", 1920));
		
		drawFrame();
	}
	
	public TimeTravlr() {
		
		drawFrame();
	}
	
	
	public void drawFrame() {
		JFrame frame = new JFrame();
		JButton startButton = new JButton("Get Image");
       startButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
        	   randImage = imageList.get(rand.nextInt(imageList.size()));

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
		frame.add(new GamePanel(randImage));
		frame.setVisible(true);
		
		
	}
}
class GamePanel extends JComponent {
	
	private String fileName;
	private TimeImage currentImage;
	private BufferedImage pic;
	
	public GamePanel(TimeImage i) {
		currentImage = i;
		fileName = i.getFileName();
		try {
			pic = ImageIO.read(new File(fileName));
		} catch (IOException e) {
			//add functionality for files that are not found later
		}
		
		
	}
	
	public void drawCurrentImage(Graphics g) {
		g.drawImage(pic, 0, 20, null);
	}
}











