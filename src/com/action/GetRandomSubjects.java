package com.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.entity.DbFill;
import com.service.FillService;
import com.service.FillServiceImpl;
import org.apache.struts2.ServletActionContext;

import com.entity.Subject;
import com.opensymphony.xwork2.ActionSupport;
import com.service.SubjectService;
import com.service.SubjectServiceImpl;

/**
 *  获取随机的题目
 * @author wyc
 *
 */
public class GetRandomSubjects extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SubjectService subjectService  = new SubjectServiceImpl();
	private FillService fillService=new FillServiceImpl();
	@SuppressWarnings("static-access")
	public String execute(){
		List<Subject> subjects = subjectService.randomFindSubject(5);//获取5题
		List<DbFill>  fills=fillService.randomFindFill(5);//获取填空题
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("subjects", subjects);
		request.setAttribute("fills", fills);
		return this.SUCCESS;
	}
}
