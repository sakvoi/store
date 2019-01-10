package cdtu.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cdtu.store.mapper.TbCustomerMapper;
import cdtu.store.pojo.PageResult;
import cdtu.store.pojo.Result;
import cdtu.store.pojo.TbCustomer;
import cdtu.store.pojo.TbCustomerExample;
import cdtu.store.pojo.TbCustomerExample.Criteria;
import cdtu.store.service.CustomerService;

/**
 * 服务实现层
 * 
 * @author Administrator
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private TbCustomerMapper customerMapper;

	/**
	 * 查询全部
	 */
	@Override
	public List<TbCustomer> findAll() {
		return customerMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		Page<TbCustomer> page = (Page<TbCustomer>) customerMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbCustomer customer) {
		String password = DigestUtils.md5DigestAsHex(customer.getPassword().getBytes());
		customer.setPassword(password);
		customerMapper.insert(customer);
	}

	/**
	 * 修改
	 */
	@Override
	public void update(TbCustomer customer) {
		String password = DigestUtils.md5DigestAsHex(customer.getPassword().getBytes());
		customer.setPassword(password);
		customerMapper.updateByPrimaryKey(customer);
	}

	/**
	 * 根据ID获取实体
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public TbCustomer findOne(Integer id) {
		return customerMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for (Integer id : ids) {
			customerMapper.deleteByPrimaryKey(id);
		}
	}

	@Override
	public PageResult findPage(TbCustomer customer, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		TbCustomerExample example = new TbCustomerExample();
		Criteria criteria = example.createCriteria();
		if (customer != null) {
			if (customer.getUsername() != null && customer.getUsername().length() > 0) {
				criteria.andUsernameLike("%" + customer.getUsername() + "%");
			}
			if (customer.getPassword() != null && customer.getPassword().length() > 0) {
				criteria.andPasswordLike("%" + customer.getPassword() + "%");
			}
			if (customer.getRealname() != null && customer.getRealname().length() > 0) {
				criteria.andRealnameLike("%" + customer.getRealname() + "%");
			}
			if (customer.getSex() != null && customer.getSex().length() > 0) {
				criteria.andSexLike("%" + customer.getSex() + "%");
			}
			if (customer.getIdcard() != null && customer.getIdcard().length() > 0) {
				criteria.andIdcardLike("%" + customer.getIdcard() + "%");
			}
			if (customer.getEmail() != null && customer.getEmail().length() > 0) {
				criteria.andEmailLike("%" + customer.getEmail() + "%");
			}
			if (customer.getTel() != null && customer.getTel().length() > 0) {
				criteria.andTelLike("%" + customer.getTel() + "%");
			}
			if (customer.getAddress() != null && customer.getAddress().length() > 0) {
				criteria.andAddressLike("%" + customer.getAddress() + "%");
			}
			if (customer.getCode() != null && customer.getCode().length() > 0) {
				criteria.andCodeLike("%" + customer.getCode() + "%");
			}
		}
		Page<TbCustomer> page = (Page<TbCustomer>) customerMapper.selectByExample(example);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 登录
	 */
	@Override
	public Result login(String username, String password) {
		String pwd = DigestUtils.md5DigestAsHex(password.getBytes());
		TbCustomerExample customerExample = new TbCustomerExample();
		Criteria criteria = customerExample.createCriteria();
		criteria.andUsernameEqualTo(username);
		criteria.andPasswordEqualTo(pwd);
		List<TbCustomer> list = customerMapper.selectByExample(customerExample);
		if (list.size() > 0) {
			return new Result(true, "登录成功");
		} else {
			return new Result(false, "登录失败");
		}
	}

	/**
	 * 注册
	 */
	@Override
	public void register(TbCustomer customer) {
		String password = DigestUtils.md5DigestAsHex(customer.getPassword().getBytes());
		customer.setPassword(password);
		customerMapper.insertSelective(customer);
	}

	@Override
	public Result findByNamePwd(String username, String password) {
		String pwd = DigestUtils.md5DigestAsHex(password.getBytes());
		TbCustomerExample customerExample = new TbCustomerExample();
		Criteria criteria = customerExample.createCriteria();
		criteria.andUsernameEqualTo(username);
		criteria.andPasswordEqualTo(pwd);
		List<TbCustomer> list = customerMapper.selectByExample(customerExample);
		if (list.size() > 0) {
			return new Result(true, "登录成功");
		} else {
			return new Result(false, "登录失败");
		}
	}
}
