package com.wipro.bank.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.wipro.bank.model.BankUser;

@Repository
public interface BankUserRepository extends JpaRepository<BankUser, Integer>{
	@Query("SELECT c FROM BankUser c WHERE c.balance > :balance")
	List<BankUser> findBankUserBalanceGreaterThan(@Param("balance") int balance);
	
	@Query("SELECT c FROM BankUser c WHERE c.balance < :balance")
	List<BankUser> findBankUserBalanceLessThan(@Param("balance") int balance);
	
}
