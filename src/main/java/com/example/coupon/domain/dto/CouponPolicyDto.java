package com.example.coupon.domain.dto;

import com.example.coupon.domain.SellerType;
import com.example.coupon.domain.entity.CouponPolicy;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CouponPolicyDto {

    private Long id;
    private String name;
    private SellerType sellerType;
    private Long sellerId;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private List<CouponDto> couponList;

    protected CouponPolicyDto(CouponPolicy entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.sellerId = entity.getSellerId();
        this.sellerType = entity.getSellerType();
        this.createDate = entity.getCreateDate();
        this.updateDate = entity.getUpdateDate();

        this.couponList = entity.getCouponList().stream().map(
                CouponDto::ofEntity
        ).collect(Collectors.toList());

    }

    public static CouponPolicyDto ofEntity(CouponPolicy entity) {
        return new CouponPolicyDto(entity);
    }

}
