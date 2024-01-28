import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.Random;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class TimeTravlr {
	private ArrayList<TimeImage> imageList = new ArrayList<TimeImage>();
	private Random rand = new Random();
	private TimeImage randImage;
	private GamePanel gamePanel;
	private String tempText = "Enter your first guess \n (use negative numbers for BC)";
	 
	
	public TimeTravlr() {
		
		imageList.add(new TimeImage("images/1910scar.jpg", 1908));
		imageList.add(new TimeImage("images/ameliaearhart.jpg",1920));
		imageList.add(new TimeImage("images/apollo13.jpg",1970));
		imageList.add(new TimeImage("images/beatles.jpg",1964));
		//imageList.add(new TimeImage("images/challenger.webp",1930));
		imageList.add(new TimeImage("images/chernobyl.jpg",1986));
		imageList.add(new TimeImage("images/coldwar.jpg",1962));
		imageList.add(new TimeImage("images/dinosaurstrex.jpg",-90000000));
		imageList.add(new TimeImage("images/dinosaurs.jpg",-150000000));
		imageList.add(new TimeImage("images/egypt.jpg",-2400));
		imageList.add(new TimeImage("images/elvis.jpg",1954));
		imageList.add(new TimeImage("images/firsttelevisions.jpg",1927));
		imageList.add(new TimeImage("images/gandhi.jpg",1930));
		imageList.add(new TimeImage("images/greatdepression.jpg",1929));
		imageList.add(new TimeImage("images/gulfwar.jpg",1990));
		imageList.add(new TimeImage("images/hindenburg.jpg",1937));
		imageList.add(new TimeImage("images/hiroshima.jpg",1945));
		imageList.add(new TimeImage("images/holocaust.jpg",1941));
		imageList.add(new TimeImage("images/iraqirevolt.jpg",1920));
		imageList.add(new TimeImage("images/macintosh.jpg",1984));
		imageList.add(new TimeImage("images/marketcrash.jpg",1987));
		imageList.add(new TimeImage("images/.moonlanding.jpg",1969));
		imageList.add(new TimeImage("images/nixon.jpg",1970));
		imageList.add(new TimeImage("images/ojsimpson.jpg",1995));
		imageList.add(new TimeImage("images/pilgrims.jpg",1621));
		imageList.add(new TimeImage("images/radio.jpg",1893));
		imageList.add(new TimeImage("images/renaissance.jpg",1519));
		imageList.add(new TimeImage("images/sputnik.jpg",1957));
		imageList.add(new TimeImage("images/stoneage.jpg",-2600000));
		imageList.add(new TimeImage("images/titanic.jpg",1912));
		imageList.add(new TimeImage("images/vietnam.jpg",1955));
		imageList.add(new TimeImage("images/vikings.jpg",800));
		imageList.add(new TimeImage("images/wrightbrothers.jpg", 1903));
		imageList.add(new TimeImage("images/ww1.jpg",1914));
		imageList.add(new TimeImage("images/ww2.jpg",1939));
		imageList.add(new TimeImage("images/AlbertEinstein.jpg",1951));
		imageList.add(new TimeImage("FrenchRevolution.jpg",1787));
		imageList.add(new TimeImage("Boxing.jpg",1965));
		
		randImage = imageList.get(rand.nextInt(imageList.size()));

		gamePanel = new GamePanel(randImage);
		drawFrame();
	}
	
	
	
	
	public void drawFrame() {
		JFrame frame = new JFrame();
		JButton startButton = new JButton("Get Image");
       startButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
        	   randImage = imageList.get(rand.nextInt(imageList.size()));
        	   gamePanel.resetCurrentImage(randImage);
        	   frame.repaint();

           }
       });
		
		
		frame.setName("TimeTravlr!");
		//ProductionLine clonedLine = line.clone();
//works here		System.out.println(line.getInputQueue());
		frame.setSize(1400,900);
// empty here		System.out.println(line.getInputQueue());
		frame.setBackground(Color.ORANGE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.add(startButton);
		frame.add(panel, BorderLayout.PAGE_START);
		
		JPanel panel2 = new JPanel();
        JTextField guessField = new JTextField(60);
        guessField.setText("");
        guessField.setFont( new Font("Sans_Serif", Font.PLAIN, 24));
     //   guessField.setBounds(0, 0, 500, 80); // Set the position and size of the text field
        panel2.add(guessField);
        frame.add(panel2, BorderLayout.PAGE_END);
        
        JPanel panel3 = new JPanel();
        JTextArea textField2 = new JTextArea();
        textField2.setEditable(false);
        textField2.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        textField2.setText("Welcome to TimeTravlr.\n An Image based game based off of GeoGuesser. \n Assist out time travelers in their \nDeLorean and find out what \n year they're in based on the image. \n Guess any year and see how far you were!");
        guessField.setBounds(0, 0, 300, 900);
        panel3.add(textField2);
        frame.add(panel3, BorderLayout.LINE_END);
        
        JPanel panel4 = new JPanel();
        JTextArea textField3 = new JTextArea();
        textField3.setEditable(false);
        textField3.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        textField3.setText(tempText);
        guessField.setBounds(0, 0, 300, 900);
        panel4.add(textField3);
        frame.add(panel4, BorderLayout.LINE_START);
        
        JPanel buttonPanel = new JPanel();
        JButton enterButton = new JButton("Guess!");
        enterButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
        	   String answer = guessField.getText();
        	   try {
        		  int intAnswer = Integer.parseInt(answer);
        		  int difference = intAnswer - randImage.getTime();
        		  if (difference < 0)
        			  difference = difference *-1;
        		  
        		  if(difference == 0) {
        			  textField3.setText("Correct! \n This picture is from " + randImage.getTime());
        		  } else {
        			  textField3.setText("Wrong Time! \nThis Picture is from" + randImage.getTime() + " \nyou were about " + difference + " years off.");
        		  }
        		  
        	   } catch (NumberFormatException n) {
        		   tempText = "Invalid Guess Format";
        	   }

           }
       });
        buttonPanel.setBackground(Color.RED);
        buttonPanel.add(enterButton);
        buttonPanel.setMaximumSize(new Dimension(50,20));
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
         mainPanel.add(gamePanel);
        mainPanel.add(buttonPanel);
      
		frame.add(mainPanel);
     //   frame.add(mainPanel, BorderLayout.CENTER);
		frame.setVisible(true);
		
		
	}
}

class GamePanel extends JComponent {
	
	private String fileName;
	private TimeImage currentImage;
	private BufferedImage pic;
	
	private TimeImage errorImage;
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawCurrentImage(g);
	}
	
	public GamePanel(TimeImage i) {
		errorImage = new TimeImage("error.jpg",0000);
		currentImage = i;
		fileName = i.getFileName();
		try {
			pic = ImageIO.read(new File(fileName));
		} catch (IOException e) {
			//add functionality for files that are not found later
			resetCurrentImage(new TimeImage("error.jpg",0000));
			System.out.println("Cant find image file");
			
			
		}
		
	}
	
	public void resetCurrentImage(TimeImage i) {
		currentImage = i;
		fileName = i.getFileName();
		try {
			pic = ImageIO.read(new File(fileName));
		} catch (IOException e) {
			//add functionality for files that are not found later
			System.out.println("Cant find image file");
		}
	}
	
	private static BufferedImage scale2w(BufferedImage before, double scale) {
	    int w = before.getWidth();
	    // Create a new image of the proper size
	    int w2 = (int) (w * scale);

	    BufferedImage after = new BufferedImage(w2, before.getHeight(), BufferedImage.TYPE_INT_ARGB);
	    AffineTransform scaleInstance = AffineTransform.getScaleInstance(scale, 1);
	    AffineTransformOp scaleOp 
	        = new AffineTransformOp(scaleInstance, AffineTransformOp.TYPE_BILINEAR);

	    Graphics2D g2 = (Graphics2D) after.getGraphics();
	    // Here, you may draw anything you want into the new image, but we're
	    // drawing a scaled version of the original image.
	    g2.drawImage(before, scaleOp, 0, 0);
	    g2.dispose();
	    return after;
	}
	
	private static BufferedImage scale2h(BufferedImage before, double scale) {

	    int h = before.getHeight();
	    // Create a new image of the proper size

	    int h2 = (int) (h * scale);
	    BufferedImage after = new BufferedImage(before.getWidth(), h2, BufferedImage.TYPE_INT_ARGB);
	    AffineTransform scaleInstance = AffineTransform.getScaleInstance(1, scale);
	    AffineTransformOp scaleOp 
	        = new AffineTransformOp(scaleInstance, AffineTransformOp.TYPE_BILINEAR);

	    Graphics2D g2 = (Graphics2D) after.getGraphics();
	    // Here, you may draw anything you want into the new image, but we're
	    // drawing a scaled version of the original image.
	    g2.drawImage(before, scaleOp, 0, 0);
	    g2.dispose();
	    return after;
	}
	
	
	public void drawCurrentImage(Graphics g) {
		
		pic = scale2w(pic,(double)(700/(double)pic.getWidth()));
		pic = scale2h(pic, (double)(450/(double)pic.getHeight()));
		g.drawImage(pic, 25, 20, null);
			
		}
	}












