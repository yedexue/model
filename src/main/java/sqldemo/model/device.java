package sqldemo.model;
public class device {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column device.DeviceID
     *
     * @mbg.generated Sun May 05 20:04:36 CST 2019
     */
    private Integer deviceid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column device.Validation
     *
     * @mbg.generated Sun May 05 20:04:36 CST 2019
     */
    private Boolean validation;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column device.DeviceID
     *
     * @return the value of device.DeviceID
     *
     * @mbg.generated Sun May 05 20:04:36 CST 2019
     */
    public Integer getDeviceid() {
        return deviceid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column device.DeviceID
     *
     * @param deviceid the value for device.DeviceID
     *
     * @mbg.generated Sun May 05 20:04:36 CST 2019
     */
    public void setDeviceid(Integer deviceid) {
        this.deviceid = deviceid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column device.Validation
     *
     * @return the value of device.Validation
     *
     * @mbg.generated Sun May 05 20:04:36 CST 2019
     */
    public Boolean getValidation() {
        return validation;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column device.Validation
     *
     * @param validation the value for device.Validation
     *
     * @mbg.generated Sun May 05 20:04:36 CST 2019
     */
    public void setValidation(Boolean validation) {
        this.validation = validation;
    }
}