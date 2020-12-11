/**
* @author Yunus Şen yunus.sen3@ogr.sakarya.edu.tr
* @author Nazlıcan Çınar nazlican.cinar@ogr.sakarya.edu.tr
* @since 05.04.2020
*/
package rastgelekısıuret;

import rastgelekısıuret.Rastgele;
import java.io.FileWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class RastgeleKisi {
   
    public Kisi _newPerson;
    public RastgeleKisi(String nameSurname) {//gönderilen parametre ile yeni bir kisi olusturulur
        _newPerson = new Kisi(nameSurname);
    }
    
    public static void RastgeleKisiUret(int num) throws IOException
    {//üretilecek kişi sayısı parametre ile alınır
        
        Rastgele rastgeleSayi;
        
        
        FileInputStream _fileStream;
         _fileStream = new FileInputStream("random_isimler.txt");
        BufferedInputStream _bfStream;
         _bfStream = new BufferedInputStream(_fileStream);
        DataInputStream _dataStream;
        _dataStream = new DataInputStream(_bfStream);
        FileWriter _fileWriter;
        _fileWriter = new FileWriter("Kisiler.txt");
        BufferedWriter _bufWriter;
       _bufWriter = new BufferedWriter(_fileWriter);
       
       
        RastgeleKisi[] _contacts = new RastgeleKisi[num];//dizi uzunlugu parametredeki sayı kadar
        for(int i = 0; i < num; i++)
        {
            rastgeleSayi = new Rastgele(3000+i);
            
            for(int k=0;k<(rastgeleSayi.createRandomNumber()&3001);k++)
            {//rastgele isim bulmak için readLine ile random_isimler.txt dosyasından satır okur ve son okunan satur kisi ismi olarak atanir.
                _dataStream.readLine();
            }
            _fileStream.getChannel().position(0);
            _bfStream = new BufferedInputStream(_fileStream);
            _contacts[i] = new RastgeleKisi(_dataStream.readLine());
            _bufWriter.write(_contacts[i].createRandPerson());
            _bufWriter.newLine();                            
        }
        
        _bfStream.close();
        _fileStream.close();
        _dataStream.close();
        _bufWriter.close();
    }
    
    public String createRandPerson(){ //yeni bir kisi olusturup string olarak doner
        return _newPerson.TCno.readTcNo() + " " + _newPerson.name_surname + " " + _newPerson.age + " " + 
                _newPerson.phone.readPhone()+ " (" + _newPerson.phone.imei.readImei() + ")";
    }
    
    public static int[] controlContacts() throws FileNotFoundException, IOException{//Kontrol işlemi
        FileInputStream _fileStream1;
         _fileStream1 = new FileInputStream("Kisiler.txt");
        BufferedInputStream _bfStream1;
         _bfStream1 = new BufferedInputStream(_fileStream1);
        DataInputStream _dataStream1;
         _dataStream1 = new DataInputStream(_bfStream1);
         
        int _recordNo=0,_wrongTCNo=0,_wrongIMEI=0;

        while(_dataStream1.available() != 0){
            _recordNo++;//her satır kayıt sayısına denktir
            
            String TCNo,IMEINo;
            String temp=_dataStream1.readLine();
            String[] _data = temp.split(" ");//satırdaki verileri bosluga göre split edilir ve verileri ayrıstırabiliriz.     
            TCNo = _data[0];
            if(!TCKimlikNo.controlTCNo(TCNo))
            {//tc no yanlis ise sayac arttırılır
                _wrongTCNo++;
            }    
            IMEINo = _data[_data.length - 1];
            IMEINo = IMEINo.replaceAll("\\(", "");//satırdaki imei no yanındaki parantezler null ile replace edilir
            IMEINo = IMEINo.replaceAll("\\)", "");
            if(!ImeiNo.controlIMEINo(IMEINo))
            {//imei no yanlis ise sayac arttırılır
                _wrongIMEI++;
            }
        }
        
        int[] _info = {_recordNo, _wrongTCNo, _wrongIMEI}; //kayit sayisi, yanlis tc no, yanlis imei no dondurulur
        return _info;
    }
    
    
    
}
