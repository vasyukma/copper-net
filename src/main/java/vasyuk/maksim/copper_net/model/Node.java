package vasyuk.maksim.copper_net.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Node {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @NotNull
    private NodeType type;
    @NotNull
    @ManyToOne
    private Node parent;
    @OneToMany
    private Set<Node> children = new HashSet<>();
    @NotNull
    private String shortName;
    @NotNull
    private String longName;
    @NotNull
    private String description;
}
