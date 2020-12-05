/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
/* 
Yazılımcıya notlar:

 *ilk önce bu panel yüklendiği için mainPaneldeki kullanıcı adını aldığımız zaman boş değer geliyordu. Onu halllettik

// http://data.fixer.io/api/latest?access_key=bef6d960365ae70273d3b370e0a6ae8c api


*/
import com.sun.java.accessibility.util.java.awt.ListTranslator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
import javax.swing.border.Border;
import javax.swing.text.JTextComponent;
import logic.publicPanelAction;
import logic.sorgular;
public class publicPanel implements KeyListener{
 
           
 
    mainPanel mP;
    //JFrame jf=null;
    JPanel publicpanel=null;
public int indis;
  mainPanel mainpanel;
public String ad;
    private Border loweredbevel;
    private Border blackline;
    
    publicPanelAction p=new publicPanelAction(this);
    
    //action a=new action(this); 
     public publicPanel(){
     
           // getlistt().add(new JScrollPane( getlist1()) );
           getlistt();
          
     }

  
   public JPanel getpublicpanel(){
       if(publicpanel==null){
           publicpanel=new JPanel();
           publicpanel.setBounds(0, 0, 1600 , 950);
           publicpanel.setBackground(Color.decode("#495e5d")); 
           publicpanel.add(getkimlik());
           publicpanel.setLayout(null);
           publicpanel.setVisible(false);
           publicpanel.add(getbuton());
           publicpanel.add(getNotes());
           publicpanel.add(getkalan());
           publicpanel.add(getnotButon());
           publicpanel.add(getnotAciklama());
           publicpanel.add(getlistt());
           publicpanel.add(getgelenNot());
          // publicpanel.add(getcikis());
           paralar();
            publicpanel.add(getYenile());
       }
       return publicpanel;
   }
   public void paralar(){
       publicpanel.add(getdoviz());
           publicpanel.add(gettl());
            publicpanel.add(geteur());
            publicpanel.add(getusd());
            publicpanel.add(getgbp());
             publicpanel.add(getcny());
             publicpanel.add(getkwd());
             publicpanel.add(getcomboPara());
          
             
   }
  JLabel tl=null;
  public JLabel gettl(){
      if(tl==null){
          tl=new JLabel("-TÜRK LİRASI-");
          tl.setBounds(300  , 200, 200, 40);//setBounds(300  , 100   , 200   , 40);
          
         tl.setFont(new Font("Lato", Font.BOLD, 25));
      }
      return tl;
  }
  JLabel eur=null;
  public JLabel geteur(){
      if(eur==null){
            eur=new JLabel("€EUR:");
          eur.setBounds(200  , 300, 200, 40);//setBounds(300  , 100   , 200   , 40);
          
         eur.setFont(new Font("Lato", Font.BOLD, 20));
      }
      return eur;
  }
 
  
   JLabel usd=null;
  public JLabel getusd(){
      if(usd==null){
            usd=new JLabel("$USD:");
          usd.setBounds(200  , 400, 200, 40);//setBounds(300  , 100   , 200   , 40);
          
         usd.setFont(new Font("Lato", Font.BOLD, 20));
      }
      return usd;
  }
 
  
  
  
  JLabel gbp=null;
  public JLabel getgbp(){
      if(gbp==null){
            gbp=new JLabel("£GBP:");
          gbp.setBounds(200  , 500, 200, 40);//setBounds(300  , 100   , 200   , 40);
          
         gbp.setFont(new Font("Lato", Font.BOLD, 20));
      }
      return gbp;
  }
   JLabel cny=null;
  public JLabel getcny(){
      if(cny==null){
            cny=new JLabel("¥CNY:");
          cny.setBounds(200  , 600, 200, 40);//setBounds(300  , 100   , 200   , 40);
    
         cny.setFont(new Font("Lato", Font.BOLD, 20));
      }
      return cny;
  }
 
  
  
    JLabel kwd=null;
  public JLabel getkwd(){
      if(kwd==null){
            kwd=new JLabel("KWD:");
          kwd.setBounds(200  , 700, 200, 40);//setBounds(300  , 100   , 200   , 40);
          
         kwd.setFont(new Font("Lato", Font.BOLD, 20));
      }
      return kwd;
  }
  
    JComboBox combo=null;
    public JComboBox getcombo(){
        if(combo==null){
                combo=new JComboBox(sorgu.tarihler);//sorgu.notlar  giriş butonunda combo yarattım ve publicpaneldeki listt paneline ekleme yaptım
                combo.setBackground(Color.decode("#3B3F42"));
                combo.setForeground(Color.decode("#6c7b8b"));
                combo.addActionListener(p);
                combo.setBorder(null);
                combo.setVisible(false);
                                            
        }
        return combo;
    }
           
   String[] paraDizisi={"USD,EURO,CNY,GBP,KWD"};
    JComboBox comboPara=null;
    public JComboBox getcomboPara(){
        if(comboPara==null){
            comboPara=new JComboBox(paraDizisi);
            comboPara.setLocation(420, 300);
            comboPara.setSize(indis, adet);
            comboPara.setBackground(Color.decode("#3B3F42"));
            comboPara.setForeground(Color.decode("#6c7b8b"));
            comboPara.addActionListener(p);
            comboPara.setVisible(true);
            comboPara.setBorder(null);                              
        }
        return comboPara;
    }
   
   public String getad(String b){// mainpanelindeki değerle buradaki ad değerini eşliyor.
      return ad=b;
   }
   
   public void setpublicpanel(publicPanel publicpanel){
      this.publicpanel=this.publicpanel;
   }
  

 JLabel kimlik=null;
public JLabel getkimlik(){
    if(kimlik==null){
    kimlik=new JLabel();
    kimlik.setBounds(2,0,200,40);
   kimlik.setForeground(Color.white);
   kimlik.setFont(new Font("Righteous", Font.BOLD, 20));
    
}
    return kimlik;
}


/////////// Not eklemek için gerekli nesneler oluşturuluyor. ///////////////
// #2B2B2B netbeans dracula renk kodu.
  JTextArea notes=null;
  public JTextArea getNotes(){
      if(notes==null){
          notes=new JTextArea();
          notes.setBounds(1150,80,400,150);
        JScrollPane jScrollPane1 = new JScrollPane();
         jScrollPane1.setViewportView(notes);
          notes.setBackground(Color.decode("#2B2B2B"));
          notes.setForeground(Color.decode("#6c7b8b"));
//          notes.setBorder(loweredbevel);
//          notes.setBorder(blackline);
           notes.setCursor(Cursor.getDefaultCursor());
          notes.setLineWrap(true);// sınıra gelince alt satıra geçmesini sağlıyor.
         notes.setFont(new Font("Righteous", Font.ITALIC, 14));
             notes.addKeyListener(this);
          notes.setCaretColor(Color.white);
      }
      return notes;
  }
  public void setNotes(JTextArea notes){
      this.notes=notes;
  }

JTextField notesfield=null;
  public JTextField getnotesfield(){
      if(notesfield==null){
          notesfield=new JTextField();
          notesfield.setBounds(1100,100,400,150);
          notesfield.setBackground(Color.decode("#2B2B2B"));
          notesfield.setForeground(Color.decode("#6c7b8b"));
          notesfield.setBorder(null);
       
             
      }
      return notesfield;
  }
  public void setNotes(JTextField notesfield){
      this.notesfield=notesfield;
  }
 JLabel kalanLbl=null;
 public JLabel getkalan(){
     if(kalanLbl==null){
         kalanLbl=new JLabel("250");
         kalanLbl.setBounds(1530, 213, 50, 50);
         kalanLbl.setForeground(Color.decode("#8b0000"));
     }
     return kalanLbl;
 }

JButton notButon=null;
public JButton getnotButon(){
    if(notButon==null){
        notButon=new JButton("Save");
        notButon.setBounds(1450, 250, 100, 40);
        notButon.setBorder(null);
        notButon.setForeground(Color.black);
        notButon.setBackground(Color.decode("#3b4c4b"));
        notButon.addActionListener(p);
    }
    return notButon;
}


JLabel notAciklama=null;
public JLabel getnotAciklama(){
    if(notAciklama==null){
        notAciklama=new JLabel();
        notAciklama.setBounds(1150, 232, 200, 30); //notes.setBounds(1150,80,400,150);
        notAciklama.setForeground(Color.decode("#8b0000"));
        notAciklama.setVisible(true);
        
    }
    return notAciklama;
}
 sorgular sorgu=new sorgular();
    JPanel listt=null;
 
    
    
    public JPanel getlistt(){
        if(listt==null){
            listt=new JPanel();
            listt.setBounds(1150, 310, 400, 210);
            listt.setBackground(Color.decode("#495e5d"));//#495e5d
            //listt.setLayout(null);
          
           //kombo.setSize(100, 100);
       listt.add(getcombo());
          
       
            
        }
        return listt;
    }
    JButton buton=null;
public JButton getbuton(){
    if(buton==null){
        buton=new JButton();
        buton.setText("Show notes");
        buton.setBounds(1450 , 300,100, 50);
        buton.setBackground(Color.decode("#3b4c4b"));
        buton.setForeground(Color.black);
        buton.addActionListener(p);
        buton.setBorder(null);
    }
    return buton;
}
JButton cikis=null;
public JButton getcikis(){
    if(cikis==null){
        cikis=new JButton("Hesaptan çık");
        cikis.setBounds(1480, 0, 120, 40);
        cikis.setBackground(Color.decode("#800000"));
        cikis.setForeground(Color.decode("#ffd39b"));
        cikis.addActionListener(p);
        cikis.setBorder(null);
    }
    return cikis;
}
  JTextArea gelenNot=null;
  public JTextArea getgelenNot(){
      if(gelenNot==null){
          gelenNot=new JTextArea();
          gelenNot.setBounds(1150, 530, 400, 210);
          gelenNot.setBackground(Color.decode("#3b4c4b"));
          gelenNot.setForeground(Color.decode("#eed2ee"));
          gelenNot.setEditable(false);
          gelenNot.setVisible(false);
          gelenNot.setLineWrap(true);
     
             
      }
      return gelenNot;
  }
  
  
     
     
/*JList list1=new JList(dizi1);
           
            //list1.setVisibleRowCount(5);
            list1.setBounds(0  ,0   , 100, 100);*/

    
    
    
 
//////////// Burada not nesneleri bitiyor. /////////////////



   public void yazdır(){
       System.out.println("publicPanelden gelen ad:"+ad);
   }

   JLabel doviz=null;
   public JLabel getdoviz(){
       if(doviz==null){
           doviz=new JLabel("Exchange");
           doviz.setForeground(Color.decode("#2e8b57"));
           doviz.setBounds(300  , 100   , 200   , 40);
          
          doviz.setFont(new Font("Righteous", Font.BOLD, 40));
       }
       return doviz;
   }
   JButton yenile=null;
   //   ImageIcon img1=new ImageIcon(getClass().getResource("ayar.png"))
    ImageIcon butonImg=new ImageIcon(getClass().getResource("yenile.png"));
   public JButton getYenile(){
       if(yenile==null){
          
           yenile=new JButton();
           yenile.setBounds(530, 100, 40  , 40);
           yenile.setIcon(butonImg);
           yenile.addActionListener(p);
           yenile.setBackground(Color.decode("#495e5d"));
           yenile.setBorder(null);
       }
       return yenile;
   }        
   
   
   
   
   
   
   
   
    @Override
    public void keyTyped(KeyEvent e) {
       
    }
 String degerler;
public int adet=250;
    @Override
    public void keyPressed(KeyEvent e) { // kalan sayıyı görüntülüyor.
        getNotes().setEditable(true);
        getnotAciklama().setText("");
        // not girildiğinde kalan adeti gösteriyor
        if(adet!=0)
        {
             if(e.getKeyCode()==KeyEvent.VK_BACK_SPACE){
                     if(adet<250){
                         adet=adet+1;
                    getkalan().setText(String.valueOf(adet));}
          
                    } 
    
             else{
                     if(adet>0){
                         adet=adet-1;
                         getkalan().setText(String.valueOf(adet));}
                 }
        }
        else{
            
            getNotes().setEditable(false);
            if(e.getKeyCode()==KeyEvent.VK_BACK_SPACE){
                   getNotes().setEditable(true);
                   if(adet<250) adet=adet+1;
            }
        }
       
    } ////////////////////////// biter. 

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

   
  
   
}
