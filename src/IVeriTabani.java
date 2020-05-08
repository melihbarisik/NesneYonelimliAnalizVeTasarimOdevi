import java.sql.Connection;
import java.sql.SQLException;

public interface IVeriTabani {

    public boolean login(String kullaniciAdi , String sifre,IAgArayuzu agArayuzu) throws SQLException;
    public void veriTabaninaKayitEt(int anlikSicaklık, String Tarih,IAgArayuzu agArayuzu) throws SQLException;
}
