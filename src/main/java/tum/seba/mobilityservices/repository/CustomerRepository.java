package tum.seba.mobilityservices.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.stereotype.Repository;

import tum.seba.mobilityservices.entity.Customer;
import tum.seba.mobilityservices.entity.User;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {


	@Query("SELECT c FROM Customer c, Rental r, Invoice i WHERE c.id = r.customer.id AND r.invoice = i AND i.isPaid = false")
	public List<Customer> findCustomersWithUnpaidInvoices();

	Optional<User> findByEmail(String Username);
}
