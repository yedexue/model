package sqldemo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import sqldemo.model._partition;
@Mapper
@Component
public interface _partitionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table _partition
     *
     * @mbg.generated Wed May 15 00:29:27 CST 2019
     */
    int deleteByPrimaryKey(Integer partitionid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table _partition
     *
     * @mbg.generated Wed May 15 00:29:27 CST 2019
     */
    int insert(_partition record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table _partition
     *
     * @mbg.generated Wed May 15 00:29:27 CST 2019
     */
    int insertSelective(_partition record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table _partition
     *
     * @mbg.generated Wed May 15 00:29:27 CST 2019
     */
    _partition selectByPrimaryKey(Integer partitionid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table _partition
     *
     * @mbg.generated Wed May 15 00:29:27 CST 2019
     */
    int updateByPrimaryKeySelective(_partition record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table _partition
     *
     * @mbg.generated Wed May 15 00:29:27 CST 2019
     */
    int updateByPrimaryKey(_partition record);
    List<_partition> selectByRTOS(Integer rtosid);
}