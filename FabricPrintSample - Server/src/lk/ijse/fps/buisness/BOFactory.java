/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.buisness;

import lk.ijse.fps.buisness.custom.impl.BDUOrderQueu;
import lk.ijse.fps.buisness.custom.impl.ColorBOImpl;
import lk.ijse.fps.buisness.custom.impl.CustomerBOImpl;
import lk.ijse.fps.buisness.custom.impl.DesignBOImp;
import lk.ijse.fps.buisness.custom.impl.FabricBoImpl;
import lk.ijse.fps.buisness.custom.impl.FabricCttingImpl;
import lk.ijse.fps.buisness.custom.impl.FabricQueuImpl;
import lk.ijse.fps.buisness.custom.impl.ItemBOImpl;
import lk.ijse.fps.buisness.custom.impl.JasperBoImpl;
import lk.ijse.fps.buisness.custom.impl.LoginBoImpl;
import lk.ijse.fps.buisness.custom.impl.OrdersBOImpl;
import lk.ijse.fps.buisness.custom.impl.SuperVisorQueuImpl;
import lk.ijse.fps.buisness.custom.impl.colourQueuImpl;

/**
 *
 * @author Sachinda Nipun
 */
public class BOFactory {

    public enum BOTypes {
        CUSTOMER, ITEM, ORDERQUEU, FABRICQUEU, COLORFACRORY, COLORS, SUPERVISORQUEU, ORDERS, FABRIC, DESIGN, FABRICCUTTING, LOGIN,REPORTS
        
    }

    private static BOFactory boFactory;

    private BOFactory() {

    }

    public static BOFactory getInstance() {
        if (boFactory == null) {
            boFactory = new BOFactory();
        }
        return boFactory;
    }

    public SuperBO getBO(BOTypes type) {
        switch (type) {
            case CUSTOMER:
                return new CustomerBOImpl();
            case ITEM:
                return new ItemBOImpl();
            case ORDERQUEU:
                return BDUOrderQueu.getInstance();
            case FABRICQUEU:
                return FabricQueuImpl.getInstance();
            case COLORFACRORY:
                return colourQueuImpl.getInsatance();
            case COLORS:
                return new ColorBOImpl();
            case SUPERVISORQUEU:
                return SuperVisorQueuImpl.geyInsatnce();
            case ORDERS:
                return new OrdersBOImpl();
            case FABRIC:
                return new FabricBoImpl();
            case DESIGN:
                return new DesignBOImp();
            case FABRICCUTTING:
                return new FabricCttingImpl();
            case LOGIN:
                return new LoginBoImpl();
                case REPORTS:
                    return new JasperBoImpl();
            default:
                return null;
        }
    }
}
