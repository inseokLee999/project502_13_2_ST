package org.choongang.attend.service;

import org.choongang.attend.constants.AttendMenu;
import org.choongang.attend.mapper.AttendMapper;
import org.choongang.global.AbstractServiceLocator;
import org.choongang.global.Menu;
import org.choongang.global.Service;
import org.choongang.global.ServiceLocator;
import org.choongang.global.configs.DBConn;
import org.choongang.subject.constants.SubjMenu;
import org.choongang.subject.mapper.SubjectMapper;
import org.choongang.subject.services.*;

public class AttendServiceLocator extends AbstractServiceLocator {
    private static ServiceLocator instance;
    public static ServiceLocator getInstance(){
        if (instance == null){
            instance = new AttendServiceLocator();
        }
        return instance;
    }
    public AttendMapper attendMapper(){
        return DBConn.getSession().getMapper(AttendMapper.class);
    }

    @Override
    public Service find(Menu menu) {
        Service service = services.get(menu);
        if(service!= null){
            return service;
        }
        if(menu instanceof AttendMenu) {
            AttendMenu attendMenu = (AttendMenu) menu;

            switch (attendMenu) {
                case CREATE:
                    service = new AttendCreateService(attendMapper());
                    break;
                case READ:
                    service = new AttendReadService(attendMapper());
                    break;
                case UPDATE:
                    service = new AttendUpdateService(attendMapper());
                    break;
                case DELETE:
                    service = new AttendDeleteService(attendMapper());
                    break;
            }
        }
        services.put(menu,service);
        return service;
    }
}
