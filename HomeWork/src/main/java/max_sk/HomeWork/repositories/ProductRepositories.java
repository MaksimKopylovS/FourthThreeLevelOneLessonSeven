package max_sk.HomeWork.repositories;

import max_sk.HomeWork.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepositories extends JpaRepository<Product, Long> {
            //Раскожите пожалуйста как можно переопределять данные методы ?
            //Как можно создавать свои методы?
            //Можно ли создать Клас и имплиментить его от JpaRepository, будут ли данные методы также работать ?
            Optional<Product> findByTitle(String title);
            List<Product> findAllByCostIsGreaterThanEqual(int cost);
            List<Product> findAllByCostIsLessThanEqual(int cost);
            List<Product> findByOrderByCostAsc();
            List<Product> findByOrderByCostDesc();

}
