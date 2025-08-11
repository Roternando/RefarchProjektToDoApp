package de.muenchen.todo;

import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubTodoRepository extends PagingAndSortingRepository<SubTodoEntity, UUID>, CrudRepository<SubTodoEntity, UUID> {
}
