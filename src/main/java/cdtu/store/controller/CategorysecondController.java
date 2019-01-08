package cdtu.store.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cdtu.store.pojo.PageResult;
import cdtu.store.pojo.Result;
import cdtu.store.pojo.TbCategorysecond;
import cdtu.store.service.CategorysecondService;
/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/categorysecond")
public class CategorysecondController {

	@Autowired
	private CategorysecondService categorysecondService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbCategorysecond> findAll(){			
		return categorysecondService.findAll();
	}
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return categorysecondService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param categorysecond
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody TbCategorysecond categorysecond){
		try {
			categorysecondService.add(categorysecond);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param categorysecond
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody TbCategorysecond categorysecond){
		try {
			categorysecondService.update(categorysecond);
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
	public TbCategorysecond findOne(Integer id){
		return categorysecondService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(Integer [] ids){
		try {
			categorysecondService.delete(ids);
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
	public PageResult search(@RequestBody TbCategorysecond categorysecond, int page, int rows  ){
		return categorysecondService.findPage(categorysecond, page, rows);		
	}
	
}
