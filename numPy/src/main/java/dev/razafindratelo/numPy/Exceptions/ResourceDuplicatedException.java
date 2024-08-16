package dev.razafindratelo.numPy.Exceptions;

public class ResourceDuplicatedException extends RuntimeException {
    public ResourceDuplicatedException(String message) {
        super(" --- Resource duplicated exception" + message);
    }
}
