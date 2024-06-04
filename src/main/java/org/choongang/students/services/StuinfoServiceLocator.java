package org.choongang.students.services;

import org.choongang.global.AbstractServiceLocator;
import org.choongang.global.Menu;
import org.choongang.global.Service;
import org.choongang.global.ServiceLocator;
import org.choongang.global.configs.DBConn;
import org.choongang.students.constants.StuInfoMenu;
import org.choongang.students.mapper.StuInfoMapper;

public class StuinfoServiceLocator extends AbstractServiceLocator {

    private static ServiceLocator instance;
    public static ServiceLocator getInstance(){
        if (instance == null){
            instance = new StuinfoServiceLocator();
        }
        return instance;
    }
    public StuInfoMapper stuinfoMapper(){
        return DBConn.getSession().getMapper(StuInfoMapper.class);
    }

    @Override
    public Service find(Menu menu) {
        Service service = services.get(menu);
        if(service!= null){
            return service;
        }
        if(menu instanceof StuInfoMenu) {
            StuInfoMenu stuInfoMenu = (StuInfoMenu) menu;

            switch (stuInfoMenu) {
                case CREATE:
                    service = new CreateStuinfoService(stuinfoMapper());
                    break;
                case READ:
                    service = new ReadStuinfoService(stuinfoMapper());
                    break;
                case UPDATE:
                    service = new UpdateStuinfoService(stuinfoMapper());
                    break;
                case DELETE:
                    service = new DeleteStuinfoService(stuinfoMapper());
                    break;
            }
        }
        services.put(menu,service);
        return service;
    }
}
