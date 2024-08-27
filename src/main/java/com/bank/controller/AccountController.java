package com.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.models.Account;
import com.bank.services.AccountService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Account Management")
@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @ApiOperation(value = "Получить аккаунт по идентификатору", notes = "Возвращает аккаунт по идентификатору")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Успешное получение аккаунта"),
        @ApiResponse(code = 404, message = "Аккаунт не найден")
    })
    @GetMapping("/{id}")
    public Account getAccount(@PathVariable String id) {
        return accountService.getAccountById(id);
    }

    @ApiOperation(value = "Создать новый аккаунт", notes = "Создает новый аккаунт с указанным типом")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Аккаунт успешно создан"),
        @ApiResponse(code = 400, message = "Неверный запрос, возможно, не указан тип аккаунта")
    })
    @PostMapping
    public boolean createAccount(@RequestBody Account account) {
        // Вызов метода createAccount с типом аккаунта
        return accountService.createAccount(account.getAccountType().name());
    }

    @ApiOperation(value = "Обновить информацию об аккаунте", notes = "Обновляет информацию об аккаунте по идентификатору")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Аккаунт успешно обновлен"),
        @ApiResponse(code = 404, message = "Аккаунт не найден"),
        @ApiResponse(code = 400, message = "Неверный запрос, возможно, предоставлены неверные данные")
    })
    @PutMapping("/{id}")
    public boolean updateAccount(@PathVariable String id, @RequestBody Account account) {
        return accountService.updateAccount(id, account);
    }

    @ApiOperation(value = "Удалить аккаунт по идентификатору", notes = "Удаляет аккаунт по идентификатору")
    @ApiResponses(value = {
        @ApiResponse(code = 204, message = "Аккаунт успешно удален"),
        @ApiResponse(code = 404, message = "Аккаунт не найден")
    })
    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable String id) {
        accountService.deleteAccount(id);
    }
}
