package cdtu.store.service;
import java.util.List;

import cdtu.store.pojo.PageResult;
import cdtu.store.pojo.TbCategorysecond;

/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface CategorysecondService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<TbCategorysecond> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum,int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(TbCategorysecond categorysecond);
	
	
	/**
	 * 修改
	 */
	public void update(TbCategorysecond categorysecond);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public TbCategorysecond findOne(Integer id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	public void delete(Integer [] ids);

	/**
	 * 分页
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	public PageResult findPage(TbCategorysecond categorysecond, int pageNum,int pageSize);
	
}
