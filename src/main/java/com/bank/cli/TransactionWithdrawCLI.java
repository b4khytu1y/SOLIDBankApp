package com.bank.cli;

public class TransactionWithdrawCLI {
    private WithdrawOperationCLI withdrawOperationCLI;

    public TransactionWithdrawCLI(WithdrawOperationCLI withdrawOperationCLI) {
        this.withdrawOperationCLI = withdrawOperationCLI;
    }

    public void execute() {
        withdrawOperationCLI.execute();
    }
}