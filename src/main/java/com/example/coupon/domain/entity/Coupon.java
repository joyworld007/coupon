package com.example.coupon.domain.entity;


import com.example.coupon.domain.dto.CouponDto;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    private Long orderId;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;

    @Builder
    public Coupon(CouponPolicy couponPolicy, Long userId, String status, Long orderId) {
        this.couponPolicy = couponPolicy;
        this.userId = userId;
        this.status = status;
        this.orderId = orderId;
        this.createDate = LocalDateTime.now();
        this.updateDate = LocalDateTime.now();
    }

    protected Coupon(CouponDto dto) {
        this.id = dto.getId();
        this.userId = dto.getUserId();
        this.status = dto.getStatus();
        this.orderId = dto.getOrderId();
        this.createDate = dto.getCreateDate();
        this.updateDate = dto.getUpdateDate();
    }

    public static Coupon ofDto(CouponDto dto) {
        return new Coupon(dto);
    }

}
