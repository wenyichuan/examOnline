package action;

import bean.Choice;
import biz.choiceBiz;
import biz.choiceBizImpl;
import com.opensymphony.xwork2.ActionSupport;

import java.io.File;
import java.util.List;

public class ChoiceAction extends ActionSupport {
    private List<Choice> list;
    private Choice choice;
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

    public List<Choice> getList() {
        return list;
    }

    public void setList(List<Choice> list) {
        this.list = list;
    }

    public Choice getChoice() {
        return choice;
    }

    public void setChoice(Choice choice) {
        this.choice = choice;
    }

    public String outExcel() throws Exception{
        choiceBiz choiceBiz=new choiceBizImpl();
        list=choiceBiz.getAll();
        Excel excel =new Excel();
        excel.outportExcel(list);
        return SUCCESS;
    }
    //导入excel表格
    public String InExcel3() throws Exception{
        Excel excel = new Excel();
        excel.importExcel(file, fileFileName);
        return SUCCESS;
    }
}
