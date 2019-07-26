package sqldemo.model;
public class ASyncMessaging {
    private Integer asyncmessagingid;

    private String message;

    private Integer port;

    private String ptc;

    public Integer getAsyncmessagingid() {
        return asyncmessagingid;
    }

    public void setAsyncmessagingid(Integer asyncmessagingid) {
        this.asyncmessagingid = asyncmessagingid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getPtc() {
        return ptc;
    }

    public void setPtc(String ptc) {
        this.ptc = ptc == null ? null : ptc.trim();
    }
}