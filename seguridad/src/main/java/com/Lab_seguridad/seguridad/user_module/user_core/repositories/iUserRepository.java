package com.Lab_seguridad.seguridad.user_module.user_core.repositories;

import com.Lab_seguridad.seguridad.user_module.user_core.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface iUserRepository extends CrudRepository<User, Integer> {

    @Query(value = "SELECT * FROM usuario", nativeQuery = true)
    public List<User> getUsersByQuery();

    @Query(value = "SELECT * FROM usuario WHERE usuario= :usuario AND clave= :clave", nativeQuery = true)
    public User getUserByQuery(@Param("usuario") String username, @Param("clave") String password);
}
