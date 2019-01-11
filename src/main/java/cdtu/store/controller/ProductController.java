package cdtu.store.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cdtu.store.pojo.PageResult;
import cdtu.store.pojo.Result;
import cdtu.store.pojo.TbProduct;
import cdtu.store.service.ProductService;
/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbProduct> findAll(){	
		List<TbProduct> products = productService.findAll();
		for (TbProduct product : products) {
			product.setImage("../product/images/" + product.getImage());
		}
		return products;
	}
	@RequestMapping("/findBySid")
	public List<TbProduct> findBySid(Integer sid){
		List<TbProduct> products = productService.findBySid(sid);
		for (TbProduct product : products) {
			product.setImage("../product/images/" + product.getImage());
		}
		return products;
	}
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return productService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param product
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody TbProduct product){
		try {
			productService.add(product);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param product
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody TbProduct product){
		try {
			productService.update(product);
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
	public TbProduct findOne(Integer id){
		return productService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(Integer [] ids){
		try {
			productService.delete(ids);
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
	public PageResult search(@RequestBody TbProduct product, int page, int rows  ){
		return productService.findPage(product, page, rows);		
	}
	
}
