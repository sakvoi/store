package cdtu.store.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cdtu.store.mapper.TbProductMapper;
import cdtu.store.pojo.PageResult;
import cdtu.store.pojo.TbProduct;
import cdtu.store.pojo.TbProductExample;
import cdtu.store.pojo.TbProductExample.Criteria;
import cdtu.store.service.ProductService;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private TbProductMapper productMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TbProduct> findAll() {
		return productMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbProduct> page=   (Page<TbProduct>) productMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbProduct product) {
		productMapper.insert(product);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TbProduct product){
		productMapper.updateByPrimaryKey(product);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TbProduct findOne(Integer id){
		return productMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			productMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(TbProduct product, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbProductExample example=new TbProductExample();
		Criteria criteria = example.createCriteria();
		
		if(product!=null){			
						if(product.getPname()!=null && product.getPname().length()>0){
				criteria.andPnameLike("%"+product.getPname()+"%");
			}
			if(product.getImage()!=null && product.getImage().length()>0){
				criteria.andImageLike("%"+product.getImage()+"%");
			}
			if(product.getDesc()!=null && product.getDesc().length()>0){
				criteria.andDescLike("%"+product.getDesc()+"%");
			}
			if(product.getPcode()!=null && product.getPcode().length()>0){
				criteria.andPcodeLike("%"+product.getPcode()+"%");
			}
			if(product.getStatus()!=null && product.getStatus().length()>0){
				criteria.andStatusLike("%"+product.getStatus()+"%");
			}
	
		}
		
		Page<TbProduct> page= (Page<TbProduct>)productMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}
	
}
