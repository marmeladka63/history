package com.bank.history.service;

import com.bank.history.controller.HistoryController;
import com.bank.history.entity.History;
import com.bank.history.repository.HistoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

/**
 * Сервисный слой, обеспечивающий обмен данными между REST контроллером и БД
 *
 * @author Peshkova Valentina
 */

@Service
public class HistoryServiceImpl implements HistoryService {
    private final HistoryRepository historyRepository;
    private final Logger logger = LoggerFactory.getLogger(HistoryController.class);

    @Autowired
    public HistoryServiceImpl(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    @Override
    @Transactional
    public List<History> getAllHistory() {
        logger.info("запущен метод getAllHistory");
        return historyRepository.findAll();
    }

    @Override
    public History findHistoryById(Long id) {
        logger.info("запущен метод findHistoryById");
        Optional<History> historyFromDb = historyRepository.findById(id);
        return historyFromDb.orElseThrow(EntityNotFoundException::new);
    }

    @Override
    @Transactional
    public History saveHistory(History history) {
        logger.info("запущен метод saveHistory");
        return historyRepository.save(history);

    }

    @Override
    public void deleteHistory(Long id) {
        logger.info("запущен метод deleteHistory");
        historyRepository.deleteById(id);
    }


}
