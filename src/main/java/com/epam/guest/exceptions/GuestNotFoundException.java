package com.epam.guest.exceptions;

/**
 * The type Guest not found exception.
 */
public class GuestNotFoundException extends RuntimeException {
    /**
     * Instantiates a new Guest not found exception.
     *
     * @param message the message
     */
    public GuestNotFoundException(String message) {
        super(message);
    }
}
