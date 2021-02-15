package es.urjc.cloudapps.planes.dto;

public class ProvinceTotalsDto {

    private final String _id;
    private final Integer provinces;

    public ProvinceTotalsDto(String _id, int provinces) {
        this._id = _id;
        this.provinces = provinces;
    }

    public String getId() {
        return _id;
    }

    public Integer getProvinces() {
        return provinces;
    }
}
