package com.bank.history.repository;

import com.bank.history.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Класс, описывающий взаимодействие с таблицей
 *
 * @author Peshkova Valentina
 */

@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {
}
