package cdtu.store.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cdtu.store.mapper.TbOrderitemMapper;
import cdtu.store.pojo.PageResult;
import cdtu.store.pojo.TbOrderitem;
import cdtu.store.pojo.TbOrderitemExample;
import cdtu.store.pojo.TbOrderitemExample.Criteria;
import cdtu.store.service.OrderitemService;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class OrderitemServiceImpl implements OrderitemService {

	@Autowired
	private TbOrderitemMapper orderitemMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TbOrderitem> findAll() {
		return orderitemMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbOrderitem> page=   (Page<TbOrderitem>) orderitemMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbOrderitem orderitem) {
		orderitemMapper.insert(orderitem);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TbOrderitem orderitem){
		orderitemMapper.updateByPrimaryKey(orderitem);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TbOrderitem findOne(Integer id){
		return orderitemMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			orderitemMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(TbOrderitem orderitem, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbOrderitemExample example=new TbOrderitemExample();
		Criteria criteria = example.createCriteria();
		
		if(orderitem!=null){			
				
		}
		
		Page<TbOrderitem> page= (Page<TbOrderitem>)orderitemMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}

		@Override
		public List<TbOrderitem> findByOid(Integer oid) {
			return orderitemMapper.findByOid(oid);
		}
	
}
