package org.xidian.lichen.backend.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.xidian.lichen.backend.entity.Account;

@Mapper
@Repository
public interface AccountDao {
    Account getAccountByUsername(@Param("username") String username);
}
