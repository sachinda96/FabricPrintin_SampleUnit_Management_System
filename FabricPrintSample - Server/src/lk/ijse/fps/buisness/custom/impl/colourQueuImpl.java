/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.buisness.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.fps.buisness.custom.ColourQueu;
import lk.ijse.fps.dto.ColourQueuDTO;

/**
 *
 * @author Sachinda Nipun
 */
public class colourQueuImpl implements ColourQueu{
    
    private static colourQueuImpl colourImpl;
    
    private ArrayList<ColourQueuDTO> colourQueu;

    private colourQueuImpl() {
        colourQueu=new ArrayList<>();
        
    }
    public static colourQueuImpl getInsatance(){
        if (colourImpl==null) {
            colourImpl=new colourQueuImpl();
        }
        return colourImpl;
    }
    

    @Override
    public boolean addColourseQueue(ColourQueuDTO colourQueu) throws Exception {
        return this.colourQueu.add(colourQueu);
    }

    @Override
    public boolean removeColourseQueue(ColourQueuDTO colourQueu) throws Exception {
        return this.colourQueu.remove(colourQueu);
    }

    @Override
    public ColourQueuDTO getColourse() throws Exception {
        ColourQueuDTO colour=colourQueu.get(0);
        colourQueu.remove(colour);
        return colour;
    }

    @Override
    public List<ColourQueuDTO> getColourseList() throws Exception {
        return colourQueu;
    }
    
}
