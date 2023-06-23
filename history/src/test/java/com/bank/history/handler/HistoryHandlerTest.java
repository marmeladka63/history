package com.bank.history.handler;

import com.bank.history.exception.HistoryNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

@ExtendWith(SpringExtension.class)
@DisplayName("Обработчик ошибок")
class HistoryHandlerTest {

    @InjectMocks
    private HistoryHandler handler;

    @Test
    void handlerExceptionTest() {

        //given
        HistoryNotFoundException e = mock(HistoryNotFoundException.class);


        // when
        ResponseEntity<HistoryErrorResponse> responseEntity = handler.handlerException(e);

        //then
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());

    }


}