package de.muenchen.todo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SubTodoRepository extends PagingAndSortingRepository<SubTodoEntity, UUID>, CrudRepository<SubTodoEntity, UUID>  {
}
