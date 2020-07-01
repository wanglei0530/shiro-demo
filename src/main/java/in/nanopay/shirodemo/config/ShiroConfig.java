package in.nanopay.shirodemo.config;

import in.nanopay.shirodemo.shiro.UserRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author ：wanglei
 * @create ：2020-02-27 11:22
 * @description：
 */
@Configuration
public class ShiroConfig {

	//创建ShiroFilterFactoryBean对象
	@Bean
	public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager) {
		ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
		shiroFilter.setSecurityManager(defaultWebSecurityManager);
		shiroFilter.setLoginUrl("/demo/login");
		shiroFilter.setUnauthorizedUrl("/demo/unAuth");
		Map<String, String> filterMap = new LinkedHashMap<>();
		filterMap.put("/demo/anon/pub", "anon");
		filterMap.put("/demo/login", "anon");

		filterMap.put("/demo/user/add", "perms[user:add]");

		filterMap.put("/demo/user/**", "authc");
		shiroFilter.setFilterChainDefinitionMap(filterMap);
		return shiroFilter;
	}


	//创建SecurityManager安全管理器
	@Bean(name = "defaultWebSecurityManager")
	public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(userRealm);
		return securityManager;
	}


	//创建Realm
	@Bean(name = "userRealm")
	public UserRealm getUserRealm() {
		return new UserRealm();
	}

}

