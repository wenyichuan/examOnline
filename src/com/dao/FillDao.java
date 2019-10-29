package com.dao;

import com.entity.DbFill;
import com.util.Page;

import java.util.List;

public interface FillDao extends BaseDao {
    //根据标题找到题目
    public DbFill findFillByTitle(String title);
    //分页查询试题
    public List<DbFill> findFillByPage(Page page);
    //查询试题总量
    public int findFillCount();
    //根据id查询试题
    public DbFill findFilByID(int id);
    //根据试题ID删除试题
    public void deleteByID(int id);
    //根据试题标题**模糊查询**试题
    public List<DbFill> likeQueryByTitle(String title,Page page);
    //模糊查询的记录数
    public int findLikeQueryCount(String title);
    //随机取出试题
    public List<DbFill> randomFindFill(int number);
}
