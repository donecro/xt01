package com.xt01.dto;

import com.ctc.wstx.dtd.TokenModel;

public interface TokenManager {
    /**
     * 创建一个token关联上指定管理员
     * @param id 指定管理员的id
     * @return 生成的token
     */
    public TokenModel createToken(int id);
    /**
     * 检查token是否有效
     * @param model token
     * @return 是否有效
     */
    public boolean checkToken(TokenModel model);
    /**
     * 从字符串中解析token
     * @param authentication 加密后的字符串
     * @return
     */
    public TokenModel getToken(String authentication);
    /**
     * 清除token
     * @param id 登录管理员的id
     */
    public void deleteToken(int id);
}
