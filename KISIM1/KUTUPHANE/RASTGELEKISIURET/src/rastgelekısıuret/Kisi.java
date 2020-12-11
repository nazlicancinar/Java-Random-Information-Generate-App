/**
* @author Yunus Şen yunus.sen3@ogr.sakarya.edu.tr
* @author Nazlıcan Çınar nazlican.cinar@ogr.sakarya.edu.tr
* @since 05.04.2020
*/
package rastgelekısıuret;

import rastgelekısıuret.Rastgele;

public class Kisi { //bilgileri burada tutup tc ve telefon no bu sınıfta olusturulur
   
    public TelefonNo phone;
    public TCKimlikNo TCno;
    public String name_surname;
    public int age;
    
    
    public Kisi(String name_surname) {
        Rastgele rastgeleSayi;     
        rastgeleSayi = new Rastgele(100);
        
        this.name_surname = name_surname;
        this.age = (rastgeleSayi.createRandomNumber() * name_surname.length())%101; //rsatgeleligi arttıtmak amacıyla
        this.phone = new TelefonNo();
        this.TCno = new TCKimlikNo();
        
    }
    
}
