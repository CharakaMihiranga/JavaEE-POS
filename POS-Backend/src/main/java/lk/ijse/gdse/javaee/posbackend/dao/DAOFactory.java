package lk.ijse.gdse.javaee.posbackend.dao;

import lk.ijse.gdse.javaee.posbackend.bo.SuperBO;
import lk.ijse.gdse.javaee.posbackend.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.gdse.javaee.posbackend.dao.custom.impl.ItemDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;
    public static DAOFactory getDaoFactory(){
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }
    public enum DAOTypes{
        CUSTOMER,ITEM
    }
    public SuperDAO getDAO(DAOTypes daoTypes){
        switch (daoTypes){
            case CUSTOMER:
                return new CustomerDAOImpl();
            case ITEM:
                return new ItemDAOImpl();
            default:
                return null;
        }
    }
}
