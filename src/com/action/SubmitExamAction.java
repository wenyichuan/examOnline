package com.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.service.*;
import org.apache.struts2.ServletActionContext;

import com.entity.Student;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 提交试卷，计算分数
 * @author wyc
 *
 */
public class SubmitExamAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Integer> stID;//考试的题目id
	private List<Integer> stID1;
	private SubjectService subjectService = new SubjectServiceImpl();
	private StudentService studentService = new StudentServiceImpl();

	private FillService fillService=new FillServiceImpl();

	public List<Integer> getStID() {
		return stID;
	}
	public void setStID(List<Integer> stID) {
		this.stID = stID;
	}

	public List<Integer> getStID1() {
		return stID1;
	}

	public void setStID1(List<Integer> stID1) {
		this.stID1 = stID1;
	}


	@SuppressWarnings({ "unchecked", "static-access" })
	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		List<String> studentAnswers = new ArrayList<String>();
		for(int i=0;i<5;i++){
			String answer = request.getParameter("stAnswer"+i);//获取每道题的回答
			studentAnswers.add(answer);//加入List中
		}
		int choicescore = subjectService.accountResult(stID, studentAnswers);//计算score

		List<String> fillAnswers =new ArrayList<String>();
		for(int i=0;i<5;i++){
			String answer = request.getParameter("stAnswer1"+i);//获取每道题的回答
			fillAnswers.add(answer);//加入List中
		}

        int fillscore=fillService.accountResult(stID1,studentAnswers);

        int score=choicescore+fillscore;

        Map session = ActionContext.getContext().getSession();
		Student student = (Student)session.get("studentInfo");//获取Session中的学生信息
		String studentID = student.getStudentID();
		studentService.setStudentResult(studentID, score);//把成绩保存到数据库中
		request.setAttribute("studentName",student.getStudentName());
		request.setAttribute("score",score);
		session.put("stIDs", stID);//把试题编号保存到Session中，方便下一个页面调用session显示正确的答案和解析
		session.put("stID1",stID1);
		return this.SUCCESS;
	}
	
}
