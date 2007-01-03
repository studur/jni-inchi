/* File: JniInchiStereo0D.java
 * Author: Sam Adams
 * 
 * Copyright (C) 2006 Sam Adams
 */
package net.sf.jniinchi;

/**
 * Encapsulates properites of InChI Stereo Parity.  See <tt>inchi_api.h</tt>.
 * @author Sam Adams
 */
public class JniInchiStereo0D {
    
	/**
	 * Indicates non-existent (central) atom. Value from inchi_api.h.
	 */
	public static final int NO_ATOM = -1;
	
	/**
	 * Neighbouring atoms.
	 */
    protected JniInchiAtom[] neighbors = new JniInchiAtom[4];
    
    /**
     * Central atom.
     */
    protected JniInchiAtom centralAtom;
    
    /**
     * Stereo parity type.
     */
    protected INCHI_STEREOTYPE type;
    
    /**
     * Parity.
     */
    protected INCHI_PARITY parity;
    
    /**
     * Second parity (for disconnected systems). 
     */
    protected INCHI_PARITY disconParity = INCHI_PARITY.NONE;
    
    /**
     * Constructor.  See <tt>inchi_api.h</tt> for details of usage.
     * 
     * @see createNewTetrahedralStereo0D()
     * @see createNewDoublebondStereo0D()
     * 
     * @param atC	Central atom
     * @param at0	Neighbour atom 0
     * @param at1	Neighbour atom 1
     * @param at2	Neighbour atom 2
     * @param at3	Neighbour atom 3
     * @param type	  	Stereo parity type
     * @param parity	Parity
     */
    public JniInchiStereo0D(JniInchiAtom atC, JniInchiAtom at0, 
            JniInchiAtom at1, JniInchiAtom at2, JniInchiAtom at3,
            INCHI_STEREOTYPE type, INCHI_PARITY parity) {
        
        centralAtom = atC;
        neighbors[0] = at0;
        neighbors[1] = at1;
        neighbors[2] = at2;
        neighbors[3] = at3;
        
        this.type = type;
        this.parity = parity;
    }
    
    /**
     * Set second parity (for disconnected systems)
     * @param parity
     */
    public void setDisconnectedParity(INCHI_PARITY parity) {
        this.disconParity = parity;
    }
    
    /**
     * Returns central atom of stereo parity.
     * @return
     */
    public JniInchiAtom getCentralAtom() {
    	return(centralAtom);
    }
    
    /**
     * Returns neighboring atoms of stereo parity.
     * @return
     */
    public JniInchiAtom[] getNeighbors() {
    	return(neighbors);
    }
    
    /**
     * Returns parity.
     * @return
     */
    public INCHI_PARITY getParity() {
    	return(parity);
    }
    
    /**
     * Returns type of stereochemistry.
     * @return
     */
    public INCHI_STEREOTYPE getStereoType() {
    	return(type);
    }
    
    /**
     * Generates string representation of information on stereo parity,
     * for debugging purposes.
     */
    public String getDebugString() {
        return("InChI Stereo0D: "
            + (centralAtom == null ? "-" : centralAtom.elname)
            + " [" + neighbors[0].elname + "," + neighbors[1].elname
            + "," + neighbors[2].elname + "," + neighbors[3].elname + "] "
            + "Type::" + type + " // "
            + "Parity:" + parity
            );
    }
    
    /**
     * Outputs information on stereo parity, for debugging purposes.
     */
    public void debug() {
    	System.out.println(getDebugString());
    }
    
    
    /**
     * <p>Convenience method for generating 0D stereo parities at tetrahedral
     * atom centres.
     * 
     * <p><b>Usage notes from <i>inchi_api.h</i>:</b>
     * <pre>
     *  4 neighbors
     *
     *  ==============================================
     *  Note. Correspondence to CML 0D stereo parities
     *  ==============================================
     *  a list of 4 atoms corresponds to CML atomRefs4
     *  
     *  tetrahedral atom
     *  ================
     *  CML atomParity > 0 <=> INCHI_PARITY_EVEN
     *  CML atomParity < 0 <=> INCHI_PARITY_ODD
     *  
     *                               | 1   1   1   1  |  where xW is x-coordinate of
     *                               | xW  xX  xY  xZ |  atom W, etc. (xyz is a
     *  CML atomParity = determinant | yW  yX  yY  yZ |  'right-handed' Cartesian
     *                               | zW  zX  xY  zZ |  coordinate system)
     * </pre>
     * 
     * @param atC	Central atom
     * @param at0	Neighbour atom 0
     * @param at1	Neighbour atom 1
     * @param at2	Neighbour atom 2
     * @param at3	Neighbour atom 3
     * @param parity Parity
     */
    public static JniInchiStereo0D createNewTetrahedralStereo0D(JniInchiAtom atC, JniInchiAtom at0, 
            JniInchiAtom at1, JniInchiAtom at2, JniInchiAtom at3,
            INCHI_PARITY parity) {
    	
    	JniInchiStereo0D stereo = new JniInchiStereo0D(atC, at0, at1, at2, at3, INCHI_STEREOTYPE.TETRAHEDRAL, parity);
    	return(stereo);
    }
    
    
    /**
     * <p>Convenience method for generating 0D stereo parities at stereogenic
     * double bonds.
     * 
     * <p><b>Usage notes from <i>inchi_api.h</i>:</b>
     * <pre>
     *  =============================================
     *  stereogenic bond >A=B< or cumulene >A=C=C=B<
     *  =============================================
     *
     *                              neighbor[4]  : {#X,#A,#B,#Y} in this order
     *  X                           central_atom : NO_ATOM
     *   \            X      Y      type         : INCHI_StereoType_DoubleBond
     *    A==B         \    /
     *        \         A==B
     *         Y
     *
     *  parity= 'e'    parity= 'o'   unknown parity = 'u'
     * 
     *  ==============================================
     *  Note. Correspondence to CML 0D stereo parities
     *  ==============================================
     *  
     *  stereogenic double bond and (not yet defined in CML) cumulenes
     *  ==============================================================
     *  CML 'C' (cis)      <=> INCHI_PARITY_ODD
     *  CML 'T' (trans)    <=> INCHI_PARITY_EVEN
     * </pre>
     * 
     * @param at0	Neighbour atom 0
     * @param at1	Neighbour atom 1
     * @param at2	Neighbour atom 2
     * @param at3	Neighbour atom 3
     * @param parity Parity
     * @return
     */
    public static JniInchiStereo0D createNewDoublebondStereo0D(JniInchiAtom at0, 
            JniInchiAtom at1, JniInchiAtom at2, JniInchiAtom at3,
            INCHI_PARITY parity) {
            
    	JniInchiStereo0D stereo = new JniInchiStereo0D(null, at0, at1, at2, at3, INCHI_STEREOTYPE.DOUBLEBOND, parity);
    	return(stereo);
    }
}