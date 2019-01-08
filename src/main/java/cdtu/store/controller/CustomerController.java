package cdtu.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cdtu.store.pojo.PageResult;
import cdtu.store.pojo.Result;
import cdtu.store.pojo.TbCustomer;
import cdtu.store.service.CustomerService;

/**
 * controller
 * 
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	/**
	 * 返回全部列表
	 * 
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbCustomer> findAll() {
		return customerService.findAll();
	}

	/**
	 * 返回全部列表
	 * 
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult findPage(int page, int rows) {
		return customerService.findPage(page, rows);
	}

	/**
	 * 增加
	 * 
	 * @param customer
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody TbCustomer customer) {
		try {
			customerService.add(customer);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}

	/**
	 * 注册
	 * 
	 * @param customer
	 * @return
	 */
	@RequestMapping("/register")
	public Result register(@RequestBody TbCustomer customer) {
		try {
			customerService.register(customer);
			return new Result(true, "注册成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "注册失败");
		}
	}

	/**
	 * 修改
	 * 
	 * @param customer
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody TbCustomer customer) {
		try {
			customerService.update(customer);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "修改失败");
		}
	}

	/**
	 * 获取实体
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	public TbCustomer findOne(Integer id) {
		return customerService.findOne(id);
	}

	/**
	 * 批量删除
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(Integer[] ids) {
		try {
			customerService.delete(ids);
			return new Result(true, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}

	/**
	 * 查询+分页
	 * 
	 * @param brand
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/search")
	public PageResult search(@RequestBody TbCustomer customer, int page, int rows) {
		return customerService.findPage(customer, page, rows);
	}

	@RequestMapping("/login")
	public Result login(String username, String password) {
		return customerService.login(username, password);
	}

}
