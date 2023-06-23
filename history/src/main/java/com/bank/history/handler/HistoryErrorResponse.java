package com.bank.history.handler;
/**
 * Класс описывающий сообщение об ошибке и время в которое произошла ошибка
 *
 * @author Peshkova Valentina
 */


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class HistoryErrorResponse {
    private String message;
    private long timestamp;

}
