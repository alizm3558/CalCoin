/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;
import gui.mainPanel;
import gui.publicPanel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *             ilk olarak mysql-connector-java  jarını yüklememiz gerekiyor.
 * @author aliba
 */
public class sorgular {
   private Connection con=null;
   private Statement statement=null;
   private PreparedStatement preparedStatement=null;
   connections databases;
   mainPanel mp;
  public boolean baglanma=false;
   public sorgular(){

          String url="jdbc:mysql://"+databases.host+":"+ databases.port+"/"+databases.db_ismi; 
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver başarılı");
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver başarısız");
        }// yüklediğimiz mysql kütüphanesine bakıyor.
        try {
            con=DriverManager.getConnection(url,databases.kullanici_adi,databases.parola);
            System.out.println("Veri tabanı başarılı");
            baglanma=true;
        } catch (SQLException ex) {
            System.out.println("Veri tabanı başarısız");
          baglanma=false;
            
        }
        System.out.println("Bağlantı deüeri: "+baglanma);
       
    
}
   
   public boolean kullaniciKontrol(String kullanici_adi,String parola){
       // sorguya göre eğer girilen bilgilerde bir kullanıcı varsa true değer döndürüyor. ona göre kod deva ediyoruz
       String sorgu="select * from users where username=? and password=?"; 

       try {
           preparedStatement=con.prepareStatement(sorgu);
           preparedStatement.setString(1,kullanici_adi );
           preparedStatement.setString(2, parola);
           preparedStatement.executeQuery();
            ResultSet rs=preparedStatement.executeQuery();
            return rs.next();
       } catch (SQLException ex) {
         return false;
       }
       
   }
   
   
     public boolean kayitKontrol(String kullanici_adi,String parola){ // çalışıyor.
       String sorgu="select * from users where username=?";
       try {
           preparedStatement=con.prepareStatement(sorgu);
           preparedStatement.setString(1,kullanici_adi );
           
           preparedStatement.executeQuery();
            ResultSet rs=preparedStatement.executeQuery();
            System.out.println("gelenler :"+rs);
            return rs.next();
       } catch (SQLException ex) {
           
         return false;
       }
       
   }
     
     public void jsonEkle(String gelennJson){
           Date simdikiZaman = new Date();
        // notları getirdiğimizdede id yi küçükten büyüğe doğru sıralanmış olarak getiririz.(Yeniler en son id de.)
        
        
        DateFormat df = new SimpleDateFormat("dd.M.yyyy - HH:mm:ss"); // hh olduğu zaman da 12 üzerinden, HH : 24 üzerinden gösteriyor saati.
        df.format(simdikiZaman);
        String a=df.format(simdikiZaman).toString(); 
         String sorgu="insert into gelenjson(json,tarih) values(?,?)";
         try {
             preparedStatement=con.prepareStatement(sorgu);
             preparedStatement.setString(1, gelennJson);
             preparedStatement.setString(2, a);
             preparedStatement.executeUpdate();
             System.out.println("Json kaydedildi..");
         } catch (Exception e) {
             System.out.println(e.getMessage());
             System.out.println("Json kaydedilemedi..");
         }
     }
     
     
     
   public void kullaniciEkle(String ad,String sifre,String mail ){ // çalışıyor.
           String sorgu="insert into users(userName,password,mail) values(?,?,?)";
       try {
           preparedStatement=con.prepareStatement(sorgu);
           preparedStatement.setString(1, ad); // ilk ?
           preparedStatement.setString(2, sifre); // ikinci ?
           preparedStatement.setString(3, mail); // üçüncü ?
           preparedStatement.executeUpdate(); 
           System.out.println("Veri eklendi");
           
           
       } catch (SQLException ex) {
           System.out.println("Veri eklenemedi");
       }
   
   }  // kullanıcı ekliyor. 
   public publicPanel getpP(){
       return pP;
   }
   public void notEkle(String kullanici_adi,String not){  // not ekleme fonksiyonu çalışıyor.
             Date simdikiZaman = new Date();
        // notları getirdiğimizdede id yi küçükten büyüğe doğru sıralanmış olarak getiririz.(Yeniler en son id de.)
        
        
        DateFormat df = new SimpleDateFormat("dd.M.yyyy - HH:mm:ss"); // hh olduğu zaman da 12 üzerinden, HH : 24 üzerinden gösteriyor saati.
        df.format(simdikiZaman);
        String a=df.format(simdikiZaman).toString(); 
      String sorgu="insert into notes(userName,date,note) values(?,?,?)";
       try {
           preparedStatement=con.prepareStatement(sorgu);
           preparedStatement.setString(1, kullanici_adi);
           preparedStatement.setString(2, a);
           preparedStatement.setString(3, not);
           preparedStatement.executeUpdate();
           System.out.println("Notlar eklendi..");
           
       } catch (SQLException ex) {
           System.out.println("Notlar eklenemedi..");
       }
   } // not ekleme fonksiyonu bitti.
   
  public String[] tarihler=new String[100];
   publicPanel pP;
   public String[] notlar=new String[100];
   
   
   public void notGetir(String adi){//String kullanici_adi
       int sayac=0;
       String sorgu="select * from notes where userName='"+adi+"' order by id asc limit 0,99";
       try {
         
          // preparedStatement.setString(1,kullanici_adi);
               
   statement=con.createStatement();
            ResultSet rs=statement.executeQuery(sorgu);
  
            while(rs.next()){
              String tarih=rs.getString("date");
              String not=rs.getString("note");
               //getpP().getkombo().addItem(not);
                tarihler[sayac]=tarih;
                notlar[sayac]=not;
                //System.out.println("notlar :"+not);
                System.out.println("tek tek norlar dizidekiler: "+tarihler[sayac]);
                System.out.println("notlar: "+notlar[sayac]);
                sayac=sayac+1;
            }
            System.out.println("notlar geldi");
       } catch (SQLException ex) {
           System.out.println("notlar gelmedi");
       }
       
   } // tarihleri getiren fonksiyon biter.
   
 
   
   
}
