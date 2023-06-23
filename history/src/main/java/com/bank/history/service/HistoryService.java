package com.bank.history.service;

import com.bank.history.entity.History;

import java.util.List;
/**
 * Сервисный интерфейс, обеспечивающий обмен данными между REST контроллером и БД
 *
 *  @author Peshkova Valentina
 */


public interface HistoryService {
    List<History> getAllHistory();
    History findHistoryById(Long id);
    History saveHistory(History history);

    void deleteHistory(Long id);
}
