/*
 *  JNI InChI Wrapper - A Java Native Interface Wrapper for InChI.
 *  Copyright 2006, 2007, 2008 Sam Adams <sea36 at users.sourceforge.net>
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
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301 USA
 * or see <http://www.gnu.org/licenses/>.
 */
package net.sf.jniinchi;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sam Adams
 */
public class JniInchiStructure {

    /**
     * List of atoms.
     */
    private List atomList = new ArrayList();

    /**
     * List of bonds.
     */
    private List bondList = new ArrayList();

    /**
     * List of stero parities.
     */
    private List stereoList = new ArrayList();


    /**
     * Returns number of atoms in structure.
     */
    public int getNumAtoms() {
        return atomList.size();
    }

    /**
     * Returns number of bonds in structure.
     */
    public int getNumBonds() {
        return bondList.size();
    }

    /**
     * Returns number of stereo parities in strucuture.
     */
    public int getNumStereo0D() {
        return stereoList.size();
    }


    /**
     * Adds atom to inchi molecule.
     *
     * @param atom  Atom to add
     * @return      Added atom
     */
    @SuppressWarnings("unchecked")
	public JniInchiAtom addAtom(JniInchiAtom atom) {
        atomList.add(atom);
        return atom;
    }

    /**
     * Adds bond to inchi molecule.
     *
     * @param bond  Bond to add
     * @return      Added bond
     */
    @SuppressWarnings("unchecked")
	public JniInchiBond addBond(JniInchiBond bond) {
        bondList.add(bond);
        return bond;
    }

    /**
     * Adds 0D stereo parity to inchi molecule.
     *
     * @param parity  Parity to add
     * @return        Added parity
     */
    @SuppressWarnings("unchecked")
	public JniInchiStereo0D addStereo0D(JniInchiStereo0D parity) {
        stereoList.add(parity);
        return parity;
    }


    /**
     * Returns atom from structure.
     * @param i    Index of atom to return.
     * @return
     */
    public JniInchiAtom getAtom(final int i) {
        return (JniInchiAtom) atomList.get(i);
    }

    /**
     * Returns bond from structure.
     * @param i    Index of bond to return.
     * @return
     */
    public JniInchiBond getBond(final int i) {
        return (JniInchiBond) bondList.get(i);
    }

    /**
     * Returns stereo parity from structure.
     * @param i    Index of stereo parity to return.
     * @return
     */
    public JniInchiStereo0D getStereo0D(final int i) {
        return (JniInchiStereo0D) stereoList.get(i);
    }

    public void setStructure(JniInchiStructure structure) {
        this.atomList = structure.atomList;
        this.bondList = structure.bondList;
        this.stereoList = structure.stereoList;
    }
    
    int getAtomIndex(JniInchiAtom atom) {
    	return atomList.indexOf(atom);
    }
    
    int getStereo0DIndex(JniInchiStereo0D stereo) {
    	return stereoList.indexOf(stereo);
    }
}
