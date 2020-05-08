import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class Eyleyici implements IEyleyici {

    private static Eyleyici instance;

    private int minSicaklikDegeri;
    private boolean sogutucuDurumu;

    private Eyleyici() {
        instance = null;
        minSicaklikDegeri = -14;
        sogutucuDurumu = false;
    }


    public static Eyleyici getInstance() {
        if (instance == null) {
            instance = new Eyleyici();
        }
        return instance;
    }


    public int sogutucuyuAc(int guncelSicaklikDegeri, Publisher p, IAgArayuzu agArayuzuIki) throws SQLException {

        if (sogutucuDurumu == false) {

            agArayuzuIki.goruntule("Soğutucu Cihaz Açılıyor. \n");
            agArayuzuIki.goruntule("Sıcaklık Değeri Ayarlanıyor... \n \n");
            while (guncelSicaklikDegeri >= minSicaklikDegeri - 3) {
                guncelSicaklikDegeri--;
            }
            agArayuzuIki.goruntule("Sıcaklık Değeri Ayarlandı. \n");

            p.notify(guncelSicaklikDegeri, agArayuzuIki);
            sogutucuDurumu = true;


        } else {
            agArayuzuIki.goruntule("Soğutucu Cihaz Zaten Açık Konumda. \n \n");

        }
        return guncelSicaklikDegeri;

    }

    public void sogutucuyuKapat(IAgArayuzu agArayuzuIki) {

        if (sogutucuDurumu == true) {
            agArayuzuIki.goruntule("Soğutucu Başarılı Bir Şekilde Kapatıldı. \n \n");

            sogutucuDurumu = false;
        } else {
            agArayuzuIki.goruntule("Soğutucu Zaten Kapalı Konumda. \n \n");

        }


    }

    public boolean getSogutucuDurumu() {
        return this.sogutucuDurumu;
    }

}
