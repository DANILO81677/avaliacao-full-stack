package br.com.tokiomarine.evaluationbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.tokiomarine.evaluationbackend.entity.UserFinancialTransfer;

@Repository
public interface IUserFinancialTransferRepository extends JpaRepository<UserFinancialTransfer, Integer> {


}
