package sqldemo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import sqldemo.model.processor;
@Mapper
@Component
public interface processorMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table processor
     *
     * @mbg.generated Tue Jun 04 16:05:19 CST 2019
     */
    int deleteByPrimaryKey(Integer processorid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table processor
     *
     * @mbg.generated Tue Jun 04 16:05:19 CST 2019
     */
    int insert(processor record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table processor
     *
     * @mbg.generated Tue Jun 04 16:05:19 CST 2019
     */
    int insertSelective(processor record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table processor
     *
     * @mbg.generated Tue Jun 04 16:05:19 CST 2019
     */
    processor selectByPrimaryKey(Integer processorid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table processor
     *
     * @mbg.generated Tue Jun 04 16:05:19 CST 2019
     */
    int updateByPrimaryKeySelective(processor record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table processor
     *
     * @mbg.generated Tue Jun 04 16:05:19 CST 2019
     */
    int updateByPrimaryKey(processor record);
//    List<processor> selectAll();
}