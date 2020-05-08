import java.sql.*;
import java.util.Scanner;

public class VeriTabani implements IVeriTabani{

    @Override
    public boolean login(String kullaniciAdi , String sifre,IAgArayuzu agArayuzu) throws SQLException {


        agArayuzu.goruntule("Veri Tabanına Bağlanılıyor... \n");
        Connection newConnect = baglan(agArayuzu);
        ResultSet rs=null;
        PreparedStatement pst=null;

        agArayuzu.goruntule("Bilgiler Kontrol Ediliyor. \n");
        String sqlKomut = "select * from \"Yetkililer\".\"Kisiler\" where \"kullaniciAdi\"=? and sifre=?";
        pst = newConnect.prepareStatement(sqlKomut);
        pst.setString(1,kullaniciAdi);
        pst.setString(2,sifre);

        rs = pst.executeQuery();

        newConnect.close();

        if(rs.next())
        {
            agArayuzu.goruntule("Kullanıcı Adı ve Şifre Doğrulandı. \n \n");
            return true;
        }
        else
        {
            agArayuzu.goruntule("Girilen Kullanıcı Adı ve Şifre Hatalı. \n \n");
            return false;
        }

    }
    private Connection baglan(IAgArayuzu agArayuzu) {

        Connection connection =null;

        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/YetkiliKisiler", "postgres", "12345");

            if (connection != null)
                agArayuzu.goruntule("Veri Tabanına Bağlandı. \n");
            else
                agArayuzu.goruntule("Bağlantı girişimi başarısız! \n");

        } catch (Exception e) {
            agArayuzu.goruntule("Baglanti Yapilamadı. \n");
            e.printStackTrace();
        }
        return connection;
    }
    public void veriTabaninaKayitEt(int anlikSicaklik, String Tarih,IAgArayuzu agArayuzu) throws SQLException {

        int i =0;

        Connection newConnection = baglan(agArayuzu);
        PreparedStatement pst = null;




        String sqlKomutu = "INSERT INTO \"Yetkililer\".\"SicaklikDegerleri\"(\"Sicaklik\",\"EklenmeTarihi\") VALUES(?,?)";

        pst = newConnection.prepareStatement(sqlKomutu);
        pst.setInt(1,anlikSicaklik);
        pst.setString(2,Tarih);
        i=pst.executeUpdate();

        newConnection.close();







    }
}
