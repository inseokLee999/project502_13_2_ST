package org.choongang.member.services;

import org.choongang.global.AbstractServiceLocator;
import org.choongang.global.Menu;
import org.choongang.global.Service;
import org.choongang.global.ServiceLocator;
import org.choongang.global.configs.DBConn;
import org.choongang.global.constants.MainMenu;
import org.choongang.member.mapper.MemberMapper;
import org.choongang.member.validators.JoinValidator;
import org.choongang.member.validators.LoginValidator;

public class MemberServiceLocator extends AbstractServiceLocator{
    private static ServiceLocator instance;
    private MemberServiceLocator() {}

    public static ServiceLocator getInstance() {
        if (instance == null) {
            instance = new MemberServiceLocator();
        }

        return instance;
    }

    public MemberMapper memberMapper() {
        return DBConn.getSession().getMapper(MemberMapper.class);
    }

    public JoinValidator joinValidator() {
        return new JoinValidator();
    }

    public LoginValidator loginValidator() {
        return new LoginValidator(memberMapper());
    }

    @Override
    public Service find(Menu menu) {
        Service service = services.get(menu);
        if(service!=null){
            return service;
        }

        MainMenu mainMenu = (MainMenu)menu;


        switch(mainMenu){
            case JOIN: service = new JoinService(memberMapper(), joinValidator()); break;
            case LOGIN: service = new LoginService(memberMapper(), loginValidator()); break;

        }
        return service;
    }
}
