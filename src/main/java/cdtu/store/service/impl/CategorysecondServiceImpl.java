package cdtu.store.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cdtu.store.mapper.TbCategorysecondMapper;
import cdtu.store.pojo.PageResult;
import cdtu.store.pojo.TbCategorysecond;
import cdtu.store.pojo.TbCategorysecondExample;
import cdtu.store.pojo.TbCategorysecondExample.Criteria;
import cdtu.store.service.CategorysecondService;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class CategorysecondServiceImpl implements CategorysecondService {

	@Autowired
	private TbCategorysecondMapper categorysecondMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TbCategorysecond> findAll() {
		return categorysecondMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbCategorysecond> page=   (Page<TbCategorysecond>) categorysecondMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbCategorysecond categorysecond) {
		categorysecondMapper.insert(categorysecond);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TbCategorysecond categorysecond){
		categorysecondMapper.updateByPrimaryKey(categorysecond);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TbCategorysecond findOne(Integer id){
		return categorysecondMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			categorysecondMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
	@Override
	public PageResult findPage(TbCategorysecond categorysecond, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbCategorysecondExample example=new TbCategorysecondExample();
		Criteria criteria = example.createCriteria();
		
		if(categorysecond!=null){			
						if(categorysecond.getCsname()!=null && categorysecond.getCsname().length()>0){
				criteria.andCsnameLike("%"+categorysecond.getCsname()+"%");
			}
	
		}
		
		Page<TbCategorysecond> page= (Page<TbCategorysecond>)categorysecondMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}

}
