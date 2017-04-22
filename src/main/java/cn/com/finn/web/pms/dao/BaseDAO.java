package cn.com.finn.web.pms.dao;

import org.hibernate.SessionFactory;

/**
 * 
 * @author Finn Zhao
 * @version 2017年4月23日
 */
public abstract class BaseDAO<T> {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}
