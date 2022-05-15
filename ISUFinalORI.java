//Justin Orial
//An Epic Create-You-Own-Character application. It allows the user to customize the physical and physiological attributes of an avatar.
//06/03/2019
//06/18/2019

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.sound.sampled.*;

public class ISUFinalORI implements ActionListener
{
   //Declaring all global variables
   JFrame frame;
   JPanel container, contentPane, contentPane2, contentPane3;
   JComboBox genders, classes, hairColors, shirtColors, pantsColors;
   JLabel askName, genderPrompt, headPic, shirtPic, pantsPic;
   JTextArea textArea;
   
   public String genderChoice = "boy";
   
   public static ImageIcon oof = new ImageIcon("logo.png");
   
   public static String userName;
   
   CharacterClass classChoice;
   
   public String[] genderArray = {"Select your gender", "male", "female", "CHOOSE CLASS"};
   public String[] classArray = {"Select your class", "Heavy", "Medium", "Light", "CUSTOMIZE CHARACTER"};
   public String[] hairArray = {"Select your hair color", "default", "black", "blonde","brown(male)/red(female)"};
   public String[] shirtArray = {"Select your shirt color", "Default", "Blue", "Yellow","Red"};
   public String[] pantsArray = {"Select your pants color", "DEFAULT", "BLUE(male)/GREEN(female)", "YELLOW","RED", "DONE"};
   
   //Constructor
   //pre: none
   //post: JFrame window created
   public ISUFinalORI()
   {
      //Create and set up the frame
      frame = new JFrame("Epic Character Generator");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      //Primary JPanel container that holds the three sub-containers
      container = new JPanel();
      container.setLayout(new FlowLayout());
      container.setBackground(Color.white);
      
      //Three sub-JPanel containers that have different Layouts
      contentPane = new JPanel();
      contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
      contentPane.setBackground(Color.white);
      
      contentPane2 = new JPanel();
      contentPane2.setLayout(new BoxLayout(contentPane2, BoxLayout.PAGE_AXIS));
      contentPane2.setBackground(Color.white);
      
      contentPane3 = new JPanel();
      contentPane3.setLayout(new FlowLayout());
      contentPane3.setBackground(Color.white);
      
      //adding the sub JPanels to the primary one
      container.add(contentPane);
      container.add(contentPane2);
      container.add(contentPane3);
      
      //Displaying the head, shirt and pants pictures on top of eachother
      headPic = new JLabel(new ImageIcon("boyHeadDefault.jpg"));
      contentPane.add(headPic);
      
      shirtPic = new JLabel(new ImageIcon("boyShirtDefault.jpg"));
      contentPane.add(shirtPic);
      
      pantsPic = new JLabel(new ImageIcon("boyPantsDefault.jpg"));
      contentPane.add(pantsPic);
      
      //Creating the combo boxes for the choices
      genders = new JComboBox(genderArray);
      genders.setSelectedIndex(0);
      genders.addActionListener(this);
      contentPane2.add(genders);
      
      classes = new JComboBox(classArray);
      classes.setSelectedIndex(0);
      classes.addActionListener(this);
      contentPane2.add(classes);
      
      hairColors = new JComboBox(hairArray);
      hairColors.setSelectedIndex(0);
      hairColors.addActionListener(this);
      contentPane2.add(hairColors);
      
      shirtColors = new JComboBox(shirtArray);
      shirtColors.setSelectedIndex(0);
      shirtColors.addActionListener(this);
      contentPane2.add(shirtColors);
      
      pantsColors = new JComboBox(pantsArray);
      pantsColors.setSelectedIndex(0);
      pantsColors.addActionListener(this);
      contentPane2.add(pantsColors);
      
      //Text area that displays information about the character based on the chosen class
      textArea = new JTextArea();
      textArea.setEditable(false);
      textArea.setBounds(550, 46, 252, 296);
      textArea.setText("Name: "+ userName + "\n");
      contentPane3.add(textArea);
    
      //Add primary content pane to frame
      frame.setContentPane(container);
    
      //Size and then display the frame in the middle of the screen
      frame.pack();
      frame.setSize(1000,400);
      frame.setVisible(true);
      frame.setLocationRelativeTo(null);
      
      //hiding the rest of the combo boxes
      classes.setVisible(false);
      hairColors.setVisible(false);
      shirtColors.setVisible(false);
      pantsColors.setVisible(false);
   }
   
   //Handle a selection from the combo boxes
   //pre: none
   //post: The appropriate picture is changed
   
   public void actionPerformed(ActionEvent event)
   {
      JComboBox comboBox = (JComboBox)event.getSource();
      String select = (String)comboBox.getSelectedItem();
      
      //All combo box selections being handled
      if(select.equals("female"))
      {
         genderChoice = "girl";
         headPic.setIcon(new ImageIcon("girlHeadDefault.jpg"));
         shirtPic.setIcon(new ImageIcon("girlShirtDefault.jpg"));
         pantsPic.setIcon(new ImageIcon("girlPantsDefault.jpg"));
      }
      else if(select.equals("male"))
      {
         genderChoice = "boy";
         headPic.setIcon(new ImageIcon("boyHeadDefault.jpg"));
         shirtPic.setIcon(new ImageIcon("boyShirtDefault.jpg"));
         pantsPic.setIcon(new ImageIcon("boyPantsDefault.jpg"));
      }
      else if(select.equals("CHOOSE CLASS"))
      {
         genders.setVisible(false);
         classes.setVisible(true);
      } 
      else if(select.equals("Heavy"))
      {
         classChoice = new HeavyClass();
         textArea.setText("Name: "+ userName + "\n\nDescription:\n" + classChoice.getDescription() + "\n\nStats:\n" + classChoice.getStats());
      } 
      else if(select.equals("Medium"))
      {
         classChoice = new MediumClass();
         textArea.setText("Name: "+ userName + "\n\nDescription:\n" + classChoice.getDescription() + "\n\nStats:\n" + classChoice.getStats());
      }
      else if(select.equals("Light"))
      {
         classChoice = new LightClass();
         textArea.setText("Name: "+ userName + "\n\nDescription:\n" + classChoice.getDescription() + "\n\nStats:\n" + classChoice.getStats());
      }
      else if(select.equals("CUSTOMIZE CHARACTER"))
      {
         classes.setVisible(false);
         hairColors.setVisible(true);
         shirtColors.setVisible(true);
         pantsColors.setVisible(true);
      }
      else if(select.equals("default"))
      {
         headPic.setIcon(new ImageIcon(genderChoice + "HeadDefault.jpg"));
      }
      else if(select.equals("black"))
      {
         headPic.setIcon(new ImageIcon(genderChoice + "HeadBlack.jpg"));
      }
      else if(select.equals("blonde"))
      {
         headPic.setIcon(new ImageIcon(genderChoice + "HeadBlonde.jpg"));
      }
      else if(select.equals("brown(male)/red(female)"))
      {
         headPic.setIcon(new ImageIcon(genderChoice + "HeadBrown.jpg"));
      }
      else if(select.equals("Default"))
      {
         shirtPic.setIcon(new ImageIcon(genderChoice + "ShirtDefault.jpg"));
      }
      else if(select.equals("Blue"))
      {
         shirtPic.setIcon(new ImageIcon(genderChoice + "ShirtBlue.jpg"));
      }
      else if(select.equals("Yellow"))
      {
         shirtPic.setIcon(new ImageIcon(genderChoice + "ShirtYellow.jpg"));
      }
      else if(select.equals("Red"))
      {
         shirtPic.setIcon(new ImageIcon(genderChoice + "ShirtRed.jpg"));
      }
      else if(select.equals("DEFAULT"))
      {
         pantsPic.setIcon(new ImageIcon(genderChoice + "PantsDefault.jpg"));
      }
      else if(select.equals("BLUE(male)/GREEN(female)"))
      {
         pantsPic.setIcon(new ImageIcon(genderChoice + "PantsBlue.jpg"));
      }
      else if(select.equals("YELLOW"))
      {
         pantsPic.setIcon(new ImageIcon(genderChoice + "PantsYellow.jpg"));
      }
      else if(select.equals("RED"))
      {
         pantsPic.setIcon(new ImageIcon(genderChoice + "PantsRed.jpg"));
      }
      else if(select.equals("DONE"))
      {
         hairColors.setVisible(false);
         shirtColors.setVisible(false);
         pantsColors.setVisible(false);
         textArea.setText("Name: "+ userName + "\n\nDescription:\n" + classChoice.getDescription() + "\n\nStats:\n" + classChoice.getStats() + "\n\nYour character is finished!");
      }
   }
   
   //Create and show the GUI
   private static void runGUI()
   {
      JFrame.setDefaultLookAndFeelDecorated(false);
      ISUFinalORI name = new ISUFinalORI();
   }
   
   public static void main(String[] args)
   {
      //Calling the playMusic method to play the song
      playMusic("ES_Amiss In Wonderland 3 - Martin Landström.wav");
   
   
      //Asking for the name of the user's character
      userName = JOptionPane.showInputDialog("Name your character");
            
      javax.swing.SwingUtilities.invokeLater(new Runnable()
      {
         public void run()
         {
            runGUI();
         }
     });
   }
   
   //Plays music 
   //pre: none
   //post: music is playing
   public static void playMusic(String musicLocation)
   {
      
      try
      {
         File musicPath = new File(musicLocation);
         
         if(musicPath.exists())
         {
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInput);
            clip.start();
            
            //JOptionPane must be used to make the Clip class work and play the song properly, so I just used the JOptionPane as the welcome screen.
            JOptionPane.showMessageDialog(null,"Welcome to the Epic Character Generator!\nYou can create your own personalised avatar, including changing the look \nand the class.The different classes give your character different statistics.\nHave fun!\nTo move on to the color options,click the \nCUSTOMIZE CHARACTER combo box option.\nTo finish, click the DONE combo box option.","Hello!",JOptionPane.INFORMATION_MESSAGE, oof);

         }
         else
         {
            System.out.println("Can't find file");
         }
      }
      catch(Exception ex)
      {
         ex.printStackTrace();
      }
   }
}