/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;


import gui.mainPanel;
import gui.publicPanel;
import java.awt.Color;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.management.ListenerNotFoundException;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JScrollPane;
/**
 *           her silmede sql ile idleri tekrar sıfırdan başlat. index+1 yapılacak silinirken; comboda index 0 dan bailıyor
 * @author aliba
 */
public class publicPanelAction implements ActionListener{
 public mainPanel mainpanel;
   public  publicPanel panel;
 sorgular sorgu=new sorgular();
 action ac=new action(mainpanel);
 int a;

    public publicPanelAction(publicPanel panel) {
        setpanel(panel);
    }
    public publicPanel getpanel(){
        return panel;
    }
    public void setpanel(publicPanel panel){
        this.panel=panel;
    }
     public mainPanel getmainpanel(){
        return mainpanel;
    }
    public void setmainpanel(mainPanel mainpanel){
        this.mainpanel=mainpanel;
    }
public String ad,not;
public String getad(String a){
    return ad=a;
}
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==getpanel().getnotButon()){
       
           getpanel().getnotAciklama().setText("");
         ad=getpanel().ad;
           not=getpanel().getNotes().getText();
          
           if(not.equals("")){
              // System.out.println("not alanı boş");
              getpanel().getnotAciklama().setForeground(Color.decode("#8b0000"));
               getpanel().getnotAciklama().setText("!Boş alan bırakmayınız..");
              }
           else
             {
                     try {
                 
                    sorgu.notEkle(ad, not);
               
             
                    // System.out.println(ad+"  > eklendi");
                      getpanel().getnotAciklama().setText("!Notunuz eklendi..");
                      getpanel().getnotAciklama().setForeground(Color.white);
                      //getpanel().getgelenNot().setText(not);
                      
                                             sorgu.notGetir(ad);// bu üç satır oluşturulan comboBox'a tekrar veri gurubu yüklüyor. Veri tabanından gelen tarihleri.
                                             ComboBoxModel tarihModel=new DefaultComboBoxModel(sorgu.tarihler);
                                             getpanel().getcombo().setModel(tarihModel);
                      
                      
                         // aciklama ekle
                     } catch (Exception xe) {
                    // System.out.println("eklenemedi");
                    getpanel().getnotAciklama().setForeground(Color.decode("#8b0000"));
                      getpanel().getnotAciklama().setText("!Not eklenemedi..");
                    } 
             }
           
               getpanel().getNotes().setText("");
               getpanel().adet=250;
               getpanel().getkalan().setText("250");
         // en son verileri görünteleme yapıldığında ise yeni veri yüklediğimiz zamanda görüntüleme fonkisyonu yenilenecek. Yeni eklenen başa gelecek.
       }
       
       if(e.getSource()==getpanel().getbuton())
       {
        
                          sorgu.notGetir(getpanel().ad);
                            ComboBoxModel tarih=new DefaultComboBoxModel(sorgu.tarihler);
                            getpanel().getcombo().setModel(tarih);
                       
                         getpanel().getcombo().setVisible(true);
                         getpanel().getgelenNot().setVisible(true);
              
       }
      
       if(e.getSource()==getpanel().getcombo()){
       sorgu.notGetir(ad);
           if(getpanel().getcombo().getSelectedIndex()>=0){
                sorgu.notGetir(ad);
               getpanel().getgelenNot().setText("    "+sorgu.notlar[getpanel().getcombo().getSelectedIndex()]);
              
           }
           else{
               getpanel().getnotAciklama().setForeground(Color.decode("#8b0000"));
               getpanel().getnotAciklama().setText("!Anlamlı değer seçilmedi.");
           }
           
       }
       if(e.getSource()==getpanel().getYenile()){
           System.out.println(ac.url_exchange());
//           ac.parseJson();                     get set ile getir.
//           System.out.println(ac.dolar);
          
       }
       
       
    }

    
  
    
}
