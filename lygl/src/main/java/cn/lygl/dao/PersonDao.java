package cn.lygl.dao;


import java.util.List;

import cn.lygl.common.dao.BaseDao;
import cn.lygl.domain.Person;
import cn.lygl.domain.Resource;
public interface PersonDao extends BaseDao<Person> {
	
	/**
	 * 根据personId查找个人信息
	 * @param personId
	 */
	Person getByPersonId(String personId);
	
	/**
	 * 删除个人信息
	 * @param personId
	 */
	void delete(String personId);

	List<Resource> getMenu(String personId, String parentResourceSn);
}
