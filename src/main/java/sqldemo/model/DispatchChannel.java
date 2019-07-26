package sqldemo.model;
public class DispatchChannel {
    private Integer dispatchchannelid;

    private Boolean timeTrigger;

    private Integer partitionid;

    public Integer getDispatchchannelid() {
        return dispatchchannelid;
    }

    public void setDispatchchannelid(Integer dispatchchannelid) {
        this.dispatchchannelid = dispatchchannelid;
    }

    public Boolean getTimeTrigger() {
        return timeTrigger;
    }

    public void setTimeTrigger(Boolean timeTrigger) {
        this.timeTrigger = timeTrigger;
    }

    public Integer getPartitionid() {
        return partitionid;
    }

    public void setPartitionid(Integer partitionid) {
        this.partitionid = partitionid;
    }
}