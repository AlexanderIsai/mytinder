package de.telran.mytinder.repository;

import de.telran.mytinder.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;
import org.springframework.lang.NonNullApi;
import org.springframework.lang.Nullable;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> getUsersByNameStartingWithIgnoreCase(String name);
    @Query("SELECT new User(u.id, u.name, u.rating, u.description) from User u " +
            " where u.name like :name%") //JPQL
    List<User> findAutocomplete3(@Param(value = "name") String name);

    @Query(nativeQuery = true, value = "SELECT * FROM account WHERE name LIKE :name% ") //SQL
    List<User> findAutocomplete2(@Param(value = "name") String name);

    List<User> findUsersByRatingBetween(int from, int to);

    List<User> findUsersByDescriptionContainingIgnoreCase(String text);

    Integer countUsersByDescriptionContainsIgnoreCase(String text);
//    @Query(nativeQuery = true)

    Boolean existsUserById(Long id);
    Page<User> findAll(@NonNull Pageable pageable);
}
