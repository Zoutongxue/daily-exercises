package org.zzz.web.shop.web.admin.service.impl;

import org.zzz.web.shop.commons.utils.RegexpUtils;
import org.zzz.web.shop.domain.TbUser;
import org.zzz.web.shop.commons.dto.*;
import org.zzz.web.shop.web.admin.dao.TbUserDao;
import org.zzz.web.shop.web.admin.service.TbUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

@Service  // 对 Service 类 实现注解
public class TbUserServiceImpl implements TbUserService {
    @Autowired
    private TbUserDao tbUserDao;

    @Override
    public List<TbUser> selectAll() {
        return tbUserDao.selectAll();
    }

    //这个位置也要改成 save 方法的实现
    //结果直接返回上一层就行了，所以是 BaseResult类 的方法
    @Override
    public BaseResult save(TbUser tbUser) {
        BaseResult baseResult = checkTbUser(tbUser);

        //通过验证
        if (baseResult.getStatus() == BaseResult.STATUS_SUCCESS) {
            tbUser.setUpdate(new Date());

            //新增用户
            if (tbUser.getId() == null) {
                //密码需要加密处理
                tbUser.setPassword(DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes()));
                tbUser.setCreated(new Date());
                tbUserDao.insert(tbUser);
            }

            //编辑用户
            else {
                tbUserDao.update(tbUser);
            }

            // 成功了以后 传一个消息
            baseResult.setMessage("保存用户信息成功");
        }

        return baseResult;
    }



    @Override
    public void delete(Long id) {
        tbUserDao.delete(id);
    }

    @Override
    public TbUser getById(Long id) {
        return tbUserDao.getById(id);
    }

    @Override
    public void update(TbUser tbUser) {
        tbUserDao.update(tbUser);
    }

    @Override
    public List<TbUser> selectByUsername(String username) {
        return tbUserDao.selectByUsername(username);
    }

    @Override
    public TbUser login(String email, String password) {
        TbUser tbUser = tbUserDao.getByEmail(email); //把 email 传进来
        if (tbUser != null){
            //明文密码加密
            String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());

            //判断加密后的密码和数据库中的密码是否一致，若一致则允许登录
            if (md5Password.equals(tbUser.getPassword())){
                return tbUser;
            }
        }
        return null;
    }

    /**
     * 用户信息的有效性验证
     * 这个是后台的验证！必须要写！否则只有前端的验证人家就可以随意在前端传数据进去！
     */
    private BaseResult checkTbUser(TbUser tbUser) {
        //默认是 OK 的
        BaseResult baseResult = BaseResult.success();

        //非空验证
        if (StringUtils.isBlank(tbUser.getEmail())) {
            // 为空，那就报个错
            baseResult = BaseResult.fail("邮箱不能为空，请重新输入");
        }

        else if (!RegexpUtils.checkEmail(tbUser.getEmail())) {
            baseResult = BaseResult.fail("邮箱格式不正确，请重新输入");
        }

        else if (StringUtils.isBlank(tbUser.getPassword())) {
            baseResult = BaseResult.fail("密码不能为空，请重新输入");
        }



        else if (StringUtils.isBlank(tbUser.getUsername())) {
            baseResult = BaseResult.fail("姓名不能为空，请重新输入");
        }

        else if (StringUtils.isBlank(tbUser.getPhone())) {
            baseResult = BaseResult.fail("手机号不能为空，请重新输入");
        }

        else if (!RegexpUtils.checkPhone(tbUser.getPhone())) {
            baseResult = BaseResult.fail("手机号格式不正确，请重新输入");
        }

        return baseResult;
    }
}