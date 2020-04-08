package ru.voskhod.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.voskhod.entity.Node;
import ru.voskhod.repository.NodeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class NodeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NodeRepository nodeRepository;

    @BeforeEach
    void setUp() {
        List<Node> all = new ArrayList<>();
        Node node = new Node().setId(1L).setTitle("Title").setParent(null);
        all.add(node);
        when(nodeRepository.findAll()).thenReturn(all);
        when(nodeRepository.findById(1L)).thenReturn(Optional.of(node));
        when(nodeRepository.save(node.setId(null))).thenReturn(node);
        when(nodeRepository.save(node)).thenReturn(node);
    }

    @Test
    void getNode() throws Exception {
        mockMvc.perform(get("/node/1")).andExpect(status().isOk());
    }

    @Test
    void getAll() throws Exception {
        mockMvc.perform(get("/")).andExpect(status().isOk());
    }

    @Test
    void createNode() throws Exception {
        mockMvc.perform(
                post("/node/new")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":null,\"title\":\"Title\",\"parent\":null}"))
                .andExpect(status().isOk());
    }

    @Test
    void updateNode() throws Exception {
        mockMvc.perform(
                put("/node/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"title\":\"Title\",\"parent\":null}"))
                .andExpect(status().isOk());
    }
}