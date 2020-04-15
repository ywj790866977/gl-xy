package com.gl.service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gl.service.entity.Account;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 账目表 Mapper 接口
 * </p>
 *
 * @author rubyle
 * @since 2020-04-15
 */
@Mapper
public interface AccountMapper extends BaseMapper<Account> {

}
