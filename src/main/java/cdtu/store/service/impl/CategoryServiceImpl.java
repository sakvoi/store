package cdtu.store.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cdtu.store.mapper.TbCategoryMapper;
import cdtu.store.pojo.PageResult;
import cdtu.store.pojo.TbCategory;
import cdtu.store.pojo.TbCategoryExample;
import cdtu.store.pojo.TbCategoryExample.Criteria;
import cdtu.store.service.CategoryService;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private TbCategoryMapper categoryMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TbCategory> findAll() {
		return categoryMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbCategory> page=   (Page<TbCategory>) categoryMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbCategory category) {
		categoryMapper.insert(category);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TbCategory category){
		categoryMapper.updateByPrimaryKey(category);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TbCategory findOne(Integer id){
		return categoryMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			categoryMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(TbCategory category, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbCategoryExample example=new TbCategoryExample();
		Criteria criteria = example.createCriteria();
		
		if(category!=null){			
						if(category.getCname()!=null && category.getCname().length()>0){
				criteria.andCnameLike("%"+category.getCname()+"%");
			}
	
		}
		
		Page<TbCategory> page= (Page<TbCategory>)categoryMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}
	
}
