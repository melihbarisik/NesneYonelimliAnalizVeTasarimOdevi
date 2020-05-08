import java.util.Random;

public class SicaklikAlgilayici implements ISicaklikAlgilayici {



    @Override
    public int  SicakligiHesapla(IEyleyici eyleyici,int sicaklik,IAgArayuzu agArayuzuIki)
    {
        if(eyleyici.getSogutucuDurumu() ==true)
        {

            agArayuzuIki.goruntule("Sıcaklık Algılayıcı Çalıştı.");
            Random random = new Random();
            sicaklik = random.nextInt(3)-(18);
        }
        else
        {
            agArayuzuIki.goruntule("Sıcaklık Algılayıcı Çalıştı.");
            Random random = new Random();
            sicaklik = random.nextInt(8)-(12);
        }


        return sicaklik;
    }




}
