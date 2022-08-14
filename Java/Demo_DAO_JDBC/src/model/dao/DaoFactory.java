package model.dao;

import model.dao.impl.SellerDaoJDBC;

public class DaoFactory {

    //Macete para expor somente a interface e não a implementação
    public static SellerDao createSellerDao() {
        return new SellerDaoJDBC();
    }
}
