package org.xidian.lichen.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xidian.lichen.backend.dao.AccountDao;
import org.xidian.lichen.backend.entity.Account;
import org.xidian.lichen.backend.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    @Override
    public Account getAccountByUsername(String username) {
        return accountDao.getAccountByUsername(username);
    }
}
