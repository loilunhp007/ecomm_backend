package com.Sell_Store.demo.Entity;

import lombok.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.Sell_Store.demo.Utils.DatePrefixedSequenceIdGenerator;
import com.Sell_Store.demo.Utils.StringPrefixedSequenceIdGenerator;

import org.hibernate.annotations.GenericGenerator;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Setter
@Getter
@Table(name = "orders")
public class Order {
    @Id
    @GenericGenerator(
        name = "order_seq", 
        strategy = "com.Sell_Store.demo.Utils.StringPrefixedSequenceIdGenerator",
        parameters = {
            @org.hibernate.annotations.Parameter(
                name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
            @org.hibernate.annotations.Parameter(
                name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "Or_"),
                @org.hibernate.annotations.Parameter(
                name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
    @GeneratedValue(generator = "order_seq",
        strategy = GenerationType.SEQUENCE)  
    @Column(name = "orderID",columnDefinition = "nvarchar(20)",nullable = false)
    private String orderID;
    @ManyToOne
    @JoinColumn(name = "uid")
    private UserDetail userDetail;
    @Column(name="starttime", nullable = false)
    private String startTime;
    @Column(name="endtime", nullable = true, updatable = true, insertable = true)
    private String endTime;
    @Column(name = "total",columnDefinition = "double",nullable = false)
    private Double total;
    @Column(name = "state",columnDefinition = "int",nullable = false)
    private int state;
    @OneToOne
    @JoinColumn(name = "payment_id", referencedColumnName = "payment_id")
    private PaymentMethod paymentMethod;
}
