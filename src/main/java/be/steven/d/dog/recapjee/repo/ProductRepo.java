package be.steven.d.dog.recapjee.repo;

import be.steven.d.dog.recapjee.model.Product;
import org.springframework.data.repository.CrudRepository;

/**
 * PRODUCT REPOSITORY
 *
 * @author d.Dog
 */
public interface ProductRepo extends CrudRepository<Product, Integer> {
}
