package org.example.Repository;

import org.example.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface Repository extends JpaRepository<UserEntity,Long> {

}