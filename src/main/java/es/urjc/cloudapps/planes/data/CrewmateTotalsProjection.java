package es.urjc.cloudapps.planes.data;

public class CrewmateTotalsProjection {

    private String name;
    private String surname;
    private long totalFlies;
    private double flyingHours;

    public CrewmateTotalsProjection(String name, String lastname, long totalFlies, double flyingHours) {
        this.name = name;
        this.surname = lastname;
        this.totalFlies = totalFlies;
        this.flyingHours = flyingHours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public long getTotalFlies() {
        return totalFlies;
    }

    public void setTotalFlies(long totalFlies) {
        this.totalFlies = totalFlies;
    }

    public double getFlyingHours() {
        return flyingHours;
    }

    public void setFlyingHours(double flyingHours) {
        this.flyingHours = flyingHours;
    }
}
