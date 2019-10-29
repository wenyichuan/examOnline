package com.action;

import com.entity.DbFill;
import com.opensymphony.xwork2.ActionSupport;
import com.service.FillService;
import com.service.FillServiceImpl;

public class FillUpdateAction extends ActionSupport {
    private static final long serialVersionUID = 1L;
    private int stId;//编号
    private String stTitle;//题目
    private String stAnswer;//答案
    private String stParse;//解析

    private FillService fillService=new FillServiceImpl();

    public int getStId() {
        return stId;
    }

    public void setStId(int stId) {
        this.stId = stId;
    }

    public String getStTitle() {
        return stTitle;
    }

    public void setStTitle(String stTitle) {
        this.stTitle = stTitle;
    }

    public String getStAnswer() {
        return stAnswer;
    }

    public void setStAnswer(String stAnswer) {
        this.stAnswer = stAnswer;
    }

    public String getStParse() {
        return stParse;
    }

    public void setStParse(String stParse) {
        this.stParse = stParse;
    }
    @Override
    public String execute() throws Exception {
        DbFill fill = new DbFill();
        fill.setStID(stId);
        fill.setStTitle(stTitle);
        fill.setStAnswer(stAnswer);
        fill.setStParse(stParse);
        fillService.updateFill(fill);
        this.addActionMessage("更新成功");
        return this.SUCCESS;
    }
}
