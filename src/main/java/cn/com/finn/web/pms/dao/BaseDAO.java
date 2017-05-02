package cn.com.finn.web.pms.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cn.com.finn.web.pms.po.PO;

/**
 * 
 * @author Finn Zhao
 * @version 2017年4月23日
 */
@SuppressWarnings("unchecked")
public abstract class BaseDAO<T extends PO> {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session getCurrentSession() {
        return this.getSessionFactory().getCurrentSession();
    }

    public T load(Class<T> clazz, java.io.Serializable id) {
        return (T) this.getSessionFactory().getCurrentSession().load(clazz, id);
    }

    public T get(Class<T> clazz, java.io.Serializable id) {
        return (T) this.getSessionFactory().getCurrentSession().get(clazz, id);
    }

    public Serializable save(T po) {
        return this.getSessionFactory().getCurrentSession().save(po);
    }

    public void update(T po) {
        this.getSessionFactory().getCurrentSession().update(po);
    }

    public void remove(T po) {
        this.getSessionFactory().getCurrentSession().delete(po);
        ;
    }
}
