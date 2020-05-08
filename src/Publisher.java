import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Publisher implements ISubject{


    private List<IObserver> subscribers = new ArrayList<>();

    @Override
    public void attach(IObserver newSubscriber)
    {
        subscribers.add(newSubscriber);
    }

    @Override
    public void detach(IObserver newSubscriber)
    {
        subscribers.remove(newSubscriber);
    }

    @Override
    public void notify(int anlikSicaklik,IAgArayuzu agArayuzu) throws SQLException {
        for(IObserver subscriber: subscribers) {
            subscriber.update(anlikSicaklik,agArayuzu);
        }
    }
}
