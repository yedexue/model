package sqldemo.model;
public class InvocationChannel {
    private Integer invocationchannelid;

    private Boolean crossdomain;

    private Integer partitionid;

    public Integer getInvocationchannelid() {
        return invocationchannelid;
    }

    public void setInvocationchannelid(Integer invocationchannelid) {
        this.invocationchannelid = invocationchannelid;
    }

    public Boolean getCrossdomain() {
        return crossdomain;
    }

    public void setCrossdomain(Boolean crossdomain) {
        this.crossdomain = crossdomain;
    }

    public Integer getPartitionid() {
        return partitionid;
    }

    public void setPartitionid(Integer partitionid) {
        this.partitionid = partitionid;
    }
}