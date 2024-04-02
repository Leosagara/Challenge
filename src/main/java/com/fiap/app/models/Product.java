package com.fiap.app.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fiap.app.models.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name="product")
@AttributeOverride(name = "id", column = @Column(name = "productId"))
public class Product extends BaseEntity {

    private String productName;
    private String productType;
    private Float productPrice;
    private Integer productQuantity;
    private Long supplierId;
    private Long requestId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="supplierId", referencedColumnName="supplierId", insertable = false, updatable = false)
    @JsonIgnore
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name="requestId", referencedColumnName="requestId", insertable = false, updatable = false)
    private Request request;
}
