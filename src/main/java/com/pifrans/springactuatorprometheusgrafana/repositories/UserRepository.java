package com.pifrans.springactuatorprometheusgrafana.repositories;


import com.pifrans.springactuatorprometheusgrafana.domains.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
