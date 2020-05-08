import java.sql.SQLException;

public interface IObserver {

    public void update(int anlikSicaklik,IAgArayuzu agArayuzu) throws SQLException;
}
