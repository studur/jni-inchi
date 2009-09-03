/**
 * Copyright (C) 2006-2009 Sam Adams <sam.adams@cantab.net>
 *
 * This file is part of JNI-InChI.
 *
 * JNI-InChI is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * JNI-InChI is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with JNI-InChI. If not, see <http://www.gnu.org/licenses/>.
 */
package net.sf.jniinchi;


/**
 * <p>Type-safe enumeration of InChIKey check return codes.
 *
 * <p>InChI library return values:<br>
 * <tt>
 * VALID			(0)
 * INVALID_LENGTH 	(1)
 * INVALID_LAYOUT 	(2)
 * INVALID_CHECKSUM	(3)
 * </tt>
 * <p>See <tt>inchi_api.h</tt>.
 * @author Sam Adams
 */
public enum INCHI_KEY_STATUS {

    VALID("VALID", 0),

    INVALID_LENGTH("INVALID_LENGTH", 1),

    INVALID_LAYOUT("INVALID_LAYOUT", 2),

    INVALID_CHECKSUM("INVALID_CHECKSUM", 3);


    /**
     * Name.
     */
    private final String name;

    /**
     * Internal InChI index (from inchi_api.h).
     */
    private final int indx;

    /**
     * Constructor.
     */
    private INCHI_KEY_STATUS(final String name, final int indx) {
        this.name = name;
        this.indx = indx;
    }

    public int getIndx() {
        return indx;
    }

    public String toString() {
        return name;
    }

    public static INCHI_KEY_STATUS getValue(int value) {
        INCHI_KEY_STATUS keyStatus;
        switch (value) {
            case 0: keyStatus = INCHI_KEY_STATUS.VALID; break;
            case 1: keyStatus = INCHI_KEY_STATUS.INVALID_LENGTH; break;
            case 2: keyStatus = INCHI_KEY_STATUS.INVALID_LAYOUT; break;
            case 3: keyStatus = INCHI_KEY_STATUS.INVALID_CHECKSUM; break;
            default:
                keyStatus = null;
        }
        return keyStatus;
    }

}
