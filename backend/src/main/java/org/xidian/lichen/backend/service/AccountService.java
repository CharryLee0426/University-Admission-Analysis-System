package org.xidian.lichen.backend.service;

import org.xidian.lichen.backend.entity.Account;

public interface AccountService {
    Account getAccountByUsername(String username);
}
