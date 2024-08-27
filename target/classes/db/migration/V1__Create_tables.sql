CREATE TABLE Account (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    accountNumber VARCHAR(10) NOT NULL,
    clientId VARCHAR(10) NOT NULL,
    balance DECIMAL(19, 2) NOT NULL
);

CREATE TABLE Transaction (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    accountId BIGINT NOT NULL,
    amount DECIMAL(19, 2) NOT NULL,
    transactionType VARCHAR(10) NOT NULL,
    FOREIGN KEY (accountId) REFERENCES Account(id)
);
CREATE TABLE users (
    username VARCHAR(255) PRIMARY KEY,
    password VARCHAR(255) NOT NULL
);
