/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import logic.action;
import java.awt.Color;
import java.awt.TextField;
import javax.swing.*;
import logic.connections;
import logic.sorgular;

/**
 *
 * @author aliba
 */
public class mainPanel {
      publicPanel pP=null;
      
     public String kimlikName;
      sorgular sorgu;
      public String uName,passWrd;
      JList<String> list1=null;
    JFrame jf=null;
    JPanel anapanel=null;
     JPanel inputPanel=null,signPanel=null;
    JButton buton=null,signButon=null,signRecord=null;
JPasswordField passfield=null;
   JTextField textUser=null,signUser=null,signPass=null,signPass2=null;
   JTextField textPass=null;
   JLabel labelName=null;
   JLabel labelPass=null;
   JLabel logo=null,signlblUser=null,signlblPass=null,signlblPass2=null;
   
   action a=new action(this);
   
   ImageIcon img=new ImageIcon(getClass().getResource("logo.png"));
   ImageIcon girisImg=new ImageIcon(getClass().getResource("girisLogo.png"));
   public mainPanel(){
      
       getanapanel().add(getpP().getpublicpanel()); 
     
      getJf().setVisible(true); //getanapanel().add(getgrafik().getPanel());
      
      
    
   }
   public JFrame getJf(){
       if(jf==null){
           jf=new JFrame();
           jf.setTitle("CalCoin - Calculate Coin");
           jf.setSize(1600  ,950);
              jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               jf.setLocationRelativeTo(null);
                jf.setVisible(true);
               //jf.setBackground(Color.decode("#004D40"));
                jf.setIconImage(img.getImage());
                jf.setResizable(false);
                jf.setContentPane(getanapanel());
                
                
       }
       return jf;
   }
   public void setjf(JFrame jf){
           
          this.jf=jf;
           
       }
   
   ////////////////////////////////////////////////////// panel 1 
 
       public JPanel getanapanel(){
            DefaultListModel<String> l1 = new DefaultListModel<>();  
          l1.addElement("Item1");  
          l1.addElement("Item2");  
          l1.addElement("Item3");  
          l1.addElement("Item4");  
              if(anapanel==null){
               anapanel=new JPanel();
               anapanel.setBounds(0, 0,1600 , 960);
               
                anapanel.setBackground(Color.decode("#495e5d"));  //#495e5d
               anapanel.setLayout(null); 
                 anapanel.add(getinputPane1());
                 anapanel.add(getsignPanel());
                 
                 
                
                 
                 
           
          }
          return anapanel;
      }
       
       public void setanapanel(JPanel anapanel){
           this.anapanel=anapanel;
       }
    
       public JPanel getinputPane1(){
           if(inputPanel==null){
               inputPanel=new JPanel();
               inputPanel.setBounds(550, 140, 500, 580);
               inputPanel.setBackground(Color.decode("#3b4c4b")); // daha koyu olan renk :)
               inputPanel.add(getlogo());
               inputPanel.setLayout(null);
               inputPanel.add(getlabelName());
               inputPanel.add(gettextUser());
               inputPanel.add(getlabelPass());
               inputPanel.add(getpassfield());
               inputPanel.add(getbuton());
               inputPanel.add(getsignButon());
               inputPanel.add(getgirisLbl());
           
     
           } 
           return inputPanel;
       }
       public void setinputPanel(JPanel inputPanel ){
           this.inputPanel=inputPanel;
       }
       
       public JLabel getlogo(){
           if(logo==null){
               logo=new JLabel(girisImg);
               logo.setBounds(180, 0, 140, 130);
           
               logo.setVisible(true);
              
           }
           return logo;
       }
       public void setlogo(JLabel logo){
           this.logo=logo;
       }
       
       
       public JLabel getlabelName(){
           if(labelName==null){
               labelName=new JLabel("User name:");
               labelName.setBounds(140, 180, 220, 40);
               labelName.setForeground(Color.black);
              labelName.setBackground(Color.decode("#3b4c4b"));
               
               
           }
           return labelName;
       }
      
       public JTextField gettextUser(){
           if(textUser==null){
               textUser=new JTextField();
             
              textUser.setBounds(140, 230,220, 40);
               textUser.setVisible(true);
               textUser.setBackground(Color.decode("#495e5d"));
               textUser.setForeground(Color.black);
             
               textUser.setBorder(null);
               
           }
         
       return  textUser;
}
      public void settextUser(JTextField textUser){
          this.textUser=textUser;
      }
      
      public JLabel getlabelPass(){
          if(labelPass==null){
              labelPass=new JLabel("Password:");
              labelPass.setBounds(140, 300, 220, 40);
              labelPass.setForeground(Color.black);
              labelPass.setBackground(Color.decode("#3b4c4b"));
              
          }
          return labelPass;
      }
     /* public JTextField gettextPass(){
          if(textPass==null){
              textPass=new JTextField();
              textPass.setBounds(140, 350, 220, 40);
              textPass.setForeground(Color.black);
              textPass.setBackground(Color.decode("#495e5d"));
              
              textPass.setBorder(null);
          } 
          return textPass;
      }*/
      public JPasswordField getpassfield(){
           if(passfield==null){
              passfield=new JPasswordField();
              passfield.setBounds(140, 350, 220, 40);
              passfield.setForeground(Color.black);
              passfield.setBackground(Color.decode("#495e5d"));
              
              passfield.setBorder(null);
          }
          return passfield;
      }
       
      public void setpassfield(JPasswordField passfield){
         this.passfield=passfield;
      }
      
    
      public JButton getbuton(){
          if(buton==null){
              buton=new JButton("Login");
              buton.setBounds(260, 410, 100, 40);
              buton.setBackground(Color.decode("#495e5d"));
              buton.setForeground(Color.black);
              buton.setBorder(null);
              buton.addActionListener(a);
          }
          return buton;
      } 
      public void setbuton(JButton buton){
          this.buton=buton;
      }
      public JLabel girisLbl=null;           
      public JLabel getgirisLbl(){
          if(girisLbl==null){
               girisLbl =new JLabel();//"!Boş alan bırakmayınız.."
             girisLbl.setBounds(230, 451, 200,40);
             girisLbl.setForeground(Color.decode("#8b0000"));
          }
          return girisLbl;
      }
      
      public JButton getsignButon(){
          if(signButon==null){
              signButon=new JButton("New account ");
              signButon.setBounds(390,530,100,40);
                     signButon.setBackground(Color.decode("#3b4c4b"));
              signButon.setForeground(Color.black);
              signButon.setBorder(null);
              signButon.addActionListener(a);
          }
          return signButon;
      }
      
       public void setsignButon(JButton signButon){
           this.signButon=signButon;
       }
      
       public JPanel getsignPanel(){
           if(signPanel==null){
               signPanel=new JPanel();
               signPanel.setBounds(1060, 280, 400, 440);
               signPanel.setBackground(Color.decode("#3b4c4b"));
               signPanel.setLayout(null);
               signPanel.add(getsignlblUser());
               signPanel.add(getsignUser());
               signPanel.add(getsigntitle());
               signPanel.add(getsignlblPass());
               signPanel.add(getsignPass());
               signPanel.add(getsignlblPass2());
                 signPanel.add(getsignPass2());
               signPanel.add(getsignRecord());
               signPanel.add(getaciklamaLbl());
              signPanel.setVisible(false);
           }
           return signPanel;
       }
       
       JLabel signTitle=null;
        public JLabel getsigntitle(){
           if(signTitle==null){
               signTitle=new JLabel("-ENTRY-");
               signTitle.setBounds(178 , 0,220, 30);
               signTitle.setForeground(Color.black);
           }
           return signTitle;
       }
       
       public JLabel getsignlblUser(){
           if(signlblUser==null){
               signlblUser=new JLabel("User name:");
               signlblUser.setBounds(100 , 40,220, 40);
               signlblUser.setForeground(Color.black);
           }
           return signlblUser;
       }
       
       
    
       public JTextField getsignUser(){
           if(signUser==null){
               signUser=new JTextField();
               signUser.setBounds(100, 90, 220, 40);
               signUser.setBackground(Color.decode("#495e5d"));
               signUser.setForeground(Color.black);
               signUser.setBorder(null);
           }
           return signUser;
       }
      
       public JLabel getsignlblPass(){
           if(signlblPass==null){
               signlblPass=new JLabel("Password:");
               signlblPass.setBounds(100 , 150,220, 40);
               signlblPass.setForeground(Color.black); //signlblPass2
               
           }
           return signlblPass;
       }
        
       public JTextField getsignPass(){
           if(signPass==null){
               signPass=new JTextField();
               signPass.setBounds(100, 200, 220, 40);
               signPass.setBackground(Color.decode("#495e5d"));
               signPass.setForeground(Color.black);
               signPass.setBorder(null);
           }
           return signPass;
       }
//       JPasswordField pass2=null;
//       public JPasswordField getpass2(){
//             if(pass2==null){
//               pass2=new JPasswordField();
//               pass2.setBounds(100, 200, 220, 40);
//               pass2.setBackground(Color.decode("#495e5d"));
//               pass2.setForeground(Color.black);
//               pass2.setBorder(null);
//           }
//           return pass2;
//       }
     
       
     
       public void setsignPass(JTextField signPass){
           this.signPass=signPass;
       }
        public JLabel getsignlblPass2(){
           if(signlblPass2==null){
               signlblPass2=new JLabel("E-mail::");
               signlblPass2.setBounds(100 , 260,220, 40);
               signlblPass2.setForeground(Color.black); //signlblPass2
               
           }
           return signlblPass2;
       }
        public JTextField getsignPass2(){
           if(signPass2==null){
               signPass2=new JTextField();
               signPass2.setBounds(100, 310, 220, 40);
               signPass2.setBackground(Color.decode("#495e5d"));
               signPass2.setForeground(Color.black);
               signPass2.setBorder(null);
           }
           return signPass2;
       }
       public void setsignPass2(JTextField signPass2){
           this.signPass2=signPass2;
       }
        public JButton getsignRecord(){
          if(signRecord==null){
              signRecord=new JButton("Sign up");
              signRecord.setBounds(220, 360, 100, 40);
              signRecord.setBackground(Color.decode("#495e5d"));
              signRecord.setForeground(Color.black);
              signRecord.setBorder(null);
              signRecord.addActionListener(a);
          }
          return signRecord;
      } 
        JLabel aciklamaLbl=null;
        public JLabel getaciklamaLbl(){
            if(aciklamaLbl==null){
             aciklamaLbl =new JLabel();//"!Girilen bilgilerde kullanıcı vardır.."
             aciklamaLbl.setBounds(135, 401, 200,40);
             aciklamaLbl.setForeground(Color.decode("#8b0000"));
            }
            return aciklamaLbl;
        }
        
        
      public void setsignRecord(JButton signRecord){
          this.signRecord=signRecord;
      }
      ///////////////////
   
    public publicPanel getpP(){
        if(pP==null){
            pP=new publicPanel();
        }
        return pP;
    }
    
    public JList getlist1(){
        if(list1==null){
            list1=new JList<>();
            list1.setBounds(10, 10, 70, 100);
            list1.setBackground(Color.white);
            list1.setForeground(Color.black);
            list1.setVisible(true);
            
        }
        return list1;
    }
       public connections connect;
       public connections getconnect(){
           return connect;
       }
       
       

}// son parantez.