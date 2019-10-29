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
import java.util.ArrayList;
import java.util.List;

/**
* 查找试题信息 -根据课程名
* @author wyc
*
*/
public class QueryFillByClassAction extends ActionSupport {
    private String fillTitle;
    private int currentPage;//当前页
    private int everyPage=5;//每一页记录
    private FillService fillService=new FillServiceImpl();
    private int totalCount;//总共页

    public String getFillTitle() {
        return fillTitle;
    }

    public void setFillTitle(String fillTitle) {
        this.fillTitle = fillTitle;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getEveryPage() {
        return everyPage;
    }

    public void setEveryPage(int everyPage) {
        this.everyPage = everyPage;
    }

    public FillService getFillService() {
        return fillService;
    }

    public void setFillService(FillService fillService) {
        this.fillService = fillService;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
    @Override
    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        totalCount = fillService.countLikeFill(fillTitle);
        if(currentPage>0){
            //currentPage为0时，用post传参不会出现编码不一致
            //currentPage大于0时，用get传参会出现编码不一致的情况
            fillTitle = new String(fillTitle.getBytes("ISO-8859-1"),"UTF-8");
        }
        request.setAttribute("fillTitle", fillTitle);
        Page page = new Page();
        page = PageUtil.createPage(everyPage, totalCount, currentPage);
        PageResult pageResult = fillService.likeQueryByFillTitle(fillTitle, page);
        List<DbFill> fills = pageResult.getList();
        List<DbFill> newFills = new ArrayList<DbFill>();
        for (DbFill fill : fills) {
            String newTitle =  fill.getStTitle().replaceAll(fillTitle, "<font color='red'>"+fillTitle+"</font>");//关键字标红
            fill.setStTitle(newTitle);
            newFills.add(fill);
        }
        page = pageResult.getPage();
        request.setAttribute("fills", newFills);
        request.setAttribute("page", page);
        return this.SUCCESS;
    }

}
