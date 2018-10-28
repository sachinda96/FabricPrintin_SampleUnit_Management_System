/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.dto;

import java.util.List;

/**
 *
 * @author Sachinda Nipun
 */
public class PlaceOrderDTO extends SuperDTO{
    private DesignDTO designDTO;
    private OrderDTO orderDTO;
    private CustomerDTO customerDTO;
    private List<OrderDetailDto> orderDetails;
    private OrderDetail_PKDto orderDetailPKDto;
    private List<OrderDTO> listOrders;

    public PlaceOrderDTO() {
    }

    public PlaceOrderDTO(DesignDTO designDTO, OrderDTO orderDTO, CustomerDTO customerDTO, List<OrderDetailDto> orderDetails, OrderDetail_PKDto orderDetailPKDto, List<OrderDTO> listOrders) {
        this.designDTO = designDTO;
        this.orderDTO = orderDTO;
        this.customerDTO = customerDTO;
        this.orderDetails = orderDetails;
        this.orderDetailPKDto = orderDetailPKDto;
        this.listOrders = listOrders;
    }

    /**
     * @return the designDTO
     */
    public DesignDTO getDesignDTO() {
        return designDTO;
    }

    /**
     * @param designDTO the designDTO to set
     */
    public void setDesignDTO(DesignDTO designDTO) {
        this.designDTO = designDTO;
    }

    /**
     * @return the orderDTO
     */
    public OrderDTO getOrderDTO() {
        return orderDTO;
    }

    /**
     * @param orderDTO the orderDTO to set
     */
    public void setOrderDTO(OrderDTO orderDTO) {
        this.orderDTO = orderDTO;
    }

    /**
     * @return the customerDTO
     */
    public CustomerDTO getCustomerDTO() {
        return customerDTO;
    }

    /**
     * @param customerDTO the customerDTO to set
     */
    public void setCustomerDTO(CustomerDTO customerDTO) {
        this.customerDTO = customerDTO;
    }

    /**
     * @return the orderDetails
     */
    public List<OrderDetailDto> getOrderDetails() {
        return orderDetails;
    }

    /**
     * @param orderDetails the orderDetails to set
     */
    public void setOrderDetails(List<OrderDetailDto> orderDetails) {
        this.orderDetails = orderDetails;
    }

    /**
     * @return the orderDetailPKDto
     */
    public OrderDetail_PKDto getOrderDetailPKDto() {
        return orderDetailPKDto;
    }

    /**
     * @param orderDetailPKDto the orderDetailPKDto to set
     */
    public void setOrderDetailPKDto(OrderDetail_PKDto orderDetailPKDto) {
        this.orderDetailPKDto = orderDetailPKDto;
    }

    /**
     * @return the listOrders
     */
    public List<OrderDTO> getListOrders() {
        return listOrders;
    }

    /**
     * @param listOrders the listOrders to set
     */
    public void setListOrders(List<OrderDTO> listOrders) {
        this.listOrders = listOrders;
    }

    
}
