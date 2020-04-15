package com.gl.service.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gl.service.entity.Account;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * <p>
 * Account服务类
 * </p>
 *
 * @author rubyle
 * @since 2020-04-15
 */
@Service
public interface AccountService  {

	List<Account> list();

    IPage<Account> page(Integer pageNum,Integer pageSize);

    void add(Account account);

	void modify(Account account);

    void   delete(Long id);

	Account get(Long id);
}