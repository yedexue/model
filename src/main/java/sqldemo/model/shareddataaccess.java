package sqldemo.model;
public class shareddataaccess {
    private Integer shareddataaccessid;

    private Integer cache;

    private String delay;

    private String mode;

    private Integer shared;

    public Integer getShareddataaccessid() {
        return shareddataaccessid;
    }

    public void setShareddataaccessid(Integer shareddataaccessid) {
        this.shareddataaccessid = shareddataaccessid;
    }

    public Integer getCache() {
        return cache;
    }

    public void setCache(Integer cache) {
        this.cache = cache;
    }

    public String getDelay() {
        return delay;
    }

    public void setDelay(String delay) {
        this.delay = delay == null ? null : delay.trim();
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode == null ? null : mode.trim();
    }

    public Integer getShared() {
        return shared;
    }

    public void setShared(Integer shared) {
        this.shared = shared;
    }
}