package org.xidian.lichen.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.xidian.lichen.backend.entity.Account;
import org.xidian.lichen.backend.service.AccountService;
import org.xidian.lichen.backend.util.AESUtil;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password) {
        Account result = accountService.getAccountByUsername(username);
        String encryptedPwd = "";

        try {
            encryptedPwd = AESUtil.encrypt(password);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

        if (result!= null && result.getPassword().equals(encryptedPwd)) {
            return "success";
        } else {
            return "fail";
        }
    }
}
