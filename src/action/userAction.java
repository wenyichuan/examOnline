package action;

import bean.User;
import biz.userBiz;
import biz.userBizImpl;
import com.opensymphony.xwork2.ActionSupport;

import java.io.File;
import java.util.List;

public class userAction extends ActionSupport {

	private List<User> list;
	private User u;
	private File file;
	private String fileFileName;
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	public List<User> getList() {
		return list;
	}
	public void setList(List<User> list) {
		this.list = list;
	}
	public User getU() {
		return u;
	}
	public void setU(User u) {
		this.u = u;
	}
	
	public String ouexcel()throws Exception{
		userBiz user=new userBizImpl();
		list=user.getAll();
		Excel2 e = new Excel2();
		e.outportExcel2(list);
		return SUCCESS;
	}
	
	//导入excel表格
		public String Inexcel() throws Exception{
			Excel2 e = new Excel2();
			e.importExcel(file, fileFileName);		
			return SUCCESS;
		}
}
