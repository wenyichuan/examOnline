package com.action;

import com.entity.DbFill;
import com.opensymphony.xwork2.ActionSupport;
import com.service.FillService;
import com.service.FillServiceImpl;
import org.apache.struts2.ServletActionContext;

public class FillUpdateBefore extends ActionSupport {
    private static final long serialVersionUID = 1L;
    private int stId;
    private FillService fillService=new FillServiceImpl();

    public int getStId() {
        return stId;
    }

    public void setStId(int stId) {
        this.stId = stId;
    }
    @Override
    public String execute() throws Exception {
        DbFill fill = fillService.showFillDetail(stId);
        ServletActionContext.getRequest().setAttribute("fill",fill);
        return this.SUCCESS;
    }
}
