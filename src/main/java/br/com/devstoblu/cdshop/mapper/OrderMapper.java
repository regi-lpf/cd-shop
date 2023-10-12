package br.com.devstoblu.cdshop.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import br.com.devstoblu.cdshop.dto.OrderDTO;
import br.com.devstoblu.cdshop.model.Order;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderDTO orderToOrderDTO(Order order);
    Order orderDTOToOrder(OrderDTO orderDTO);
    OrderDTO entityToDTO(Order order);
    List<OrderDTO> entitiesToDTOs(List<Order> orders);
    Order dtoToEntity(OrderDTO orderDTO);
}
