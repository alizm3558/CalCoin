/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;
import gui.mainPanel;
import gui.publicPanel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import javax.swing.JComboBox;
import java.util.Timer;
import java.util.TimerTask;
/**
 *
 * @author aliba
 */
public class action implements ActionListener{
  
   public mainPanel mainpanel;
    publicPanel publicpanel;
    connections connect;
    sorgular sorgu=new sorgular();
   private String adminName="", adminPass="";
 
   /*public Weather url_Connect(String sehir){
         
        Weather weather = new Weather();//weather sınıfını çağırdık
        String result = "";//json çekip bu stringe aktarıcaz
        try {
            URL weather_url = new URL("http://api.openweathermap.org/data/2.5/weather?q="+sehir+",tr&appid=4e1fdea7f65270d74ec695a2e5da2d2c");// json'a api key ve seçili şehiri gönderiyor..
            HttpURLConnection weather_url_con = (HttpURLConnection) weather_url.openConnection();
            InputStreamReader inputStreamReader = new InputStreamReader(weather_url_con.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//buffered reader ile okuduk
            String line = null;// bu ise jsonu satır satır okuyup result'a ekliyoruz
            while ((line = bufferedReader.readLine()) != null){                
                result += line;
            }
            bufferedReader.close();
            return weather = parseResult(result); 
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return weather;
        }*/    
 
   public  String url_exchange()
        {
    exchange doviz=new exchange();
    String result="";
       try {
           URL exchange_url= new URL("http://data.fixer.io/api/latest?access_key=bef6d960365ae70273d3b370e0a6ae8c");
           HttpURLConnection exchange_url_con=(HttpURLConnection) exchange_url.openConnection();
           InputStreamReader inputStreamReader=new InputStreamReader(exchange_url_con.getInputStream());
//           BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
//           String line=null;
//           while((line=bufferedReader.readLine())!=null){
//               result+=line;
//           }
//           bufferedReader.close();
//           return doviz= parseResult(result);
                int data=inputStreamReader.read();
                while(data>0){
                    char character=(char)data;
                    result+=character;
                    data=inputStreamReader.read();
                  
                }
                  System.out.println("json geldi");
                return result;
              
       } catch (Exception e) {
           System.out.println("json hata verdi");
            return null;
       }
   
}
   exchange genelDoviz;
        public double resultUsd,resultCyn,resultTl,resultGbp,resultKwd;
        
       public void parseJson(){
           try {
              /*not:
                 * Json nesnesinde "[]": dizi,  "{}": nesneyi ifade ediyor 
                        Yani bu url de jsondaki rates nesnedir.
               */
               JSONObject jsonObject=new JSONObject(url_exchange());  // url_change fonksiyonunda json bağlantısı yapılıp veriler geliyor.
               resultTl=jsonObject.getJSONObject("rates").getDouble("TRY"); // resultTl ye jsonObjectnin rates objesinden try double değeri geliyor. 
               resultKwd=jsonObject.getJSONObject("rates").getDouble("KWD");
               resultCyn=jsonObject.getJSONObject("rates").getDouble("CNY");
               resultGbp=jsonObject.getJSONObject("rates").getDouble("GBP");
               resultUsd=jsonObject.getJSONObject("rates").getDouble("USD");
//               genelDoviz.setTl(resultTl); //euro sonucu
//               genelDoviz.setUsd(resultUsd);
//               genelDoviz.setGbp(resultGbp);
//               genelDoviz.setKwd(resultKwd);
//               genelDoviz.setCyn(resultCyn);
                 System.out.println("CNY:"+ resultCyn);
               
        
              
           } catch (Exception e) {
               System.out.println(e.getMessage());
           }
           
           
        }
      public double euro,dolar,cin,kuveyt,sterlin,euroG,dolarG,cinG,kuveytG,sterlinG;
       public void paraHesaplama(){
           euro=resultTl;
           dolar=resultTl/resultUsd; // çalışıyor.
           cin=resultCyn/resultTl;
           kuveyt=resultTl/resultKwd;
           sterlin=resultTl/resultGbp;
           
           getmainpanel().getpP().geteur().setText("€EUR: "+ new DecimalFormat("##.###").format(euro)); 
           getmainpanel().getpP().getusd().setText("$USD: "+ new DecimalFormat("##.###").format(dolar));  // new DecimalFormat(“##.##”).format(sayi1+sayi2)
           getmainpanel().getpP().getgbp().setText("£GBP: "+new DecimalFormat("##.###").format(sterlin));
           getmainpanel().getpP().getcny().setText("¥CNY: "+new DecimalFormat("##.###").format(cin));
           getmainpanel().getpP().getkwd().setText("KWD: "+new DecimalFormat("##.###").format(kuveyt));
  
           
         
       }
       
    
      
       
               
       
    public action(mainPanel mainpanel){
        setmainpanel(mainpanel);
        
    
    }
    
    public connections getconnect(){
        return connect;
    }
    public void setconnect(connections connect){
        this.connect=connect;
    }
    
  // public JComboBox kombo=null;
    
    public mainPanel getmainpanel(){
        return mainpanel;
    }
    public void setmainpanel(mainPanel mainpanel){
        this.mainpanel=mainpanel;
    }
    
    public publicPanel getpublicpanel(){
        return publicpanel;
       
    }
    public void setpublicpanel(publicPanel pulicpanel){
        this.publicpanel=publicpanel;
    }
     public static String[] dizi1={"ali","ohahah","bakır"};
  
     public void actionPerformed(ActionEvent e)
     {
         if(e.getSource()==getmainpanel().getbuton()) // a butonu
         {
             /* bu buton kullanıcı girişini kontrol ediyor ve kllanıcı doğrulandığında;
                 kullanıcı adını publicPanele göndererek o paneli visible yapıyor.*/
             
             
              getmainpanel().getsignPanel().setVisible(false); // kayıt ekranını kapatıyor.
            //getmainpanel().gettextUser().setText("dasdsadas");
           adminName=getmainpanel().gettextUser().getText();
             adminPass=getmainpanel().getpassfield().getText();
             
             boolean anahtar2=sorgu.kullaniciKontrol(adminName  , adminPass); // girilen değerlere eşit veri var mıdır yok mudur diye cevaben boolean değeri getiriyor.

                   if(adminName.equals("") || adminPass.equals(""))   // giriş panelinin butonu.
                    {
                                  
                             getmainpanel().getgirisLbl().setText("!Boş alan bırakmayınız..");
                    
                    }
            
                  else  { 
                                    if(anahtar2==true){
                                 //  getpublicpanel().getKimlik().setText(adminName);
                                     getmainpanel().getpP().getad(adminName);
                                     System.out.println("gelen ad: "+getmainpanel().getpP().ad); // bu satır konsolda kullanıcı adını yazdırıyor.
                                     getmainpanel().getpP().getpublicpanel().setVisible(true);   
                                     getmainpanel().getinputPane1().setVisible(false);
                                     getmainpanel().getpP().getkimlik().setText("Admin: "+adminName);// bu satır publicPanele kulllanıcı adını gönderiyor.
                                            
                                     getmainpanel().getpP().getad(adminName);
                                             sorgu.notGetir(adminName);//notları getiriyor.
                                             ComboBoxModel tarihModel=new DefaultComboBoxModel(sorgu.tarihler);
                                             getmainpanel().getpP().getcombo().setModel(tarihModel);
                                  
                                      
                                        System.out.println(url_exchange()); 
                                        parseJson();// jsonu para birimlerine parçalıyor..
                                        paraHesaplama();// çalışıyor..
                                                sorgu.jsonEkle(url_exchange());
         
  
                                 }
                                  else{
                                 // giriş panelindeki textboxlar bolaştılıyor.
                                     getmainpanel().getpassfield().setText(null);
                                     getmainpanel().getgirisLbl().setText("!Kayıt bulunamadı..");
                              
                                     }
                          
                        }
         }   // a butonu biter.
         
         if(e.getSource()==getmainpanel().getsignButon()){
             getmainpanel().getsignPanel().setVisible(true); // Yeni kayıt panelini açıyor.
               
         
                     }  ////////////////////////
         
         if(e.getSource()==getmainpanel().getsignRecord()) //////////    Yeni kullanıcı ekliyor.
         {

             String kullanici_adi,parola,mail;
             kullanici_adi=getmainpanel().getsignUser().getText();
             parola=getmainpanel().getsignPass().getText();
             mail=getmainpanel().getsignPass2().getText();
             
             if(kullanici_adi.equals("") || parola.equals("") || mail.equals("")){
                 getmainpanel().getaciklamaLbl().setText("!Boş alan bırakmayınız..");
             }
             
             else{
             boolean anahtar=sorgu.kayitKontrol(kullanici_adi, parola); // girilen bilgileri kontrol ediyor ve boolean değeri dönderiyor.
             
              System.out.println(anahtar);
             if(anahtar==true){
                 
                    getmainpanel().getaciklamaLbl().setForeground(Color.decode("#8b0000"));
                    getmainpanel().getaciklamaLbl().setText("!Başka kullanıcı adı giriniz.");
             }
             else{
                 sorgu.kullaniciEkle(kullanici_adi, parola, mail); // kullanıcı ekleme fonksiyonu.
                 
                    getmainpanel().getaciklamaLbl().setForeground(Color.white);
                    getmainpanel().getaciklamaLbl().setText("!Yeni kullanıcı eklendi");
                    
                    getmainpanel().getsignPass2().setText("");
                    getmainpanel().getsignPass().setText("");
                    getmainpanel().getsignUser().setText("");
             } /////
         
         }
         
             
         } /// kullanıcı ekleme butonu son.
 
//         if(e.getSource()==kombo){
//            getmainpanel().getpP().indis=kombo.getSelectedIndex();
////             System.out.println("indis değer: "+kombo.getSelectedIndex());
//////System.out.println("not: "+sorgu.notlar[getmainpanel().getpP().indis]);
//if(getmainpanel().getpP().indis>=0)
//getmainpanel().getpP().getgelenNot().setText(sorgu.notlar[getmainpanel().getpP().indis]);
//else{
//    getmainpanel().getpP().getnotAciklama().setForeground(Color.decode("#8b0000"));
//    getmainpanel().getpP().getnotAciklama().setText("!Anlamlı değer seçilmedi..");}
//              
//         }
     } // action fonksiyonu son.

   
}

