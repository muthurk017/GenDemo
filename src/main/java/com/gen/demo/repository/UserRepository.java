/*
 * the below code generated by Tabnine
 */
/*
 * package com.gen.demo.repository;
 * 
 * import com.gen.demo.domain.User; import
 * org.springframework.data.jpa.repository.JpaRepository; import
 * org.springframework.stereotype.Repository;
 * 
 * import java.util.Optional;
 * 
 * @Repository public interface UserRepository extends JpaRepository<User,
 * String> {
 * 
 * Optional<User> findByUserNameOrEmail(String userName, String email); }
 */

/*below code implemented by GPT
 * 
 */
package com.gen.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gen.demo.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    boolean existsByEmail(String email);
    boolean existsByUserName(String userName);
    
    List<User> findByNameContainingIgnoreCase(String name);
    List<User> findByUserNameContainingIgnoreCase(String userName);
    List<User> findByEmailContainingIgnoreCase(String email);
}