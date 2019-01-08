package cdtu.store.mapper;

import cdtu.store.pojo.TbOrderitem;
import cdtu.store.pojo.TbOrderitemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbOrderitemMapper {
    int countByExample(TbOrderitemExample example);

    int deleteByExample(TbOrderitemExample example);

    int deleteByPrimaryKey(Integer itemid);

    int insert(TbOrderitem record);

    int insertSelective(TbOrderitem record);

    List<TbOrderitem> selectByExample(TbOrderitemExample example);

    TbOrderitem selectByPrimaryKey(Integer itemid);

    int updateByExampleSelective(@Param("record") TbOrderitem record, @Param("example") TbOrderitemExample example);

    int updateByExample(@Param("record") TbOrderitem record, @Param("example") TbOrderitemExample example);

    int updateByPrimaryKeySelective(TbOrderitem record);

    int updateByPrimaryKey(TbOrderitem record);
}