/*
 * Copyright 2006-2010 Sam Adams <sea36 at users.sourceforge.net>
 *
 * This file is part of JNI-InChI.
 *
 * JNI-InChI is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JNI-InChI is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with JNI-InChI.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.sf.jniinchi;

import org.junit.Assert;
import org.junit.Test;

public class TestJniInchiInputInchi {

    /*
     * Test method for 'net.sf.jniinchi.JniInchiInputInchi.getOptions()'
     */
    @Test
    public void testGetOptions() {
        JniInchiInputInchi input = new JniInchiInputInchi("InChI=1/C6H6/c1-2-4-6-5-3-1/h1-6H");
        input.options = "-compress";
        Assert.assertEquals("-compress", input.getOptions());
    }

    /*
     * Test method for 'net.sf.jniinchi.JniInchiInputInchi.getInchi()'
     */
    @Test
    public void testGetInchi() {
        JniInchiInputInchi input = new JniInchiInputInchi("InChI=1/C6H6/c1-2-4-6-5-3-1/h1-6H");
        Assert.assertEquals("InChI=1/C6H6/c1-2-4-6-5-3-1/h1-6H", input.getInchi());
    }
}
