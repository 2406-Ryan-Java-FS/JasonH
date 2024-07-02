package repositories;

//import Models.ClubType;
import Models.GolfBag;
import Util.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GolfBagRepoImpl implements GolfBagRepo {

    public static Connection conn = JDBCConnection.getConnection();

    @Override
    public GolfBag getClub(int id) {
        String sql = "select * from golfclubs where club_id = ?";

        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                return buildGolfBag(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<GolfBag> getAllClubs() {
        String sql = "select * from golfclubs";

        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<GolfBag> golfbag = new ArrayList<>();

            while (rs.next()){
                golfbag.add(buildGolfBag(rs));
            }
            return golfbag;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public GolfBag addClub(GolfBag c) {
        String sql = "insert into golfclubs (brand, club_type, yardage, confidence) values (?,?,?,?) returning *";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, c.getBrand());
            ps.setString(2, c.getClubType());
            ps.setInt(3,c.getYardage());
            ps.setInt(4,c.getConfidence());

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                return buildGolfBag(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

//    @Override
//    public GolfBag updateClub(GolfBag update) {
//        try{
//            String sql = "update golfclubs set brand=?, club_type=?, yardage=?, confidence=? where club_id=? returning *";
//            PreparedStatement ps = conn.prepareStatement(sql);
//
//
//            ps.setString(1,update.getBrand());
//            ps.setString(2,update.getClubType());
//            ps.setInt(3,update.getYardage());
//            ps.setInt(4,update.getConfidence());
//            ps.setInt(5,update.getId());
//
//            ResultSet rs = ps.executeQuery();
//
//            if(rs.next()){
//                return buildGolfBag(rs);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    @Override
    public GolfBag removeClub(int id) {
        try{
            String sql = "delete from golfclubs where club_id = ? returning *";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                return buildGolfBag(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private GolfBag buildGolfBag(ResultSet rs) throws SQLException{
        GolfBag gb = new GolfBag();
        gb.setId(rs.getInt("club_id"));
        gb.setBrand(rs.getString("brand"));
        gb.setClubType(rs.getString("club_type"));
        gb.setYardage(rs.getInt("yardage"));
        gb.setConfidence(rs.getInt("confidence"));
        return gb;
    }
}
