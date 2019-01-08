package cdtu.store.mapper;

import cdtu.store.pojo.TbCategorysecond;
import cdtu.store.pojo.TbCategorysecondExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbCategorysecondMapper {
    int countByExample(TbCategorysecondExample example);

    int deleteByExample(TbCategorysecondExample example);

    int deleteByPrimaryKey(Integer csid);

    int insert(TbCategorysecond record);

    int insertSelective(TbCategorysecond record);

    List<TbCategorysecond> selectByExample(TbCategorysecondExample example);

    TbCategorysecond selectByPrimaryKey(Integer csid);

    int updateByExampleSelective(@Param("record") TbCategorysecond record, @Param("example") TbCategorysecondExample example);

    int updateByExample(@Param("record") TbCategorysecond record, @Param("example") TbCategorysecondExample example);

    int updateByPrimaryKeySelective(TbCategorysecond record);

    int updateByPrimaryKey(TbCategorysecond record);

}