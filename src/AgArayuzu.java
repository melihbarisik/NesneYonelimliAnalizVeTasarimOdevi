import java.util.Scanner;

public class AgArayuzu implements IAgArayuzu{

    @Override
    public String kullaniciIstekleriniAl() {

        int secim;



        goruntule("Ana Menu \n");
        goruntule("1-Sıcaklık Değerini Görüntüle \n");
        goruntule("2-Soğutucuyu Aç \n");
        goruntule("3-Soğutucuyu Kapat \n");
        goruntule("4-Durumu Değerlendir \n");
        goruntule("5-Çıkış \n");
        goruntule("Seçim :");



        return veriAl();
    }

    @Override
    public String veriAl()
    {
        String alinanVeri;

        Scanner input = new Scanner(System.in);


        return input.nextLine();
    }
    @Override
    public void goruntule(String mesaj)
    {
        System.out.print(mesaj);
    }
    @Override
    public String kullaniciAdiAl(String kullaniciAdi)
    {

        goruntule("Kullanıcı Adınızı Giriniz :");
        return veriAl();

    }
    @Override
    public String sifreAl(String sifre)
    {
        goruntule("Şifrenizi Giriniz :");
        return veriAl();

    }



}
