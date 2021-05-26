package com.github.webdb.core.auth;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Set;

/**
 * 获取登陆用户的详细信息
 *
 * @author 欧阳洁
 */
@Service
public class AppUserDetailsService implements UserDetailsService {
    /**
     * 验证码是否启用,默认启用
     */
    @Value("${web.verify-code.enabled:true}")
    private Boolean captchaEnabled;
    /**
     * 服务
     */
    @Resource
    private IUserSecurityService userSecurityService;

    /**
     * request
     */
    @Resource
    protected HttpServletRequest request;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (StringUtils.isEmpty(username)) {
            username = (String) request.getSession().getAttribute("username");
        }
        if (StringUtils.isEmpty(username)) {
            throw new UsernameNotFoundException("用户名为空");
        }
        if (this.captchaEnabled) {
            String code = request.getParameter("verifyCode");
            if (StringUtils.isEmpty(code)) {
                throw new UsernameNotFoundException("验证码不能为空");
            }
            String verifyCode = (String) request.getSession().getAttribute("verifyCode");
            if (verifyCode == null) {
                throw new UsernameNotFoundException("验证码已失效");
            }
            if (!code.equalsIgnoreCase(verifyCode)) {
                throw new UsernameNotFoundException("验证码错误");
            }
        }
        AppUserDetail info = null;
        try {
            String password = request.getParameter("password");
            info = userSecurityService.getUserInfo(username, password);
        } catch (Exception e) {
            throw new UsernameNotFoundException("用户名或密码错误");
        }
        if (null == info) {
            throw new UsernameNotFoundException("用户名或密码错误");
        }
        Set<GrantedAuthority> authorities = userSecurityService.authorities(username);
        User user = new User(username, info.getPassword(),
                // 是否可用
                true,
                // 是否过期
                true,
                // 证书不过期为true
                true,
                // 账户未锁定为true
                true,
                authorities);
        return user;
    }
}
