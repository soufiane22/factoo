package dev.soufiane.factoo.client;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, UUID> {
    Optional<Client> findByEmail(String name);
}