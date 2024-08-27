# Bank App Delivery

Bank App Delivery - это REST API приложение на основе Spring Boot.
Используется cборка Spring приложения через авто-конфигурацию. Для скрытия очевидных операций и
для улучшения читабельности кода использован lombok.
Для работы с данными используется:
- СУБД h2
- Spring Boot JPA
- Миграции БД с flywaydb

## Документация
Основныe endpoints:

| Метод   | Путь                                | Описание                            |
|---------|-------------------------------------|------------------------------------|
| GET     | /accounts                           | Получение списка счетов            |
| POST    | /accounts                           | Создание нового счета              |
| GET     | /accounts/{account_id}              | Получение информации об одном счете|
| DELETE  | /accounts/{account_id}              | Удаление счета                     |
| POST    | /accounts/{account_id}/withdraw     | Снятие денег со счета              |
| POST    | /accounts/{account_id}/deposit      | Внесение денег на счет             |
| GET     | /accounts/{account_id}/transactions| Получение списка всех транзакций   |

## Требования

- Java 17
- Maven 3.8.x
