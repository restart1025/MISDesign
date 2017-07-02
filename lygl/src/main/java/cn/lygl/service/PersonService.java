package cn.lygl.service;

import java.util.List;

import cn.lygl.domain.Person;
import cn.lygl.domain.Resource;

public interface PersonService {
	
	/**
	 * 根据personId查找个人信息
	 * @param personId
	 */
	Person getByPersonId(String personId);
	
	/**
	 * 更新个人信息
	 * @param personId
	 */
	void update(Person person);
	
	/**
	 * 删除个人信息
	 * @param personId
	 */
	void delete(String personId);
	
	/**
	 * 新增信息
	 * @param personId
	 */
	void add(Person person);
	
	public List<Resource> getMenu(String personId,String parentResourceSn);
}
