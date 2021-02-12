package es.urjc.cloudapps.planes.dto;

import org.json.JSONObject;

public class PlaneRevisionJsonDto {

    private final String plate;
    private final JSONObject revisionsJson;

    public PlaneRevisionJsonDto(String plate, String revisionsJson) {
        this.plate = plate;
        this.revisionsJson = revisionsJson == null ? null : new JSONObject(revisionsJson);
    }

    public String getPlate() {
        return plate;
    }

    public JSONObject getRevisionsJson() {
        return revisionsJson;
    }

}
