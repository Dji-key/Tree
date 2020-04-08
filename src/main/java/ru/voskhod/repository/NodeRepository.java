package ru.voskhod.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.voskhod.entity.Node;

@Repository
public interface NodeRepository extends JpaRepository<Node, Long> {
}
