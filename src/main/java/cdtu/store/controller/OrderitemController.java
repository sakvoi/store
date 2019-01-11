package cdtu.store.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cdtu.store.pojo.PageResult;
import cdtu.store.pojo.Result;
import cdtu.store.pojo.TbOrderitem;
import cdtu.store.service.OrderitemService;
/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/orderitem")
public class OrderitemController {

	@Autowired
	private OrderitemService orderitemService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbOrderitem> findAll(){			
		return orderitemService.findAll();
	}
	
	@RequestMapping("/findByOid")
	public List<TbOrderitem> findByOid(Integer oid){
		return orderitemService.findByOid(oid);
	}
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return orderitemService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param orderitem
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody TbOrderitem orderitem){
		try {
			orderitemService.add(orderitem);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param orderitem
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody TbOrderitem orderitem){
		try {
			orderitemService.update(orderitem);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "修改失败");
		}
	}	
	
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	public TbOrderitem findOne(Integer id){
		return orderitemService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(Integer [] ids){
		try {
			orderitemService.delete(ids);
			return new Result(true, "删除成功"); 
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}
	
		/**
	 * 查询+分页
	 * @param brand
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/search")
	public PageResult search(@RequestBody TbOrderitem orderitem, int page, int rows  ){
		return orderitemService.findPage(orderitem, page, rows);		
	}
	
}
