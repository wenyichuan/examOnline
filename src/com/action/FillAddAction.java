package com.action;

import com.entity.DbFill;
import com.opensymphony.xwork2.ActionSupport;
import com.service.FillService;
import com.service.FillServiceImpl;


public class FillAddAction extends ActionSupport {
    private static final long serialVersionUID = 1L;


    private String stTitle;
    private String stAnswer;
    private String stParse;
    private FillService fillService=new FillServiceImpl();

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
    @SuppressWarnings("static-access")
    public String execute() throws Exception {
        DbFill dbFill=new DbFill();

        dbFill.setStTitle(stTitle);
        dbFill.setStAnswer(stAnswer);
        dbFill.setStParse(stParse);
        if(fillService.saveFill(dbFill)){
            return this.SUCCESS;
        }else {
            this.addActionError("试题重复，不要重复添加");
            return this.ERROR;
        }
    }
}
