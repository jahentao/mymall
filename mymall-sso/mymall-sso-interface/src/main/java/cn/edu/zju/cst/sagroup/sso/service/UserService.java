package cn.edu.zju.cst.sagroup.sso.service;

import cn.edu.zju.cst.sagroup.common.pojo.E3Result;
import cn.edu.zju.cst.sagroup.pojo.TbUser;

public interface UserService {
    E3Result checkData(String param, Integer type);
    E3Result register(TbUser tbUser);
    E3Result login(String username, String password);
    E3Result getUserByToken(String token);
}
