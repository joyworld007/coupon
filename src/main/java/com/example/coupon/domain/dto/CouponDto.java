package com.example.coupon.domain.dto;

import com.example.coupon.domain.entity.Coupon;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class CouponDto {

    private Long id;

    private Long couponPolicyId;

    private Long userId;

    private String status;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;

    protected CouponDto(Coupon entity) {
        this.id = entity.getId();
        this.couponPolicyId = entity.getCouponPolicy().getId();
        this.status = entity.getStatus();
        this.userId = entity.getUserId();
        this.createDate = entity.getCreateDate();
        this.updateDate = entity.getUpdateDate();
    }

    public static CouponDto ofEntity(Coupon entity) {
        return new CouponDto(entity);
    }
}
