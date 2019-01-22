package com.ataccama.homework.persist.repository;

import com.ataccama.homework.persist.entity.ConnectionDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Roman Svoboda
 */
@Repository
public interface ConnectionsRepository extends JpaRepository<ConnectionDetails, Long> {
}


