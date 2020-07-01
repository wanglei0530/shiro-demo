package in.nanopay.shirodemo.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ：wanglei
 * @create ：2020-02-27 11:03
 * @description：
 */
@Controller
@RequestMapping("/demo/")
public class DemoController {

	@RequestMapping("hello")
	@ResponseBody
	public String hello(String param) {
		return param;
	}

	@RequestMapping("tologin")
	public String tologin(String un,String pwd, Model model) {
		//shiro认证
		try {
			Subject subject = SecurityUtils.getSubject();
			UsernamePasswordToken token = new UsernamePasswordToken(un,pwd);
			subject.login(token);
			//解决已登录用户切换至登录页重复登录而导致页面一直在登录页的问题
			if(!SecurityUtils.getSubject().isAuthenticated()) {
				return "/login";
			}
			return "user/main";
		} catch (UnknownAccountException e) {
			model.addAttribute("msg", "用户不存在");
		}catch (IncorrectCredentialsException e){
			model.addAttribute("msg", "密码错误");
		}
		return "/login";
	}

	@RequestMapping("login")
	public String login() {

		return "/login";
	}

	@RequestMapping("logout")
	public String logout() {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "/login";
	}

	@RequestMapping("unAuth")
	public String unAuth() {
		return "/unAuth";
	}

	@RequestMapping("anon/pub")
	public String pub(String userName, Model model) {
		model.addAttribute("param", userName);
		return "anon/pub";
	}

	@RequestMapping("user/main")
	public String main(String userName, Model model) {
		model.addAttribute("param", userName);
		return "user/main";
	}

	@RequestMapping("user/add")
	public String add(String param, Model model) {
		model.addAttribute("param", param);
		return "user/add";
	}

	@RequestMapping("user/mod")
	public String mod(String param, Model model) {
		model.addAttribute("param", param);
		return "user/mod";
	}

	@RequestMapping("user/query")
	public String query(String param, Model model) {
		model.addAttribute("param", param);
		return "user/query";
	}

	@RequestMapping("user/delete")
	public String delete(String param, Model model) {
		model.addAttribute("param", param);
		return "user/delete";
	}
}
