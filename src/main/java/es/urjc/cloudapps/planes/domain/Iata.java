package es.urjc.cloudapps.planes.domain;

import es.urjc.cloudapps.planes.exception.IataNotValidException;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Iata {

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

}
