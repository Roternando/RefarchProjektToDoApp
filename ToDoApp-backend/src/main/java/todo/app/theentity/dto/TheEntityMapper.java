package todo.app.theentity.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import todo.app.theentity.TheEntity;

@Mapper
public interface TheEntityMapper {

    TheEntityResponseDTO toDTO(TheEntity theEntity);

    @Mapping(target = "id", ignore = true)
    TheEntity toEntity(TheEntityRequestDTO theEntityRequestDTO);
}
