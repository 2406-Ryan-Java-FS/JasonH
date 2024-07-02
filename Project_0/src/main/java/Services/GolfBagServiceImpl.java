package Services;

import Models.GolfBag;
import repositories.GolfBagRepo;

import java.util.List;

public class GolfBagServiceImpl implements GolfBagService {

    private GolfBagRepo gbr;

    public GolfBagServiceImpl(GolfBagRepo gbr){
        this.gbr = gbr;
    }

    @Override
    public GolfBag getClub(int id) {
        return gbr.getClub(id);
    }

    @Override
    public List<GolfBag> getAllClubs() {
        return gbr.getAllClubs();
    }

    @Override
    public GolfBag addClub(GolfBag c) {
        return gbr.addClub(c);
    }

    @Override
    public GolfBag removeClub(int id) {
        return gbr.removeClub(id);
    }
}
