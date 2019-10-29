package com.action;

import com.entity.DbFill;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.FillService;
import com.service.FillServiceImpl;
import com.service.SubjectService;
import com.service.SubjectServiceImpl;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 显示正确的答案并且显示解析
 * @author wyc
 *
 */
public class ShowFillAnswerAction extends ActionSupport {
    private static final long serialVersionUID = 1L;
    private FillService fillService = new FillServiceImpl();
    @SuppressWarnings({ "unchecked", "static-access" })
    public String execute(){
        List<DbFill> fills = new ArrayList<DbFill>();
        HttpServletRequest request = ServletActionContext.getRequest();//获取request
        Map session = ActionContext.getContext().getSession();//获取session
        List<Integer> stIDs = (List<Integer>)session.get("stIDs");
        for (Integer fillID : stIDs) {
            DbFill fill = fillService.showFillDetail(fillID);
            fills.add(fill);
        }
        request.setAttribute("fills", fills);//把试题的信息封装成request发送给页面
        return this.SUCCESS;
    }
}
