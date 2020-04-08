package ru.voskhod.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "node")
public class Node {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Node parent;

    public Long getId() {
        return id;
    }

    public Node setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Node setTitle(String title) {
        this.title = title;
        return this;
    }

    public Node getParent() {
        return parent;
    }

    public Node setParent(Node parent) {
        this.parent = parent;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(id, node.id) &&
                Objects.equals(title, node.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }
}
