package com.example.coupon.domain.entity;


import com.example.coupon.domain.dto.CouponDto;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "coupon")
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coupon_policy_id")
    @Setter
    private CouponPolicy couponPolicy;

    private Long userId;

    private String status;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;

    @Builder
    public Coupon(CouponPolicy couponPolicy, Long userId, String status) {
        this.couponPolicy = couponPolicy;
        this.userId = userId;
        this.status = status;
        this.createDate = LocalDateTime.now();
        this.updateDate = LocalDateTime.now();
    }

    protected Coupon(CouponDto dto) {
        this.id = dto.getId();
        this.userId = dto.getUserId();
        this.status = dto.getStatus();
        this.createDate = dto.getCreateDate();
        this.updateDate = dto.getUpdateDate();
    }

    public static Coupon ofDto(CouponDto dto) {
        return new Coupon(dto);
    }

}
