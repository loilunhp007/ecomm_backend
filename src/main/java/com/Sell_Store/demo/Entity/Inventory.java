package com.Sell_Store.demo.Entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "inventory")
@IdClass(InventoryID.class)
public class Inventory {
    @Id
    @Column(name = "ware_id", columnDefinition = "nvarchar(20)")
    private Long wareid;
    @Id
    @Column(name = "product_ID", columnDefinition = "nvarchar(20)")
    private String productID;
    @Column(name = "quantity",columnDefinition = "int")
    private int quantity;
    @ManyToOne
    @MapsId("productID")
    @JoinColumn(name = "product_id")
    private Product product;
    @ManyToOne
    @MapsId("wareID")
    @JoinColumn(name = "ware_id")
    private WareHouse wareHouse;
}