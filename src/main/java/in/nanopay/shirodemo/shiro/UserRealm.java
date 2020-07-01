package in.nanopay.shirodemo.shiro;

import in.nanopay.shirodemo.dao.NpAdSysuserMapper;
import in.nanopay.shirodemo.entity.NpAdSysuser;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ：wanglei
 * @create ：2020-02-27 11:34
 * @description：
 */
@Slf4j
public class UserRealm extends AuthorizingRealm {

	@Autowired
	private NpAdSysuserMapper sysuserMapper;

	/**
	 * 授权逻辑
	 *
	 * @param principalCollection
	 * @return
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		SimpleAuthorizationInfo authenticationInfo = new SimpleAuthorizationInfo();

		log.info("进入授权逻辑");
		Subject subject = SecurityUtils.getSubject();
//		NpAdSysuser sysuser = (NpAdSysuser) subject;
		authenticationInfo.addStringPermission("user:add");
		return authenticationInfo;
	}

	/**
	 * 认证逻辑
	 *
	 * @param authenticationToken
	 * @return
	 * @throws AuthenticationException
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		log.info("进入认证逻辑");
		UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
		NpAdSysuser sysuser = sysuserMapper.selectByLoginName(token.getUsername());
		if (null == sysuser) {
			return null;
		}
		return new SimpleAuthenticationInfo(sysuser, sysuser.getPassword(), "");
	}
}
