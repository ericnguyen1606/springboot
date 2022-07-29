package com.codedecode.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.codedecode.demo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	@Query(value="select * from Users where id = ?1", nativeQuery=true)
	User getUserById(int id);
	

	@Query(value="select * from users u where u.email = :email", nativeQuery=true)
	User findByEmail(@Param("email") String email);

	@Query(value="update users set images = ?1, taxt_number = ?2, phone = ?3, description = ?4 where id = ?5", nativeQuery=true)
	User updateRecruiterById(Long id, User user, MultipartFile file);

}
