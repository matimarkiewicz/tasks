package com.crud.tasks.config;

import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.trello.client.TrelloClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Objects;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardsPrintTest {

    @Autowired
    TrelloClient trelloClient;

    @Test
    public void boardsPrintTest() {

        List<TrelloBoardDto> trelloBoardDtos = trelloClient.getTrelloBoards();

        trelloBoardDtos.stream()
                .filter(trelloBoardDto -> Objects.nonNull(trelloBoardDto.getId()))
                .filter(trelloBoardDto -> trelloBoardDto.getName().contains("Kodilla"))
                .forEach(System.out::println);
    }
}
