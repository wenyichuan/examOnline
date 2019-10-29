package com.service;

import com.dao.FillDao;
import com.dao.FillDaoImpl;
import com.entity.DbFill;
import com.util.Page;
import com.util.PageResult;
import com.util.PageUtil;

import java.util.List;

public class FillServiceImpl implements FillService {
    private FillDao fillDao=new FillDaoImpl();
    /**
     * 添加试题，如果试题标题已经纯在，就不能添加
     */
    @Override
    public boolean saveFill(DbFill dbFill) {
        String title = dbFill.getStTitle();
        if(fillDao.findFillByTitle(title)==null){
            //如果试题标题在数据库中没有找到的话，就允许添加
            fillDao.save(dbFill);
            return true;
        }else{
            return false;
        }
    }
    /**
     * 根据分页 查询试题
     */
    @Override
    public PageResult queryFillByPage(Page page) {
        page = PageUtil.createPage(page.getEveryPage(), page.getTotalCount(), page.getCurrentPage());
        List<DbFill> list = fillDao.findFillByPage(page);
        PageResult result = new PageResult(page, list);
        return result;
    }
    /**
     * 根据id，返回Fill对象
     */
    @Override
    public DbFill showFillDetail(int stID) {
        return fillDao.findFilByID(stID);

    }
    /**
     * 传入Fill对象
     */
    @Override
    public void updateFill(DbFill dbFill) {
        fillDao.update(dbFill);
    }
    /**
     * 根据id删除Subject
     */
    @Override
    public void deleteFill(int stID) {
        fillDao.deleteByID(stID);
    }
    /**
     * 模糊查询试题，并且返回分页信息
     */
    @Override
    public PageResult likeQueryByFillTitle(String stTitle, Page page) {
        page = PageUtil.createPage(page.getEveryPage(), page.getTotalCount(), page.getCurrentPage());//创建分页信息
        List<DbFill> list = fillDao.likeQueryByTitle(stTitle, page);//通过分页信息模糊查询试题
        PageResult result = new PageResult(page, list);//封装好封页信息和记录信息，返回给调用者
        return result;
    }
    /**
     * 随机抽取题库
     * @param number 即数量
     */
    @Override
    public List<DbFill> randomFindFill(int number) {
        return fillDao.randomFindFill(number);

    }
    /**
     * 计算成绩
     * @param stIDs 传入的试题id List
     * @param studentAnswers 传入的学生回答 List
     */
    @Override
    public int accountResult(List<Integer> stIDs, List<String> studentAnswers) {
        int score = 0;// 初始化总分为0
        for (int i = 0; i < stIDs.size(); i++) {
            String rightAnswer = fillDao.findFilByID(stIDs.get(i)).getStAnswer();// 通过试题的id得到正确的答案
            if (rightAnswer.equals(studentAnswers.get(i))) {
                score += 20;
            }
        }
        return score;
    }
    /**
     * 获得fill数量
     */
    @Override
    public int countFill() {
        return fillDao.findFillCount();
    }

    @Override
    public int countLikeFill(String title) {
        return fillDao.findLikeQueryCount(title);

    }
}
