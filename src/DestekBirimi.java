import java.util.Scanner;

public class DestekBirimi implements IDestekBirimi{


    private int minSicaklikDegeri = -14;


    public void durumuDegerlendir(int guncelSicaklikDegeri,IAgArayuzu agArayuzu)
    {
        if(guncelSicaklikDegeri == 0)
        {
            agArayuzu.goruntule("Lütfen Önce Güncel Sıcaklik Değerini Hesaplatınız \n" );
        }
        else
        {
            agArayuzu.goruntule("Güncel Sıcaklık Değeri :"+guncelSicaklikDegeri+"\n");

            if(guncelSicaklikDegeri >minSicaklikDegeri)
            {
                agArayuzu.goruntule("Sıcaklık Değeri Olması Gereken Değerden Düşük Soğutucu Cihazı Açınız. \n \n");

            }
            else
            {
                agArayuzu.goruntule("Güncel Sıcaklık Değeri İstenen Aralıkta İşlem Yapmak Gerekmemektedir. \n \n");

            }
        }
    }


}
