package sqldemo.model;
public class component {
    private Integer componentid;

    private String name;

    private String type;

    private String modeltype;

    private String wcet;

    public Integer getComponentid() {
        return componentid;
    }

    public void setComponentid(Integer componentid) {
        this.componentid = componentid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getModeltype() {
        return modeltype;
    }

    public void setModeltype(String modeltype) {
        this.modeltype = modeltype == null ? null : modeltype.trim();
    }

    public String getWcet() {
        return wcet;
    }

    public void setWcet(String wcet) {
        this.wcet = wcet == null ? null : wcet.trim();
    }
}