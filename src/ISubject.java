import java.sql.Date;
import java.sql.SQLException;

public interface ISubject {

    public void attach(IObserver newSubscriber);
    public void detach(IObserver newSubscriber);
    public void notify(int anlikSicalik,IAgArayuzu agArayuzu) throws SQLException;

}
