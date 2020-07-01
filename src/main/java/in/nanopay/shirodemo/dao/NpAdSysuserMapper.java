package in.nanopay.shirodemo.dao;

import in.nanopay.shirodemo.entity.NpAdSysuser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author ：wanglei
 * @create ：2020-02-27 17:25
 * @description：
 */
@Repository
public interface NpAdSysuserMapper {

	/**
	 * [新增]
	 * @author 大狼狗
	 * @date 2020/02/27
	 **/
	int insert(NpAdSysuser npAdSysuser);

	/**
	 * [刪除]
	 * @author 大狼狗
	 * @date 2020/02/27
	 **/
	int delete(int id);

	/**
	 * [更新]
	 * @author 大狼狗
	 * @date 2020/02/27
	 **/
	int update(NpAdSysuser npAdSysuser);

	/**
	 * [查询] 根据主键 id 查询
	 * @author 大狼狗
	 * @date 2020/02/27
	 **/
	NpAdSysuser load(int id);


	NpAdSysuser selectByLoginName(@Param("loginName") String loginName);
}