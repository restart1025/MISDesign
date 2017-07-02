package cn.lygl.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.lygl.dao.PersonDao;
import cn.lygl.domain.Person;
import cn.lygl.domain.Resource;
import cn.lygl.service.PersonService;

@Service("personService")
public class PersonServiceImpl implements PersonService {
	@javax.annotation.Resource(name="personDao")	
	private PersonDao personDao;

	@Override
	public Person getByPersonId(String personId) {
		return personDao.getByPersonId(personId);
	}

	@Override
	public void update(Person person) {
		personDao.update(person);
	}

	@Override
	public void delete(String personId) {
		personDao.delete(personId);
	}

	@Override
	public void add(Person person) {
		personDao.save(person);
	}

	@Override
	public List<Resource> getMenu(String personId, String parentResourceSn) {
		// TODO Auto-generated method stub
		return personDao.getMenu(personId, parentResourceSn);
	}
	
	
}
