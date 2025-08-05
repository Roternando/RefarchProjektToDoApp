package de.muenchen.todo;

import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends PagingAndSortingRepository<TodoEntity, UUID>, CrudRepository<TodoEntity, UUID> {
}
