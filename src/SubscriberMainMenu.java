import java.sql.SQLException;

public class SubscriberMainMenu implements IObserver {

    @Override
    public void update(int anlikSicaklik,IAgArayuzu agArayuzu) throws SQLException {

        agArayuzu.goruntule("Ayarlanan sıcaklık değeri :"+anlikSicaklik+ "\n \n");
    }
}
