package com.example.coupon.domain.dto;

import com.example.coupon.domain.SellerType;
import com.example.coupon.domain.entity.CouponPolicy;
import java.time.LocalDateTime;

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

  protected CouponPolicyDto(CouponPolicy entity) {
    this.id = entity.getId();
    this.name = entity.getName();
    this.sellerType = entity.getSellerType();
  }

  public static CouponPolicyDto ofEntity(CouponPolicy entity) {
    return new CouponPolicyDto(entity);
  }

}
