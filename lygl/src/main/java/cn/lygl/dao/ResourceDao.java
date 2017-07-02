package cn.lygl.dao;

import java.util.List;

import cn.lygl.common.dao.BaseDao;
import cn.lygl.domain.Resource;


public interface ResourceDao extends BaseDao<Resource> {

	Resource getByResourceSn(String resourceSn);
	/**
	 * 获取资源类型为menu的子项
	 * @param resourceSn
	 */
	List<Resource> getMenuTypeChildren(String resourceSn);
	/**
	 * 根据父级权限获取子类权限
	 * @param resourceSn
	 */
	List<Resource> getResourceByParentSn(String resourceSn);
	/**
	 * 获取所有的菜单资源项
	 */
	List<Resource> getAllMenuResources();
}
