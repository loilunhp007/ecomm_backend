package com.Sell_Store.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "comment")
@Entity
@Getter
@Setter
@IdClass(CmtId.class)
public class Comment {
    @Id
    private String orderID;
    @Id
    private String productID;
    private String noidung;
    private String sao;
    @ManyToOne
    @MapsId("orderID")
    @JoinColumn(name = "orderID")
    private Order order;
    @ManyToOne
    @MapsId("pid")
    @JoinColumn(name = "pid")
    private Product product;
}
