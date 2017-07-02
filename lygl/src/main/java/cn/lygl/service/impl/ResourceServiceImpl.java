package cn.lygl.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.lygl.dao.ResourceDao;
import cn.lygl.domain.Resource;
import cn.lygl.service.ResourceService;

@Service("resourceService")
public class ResourceServiceImpl implements ResourceService {
	@javax.annotation.Resource(name="resourceDao")
	private ResourceDao resourceDao;

	public void setResourceDao(ResourceDao resourceDao) {
		this.resourceDao = resourceDao;
	}
	
	@Override
	public int addResource(Resource resource) {
		return (Integer) resourceDao.save(resource);
	}

	@Override
	public List<Resource> getAllResources() {
		return resourceDao.findAll(Resource.class);
	}

	@Override
	public void deleteResource(int id) {
		resourceDao.delete(Resource.class, id);
	}

	@Override
	public Resource getByResourceSn(String resourceSn) {
		return resourceDao.getByResourceSn(resourceSn);
	}

	@Override
	public Resource getById(int id) {
		return resourceDao.get(Resource.class, id);
	}

	@Override
	public List<Resource> getMenuTypeChildren(String resourceSn) {
		return resourceDao.getMenuTypeChildren(resourceSn);
	}

	@Override
	public List<Resource> getResourceByParentSn(String resourceSn) {
		return resourceDao.getResourceByParentSn(resourceSn);
	}

	@Override
	public List<Resource> getByHql(String hql) {
		return resourceDao.findByPage(hql, 1, 10000);
	}

	@Override
	public List<Resource> getAllMenuResources() {
		return resourceDao.getAllMenuResources();
	}
}
