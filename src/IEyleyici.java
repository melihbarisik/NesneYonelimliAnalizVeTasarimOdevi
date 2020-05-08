import java.sql.SQLException;

public interface IEyleyici {

    public int sogutucuyuAc(int guncelSicaklik,Publisher p,IAgArayuzu agArayuzu) throws SQLException;
    public void sogutucuyuKapat(IAgArayuzu agArayuzu);
    public boolean getSogutucuDurumu();
}
