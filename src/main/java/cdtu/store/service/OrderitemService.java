package cdtu.store.service;
import java.util.List;

import cdtu.store.pojo.PageResult;
import cdtu.store.pojo.TbOrderitem;
/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface OrderitemService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<TbOrderitem> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum,int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(TbOrderitem orderitem);
	
	
	/**
	 * 修改
	 */
	public void update(TbOrderitem orderitem);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public TbOrderitem findOne(Integer id);
	
	
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
	public PageResult findPage(TbOrderitem orderitem, int pageNum,int pageSize);

	public List<TbOrderitem> findByOid(Integer oid);
	
}
