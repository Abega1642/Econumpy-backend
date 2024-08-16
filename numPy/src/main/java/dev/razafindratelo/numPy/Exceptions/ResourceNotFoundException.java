package dev.razafindratelo.numPy.Exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super("---  Resource not found" + message);
    }

}
