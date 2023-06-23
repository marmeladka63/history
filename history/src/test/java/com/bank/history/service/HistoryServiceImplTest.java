package com.bank.history.service;

import com.bank.history.entity.History;
import com.bank.history.repository.HistoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@DisplayName("Бизнес логика")
class HistoryServiceImplTest {
    @Mock
    private HistoryRepository mockRepository;

    @InjectMocks
    private HistoryServiceImpl historyService;

    History history;

    @BeforeEach
    void setUp() {
        history = new History(1L,
                null,
                null,
                null,
                null,
                null,
                null);
    }

    @Test
    @DisplayName("findAll должен вернуть пустой лист когда нет сущностей")
    void testGetAllHistory() {
        // given
        when(mockRepository.findAll()).thenReturn(List.of());

        // when
        List<History> result = historyService.getAllHistory();

        // then
        assertTrue(result.isEmpty());

    }


    @Test
    @DisplayName("findById должен вернуть сущность, когда она существует")
    void testFindHistoryById() {
        // given
        history.setId(1L);
        when(mockRepository.findById(1L)).thenReturn(Optional.of(history));

        // when
        History result = historyService.findHistoryById(1L);

        // then
        verify(mockRepository, times(1)).findById(any());
        assertEquals(result, history);


    }

    @Test
    @DisplayName("Метод save должен вызвать Repository.save()")
    void testSaveHistory() {
        // given

        // when
        historyService.saveHistory(history);

        // then
        verify(mockRepository, times(1)).save(any());

    }

    @Test
    @DisplayName("delete должен вызвать Repository.delete() когда сущность с id существует")
    void testDeleteHistory() {
        // given
        history.setId(1L);
        when(mockRepository.findById(1L)).thenReturn(Optional.of(history));

        // when
        historyService.deleteHistory(1L);

        // then

        verify(mockRepository, times(1)).deleteById(1L);


    }
}

