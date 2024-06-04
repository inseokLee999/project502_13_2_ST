package org.choongang.subject.services;

import org.choongang.global.AbstractServiceLocator;
import org.choongang.global.Menu;
import org.choongang.global.Service;
import org.choongang.global.ServiceLocator;
import org.choongang.global.configs.DBConn;
import org.choongang.subject.constants.SubjMenu;
import org.choongang.subject.mapper.SubjectMapper;

public class SubjectServiceLocator extends AbstractServiceLocator {
    private static ServiceLocator instance;
    public static ServiceLocator getInstance(){
        if (instance == null){
            instance = new SubjectServiceLocator();
        }
        return instance;
    }
    public SubjectMapper subjectMapper(){
        return DBConn.getSession().getMapper(SubjectMapper.class);
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
                    service = new CreateSubjectService(subjectMapper());
                    break;
                case READ:
                    service = new ReadSubjectService(subjectMapper());
                    break;
                case UPDATE:
                    service = new UpdateSubjectService(subjectMapper());
                    break;
                case DELETE:
                    service = new DeleteSubjectService(subjectMapper());
                    break;
            }
        }
        services.put(menu,service);
        return service;
    }
}
