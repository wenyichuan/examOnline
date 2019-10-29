package com.action;

import com.entity.Student;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.FillService;
import com.service.FillServiceImpl;
import com.service.StudentService;
import com.service.StudentServiceImpl;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 提交试卷，计算分数
 * @author wyc
 *
 */
public class FillExamAction extends ActionSupport {
    private static final long serialVersionUID = 1L;
    private List<Integer> stID;//考试的题目id
    private FillService fillService=new FillServiceImpl();
    private StudentService studentService = new StudentServiceImpl();
    public List<Integer> getStID() {
        return stID;
    }
    public void setStID(List<Integer> stID) {
        this.stID = stID;
    }


    public String execute(){
        HttpServletRequest request = ServletActionContext.getRequest();
        List<String> studentAnswers = new ArrayList<String>();
        for(int i=0;i<5;i++){
            String answer = request.getParameter("stAnswer"+i);//获取每道题的回答
            studentAnswers.add(answer);//加入List中
        }
        int score = fillService.accountResult(stID, studentAnswers);//计算score
        Map session = ActionContext.getContext().getSession();
        Student student = (Student)session.get("studentInfo");//获取Session中的学生信息
        String studentID = student.getStudentID();
        studentService.setStudentResult(studentID, score);//把成绩保存到数据库中
        request.setAttribute("studentName",student.getStudentName());
        request.setAttribute("score",score);
        session.put("stIDs", stID);//把试题编号保存到Session中，方便下一个页面调用session显示正确的答案和解析
        return this.SUCCESS;
    }
}
