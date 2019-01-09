package cdtu.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cdtu.store.mapper.TbAdminMapper;
import cdtu.store.pojo.PageResult;
import cdtu.store.pojo.Result;
import cdtu.store.pojo.TbAdmin;
import cdtu.store.pojo.TbAdminExample;
import cdtu.store.pojo.TbAdminExample.Criteria;
import cdtu.store.service.AdminService;

/**
 * 服务实现层
 * 
 * @author Administrator
 *
 */
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private TbAdminMapper adminMapper;

	/**
	 * 查询全部
	 */
	@Override
	public List<TbAdmin> findAll() {
		return adminMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		Page<TbAdmin> page = (Page<TbAdmin>) adminMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbAdmin admin) {
		adminMapper.insert(admin);
	}

	/**
	 * 修改
	 */
	@Override
	public void update(TbAdmin admin) {
		String password = DigestUtils.md5DigestAsHex(admin.getPassword().getBytes());
		admin.setPassword(password);
		adminMapper.updateByPrimaryKey(admin);
	}

	/**
	 * 根据ID获取实体
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public TbAdmin findOne(Integer id) {
		return adminMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for (Integer id : ids) {
			adminMapper.deleteByPrimaryKey(id);
		}
	}

	@Override
	public PageResult findPage(TbAdmin admin, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		TbAdminExample example = new TbAdminExample();
		Criteria criteria = example.createCriteria();
		if (admin != null) {
			if (admin.getUsername() != null && admin.getUsername().length() > 0) {
				criteria.andUsernameLike("%" + admin.getUsername() + "%");
			}
			if (admin.getPassword() != null && admin.getPassword().length() > 0) {
				criteria.andPasswordLike("%" + admin.getPassword() + "%");
			}
		}
		Page<TbAdmin> page = (Page<TbAdmin>) adminMapper.selectByExample(example);
		return new PageResult(page.getTotal(), page.getResult());
	}

	@Override
	public Result login(String username, String password) {
		String pwd = DigestUtils.md5DigestAsHex(password.getBytes());
		TbAdminExample example = new TbAdminExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		criteria.andPasswordEqualTo(pwd);
		List<TbAdmin> list = adminMapper.selectByExample(example);
		if (list.size() > 0) {
			return new Result(true, "登录成功");
		} else {
			return new Result(false, "登录失败");
		}
	}

	/**
	 * 查询
	 */
	@Override
	public Result findByNamePwd(String username, String password) {
		TbAdminExample example = new TbAdminExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		criteria.andPasswordEqualTo(password);
		List<TbAdmin> list = adminMapper.selectByExample(example);
		if (list.size() > 0) {
			return new Result(true, "成功");
		} else {
			return new Result(false, "失败");
		}
	}

	@Override
	public void changePwd(TbAdmin admin) {
		adminMapper.updateByPrimaryKeySelective(admin);
	}

}
