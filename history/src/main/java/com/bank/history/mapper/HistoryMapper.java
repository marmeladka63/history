package com.bank.history.mapper;

import com.bank.history.dto.HistoryDto;
import com.bank.history.entity.History;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 *
 * Класс преобразовывающий Entity в DTO и обратно
 *
 *  @author Peshkova Valentina
 */


@Mapper
public interface HistoryMapper {
    HistoryMapper INSTANCE = Mappers.getMapper(HistoryMapper.class);

    HistoryDto toDto(History history);

    History toEntity(HistoryDto historyDto);

}
