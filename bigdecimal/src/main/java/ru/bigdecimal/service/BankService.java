package ru.bigdecimal.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.bigdecimal.model.BankAccount;
import ru.bigdecimal.repository.BankRepository;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class BankService {
    private final BankRepository bankRepository;


    public void createBankScore (){
        var account = BankAccount.builder().balance(BigDecimal.ONE).build();
        bankRepository.save(account);
    }

    public void addMoneyToBankScore (BigDecimal money, int bankId){
        var bankAccount = getBankAccount(bankId);
        bankAccount.setBalance(bankAccount.getBalance().add(money));
        bankRepository.save(bankAccount);

    }

    public void withdrawMoneyFromBankScore (BigDecimal money, int bankId){
        var account = getBankAccount(bankId);
        account.setBalance(account.getBalance().subtract(money));
        bankRepository.save(account);
    }

    public void transferMoneyFromBankScore (BigDecimal money, int bankIdFrom, int bankIdTo){
        var bankAccountFrom = getBankAccount(bankIdFrom);
        var bankAccountTo = getBankAccount(bankIdTo);
        bankAccountFrom.setBalance(bankAccountFrom.getBalance().subtract(money));
        bankAccountTo.setBalance(bankAccountTo.getBalance().add(money));
        bankRepository.save(bankAccountFrom);
        bankRepository.save(bankAccountTo);
    }

    private BankAccount getBankAccount (int bankId){
        return bankRepository.findById(bankId).orElseThrow();
    }

}
