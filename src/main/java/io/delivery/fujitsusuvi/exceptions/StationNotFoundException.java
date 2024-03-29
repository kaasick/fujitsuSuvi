package io.delivery.fujitsusuvi.exceptions;

public class StationNotFoundException extends RuntimeException {
    private final static long serialVersionUID = 1L;

    public StationNotFoundException() {
        super();
    }

    public StationNotFoundException(String message) {
        super(message);
    }
}
