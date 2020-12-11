/**
* @author Yunus Şen yunus.sen3@ogr.sakarya.edu.tr
* @author Nazlıcan Çınar nazlican.cinar@ogr.sakarya.edu.tr
* @since 05.04.2020
*/
package rastgelekısıuret;


import java.util.Date;
import rastgelekısıuret.Rastgele;
public class TelefonNo {//telefon nonun oluşturulmasından ve saklanmasından sorumlu sınıf
    
    public ImeiNo imei;
    private int[] _phone;
    
    Date _date = new Date();
    
    
    public TelefonNo(){
        
        Rastgele rastgeleSayi;        
        Rastgele rastgeleSayi1;     
       
        this._phone = new int[11];
        this._phone[0] = 0;//ilk hane sıfır
        this._phone[1] = 5;//ikinci hane 5 olmak zorunda
        
        int[] thirdChar = {0, 3, 4, 5}; //05xx olacağı icin 0, 3, 4, 5 alabilir
    
        rastgeleSayi = new Rastgele(10);
        this._phone[2] = thirdChar[rastgeleSayi.createRandomNumber()%4];//0, 3 ,4, 5
        rastgeleSayi1 = new Rastgele(10);
        this._phone[3] = (rastgeleSayi1.createRandomNumber()&8) + 1;//0 hariç her rakam
        
        for(int i = 4; i < 11; i++)
        {
            rastgeleSayi = new Rastgele(10 + i); //rastgeleliği arttırmak amacıyla
            this._phone[i] = rastgeleSayi.createRandomNumber()%10;//rastgele atama yapılır
        }
        
        this.imei = new ImeiNo();
    }
    
    public String readPhone(){ //telefon no okuma metodu
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 11; i++)
        {
            sb.append(_phone[i]);
        }
        return sb.toString();
    }
    
}
