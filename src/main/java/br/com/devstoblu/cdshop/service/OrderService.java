package br.com.devstoblu.cdshop.service;

import org.springframework.stereotype.Service;

import br.com.devstoblu.cdshop.dto.OrderDTO;
import br.com.devstoblu.cdshop.mapper.OrderMapper;
import br.com.devstoblu.cdshop.model.Order;
import br.com.devstoblu.cdshop.model.Product;
import br.com.devstoblu.cdshop.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper; // Assuming you have an OrderMapper
    private final ClientService clientService; // Assuming you have a ClientService
    private final ProductService productService; // Assuming you have a ProductService

    public OrderService(OrderRepository orderRepository, OrderMapper orderMapper, ClientService clientService, ProductService productService) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
        this.clientService = clientService;
        this.productService = productService;
    }

    public List<OrderDTO> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orderMapper.entitiesToDTOs(orders);
    }

    public OrderDTO getOrderById(Long orderId) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        return orderOptional.map(orderMapper::entityToDTO).orElse(null);
    }

    public OrderDTO createOrder(OrderDTO orderDTO) {
        // Validate input, perform business logic, etc.

        Order order = orderMapper.dtoToEntity(orderDTO);

        // Set client using the clientService (assuming you have a method to get a client by ID)
        order.setClient(clientService.getClientById(orderDTO.getClientId()));

        // Set products using the productService (assuming you have a method to get products by IDs)
        List<Long> productIds = orderDTO.getProductIds();
        List<Product> products = productService.getProductsByIds(productIds);
        order.setProducts(products);

        Order savedOrder = orderRepository.save(order);
        return orderMapper.entityToDTO(savedOrder);
    }

    public OrderDTO updateOrder(Long orderId, OrderDTO orderDTO) {
        Optional<Order> existingOrderOptional = orderRepository.findById(orderId);
        if (existingOrderOptional.isPresent()) {
            Order existingOrder = existingOrderOptional.get();

            // Update fields based on orderDTO
            existingOrder.setProducts(productService.getProductsByIds(orderDTO.getProductIds()));

            // Set client using the clientService (assuming you have a method to get a client by ID)
            existingOrder.setClient(clientService.getClientById(orderDTO.getClientId()));

            // Set products using the productService (assuming you have a method to get products by IDs)
            List<Long> productIds = orderDTO.getProductIds();
            List<Product> products = productService.getProductsByIds(productIds);
            existingOrder.setProducts(products);

            // Save the updated entity
            Order updatedOrder = orderRepository.save(existingOrder);
            return orderMapper.entityToDTO(updatedOrder);
        }
        return null;  // Handle the case where the order is not found
    }

    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }
}