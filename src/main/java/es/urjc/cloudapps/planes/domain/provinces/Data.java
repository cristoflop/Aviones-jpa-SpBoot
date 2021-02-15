package es.urjc.cloudapps.planes.domain.provinces;

import org.springframework.data.mongodb.core.mapping.Field;

public class Data {

    @Field(name="Anyo")
    private Integer year;

    @Field(name="Valor")
    private Integer value;

    public Integer getYear() {
        return year;
    }

    public Integer getValue() {
        return value;
    }
}
