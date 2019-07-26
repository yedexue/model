package sqldemo.model;
public class syncinterface {
    private Integer syncinterfaceid;

    private String delay;

    private String paralist;

    private String _return;

    public Integer getSyncinterfaceid() {
        return syncinterfaceid;
    }

    public void setSyncinterfaceid(Integer syncinterfaceid) {
        this.syncinterfaceid = syncinterfaceid;
    }

    public String getDelay() {
        return delay;
    }

    public void setDelay(String delay) {
        this.delay = delay == null ? null : delay.trim();
    }

    public String getParalist() {
        return paralist;
    }

    public void setParalist(String paralist) {
        this.paralist = paralist == null ? null : paralist.trim();
    }

    public String getReturn() {
        return _return;
    }

    public void setReturn(String _return) {
        this._return = _return == null ? null : _return.trim();
    }
}