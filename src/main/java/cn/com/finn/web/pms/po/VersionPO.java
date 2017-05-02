package cn.com.finn.web.pms.po;

/**
 * 
 * @author Finn Zhao
 * @version 2017年4月30日
 */
public abstract class VersionPO extends PO {

    private int version;

    public int getVersion() {
        return version;
    }

    protected void setVersion(int version) {
        this.version = version;
    }

}
