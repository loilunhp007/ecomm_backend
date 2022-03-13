package com.Sell_Store.demo.Entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Setter
@Getter
@Entity
@Table(name="order_detail")
@IdClass(OrderDetail_ID.class)
public class OrderDetail {
    @Id
    @Column(name = "order_ID", columnDefinition = "varchar(20)")
    private String orderID;
    @Id
    @Column(name = "product_ID", columnDefinition = "varchar(20)")
    private String productID;
    @Column(name = "quantity",nullable = false)
    private int quantity;
    @Column(name = "price",nullable = false)
    private String price;
    @Column(name = "deliveryAddress",nullable = false)
    private String deliveryAddress;
    @Column(name = "destination",nullable = false)
    private String destination;
    @Column(name = "total",columnDefinition = "NUMERIC(18,2)",nullable = false)
    private String totalItem;
    @Column(name = "userPay",columnDefinition = "NUMERIC(18,2)",nullable = true)
    private Double userPay;
    @ManyToOne
    @JoinColumn(name = "tid")
    private Transport transport;
    @ManyToOne
    @MapsId("productID")
    @JoinColumn(name = "product_id")
    private Product product;
    @ManyToOne
    @MapsId("orderID")
    @JoinColumn(name = "order_id")
    private Order order;
    
}
