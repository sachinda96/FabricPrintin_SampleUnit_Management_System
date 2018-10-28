/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.buisness.custom.impl;


import java.util.ArrayList;
import java.util.List;
import lk.ijse.fps.buisness.custom.SupervisorQueu;
import lk.ijse.fps.dto.SupervisorQueuDTO;

/**
 *
 * @author Sachinda Nipun
 */
public class SuperVisorQueuImpl implements SupervisorQueu{
    private static SuperVisorQueuImpl superVisorQueuImpl;
    private ArrayList<SupervisorQueuDTO> supervisorQueu;

    private SuperVisorQueuImpl() {
        supervisorQueu=new ArrayList<>();
    }
    public static SuperVisorQueuImpl geyInsatnce(){
        if (superVisorQueuImpl==null) {
            superVisorQueuImpl=new SuperVisorQueuImpl();
        }
        return superVisorQueuImpl;
    }
    

    @Override
    public boolean addOrdersQueue(SupervisorQueuDTO supervisorQueuDTO) throws Exception {
        return this.supervisorQueu.add(supervisorQueuDTO);
    }

    @Override
    public boolean removeOrdersQueue(SupervisorQueuDTO supervisorQueuDTO) throws Exception {
        return this.supervisorQueu.remove(supervisorQueuDTO);
    }
    @Override
    public SupervisorQueuDTO getOrder() throws Exception {
        SupervisorQueuDTO supervisorQueuDTO=supervisorQueu.get(0);
        supervisorQueu.remove(supervisorQueuDTO);
        return supervisorQueuDTO;
    }

    @Override
    public List<SupervisorQueuDTO> getOrdrList() throws Exception {
        return  supervisorQueu;
    }
    
}
