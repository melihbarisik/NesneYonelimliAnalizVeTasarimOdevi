import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.sql.SQLException;

public class MerkeziIslemBirimi {

    IAgArayuzu agArayuzu;
    IAgArayuzu agArayuzuIki;
    IEyleyici eyleyici;
    ISicaklikAlgilayici sicaklikAlgilayici;
    IVeriTabani veriTabani;
    IDestekBirimi destekBirimi;




    public MerkeziIslemBirimi()
    {


        sicaklikAlgilayici = new SicaklikAlgilayici();
        veriTabani= new VeriTabani();
        destekBirimi= new DestekBirimi();
        agArayuzu = new AgArayuzu();
        agArayuzuIki=new AgArayuzuIki();



    }

    private static final String SICAKLIK_GORUNTULE = "1";
    private static final String SOGUTUCU_ACMA = "2";
    private static final String SOGUTUCU_KAPATMA = "3";
    private static final String DESTEK_ALMA = "4";
    private static final String CIKIS = "5";



    private Publisher publisherBasla()
    {
        SubscriberDataBase subscriberDatabase = new SubscriberDataBase();
        SubscriberMainMenu subscriberMainMenu = new SubscriberMainMenu();
        Publisher p = new Publisher();
        p.attach(subscriberMainMenu);
        p.attach(subscriberDatabase);

        return p;
    }

    private void islemsecimi() throws SQLException {
        int anlikSicaklik =-18;
        Publisher p = publisherBasla();


        String kullaniciSecimi ="";


        eyleyici=Eyleyici.getInstance();

        do {

            kullaniciSecimi = agArayuzu.kullaniciIstekleriniAl();

            agArayuzuIki.goruntule("\n");

            switch (kullaniciSecimi)
            {
                case SICAKLIK_GORUNTULE:
                    anlikSicaklik = sicaklikAlgilayici.SicakligiHesapla(eyleyici,anlikSicaklik,agArayuzuIki);


                    agArayuzuIki.goruntule("Cihazin Anlık Sıcaklığı :");
                    agArayuzuIki.goruntule(String.valueOf(anlikSicaklik));

                    agArayuzuIki.goruntule("\n \n");
                    break;

                case SOGUTUCU_ACMA:
                    anlikSicaklik = eyleyici.sogutucuyuAc(anlikSicaklik,p,agArayuzuIki);
                    break;
                case SOGUTUCU_KAPATMA:
                    eyleyici.sogutucuyuKapat(agArayuzuIki);
                    break;
                case DESTEK_ALMA:
                    destekBirimi.durumuDegerlendir(anlikSicaklik,agArayuzuIki);
                    break;
                case CIKIS:
                    agArayuzuIki.goruntule("İyi Günler \n");
                    break;
                default:
                    agArayuzuIki.goruntule(("1-5 Arasında Bir Sayı Girmelisiniz \n"));
            }


        } while (!kullaniciSecimi.equals(CIKIS));

    }

     public void Basla() throws SQLException {
        String kullaniciAdi = "";
        String sifre = "";
        int kalanHak=4;

         agArayuzuIki.goruntule("\n");
         agArayuzuIki.goruntule("Denetleyici Sistemi \n");



        do{
            kullaniciAdi=agArayuzuIki.kullaniciAdiAl(kullaniciAdi);
            sifre=agArayuzuIki.sifreAl(sifre);
            agArayuzuIki.goruntule("\n");

            if(veriTabani.login(kullaniciAdi,sifre,agArayuzuIki))
            {
                islemsecimi();
                break;
            }
            else
            {
                kalanHak--;
                agArayuzuIki.goruntule("Girilen Kullanıcı Adı Ve Şifre Bulunmamaktadır. \n");
                agArayuzuIki.goruntule("Kalan Deneme Hakkı :"+kalanHak+"\n \n");
            }
        }while(kalanHak != 0);

    }






}
