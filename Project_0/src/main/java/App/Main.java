package App;

import Controllers.GolfBagController;
import io.javalin.Javalin;
import io.javalin.core.JavalinConfig;
import repositories.GolfBagRepo;
import repositories.GolfBagRepoImpl;
import Services.GolfBagService;
import Services.GolfBagServiceImpl;

import static io.javalin.apibuilder.ApiBuilder.*;

public class Main {
    public static void main(String[] args) {
        Javalin app = Javalin.create(JavalinConfig::enableCorsForAllOrigins);


        establishRoutes(app);
       app.start(8080);
    }

    private static void establishRoutes(Javalin app){
        GolfBagRepo gr = new GolfBagRepoImpl();
        GolfBagService gs = new GolfBagServiceImpl(gr);
        GolfBagController gc = new GolfBagController(gs);

        app.get("/golfbag/{id}", gc.getClubById);
        app.get("/golfbag", gc.getAllClubs);
        app.post("/golfbag", gc.mkClub);
        app.put("/golfbag/{id}", gc.UDClub);
        app.delete("/golfbag/{id}",gc.delClub);
    }
}
