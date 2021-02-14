package es.urjc.cloudapps.planes.domain;

import es.urjc.cloudapps.planes.exception.IataNotValidException;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Iata implements Serializable {

    @Column(name = "iata", unique = true)
    private String value;

    public Iata(String value) {
        if (value == null || value.length() != 3)
            throw new IataNotValidException("El codigo IATA debe tener una longitud de 3 caracteres");
        this.value = value;
    }

    public Iata() {
    }

    public String getValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Iata iata = (Iata) o;
        return Objects.equals(value, iata.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Iata{" +
                "value='" + value + '\'' +
                '}';
    }
}
