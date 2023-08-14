package com.vilaka.saveentityassociationmanytomany.dto;

import com.vilaka.saveentityassociationmanytomany.entities.Category;
import com.vilaka.saveentityassociationmanytomany.entities.Product;

import java.util.HashSet;
import java.util.Set;

public class ProductDTO {

    private Long id;
    private String name;
    private Double price;
    private Set<CategoryDTO> categories = new HashSet<>();

    public ProductDTO(Long id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public ProductDTO(Product entity){
        id = entity.getId();
        name = entity.getName();
        price = entity.getPrice();
        for (Category cat : entity.getCategories()){ //Para cada Category (chamo de cat) dentro do meu entity.categories
            categories.add(new CategoryDTO(cat)); //Adicionarei à catDto uma instância de catDto da cat
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Set<CategoryDTO> getCategories() {
        return categories;
    }
}
