/**
* @author Yunus Şen yunus.sen3@ogr.sakarya.edu.tr
* @author Nazlıcan Çınar nazlican.cinar@ogr.sakarya.edu.tr
* @since 05.04.2020
*/
package rastgelekısıuret;

import static java.lang.Math.abs;
import rastgelekısıuret.Rastgele;

public class TCKimlikNo {
    
    private final int[] _kimlikno = new int[11];
    
    public TCKimlikNo(){
        createTCno();
    }
    
    private void createTCno(){//Tc no olusturma
        
       Rastgele rastgeleSayi;     
       rastgeleSayi = new Rastgele(10);
        _kimlikno[0] = (rastgeleSayi.createRandomNumber()%8) + 1; //ilk rakam sıfır olamaz o yuzden +1
        
        for(int i = 1; i<9; i++)
        {
             rastgeleSayi = new Rastgele(10 + i); //rastgeleliği arttırmak amacıyla
            _kimlikno[i] = (rastgeleSayi.createRandomNumber()%10); //aradaki rakamlar rastgele atanır
        }
        //10 ve 11. rakamın bulunma formulu
        _kimlikno[9] = abs((7*(_kimlikno[0] + _kimlikno[2] + _kimlikno[4] + _kimlikno[6] 
                + _kimlikno[8]) - (_kimlikno[1] + _kimlikno[3] + _kimlikno[5] + _kimlikno[7]))%10);
        
        _kimlikno[10] = (_kimlikno[0] + _kimlikno[1] + _kimlikno[2] + _kimlikno[3] + _kimlikno[4] 
                + _kimlikno[5] + _kimlikno[6] + _kimlikno[7] + _kimlikno[8] + _kimlikno[9])%10;
    }
      
    public String readTcNo(){ //Tc kimlik no okuma metodu
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 11; i++){
            sb.append(_kimlikno[i]);
        }
        return sb.toString();
    }
    
    public static boolean controlTCNo(String s){ //Tc kimlik no kontrol etme
        int[] _controlKimlikNo = new int[11];
        //son 2 rakam kontrol edilerek doğruluk kontrol edilir
        boolean char10 = false;
        boolean char11 = false;
        for(int i = 0; i<11; i++)
        { //alınan parametre diziye atanır
            _controlKimlikNo[i] = Character.getNumericValue(s.charAt(i));
        }
        
        if(_controlKimlikNo[9] == abs((7*(_controlKimlikNo[0] + _controlKimlikNo[2] + _controlKimlikNo[4] + _controlKimlikNo[6] + _controlKimlikNo[8])
                - (_controlKimlikNo[1] + _controlKimlikNo[3] + _controlKimlikNo[5] + _controlKimlikNo[7]))%10)) 
        {
            char10 = true;
        }
        
        if(_controlKimlikNo[10] == (_controlKimlikNo[0] + _controlKimlikNo[1] + _controlKimlikNo[2] + _controlKimlikNo[3] 
                + _controlKimlikNo[4] + _controlKimlikNo[5] + _controlKimlikNo[6] + _controlKimlikNo[7] + _controlKimlikNo[8] + _controlKimlikNo[9])%10) 
        {
            char11 = true;
        }
        return char10 && char11; //eğer son iki rakam true donerse kontrol saglanır
    }
    
    
    
}
