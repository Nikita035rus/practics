package ru.bigdecimal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bigdecimal.model.BankAccount;

@Repository
public interface BankRepository extends JpaRepository<BankAccount, Integer> {

}
