package com.dao;

import com.entity.DbFill;
import com.util.HibernateSessionFactory;
import com.util.Page;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class FillDaoImpl extends BaseDaoImpl implements FillDao{
    /**
     * 根据title返回一条记录，如果没有的话，返回空值
     * 要精准匹配= =
     * 如果有的话，就返回匹配的**第一条信息**
     */
    @Override
    public DbFill findFillByTitle(String title) {
        String hql ="from DbFill as fill where fill.stTitle=?";
        Session session = HibernateSessionFactory.getSession();
        Query query = session.createQuery(hql);
        /**
         * hql语句与sql不同，hql语句第一个问号用0来替换
         */
        query.setString(0, title);
        List<DbFill> list = query.list();
        HibernateSessionFactory.closeSession();
        if(list.size()==0){
            return null;
        }else{
            return (DbFill) list.get(0);//返回第一个匹配的试题
        }
    }
    /**
     * 根据要显示的分页要求，查询结果
     */
    @Override
    public List<DbFill> findFillByPage(Page page) {
        String hql ="from DbFill";
        Session session = HibernateSessionFactory.getSession();
        Query query = session.createQuery(hql);
        query.setMaxResults(page.getEveryPage());//每页显示的数量
        query.setFirstResult(page.getBeginIndex());//起始位置
        List<DbFill> list = query.list();
        HibernateSessionFactory.closeSession();
        return list;
    }
    /**
     * 返回记录数
     */
    @Override
    public int findFillCount() {
        Session session = HibernateSessionFactory.getSession();
        Query query = session.createQuery("from DbFill ");
        List<DbFill> list = query.list();
        int count = list.size();
        return count;
    }
    /**
     * 根据id查询一条记录
     */
    @Override
    public DbFill findFilByID(int id) {
        Session session = HibernateSessionFactory.getSession();
        DbFill dbFill = (DbFill) session.get(DbFill.class, id);
        HibernateSessionFactory.closeSession();
        return dbFill;
    }
    /**
     * 根据id删除一条记录
     */
    @Override
    public void deleteByID(int id) {
        Session session = HibernateSessionFactory.getSession();
        DbFill dbFill = (DbFill)session.get(DbFill.class, id);//获取要删除的对象
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(dbFill);
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            transaction.rollback();
        }
        HibernateSessionFactory.closeSession();

    }
    /**
     * 根据title模糊查询
     * @param title
     * @param page 指定查询的数量
     */
    @Override
    public List<DbFill> likeQueryByTitle(String title, Page page) {
        String hql = "from DbFill as fill where fill.stTitle like :title ";
        Session session = HibernateSessionFactory.getSession();
        Query query = session.createQuery(hql);
        query.setString("title", "%"+title+"%");
        query.setMaxResults(page.getEveryPage());
        query.setFirstResult(page.getBeginIndex());
        List<DbFill> list =query.list();
        HibernateSessionFactory.closeSession();
        return list;
    }
    /**
     * 查询的结果数量
     */
    @Override
    public int findLikeQueryCount(String title) {
        String hql = "from DbFill as fill where fill.stTitle like :title ";
        Session session = HibernateSessionFactory.getSession();
        Query query = session.createQuery(hql);
        query.setString("title", "%"+title+"%");
        List list = query.list();
        int count = list.size();
        HibernateSessionFactory.closeSession();
        return count;
    }
    /**
     * 随机抽取题目
     * @param number 指定抽取的数目
     */
    @Override
    public List<DbFill> randomFindFill(int number) {
        String hql = "from DbFill as fill order by rand()";
        Session session = HibernateSessionFactory.getSession();
        Query query = session.createQuery(hql);
        query.setMaxResults(number);
        List<DbFill> list =query.list();
        HibernateSessionFactory.closeSession();
        return list;
    }
}
