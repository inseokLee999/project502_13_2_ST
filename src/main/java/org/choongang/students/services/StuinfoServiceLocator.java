package org.choongang.students.services;

import org.apache.ibatis.annotations.Mapper;
import org.choongang.global.AbstractServiceLocator;
import org.choongang.global.Menu;
import org.choongang.global.Service;
import org.choongang.global.ServiceLocator;
import org.choongang.global.configs.DBConn;
import org.choongang.students.mapper.StuInfoMapper;
import org.choongang.subject.constants.SubjMenu;
import org.choongang.subject.mapper.SubjectMapper;
import org.choongang.subject.services.*;

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
        if(menu instanceof SubjMenu) {
            SubjMenu subjMenu = (SubjMenu) menu;

            switch (subjMenu) {
                case CREATE:
                    service = new CreateStuinfoService(stuinfoMapper());
                    break;
                case READ:
                    service = new ReadStuinfoService(stuinfoMapper());
                    break;
                case UPDATE:
                    service = new CreateStuinfoService(stuinfoMapper());
                    break;
                case DELETE:
                    service = new CreateStuinfoService(stuinfoMapper());
                    break;
            }
        }
        services.put(menu,service);
        return service;
    }
}
