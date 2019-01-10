package cdtu.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cdtu.store.mapper.TbSellerMapper;
import cdtu.store.pojo.PageResult;
import cdtu.store.pojo.Result;
import cdtu.store.pojo.TbSeller;
import cdtu.store.pojo.TbSellerExample;
import cdtu.store.pojo.TbSellerExample.Criteria;
import cdtu.store.service.SellerService;

/**
 * 服务实现层
 * 
 * @author Administrator
 *
 */
@Service
public class SellerServiceImpl implements SellerService {

	@Autowired
	private TbSellerMapper sellerMapper;

	/**
	 * 查询全部
	 */
	@Override
	public List<TbSeller> findAll() {
		return sellerMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		Page<TbSeller> page = (Page<TbSeller>) sellerMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbSeller seller) {
		String password = DigestUtils.md5DigestAsHex(seller.getPassword().getBytes());
		seller.setPassword(password);
		sellerMapper.insert(seller);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for (Integer id : ids) {
			sellerMapper.deleteByPrimaryKey(id);
		}
	}

	/**
	 * 修改
	 */
	@Override
	public void update(TbSeller seller) {
		String password = DigestUtils.md5DigestAsHex(seller.getPassword().getBytes());
		seller.setPassword(password);
		sellerMapper.updateByPrimaryKey(seller);
	}

	/**
	 * 根据ID获取实体
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public TbSeller findOne(Integer id) {
		return sellerMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageResult findPage(TbSeller seller, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		TbSellerExample example = new TbSellerExample();
		Criteria criteria = example.createCriteria();
		if (seller != null) {
			if (seller.getUsername() != null && seller.getUsername().length() > 0) {
				criteria.andUsernameLike("%" + seller.getUsername() + "%");
			}
			if (seller.getPassword() != null && seller.getPassword().length() > 0) {
				criteria.andPasswordLike("%" + seller.getPassword() + "%");
			}
			if (seller.getLicense() != null && seller.getLicense().length() > 0) {
				criteria.andLicenseLike("%" + seller.getLicense() + "%");
			}
			if (seller.getCompany() != null && seller.getCompany().length() > 0) {
				criteria.andCompanyLike("%" + seller.getCompany() + "%");
			}
			if (seller.getScope() != null && seller.getScope().length() > 0) {
				criteria.andScopeLike("%" + seller.getScope() + "%");
			}
		}
		Page<TbSeller> page = (Page<TbSeller>) sellerMapper.selectByExample(example);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * Login
	 */
	@Override
	public Result login(String username, String password) {
		String pwd = DigestUtils.md5DigestAsHex(password.getBytes());
		TbSellerExample example = new TbSellerExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		criteria.andPasswordEqualTo(pwd);
		List<TbSeller> list = sellerMapper.selectByExample(example);
		if (list.size() > 0) {
			return new Result(true, "登录成功");
		} else {
			return new Result(false, "登录失败");
		}
	}

	/**
	 * findByNamePwd
	 */
	@Override
	public Result findByNamePwd(String username, String password) {
		String pwd = DigestUtils.md5DigestAsHex(password.getBytes());
		TbSellerExample example = new TbSellerExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		criteria.andPasswordEqualTo(pwd);
		List<TbSeller> list = sellerMapper.selectByExample(example);
		if (list.size() > 0) {
			return new Result(true, "成功");
		} else {
			return new Result(false, "失败");
		}
	}

}
