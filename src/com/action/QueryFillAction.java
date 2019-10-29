package com.action;

import com.entity.DbFill;
import com.opensymphony.xwork2.ActionSupport;
import com.service.FillService;
import com.service.FillServiceImpl;
import com.util.Page;
import com.util.PageResult;
import com.util.PageUtil;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class QueryFillAction  extends ActionSupport {
    private static final long serialVersionUID = 1L;
    private int currentPage;//当前页
    private int everyPage=5;//每一页记录
    private FillService fillService=new FillServiceImpl();
    private int totalCount = fillService.countFill();//总共页
    public int getCurrentPage() {
        return currentPage;
    }
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
    public FillService getFillService(){return fillService;}
    public void setFillService(FillService fillService) {
        this.fillService = fillService;
    }

    public String execute() throws Exception{
        Page page = new Page();
        page = PageUtil.createPage(everyPage, totalCount, currentPage);//获取分页信息
        PageResult pageResult = fillService.queryFillByPage(page);
        List<DbFill> subjects = pageResult.getList();
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("fills", subjects);
        request.setAttribute("page", page);
        return this.SUCCESS;
    }

}
