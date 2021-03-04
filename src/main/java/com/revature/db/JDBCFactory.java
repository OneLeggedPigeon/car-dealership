package com.revature.db;

public class JDBCFactory {

    public static DAO daoFactory (Class c){
        switch (c.getName()){
            case "com.revature.model.User":
                return (DAO) UserJDBC.getInstance();
        }
        return null;
    }
}
