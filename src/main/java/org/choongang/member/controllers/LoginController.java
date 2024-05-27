package org.choongang.member.controllers;

import org.choongang.global.AbstractController;
import org.choongang.global.constants.Menu;
import org.choongang.template.Templates;

/**
 * 로그인 컨트롤러
 */
public class LoginController extends AbstractController {
    @Override
    public void show() {
        Templates.getInstance().render(Menu.LOGIN);
    }
}
