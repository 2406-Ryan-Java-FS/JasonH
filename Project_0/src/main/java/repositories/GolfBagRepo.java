package repositories;

import Models.GolfBag;
import java.util.List;

public interface GolfBagRepo {
    public GolfBag getClub(int id);

    public List<GolfBag> getAllClubs();

    public GolfBag addClub(GolfBag c);

    public GolfBag updateClub(GolfBag update);

    public GolfBag removeClub(int id);
}
