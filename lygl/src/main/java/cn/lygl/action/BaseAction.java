package cn.lygl.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.lygl.service.PersonService;
import cn.lygl.service.ResourceService;

public class BaseAction<T> extends ActionSupport implements RequestAware,
SessionAware, ApplicationAware, ModelDriven<T> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7843693690537959794L;
	//可以传送多个id给该字段 形式以逗号隔开
	protected String ids;
	//泛型实体备用
	protected T entity;
	//获取泛型List集合，交给struts以json格式返回
	protected List<T> jsonList=null;
	//page用于接收客户端传递的页码
	protected Integer page;
	//rows用于接收客户端传递的每页行数
	protected Integer rows;
	
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}	
	public void setPage(Integer page) {
		this.page = page;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	public List<T> getJsonList() {
		return jsonList;
	}
	public void setJsonList(List<T> jsonList) {
		this.jsonList = jsonList;
	}
	
	//注入service
	@Resource(name="personService")
	protected PersonService personService;
	@Resource(name="resourceService")
	protected ResourceService resourceService;
	
	public BaseAction() {
/*	ParameterizedType type = (ParameterizedType) this.getClass()
				.getGenericSuperclass();
		@SuppressWarnings("rawtypes")
		Class clazz = (Class) type.getActualTypeArguments()[0];
		try {
			entity = (T) clazz.
		} catch (Exception e) {
			throw new RuntimeException(e);
		}*/
	}
	@Override
	//返回实体压栈
	public T getModel() {
		// TODO Auto-generated method stub
		return entity;
	}
	//用于封装请求request
	protected Map<String, Object> request;
	//用于封装会话session
	protected Map<String, Object> session;
	//用于封装application
	protected Map<String, Object> application;	

	@Override
	public void setApplication(Map<String, Object> application) {
		this.application=application;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}
	@Override
	public void setRequest(Map<String, Object> request) {
		this.request=request;
	}
}
