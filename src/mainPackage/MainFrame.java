package mainPackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.WindowConstants;
import mainPackage.ServiceFactory.services;

public class MainFrame extends JFrame implements Runnable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ServiceFactory serviceFactory = new ServiceFactory();
	Location locationData = new Location();
	IWeatherDataService serviceData = serviceFactory.getService(services.OpenWeatherMap);
	WeatherData wData = new WeatherData();

	JButton b1 = new JButton("Search"); 
	JButton b2 = new JButton("Exit");
	JTextField inputText = new JTextField("Type Here",15);
	JPanel defComPan = new JPanel();
	JPanel ansComPan = new JPanel();
	JPanel endComPan = new JPanel();
	JTextArea textA = new JTextArea();
	JLabel label1 = new JLabel("Want to know whats the weather is like in Thailand or Brazil ? now you CAN !\n");
	JLabel label2 = new JLabel("Enter a city and / or Country , and find out !");
	
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension dim = tk.getScreenSize();

	BufferedImage image ;
	JLabel labelImage = new JLabel();
	ImageIcon weatherIcon = new ImageIcon();
	
	ListenerForTimer lFTimer = new ListenerForTimer(this);
	
	String ImagePath = "C:\\Users\\Elior's\\Eclipse_workspace\\WeatherProject\\BackroundWeather\\"+ (new Random().nextInt(5) + 1)+".jpg";
	ImageIcon weatherBackround = new ImageIcon(ImagePath);
	Image imageWB;
	
	Timer changingPics = new Timer(3000,lFTimer);
	
    private static GridBagConstraints gbc;
    static {
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.NORTHWEST;
    }
	
	public static JPanel wrapInBackgroundImage(JComponent component,Icon backgroundIcon) {
		return wrapInBackgroundImage(component,backgroundIcon,JLabel.TOP,JLabel.LEADING);
	}
	
    public static JPanel wrapInBackgroundImage(JComponent component,Icon backgroundIcon,int verticalAlignment,int horizontalAlignment) {
        // make the passed in swing component transparent
        component.setOpaque(false);
         
        // create wrapper JPanel
        JPanel backgroundPanel = new JPanel(new GridBagLayout());
         
        // add the passed in swing component first to ensure that it is in front
        backgroundPanel.add(component, gbc);
         
        // create a label to paint the background image
        JLabel backgroundImage = new JLabel(backgroundIcon);
         
        // set minimum and preferred sizes so that the size of the image
        // does not affect the layout size
        backgroundImage.setPreferredSize(new Dimension(1,1));
        backgroundImage.setMinimumSize(new Dimension(1,1));
         
        // align the image as specified.
        backgroundImage.setVerticalAlignment(verticalAlignment);
        backgroundImage.setHorizontalAlignment(horizontalAlignment);
         
        // add the background label
        backgroundPanel.add(backgroundImage, gbc);
         
        // return the wrapper
        return backgroundPanel;
    }
    
    JPanel backroundPanel = new JPanel(new BorderLayout(3,3));
	
    BufferedImage flagBufImg;
    Image flagim;
    ImageIcon flagImage;
    
	public MainFrame(String titleName){
		super(titleName);

		backroundPanel.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
		backroundPanel.setOpaque(false);     

		label1.setFont(new Font(label1.getName(),Font.BOLD, 18));
		label2.setFont(new Font(label2.getName(),Font.BOLD, 18));
		inputText.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
		ListenForButtons lForButton = new ListenForButtons();
		b1.addActionListener(lForButton);
		b2.addActionListener(lForButton);
		
		Box buttonBox = Box.createHorizontalBox();
		buttonBox.add(b1);
		buttonBox.add(Box.createRigidArea(new Dimension(2, 2)));
		buttonBox.add(b2);
		buttonBox.add(Box.createVerticalGlue(),BorderLayout.CENTER);
		
		backroundPanel.add(label1, BorderLayout.PAGE_START);
		backroundPanel.add(label2,BorderLayout.LINE_START);
		backroundPanel.setLayout(new GridLayout(0,1));
		backroundPanel.add(inputText);
		backroundPanel.add(buttonBox);
				
		this.setContentPane(wrapInBackgroundImage(backroundPanel,weatherBackround));
		this.setLocation(350,180);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.pack();
	}

	@Override
	public void run() {
		
		this.setVisible(true);
		changingPics.start();
		
	}
	public void getAnswer(){
		backroundPanel.setLayout(new FlowLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.weightx = 10;
		gc.weighty = 10;
		gc.insets = new Insets(5, 5, 5, 5);
		gc.anchor = GridBagConstraints.NORTHEAST;
		gc.fill = GridBagConstraints.BOTH;
		
		label1.setText("Try it Again! ");
		label2.setText("Just enter a City and Country.");
		
		textA.setText("City : "+wData.getCurLocation().getName()+"\n"+
					"Country : "+wData.getCurLocation().getSysCountry()+"\n"+
					"Geogrphic Coords : ["+wData.getCurLocation().getCoordLat()+","+wData.getCurLocation().getCoordLon()+"]\n"+
					"Temperature : "+String.format("%.1f",wData.getCurWeather().getMainTemp())+/*"	Max="+wData.getCurWeather().getMainTempMax()+"\n	Min="+wData.getCurWeather().getMainTempMax()+*/"\n"+
					"Cloudiness : "+wData.getCurWeather().getWeatherDescription()+"\n"+
					"Wind Speed = "+wData.getCurWeather().getWindSpeed()+"\n"+
					"Humidity :"+wData.getCurWeather().getMainHumidity()+"%\n"+
					"Sunrise : "+wData.getCurLocation().getSysSunrise().toString()+"\n"+
					"Sunset : "+wData.getCurLocation().getSysSunset().toString()+"\n"
					);
		
		textA.setEditable(false);
		try {
			image = ImageIO.read(new File("C:\\Users\\Elior's\\Eclipse_workspace\\WeatherProject\\Weather Icons\\"+wData.getCurWeather().getWeatherIcon()+".png"));
			weatherIcon.setImage(image);
			labelImage.setIcon(weatherIcon);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			flagBufImg = ImageIO.read(new URL("http://www.geonames.org/flags/x/"+wData.getCurLocation().getSysCountry().toLowerCase()+".gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		flagim = flagBufImg.getScaledInstance(20, 15, Image.SCALE_DEFAULT);
		this.setIconImage(flagim);
		
		textA.setBackground(new Color(240,245,255));
		textA.setFont(new Font(null, Font.BOLD, 16));
		
		gc.gridx = 1;
		gc.gridy = 1;
		ansComPan.add(textA,gc);
		
		gc.gridx = 2;
		gc.gridy = 1;
		ansComPan.add(labelImage,gc);
		
		gc.gridx = 2;
		gc.gridy = 2;
		backroundPanel.add(ansComPan,gc);
		
		this.setLocationRelativeTo(null);
		this.setExtendedState(this.MAXIMIZED_BOTH);
		this.setResizable(false);
		run();
	}
	
	///Controller
	private class ListenForButtons implements ActionListener {
		
		public void actionPerformed(ActionEvent e){
			if(e.getSource() == b1){
				
				try {
					locationData.setName(inputText.getText());
					if(locationData.getName().contains(",")){
						locationData.setSysCountry(locationData.getName().substring(locationData.getName().indexOf(",")+1, locationData.getName().length()));
						locationData.setName(locationData.getName().substring(0,locationData.getName().indexOf(",")));
					}
					wData.setWeatherData(serviceData.getWeatherData(locationData));
					getAnswer();
					} catch (WeatherDataServiceException e1) {	
						e1.getCause();
						e1.printStackTrace();
					}
			}
			else if(e.getSource() == b2){
				System.exit(0);
			}
		}	
	}
	
	private class ListenerForTimer implements ActionListener{

		MainFrame frame;
		
		ListenerForTimer(MainFrame mf){
			frame = mf;
		}
		int cur = 1;
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(cur == 10){
				cur = 1;
			}
			cur++;
			try {
				imageWB = ImageIO.read(new File("C:\\Users\\Elior's\\Eclipse_workspace\\WeatherProject\\BackroundWeather\\"+cur+".jpg"));
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(new Frame() , "Could not find file specified.", "Invalid Path", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
				}
			weatherBackround.setImage(imageWB);
			frame.repaint();
			}	
	}
}
