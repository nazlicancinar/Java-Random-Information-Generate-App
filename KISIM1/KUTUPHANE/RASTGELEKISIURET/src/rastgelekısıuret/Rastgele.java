/**
* @author Yunus Şen yunus.sen3@ogr.sakarya.edu.tr
* @author Nazlıcan Çınar nazlican.cinar@ogr.sakarya.edu.tr
* @since 05.04.2020
*/
package rastgelekısıuret;

import java.util.Date;

public class Rastgele {

int maxNumber;
int lastNumber;


public Rastgele(int no)
{
    maxNumber = no;
    Date _date = new Date();
    long time = System.currentTimeMillis() + System.nanoTime() + _date.getTime();  
    lastNumber = (int) (time % no);
}

public int createRandomNumber(){
    lastNumber = (lastNumber * 32719 + 3) % 32749;
    return lastNumber % maxNumber;
}
}