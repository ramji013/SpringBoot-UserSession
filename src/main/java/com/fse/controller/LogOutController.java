package com.fse.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class LogOutController {

    @GetMapping("/logout")
    public String logout() {
        return "logout";
    }
}
