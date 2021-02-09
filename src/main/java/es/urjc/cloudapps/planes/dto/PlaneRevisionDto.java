package es.urjc.cloudapps.planes.dto;

public class PlaneRevisionDto {

    private final String plate;
    private final long revisionId;
    private final String mechanicName;
    private final String mechanicSurname;

    public PlaneRevisionDto(String plate, long revisionId, String mechanicName, String mechanicSurname) {
        this.plate = plate;
        this.revisionId = revisionId;
        this.mechanicName = mechanicName;
        this.mechanicSurname = mechanicSurname;
    }

    public String getPlate() {
        return plate;
    }

    public long getRevisionId() {
        return revisionId;
    }

    public String getMechanicName() {
        return mechanicName;
    }

    public String getMechanicSurname() {
        return mechanicSurname;
    }

}
