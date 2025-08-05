package todo.app.repository;

import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import todo.app.common.TodoEntity;

@Repository
public interface TodoRepository extends PagingAndSortingRepository<TodoEntity, UUID>, CrudRepository<TodoEntity, UUID> {
}
