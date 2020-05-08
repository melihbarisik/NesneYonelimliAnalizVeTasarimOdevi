import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SubscriberDataBase implements IObserver{


    @Override
    public void update(int anlikSicaklik,IAgArayuzu agArayuzu) throws SQLException {

        IVeriTabani veriTabani = new VeriTabani();
        Date simdikiTarih = new Date();
        veriTabani.veriTabaninaKayitEt(anlikSicaklik,simdikiTarih.toString(),agArayuzu);;


       agArayuzu.goruntule("Ayarlanan Sıcaklık Değeri Ve Tarih VeriTabanına Eklendi. \n \n \n");



    }
}
