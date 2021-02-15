package es.urjc.cloudapps.planes.domain.provinces;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.repository.Aggregation;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.List;
import java.util.Objects;

@Document(collection = "provincia")
public class Province {

    @Id
    private String id;

    @Field(name="Nombre")
    private String name;

    @Field(name="CA")
    private String ca;

    @Field(name="Superficie")
    private String area;

    @Field(name="Datos")
    private List<Data> data;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCa() {
        return ca;
    }

    public String getArea() {
        return area;
    }

    public List<Data> getData() {
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Province province = (Province) o;
        return Objects.equals(id, province.id) && Objects.equals(name, province.name) && Objects.equals(ca, province.ca) && Objects.equals(area, province.area) && Objects.equals(data, province.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, ca, area, data);
    }
}
