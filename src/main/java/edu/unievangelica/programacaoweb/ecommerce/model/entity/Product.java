package edu.unievangelica.programacaoweb.ecommerce.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Blob;

@Getter
@Setter
@Entity
public class Product implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_generator")
    @SequenceGenerator(name = "product_generator", sequenceName = "product_id_seq", allocationSize = 1)
    private Long id;

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    private String brand;

    @NotNull
    @NotEmpty
    private String description;

    @NotNull
    private float price;

    @Lob
    @Column(columnDefinition="mediumblob")
    private byte[] image;

    @ManyToOne
    private Category category;

}
