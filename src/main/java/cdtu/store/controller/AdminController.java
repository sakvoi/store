package cdtu.store.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cdtu.store.pojo.PageResult;
import cdtu.store.pojo.Result;
import cdtu.store.pojo.TbAdmin;
import cdtu.store.service.AdminService;

/**
 * controller
 * 
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;

	/**
	 * 返回全部列表
	 * 
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbAdmin> findAll() {
		return adminService.findAll();
	}

	/**
	 * 返回全部列表
	 * 
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult findPage(int page, int rows) {
		return adminService.findPage(page, rows);
	}

	/**
	 * 增加
	 * 
	 * @param admin
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody TbAdmin admin) {
		try {
			adminService.add(admin);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}

	/**
	 * 修改
	 * 
	 * @param admin
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody TbAdmin admin) {
		try {
			adminService.update(admin);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "修改失败");
		}
	}

	/**
	 * 修改密码
	 * 
	 * @param admin
	 * @return
	 */
	@RequestMapping("/changePwd")
	public Result changePwd(@RequestBody TbAdmin admin) {
		try {
			adminService.changePwd(admin);
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
	public TbAdmin findOne(Integer id) {
		return adminService.findOne(id);
	}

	/**
	 * 查询
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping("/findByNamePwd")
	public Result findByNamePwd(String username, String password) {
		return adminService.findByNamePwd(username, password);
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
			adminService.delete(ids);
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
	public PageResult search(@RequestBody TbAdmin admin, int page, int rows) {
		return adminService.findPage(admin, page, rows);
	}

	/**
	 * 登录
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping("/login")
	public Result login(String username, String password, HttpSession session) {
		session.setAttribute("user", username);
		return adminService.login(username, password);
	}
	
	@RequestMapping("/getUser")
	public String getUser(HttpSession session) {
		String user = (String) session.getAttribute("user");
		return user;
	}
	
	@RequestMapping("/removeUser")
	public Result removeUser(HttpSession session) {
		try{
			session.removeAttribute("user");
			return new Result(true, "注销成功");
		}catch(Exception e){
			e.printStackTrace();
			return new Result(false, "注销失败");
		}
	}

}
