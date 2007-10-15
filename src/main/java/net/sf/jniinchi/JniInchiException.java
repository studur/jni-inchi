/*
 * JNI InChI Wrapper - A Java Native Interface Wrapper for InChI.
 * Copyright (C) 2006-2007  Sam Adams
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA  02110-1301, USA
 */
package net.sf.jniinchi;

/**
 * Exception thrown by JniInchi.
 * @author Sam Adams
 */
public class JniInchiException extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor.
     */
    public JniInchiException() {
        super();
    }

    /**
     * Constructs a new exception with the specified detail message.
     *
     * @param message  the detail message.
     */
    public JniInchiException(final String message) {
        super(message);
    }

    /**
     * Constructs a new exception with the specified cause.
     *
     * @param ex    the cause.
     */
    public JniInchiException(final Throwable ex) {
        super(ex);
    }
}
