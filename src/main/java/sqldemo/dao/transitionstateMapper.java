package sqldemo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import sqldemo.model.transitionstate;

@Mapper
@Component
public interface transitionstateMapper {
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table transitionstate
	 *
	 * @mbg.generated Thu Jun 20 16:53:59 CST 2019
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table transitionstate
	 *
	 * @mbg.generated Thu Jun 20 16:53:59 CST 2019
	 */
	int insert(transitionstate record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table transitionstate
	 *
	 * @mbg.generated Thu Jun 20 16:53:59 CST 2019
	 */
	int insertSelective(transitionstate record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table transitionstate
	 *
	 * @mbg.generated Thu Jun 20 16:53:59 CST 2019
	 */
	transitionstate selectByPrimaryKey(Integer id);

	List<transitionstate> selectbytransition(Integer transitionid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table transitionstate
	 *
	 * @mbg.generated Thu Jun 20 16:53:59 CST 2019
	 */
	int updateByPrimaryKeySelective(transitionstate record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table transitionstate
	 *
	 * @mbg.generated Thu Jun 20 16:53:59 CST 2019
	 */
	int updateByPrimaryKey(transitionstate record);
}