package net.javaguides.springboot.repositories;

import net.javaguides.springboot.models.entities.City;
import net.javaguides.springboot.models.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface CityRepository extends JpaRepository<City, Long>, QuerydslPredicateExecutor<City>
{

}