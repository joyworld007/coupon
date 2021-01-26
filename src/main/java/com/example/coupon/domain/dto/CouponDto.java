package com.example.coupon.domain.dto;

import com.example.coupon.domain.SellerType;
import com.example.coupon.domain.entity.Coupon;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CouponDto {

  private Long id;
  private String name;
  private SellerType sellerType;
  private Long sellerId;
  private LocalDateTime createDate;
  private LocalDateTime updateDate;

  protected CouponDto(Coupon entity) {
    this.id = entity.getId();
    this.name = entity.getName();
    this.sellerType = entity.getSellerType();
  }

  public static CouponDto ofEntity(Coupon entity) {
    return new CouponDto(entity);
  }

}
