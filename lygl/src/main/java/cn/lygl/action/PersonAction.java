package cn.lygl.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import cn.lygl.domain.Education;
import cn.lygl.domain.Gender;
import cn.lygl.domain.Person;
import cn.lygl.domain.Resource;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class PersonAction extends BaseAction<Person> {
	private static final long serialVersionUID = 1L;
	private int id;
	private String personId;//人员编号
	private String personName;//人员姓名
	private String password;//密码
	private String idNumber;//身份证号
	private String cellphoneNumber;
	private java.sql.Date birthday;//出生日期
	private Education education;//学历
	private Gender gender;//性别
	private long total;//总数
	private Integer rows;//行
	private Integer page;//页
	private Boolean rememberPwd;//是否记住密码
	private String loginIp;//登录Ip
	private  String pag;//参数
	
	/**
	 * 用户登录验证֤
	 * @return
	 * @throws IOException
	 */
  	public String login() throws IOException {
		Person person = personService.getByPersonId(personId);
		if(person == null){
			pag = LOGIN;
		}else if(password.equals(person.getPassword())){
			pag = SUCCESS;
			session.put("person", person);
		}else{
			pag = ERROR;
		}
		return SUCCESS;
	}
	//输出指定字段
	public PrintWriter out()throws IOException{
		HttpServletResponse response=ServletActionContext.getResponse();  
        response.setContentType("text/html");  
        response.setContentType("text/plain; charset=utf-8");
        PrintWriter out= response.getWriter();
        return out;
	}
	

  	public String getMenu() throws IOException {
  		Person person = (Person) session.get("person");
		String personId = person.getPersonId();
		List<Resource> resources=new ArrayList<Resource>();
		
		Resource parentResource=resourceService.getById(id);
		if(parentResource!=null){
			resources=personService.getMenu(personId,parentResource.getResourceSn());			
		}else{
			resources=personService.getMenu(personId, null);
		}
		//
		HttpServletResponse response=ServletActionContext.getResponse();  
        response.setContentType("text/html");  
        response.setContentType("text/plain; charset=utf-8");
        PrintWriter out;
        out = response.getWriter();
		JSONArray tree=new JSONArray();
		for(Resource resource:resources){
			JSONObject jo=new JSONObject();
			jo.put("id",resource.getId());
			jo.put("text",resource.getResourceName());
			jo.put("url",resource.getUrl());
			if(resource.getHasMenuChildren()){
				jo.put("state","closed");
			}else{
				jo.put("state", "open");
			}
			tree.add(jo);
		}
		out.print(tree.toString());
        out.flush(); 
        out.close(); 
		return SUCCESS;
	}
	
	//清空session
	public String exit(){
		session.clear();
		ServletActionContext.getRequest().getSession().invalidate();
		return SUCCESS;
	}
	
	
	public String getPag() {
		return pag;
	}
	public void setPag(String pag) {
		this.pag = pag;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public String getCellphoneNumber() {
		return cellphoneNumber;
	}
	public void setCellphoneNumber(String cellphoneNumber) {
		this.cellphoneNumber = cellphoneNumber;
	}
	public java.sql.Date getBirthday() {
		return birthday;
	}
	public void setBirthday(java.sql.Date birthday) {
		this.birthday = birthday;
	}
	public Education getEducation() {
		return education;
	}
	public void setEducation(Education education) {
		this.education = education;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Boolean getRememberPwd() {
		return rememberPwd;
	}
	public void setRememberPwd(Boolean rememberPwd) {
		this.rememberPwd = rememberPwd;
	}
	public String getLoginIp() {
		return loginIp;
	}
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}
	
	

}