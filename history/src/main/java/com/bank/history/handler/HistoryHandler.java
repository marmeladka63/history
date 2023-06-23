package com.bank.history.handler;


import com.bank.history.exception.HistoryNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;

/**
 * Обработка стандартных ошибок для информативных ответов клиенту
 *
 * @author Peshkova Valentina
 */


public class HistoryHandler {
    /**
     * Ошибка, когда сущности по указанному  id не существует
     *
     * @param e информация об ошибке
     * @return сообщение, которое было передано
     */


    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<HistoryErrorResponse> handlerException(HistoryNotFoundException e) {
        HistoryErrorResponse response = new HistoryErrorResponse(
                "Person with this id wasn't found!", System.currentTimeMillis());


        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}


