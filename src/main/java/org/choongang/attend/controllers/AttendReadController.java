package org.choongang.attend.controllers;

import org.choongang.AfterLoginMenu.constants.SubMenu;
import org.choongang.global.AbstractController;
import org.choongang.template.Templates;

public class AttendReadController extends AbstractController {
    @Override
    public void show() {

        Templates.getInstance().render(SubMenu.ATTENDMANAGER);
    }
    @Override
    public void prompt(){

    }
}
