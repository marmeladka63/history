package com.bank.history.handler.controller;

import com.bank.history.controller.HistoryController;
import com.bank.history.dto.HistoryDto;
import com.bank.history.entity.History;
import com.bank.history.mapper.HistoryMapper;
import com.bank.history.service.HistoryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Import(HistoryController.class)
@ExtendWith(SpringExtension.class)
@WebMvcTest(HistoryController.class)
@DisplayName("Контроллер - история")
class HistoryControllerTest {


    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private MockMvc mockMvc;


    @MockBean
    private HistoryService historyService;


    List<History> getListHistory() {
        HistoryDto firstDto = new HistoryDto(1L, 1L, 1L, 1L, 1L, 1L, 1L);
        History first = HistoryMapper.INSTANCE.toEntity(firstDto);
        HistoryDto secondDto = new HistoryDto(2L, 2L, 2L, 2L, 2L, 2L, 2L);
        History second = HistoryMapper.INSTANCE.toEntity(secondDto);
        return List.of(first, second);
    }


    @Test
    void getAllHistoryTest() throws Exception {

        // given

        // when
        when(historyService.getAllHistory()).thenReturn(getListHistory());

        // then
        mockMvc.perform(MockMvcRequestBuilders.get("/api/history")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }


    @Test
    void getHistoryByIdTest() throws Exception {

        // given
        HistoryDto firstDto = new HistoryDto(1L, 1L, 1L, 1L, 1L, 1L, 1L);
        History first = HistoryMapper.INSTANCE.toEntity(firstDto);

        // when
        when(historyService.findHistoryById(1L)).thenReturn(first);

        // then
        mockMvc.perform(MockMvcRequestBuilders.get("/api/history/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", Matchers.is(1)));
    }

    @Test
    void createHistoryTest() throws Exception {
        // given
        HistoryDto historyDto = new HistoryDto(1L, 1L, 1L, 1L, 1L, 1L, 1L);
        History history = HistoryMapper.INSTANCE.toEntity(historyDto);
        HistoryDto resultDto = new HistoryDto(1L, 1L, 1L, 1L, 1L, 1L, 1L);
        History result = HistoryMapper.INSTANCE.toEntity(resultDto);

        // when

        when(historyService.saveHistory(history)).thenReturn(result);

        // then
        String json = new ObjectMapper().writeValueAsString(history);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/history/").contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", Matchers.is(1)));
    }


    @Test
    void DeleteHistoryTest() throws Exception {

        // when
        doAnswer(invocationOnMock -> null).when(historyService).deleteHistory(2L);
        // then
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/history/2")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


}






