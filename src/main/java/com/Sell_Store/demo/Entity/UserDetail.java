package com.Sell_Store.demo.Entity;
import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.Sell_Store.demo.Utils.StringPrefixedSequenceIdGenerator;
import com.fasterxml.jackson.annotation.JsonFormat;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Data
@Getter
@Setter
@Table(name = "userdetail")
public class UserDetail {
    @Id
    @GenericGenerator(
        name = "uid_seq", 
        strategy = "com.Sell_Store.demo.Utils.StringPrefixedSequenceIdGenerator",
        parameters = {
            @org.hibernate.annotations.Parameter(
                name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
            @org.hibernate.annotations.Parameter(
                name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "U_"),
                @org.hibernate.annotations.Parameter(
                name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
           
            
    @GeneratedValue(generator = "uid_seq",
        strategy = GenerationType.SEQUENCE)  
    @Column(name="uid",updatable = false,nullable = false) 
    private String id;
    @Column(name = "phone",columnDefinition = 
    "nvarchar(20)",length = 12)
    private String phone;
    @Column(name = "firstname",columnDefinition = 
    "nvarchar(20)",length = 20)
    private String firstname;
    @Column(name = "lastname",columnDefinition = 
    "nvarchar(20)",length = 20)
    private String lastname;
    @Column(name = "address",columnDefinition = 
    "nvarchar(100)",length = 100)
    private String address;
    @Column(name="birthday")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date birthday;
    @Column(name = "gmail",columnDefinition = 
    "nvarchar(20)",length = 20)
    private String gmail;
    @Column(name="timestamp", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP",nullable = false, updatable = false,insertable = false)
    @CreationTimestamp
    private Timestamp timestamp; 

    @Column(name = "state",columnDefinition = 
    "int")
    private int state;
    @ManyToOne
    @JoinColumn(name = "typemember_id",referencedColumnName = "typeID")
    private TypeMember typeMember;
}
