package com.service;

import com.entity.DbFill;
import com.util.Page;
import com.util.PageResult;

import java.util.List;

public interface FillService {
    //添加试题，如果试题标题已经纯在，就不能添加
    public boolean saveFill(DbFill dbFill);
    //按照分页信息来查询试题
    public PageResult queryFillByPage(Page page);
    //查找试题详细信息
    public DbFill showFillDetail(int stID);
    //更新试题信息
    public void updateFill(DbFill dbFill);
    //删除试题信息
    public void deleteFill(int stID);
    //模糊查询试题信息
    public PageResult likeQueryByFillTitle(String stTitle,Page page);
    //随机查询试题信息
    public List<DbFill> randomFindFill(int number);
    /**
     * 计算成绩
     * @param stIDs 传入的试题id List
     * @param studentAnswers 传入的学生回答 List
     */
    public int accountResult(List<Integer> stIDs,List<String> studentAnswers);
    //查询试题数量
    public int countFill();
    //查询到的试题数量
    public int countLikeFill(String title);
}
