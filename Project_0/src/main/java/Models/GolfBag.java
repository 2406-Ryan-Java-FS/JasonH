package Models;

import java.util.Objects;

public class GolfBag {

    private int club_id;
    private String brand;
    private String clubType;
    private int yardage;
    private int confidence;

    public GolfBag(){
    }

    public GolfBag(int id, String brand, String clubType,
                   int yardage, int confidence){
        this.club_id = id;
        this.brand = brand;
        this.clubType = clubType;
        this.yardage = yardage;
        this.confidence = confidence;
    }

    public int getId() {
        return club_id;
    }

    public void setId(int id) {
        this.club_id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getClubType() {
        return clubType;
    }

    public void setClubType(String clubType) {
        this.clubType = clubType;
    }

    public int getYardage() {
        return yardage;
    }

    public void setYardage(int yardage) {
        this.yardage = yardage;
    }

    public int getConfidence() {
        return confidence;
    }

    public void setConfidence(int confidence) {
        this.confidence = confidence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GolfBag golfBag = (GolfBag) o;
        return club_id == golfBag.club_id && yardage == golfBag.yardage && confidence == golfBag.confidence && Objects.equals(brand, golfBag.brand) && clubType == golfBag.clubType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(club_id, brand, clubType, yardage, confidence);
    }

    @Override
    public String toString() {
        return "GolfBag{" +
                "id=" + club_id +
                ", brand='" + brand + '\'' +
                ", clubType=" + clubType +
                ", yardage=" + yardage +
                ", confidence=" + confidence +
                '}';
    }
}
