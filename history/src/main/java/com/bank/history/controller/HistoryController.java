package com.bank.history.controller;

import com.bank.history.dto.HistoryDto;
import com.bank.history.entity.History;
import com.bank.history.mapper.HistoryMapper;
import com.bank.history.service.HistoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * REST контроллер
 * доступ по /api/history
 * базовые CRUD операции
 *
 * @author Peshkova Valentina
 */


@RestController
@RequestMapping("/api/history")
public class HistoryController {

    private final HistoryService historyService;
    private final Logger logger = LoggerFactory.getLogger(HistoryController.class);

    @Autowired
    public HistoryController(HistoryService historyService) {
        this.historyService = historyService;
    }

    /**
     * /api/history
     * получение списка всех историй аудитов, метод GET
     */
    @GetMapping()
    public ResponseEntity<List<HistoryDto>> getHistoryTab() {
        logger.info("запущен метод getHistoryTab");
        List<HistoryDto> historyDto = historyService.getAllHistory()
                .stream()
                .map(HistoryMapper.INSTANCE::toDto)
                .collect(Collectors.toList());

        return new ResponseEntity<>(historyDto, HttpStatus.OK);
    }

    /**
     * /api/history/{id}
     * получение истории аудитов по id, метод GET
     */
    @GetMapping("/{id}")
    public ResponseEntity<HistoryDto> getHistoryById(@PathVariable Long id) {
        logger.info("запущен метод getHistoryById");
        History history = historyService.findHistoryById(id);
        HistoryDto historyDto = HistoryMapper.INSTANCE.toDto(history);
        return new ResponseEntity<>(historyDto, HttpStatus.OK);
    }


    /**
     * /api/history
     * создание истории, метод POST
     * форма JSON:
     */
    @PostMapping()
    public ResponseEntity<HistoryDto> createHistory(@RequestBody HistoryDto historyDto) {
        logger.info("запущен метод createHistory");
        History history = HistoryMapper.INSTANCE.toEntity(historyDto);
        historyService.saveHistory(history);
        HistoryDto saveDto = HistoryMapper.INSTANCE.toDto(history);

        return new ResponseEntity<>(saveDto, HttpStatus.OK);

    }

    /**
     * /api/history/{id}
     * удаление истории по id, метод DELETE
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteHistory(@PathVariable("id") Long id) {
        logger.info("запущен метод deleteHistory");
        historyService.deleteHistory(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    Integer f

}

