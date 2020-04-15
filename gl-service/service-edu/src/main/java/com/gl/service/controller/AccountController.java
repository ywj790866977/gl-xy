package com.gl.service.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gl.service.entity.Account;
import com.gl.service.service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

;

/**
 * @author rubyle
 * @since 2020-04-15
 */
@Api("账目表")
@RestController
@RequestMapping("/account")
@Slf4j
public class AccountController {

	@Resource
	private AccountService accountService;

	@ApiOperation("列表")
	@GetMapping("/list")
	public ResponseEntity<List<Account>> list() {
		try {
			return ResponseEntity.ok(accountService.list());
		} catch (Exception e) {
			log.error("list error", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@ApiOperation("分页")
	@GetMapping("/list/{pageNum}/{pageSize}")
	public ResponseEntity<IPage<Account>> page(@PathVariable("pageNum")Integer pageNum,@PathVariable("pageSize") Integer pageSize) {
		try {
			return ResponseEntity.ok(accountService.page(pageNum,pageSize));
		} catch (Exception e) {
			log.error("page error", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@ApiOperation("获取详情")
	@GetMapping("/get/{id}")
	public ResponseEntity<Account> get(@PathVariable("id") Long id) {
		try {
			return ResponseEntity.ok(accountService.get(id));
		} catch (Exception e) {
			log.error("get error", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@ApiOperation("添加")
	@PostMapping("/add")
	public ResponseEntity<Void> add(@RequestBody Account account) {
		try {
			accountService.add(account);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			log.error("add error", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@ApiOperation("修改")
	@PostMapping("/modify")
	public ResponseEntity<Void> modify(@RequestBody Account account) {
		try {
			accountService.modify(account);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			log.error("modify error", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@ApiOperation("删除")
	@GetMapping("/delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		try {
			accountService.delete(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			log.error("delete error", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}