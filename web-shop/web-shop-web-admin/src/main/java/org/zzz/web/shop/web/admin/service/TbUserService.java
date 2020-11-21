package org.zzz.web.shop.web.admin.service;

import org.zzz.web.shop.domain.TbUser;
import org.zzz.web.shop.commons.dto.BaseResult;
import java.util.List;

public interface TbUserService {
    public List<TbUser> selectAll();

    //把 void insert(TbUser tbUser) 变为 save 方法;
    BaseResult save(TbUser tbUser);

    void delete(Long id);

    TbUser getById(Long id);

    void update(TbUser tbUser);

    List<TbUser> selectByUsername(String username);

    /**
     * 用户登录
     * @param email
     * @param password
     * @return
     */
    TbUser login(String email, String password);
}
