package org.zzz.web.shop.web.admin.dao;

import org.zzz.web.shop.domain.TbUser;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository //用于对 DAO 实现类进行注解
public interface TbUserDao {

    /**
     * 查询全部用户信息
     * @return
     */
    public List<TbUser> selectAll();

    /**
     * 插入
     * @param tbUser
     */
    void insert (TbUser tbUser);

    /**
     * 删除
     * @param id
     */
    void delete (Long id);

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    TbUser getById(Long id);

    /**
     * 更新
     * @param tbUser
     */
    void update (TbUser tbUser);

    /**
     * 根据用户名进行模拟匹配
     * @param username
     * @return
     */
    List<TbUser> selectByUsername(String username);

    /**
     * 根据邮箱查询用户信息
     * @param email
     * @return
     */
    TbUser getByEmail(String email);
}
