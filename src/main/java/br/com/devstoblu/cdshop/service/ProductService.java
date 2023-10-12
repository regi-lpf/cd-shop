package br.com.devstoblu.cdshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devstoblu.cdshop.dto.ProductDTO;
import br.com.devstoblu.cdshop.mapper.ProductMapper;
import br.com.devstoblu.cdshop.model.Product;
import br.com.devstoblu.cdshop.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final OrderService orderService;  // Assuming you have an OrderService

    @Autowired
    public ProductService(ProductRepository productRepository, ProductMapper productMapper, OrderService orderService) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.orderService = orderService;
    }

    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return productMapper.entitiesToDTOs(products);
    }

    public ProductDTO getProductById(Long productId) {
        Optional<Product> productOptional = productRepository.findById(productId);
        return productOptional.map(productMapper::entityToDTO).orElse(null);
    }

    public ProductDTO createProduct(ProductDTO productDTO) {
        // Validate input, perform business logic, etc.

        Product product = productMapper.dtoToEntity(productDTO);
        // Set order using the orderService (assuming you have a method to get an order by ID)
        product.setOrder(orderService.getOrderById(productDTO.getOrderId()));
        
        Product savedProduct = productRepository.save(product);
        return productMapper.entityToDTO(savedProduct);
    }

    public ProductDTO updateProduct(Long productId, ProductDTO productDTO) {
        Optional<Product> existingProductOptional = productRepository.findById(productId);
        if (existingProductOptional.isPresent()) {
            Product existingProduct = existingProductOptional.get();

            // Update fields based on productDTO
            existingProduct.setPrice(productDTO.getPrice());
            existingProduct.setTitle(productDTO.getTitle());

            // Set order using the orderService (assuming you have a method to get an order by ID)
            existingProduct.setOrder(orderService.getOrderById(productDTO.getOrderId()));

            // Save the updated entity
            Product updatedProduct = productRepository.save(existingProduct);
            return productMapper.entityToDTO(updatedProduct);
        }
        return null;  // Handle the case where the product is not found
    }

    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }
}