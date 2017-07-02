package cn.lygl.service;

import java.util.List;

import cn.lygl.domain.Resource;


public interface ResourceService {

	int addResource(Resource resource);
	
	List<Resource> getAllResources();
	
	void deleteResource(int id);
	
	Resource getByResourceSn(String resourceSn);
	
	Resource getById(int id);
	
	/**
	 * 获取资源类型为menu的子项
	 * @param resourceSn
	 * @return
	 */
	List<Resource> getMenuTypeChildren(String resourceSn);
	/**
	 * 根据父级权限获取子类权限
	 * @param resourceSn
	 * @return
	 */
	List<Resource> getResourceByParentSn(String id);

	List<Resource> getByHql(String hql);
	/**
	 * 获取所有的菜单资源项
	 * @return
	 */
	public List<Resource> getAllMenuResources();
	 
}
