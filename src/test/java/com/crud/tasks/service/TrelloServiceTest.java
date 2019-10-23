package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.*;
import com.crud.tasks.trello.client.TrelloClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TrelloServiceTest {

    @InjectMocks
    private TrelloService trelloService;

    @Mock
    private TrelloClient trelloClient;

    @Mock
    private AdminConfig adminConfig;

    @Test
    public void fetchTrelloBoardsEmptyListTest(){
        //Given
        when(trelloClient.getTrelloBoards()).thenReturn(new ArrayList<>());

        //When
        List<TrelloBoardDto> trelloBoardDtos = trelloService.fetchTrelloBoards();

        //Then
        assertNotNull(trelloBoardDtos);
        assertEquals(0,trelloBoardDtos.size());
    }

    @Test
    public void createTrelloCardTest() {
        //Given
        CreatedTrelloCardDto createdTrelloCardDto = new CreatedTrelloCardDto("1", "name", "url");
        TrelloCardDto trelloCardDto = new TrelloCardDto("name", "description", "position", "1");

        when(trelloClient.createNewCard(trelloCardDto)).thenReturn(createdTrelloCardDto);

        //When
        CreatedTrelloCardDto card = trelloService.createTrelloCard(trelloCardDto);

        //Then
        assertEquals(createdTrelloCardDto.getId(), card.getId());
        assertEquals(createdTrelloCardDto.getName(), card.getName());
        assertEquals(createdTrelloCardDto.getShortUrl(), card.getShortUrl());
    }
}
