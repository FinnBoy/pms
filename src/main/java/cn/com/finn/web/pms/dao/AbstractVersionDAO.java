package cn.com.finn.web.pms.dao;

import cn.com.finn.web.pms.po.VersionPO;

/**
 * 
 * @author Finn Zhao
 * @version 2017年4月30日
 * @param <E>
 */
@SuppressWarnings("unchecked")
public class AbstractVersionDAO<E extends VersionPO> extends BaseDAO<E> {

    public E get(Class<E> clazz, java.io.Serializable id, int version) {

        E e = (E) this.getSessionFactory().getCurrentSession().get(clazz, id);

        if (e.getVersion() != version) {
            return null;
        }

        return e;
    }

}
