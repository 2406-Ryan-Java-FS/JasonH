package Controllers;

import com.google.gson.Gson;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import Models.GolfBag;
import Services.GolfBagService;
import java.util.List;

public class GolfBagController{
    private GolfBagService gbs;
    private Gson gson = new Gson();

    public GolfBagController(GolfBagService gbs){
        this.gbs=gbs;
    }

    public Handler getClubById = (context) -> {
        int id = Integer.parseInt(context.pathParam("id"));
        GolfBag g = gbs.getClub(id);
        context.result(gson.toJson(g));
    };

    public Handler getAllClubs = (context) -> {
        List<GolfBag> golfBag = gbs.getAllClubs();
        String golfBagJSON = gson.toJson(golfBag);
        context.result(golfBagJSON);
    };

    public Handler mkClub = (context) -> {
        GolfBag gb = gson.fromJson(context.body(), GolfBag.class);
        gb = gbs.addClub(gb);
        context.result(gson.toJson(gb));
    };

    public Handler delClub = (context) -> {
        int id = Integer.parseInt(context.pathParam("id"));
        GolfBag g = gbs.removeClub(id);
        context.result(gson.toJson(g));
    };
}