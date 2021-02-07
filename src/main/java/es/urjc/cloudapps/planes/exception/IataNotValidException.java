package es.urjc.cloudapps.planes.exception;

public class IataNotValidException extends RuntimeException {

    public IataNotValidException(String msg) {
        super(msg);
    }

}
