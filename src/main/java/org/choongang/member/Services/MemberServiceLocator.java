package org.choongang.member.Services;

import org.choongang.global.AbstractServiceLocator;
import org.choongang.global.Service;
import org.choongang.global.ServiceLocator;
import org.choongang.global.constants.Menu;

public class MemberServiceLocator extends AbstractServiceLocator{
    public static ServiceLocator getInstance() {
        if (instance == null) {
            instance = new MemberServiceLocator();
        }

        return instance;
    }
    @Override
    public Service find(Menu menu) {
        Service service = services.get(menu);
        if(service!=null){
            return service;
        }
        switch(menu){
            case JOIN : service = new JoinService();break;
            case LOGIN: service = new LoginService();break;

        }
        return service;
    }
}
