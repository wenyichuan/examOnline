package com.action;


import com.opensymphony.xwork2.ActionSupport;
import com.service.FillService;
import com.service.FillServiceImpl;

public class FillDeleteAction extends ActionSupport {
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
        fillService.deleteFill(stId);
        addActionMessage("删除成功!");
        return this.SUCCESS;
    }
}
