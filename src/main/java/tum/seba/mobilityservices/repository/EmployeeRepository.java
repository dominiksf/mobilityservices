package tum.seba.mobilityservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tum.seba.mobilityservices.entity.Employee;
import tum.seba.mobilityservices.entity.User;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Optional<User> findByEmail(String username);

}
