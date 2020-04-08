package ru.voskhod.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.voskhod.entity.Node;
import ru.voskhod.repository.NodeRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/node")
public class NodeController {

    private static final Logger logger = LogManager.getLogger(NodeController.class);

    @Autowired
    private NodeRepository nodeRepository;

    @GetMapping("/{id}")
    public Node getNode(@PathVariable Long id) {
        logger.info("Request id: {}", id);
        return nodeRepository.findById(id).orElseThrow(() -> new RuntimeException("No such element"));
    }

    @GetMapping("/all")
    public List<Node> getAll() {
        logger.info("Requested all items");
        return nodeRepository.findAll();
    }

    @PostMapping("/new")
    public Node createNode(@RequestBody Node node) {
        logger.info("Create new item");
        return nodeRepository.save(node);
    }

    @PutMapping("/{id}")
    public Node updateNode(@PathVariable Long id, @RequestBody Node node) {
        logger.info("Item for update: {}", node);
        return nodeRepository.save(node);
    }

    @DeleteMapping("/{id}")
    public void deleteNode(@PathVariable Long id) {
        logger.info("Requested item id: {}", id);
        nodeRepository.deleteById(id);
    }
}
