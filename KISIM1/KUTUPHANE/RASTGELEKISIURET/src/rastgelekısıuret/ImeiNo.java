/**
* @author Yunus Şen yunus.sen3@ogr.sakarya.edu.tr
* @author Nazlıcan Çınar nazlican.cinar@ogr.sakarya.edu.tr
* @since 05.04.2020
*/
package rastgelekısıuret;

import rastgelekısıuret.Rastgele;


public class ImeiNo {
     
    public int[] imei_no;
    
    public ImeiNo() 
    {
        imei_no = new int[15];
        int[] _temp = new int[15];
        int sum = 0;
        Rastgele rastgeleSayi;     
        rastgeleSayi = new Rastgele(10);
        
        imei_no[0] =   rastgeleSayi.createRandomNumber()%9 + 1;  //ilk rakam sıfır olamaz o yuzden +1
        
        for(int i = 1; i < 14; i++)//13 rakam icin rastgele atama yapar
        {
            rastgeleSayi = new Rastgele(10 + i); //rastgeleligi arttırmak amacıyla
            imei_no[i] = rastgeleSayi.createRandomNumber()%10;
        }
        
        System.arraycopy(imei_no, 0, _temp, 0, imei_no.length);
        
        for(int i = 1; i<14; i+=2)//çift rakamlar x 2
        {
            _temp[i] *=2;
            sum+=_temp[i]%10+(_temp[i]-_temp[i]%10)/10; //basamak degerlerini topla
        }
        
        for(int i = 0; i<13; i+=2)
        {//geri kalan rakamlar aynen toplanır
            sum+=imei_no[i];
        }
        
        if(sum%10 != 0)//14 tane rakamın toplamının modunun 10'a tümleyeni son rakamı verir.
        {
            imei_no[14]=10-(sum%10);
        }
        else
        {
            imei_no[14] = 0;
        }
    }
    
     public  String readImei(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 15; i++){
            sb.append(imei_no[i]);
        }
        return sb.toString();
    }
     
     public static boolean controlIMEINo(String s){ //imei no kntrol et
       
        int[] _controlIMEI = new int[15];
        int _sum = 0;
        
        for(int i = 0; i<15; i++)
        {
            _controlIMEI[i] = Character.getNumericValue(s.charAt(i));
        }
        
        for(int i = 1; i<14; i+=2)
        {
            _controlIMEI[i] *=2;
            _sum+=_controlIMEI[i]%10+(_controlIMEI[i]-_controlIMEI[i]%10)/10;
        }
        
        for(int i = 0; i<13; i+=2)
        {
            _sum+=_controlIMEI[i];
        }
        
        
        if(_controlIMEI[14] != 0)
            return 10-(_sum%10) == _controlIMEI[14];
        else if(_controlIMEI[14] == 0 && _sum%10 == 0 ) 
            return true;
        
        return false;
    }
    
    
    
     
    
}
