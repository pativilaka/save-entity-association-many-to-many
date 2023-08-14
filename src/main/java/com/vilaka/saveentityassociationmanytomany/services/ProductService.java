package com.vilaka.saveentityassociationmanytomany.services;

import com.vilaka.saveentityassociationmanytomany.dto.CategoryDTO;
import com.vilaka.saveentityassociationmanytomany.dto.ProductDTO;
import com.vilaka.saveentityassociationmanytomany.entities.Category;
import com.vilaka.saveentityassociationmanytomany.entities.Product;
import com.vilaka.saveentityassociationmanytomany.repositories.CategoryRepository;
import com.vilaka.saveentityassociationmanytomany.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional
    public ProductDTO insert(ProductDTO dto){

        Product entity = new Product();
        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());

        for (CategoryDTO catDto : dto.getCategories()){
            Category cat = categoryRepository.getReferenceById(catDto.getId());
            //Category cat = new Category();
            //cat.setId(catDto.getId());
            entity.getCategories().add(cat);
        }

        entity = productRepository.save(entity);
        return new ProductDTO(entity);
    }
}
