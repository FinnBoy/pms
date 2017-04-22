package cn.com.finn.web.pms.po;

import cn.com.finn.module.util.HashCodeUtils;

/**
 * 
 * @author Finn Zhao
 * @version 2017年4月23日
 */
public abstract class PO {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object object) {

        if (object == this) {
            return true;
        }

        if (object == null) {
            return false;
        }

        if (!(object instanceof PO)) {
            return false;
        }

        PO another = (PO) object;

        if (another.getId() == null || this.getId() == null) {
            return false;
        }

        return another.getId().equals(this.getId());
    }

    @Override
    public int hashCode() {
        return HashCodeUtils.getInstance().append(this.id).hashCode();
    }
}
