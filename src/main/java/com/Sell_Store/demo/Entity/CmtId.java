package com.Sell_Store.demo.Entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CmtId implements Serializable{
    @Column(name = "orderID", columnDefinition = "nvarchar(20)")
    private String orderID;
    @Column(name = "pid",columnDefinition = "nvarchar(20)")
    private String productID;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CmtId cmtId = (CmtId) o;
        return Objects.equals(orderID, cmtId.orderID) &&
                Objects.equals(productID, cmtId.productID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderID, productID);
    }
}
