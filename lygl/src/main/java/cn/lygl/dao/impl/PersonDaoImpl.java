package cn.lygl.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import cn.lygl.common.dao.impl.BaseDaoHibernate5;
import cn.lygl.dao.PersonDao;
import cn.lygl.domain.Person;
import cn.lygl.domain.Resource;

@Repository("personDao")
public class PersonDaoImpl extends BaseDaoHibernate5<Person>
	implements PersonDao 
{

	@Override
	public Person getByPersonId(String personId) {
		Query query = getSessionFactory().getCurrentSession()
				.createQuery("select p from Person p where personId=:personId")
				.setString("personId", personId);
		return (Person)query.uniqueResult();
	}

	@Override
	public void delete(String personId) {
		getSessionFactory().getCurrentSession()
			.createQuery("update Person p set p.deleted=true where personId=:personId")
			.setString("personId", personId).uniqueResult();
	}

	@Override
	public List<Resource> getMenu(String personId, String parentResourceSn) {
		String sql;
		Query query;
		if(parentResourceSn==null){
			sql="select distinct resource.* from resource inner join role_resource on resource.resource_sn=role_resource.resource_sn inner join role on role_resource.role_sn=role.role_sn inner join person_role on role.role_sn=person_role.role_sn where resource.resource_type='menu' and parent_resource_sn is null and person_role.person_id=:person_id order by resource.show_sequence";
			query =getSessionFactory().getCurrentSession()
					.createSQLQuery(sql).addEntity(Resource.class).setString("person_id", personId);
		}else{
			sql="select distinct resource.* from resource inner join role_resource on resource.resource_sn=role_resource.resource_sn inner join role on role_resource.role_sn=role.role_sn inner join person_role on role.role_sn=person_role.role_sn where resource.resource_type='menu' and parent_resource_sn=:parent_resource_sn and person_role.person_id=:person_id  order by resource.show_sequence";
			query =getSessionFactory().getCurrentSession()
					.createSQLQuery(sql).addEntity(Resource.class).setString("parent_resource_sn", parentResourceSn).setString("person_id", personId);
		}
		return (List<Resource>)query.list();
	}
	
	

}


