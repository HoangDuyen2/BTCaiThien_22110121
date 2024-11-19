package iot.star.btcaithien_22110121.Repository;

import iot.star.btcaithien_22110121.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
