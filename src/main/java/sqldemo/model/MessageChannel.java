package sqldemo.model;
public class MessageChannel {
    private Integer messagechannelid;

    private Integer inBuffer;

    private Integer outBuffer;

    public Integer getMessagechannelid() {
        return messagechannelid;
    }

    public void setMessagechannelid(Integer messagechannelid) {
        this.messagechannelid = messagechannelid;
    }

    public Integer getInBuffer() {
        return inBuffer;
    }

    public void setInBuffer(Integer inBuffer) {
        this.inBuffer = inBuffer;
    }

    public Integer getOutBuffer() {
        return outBuffer;
    }

    public void setOutBuffer(Integer outBuffer) {
        this.outBuffer = outBuffer;
    }
}