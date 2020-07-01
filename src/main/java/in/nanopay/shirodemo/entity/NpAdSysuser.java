package in.nanopay.shirodemo.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ：wanglei
 * @create ：2020-02-27 17:24
 * @description：
 */
@Data
public class NpAdSysuser implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	private Long id;

	/**
	 * 登陆名
	 */
	private String loginName;

	/**
	 * 手机号
	 */
	private String phone;

	/**
	 * 姓名
	 */
	private String name;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 状态：0、停用；1、启用
	 */
	private Integer status;

	/**
	 * 是否第一次登录: 0未登录 1已登录
	 */
	private Integer firstLogin;

	/**
	 * 客户端秘钥，创建用户时生成
	 */
	private String userSecret;

	/**
	 * salt
	 */
	private String salt;

	/**
	 * createtime
	 */
	private Date createtime;

	/**
	 * updatetime
	 */
	private Date updatetime;

	public NpAdSysuser() {
	}

}