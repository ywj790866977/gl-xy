package com.gl.service.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gl.service.entity.Account;
import com.gl.service.mapper.AccountMapper;
import com.gl.service.service.AccountService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 账目表 服务实现类
 * </p>
 *
 * @author rubyle
 * @since 2020-04-15
 */
@Service
public class AccountServiceImpl  implements AccountService {
	@Resource
	private AccountMapper accountMapper;


	@Override
	public List<Account> list() {
		return accountMapper.selectList(null);
	}

	@Override
	public IPage<Account> page(Integer pageNum, Integer pageSize) {
		IPage<Account> page = new Page<>(pageNum, pageSize);
		return accountMapper.selectPage(page, null);
	}

	@Override
	public void add(Account account) {
		accountMapper.insert(account);
	}

	@Override
	public void modify(Account account) {
		accountMapper.updateById(account);
	}

	@Override
	public void delete(Long id) {
		accountMapper.deleteById(id);
	}

	@Override
	public Account get(Long id) {
		return  accountMapper.selectById(id);
	}

}
