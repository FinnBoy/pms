package cn.com.finn.web.pms.dao;

import cn.com.finn.web.pms.po.PO;

/**
 * 
 * @author Finn Zhao
 * @version 2017年4月23日
 */
public abstract class AbstractDAO<T extends PO> extends BaseDAO<PO> {

    public T load(Class<T> clazz,java.io.Serializable id) {
        return (T) this.getSessionFactory().getCurrentSession().load(clazz, id);
    }
}
