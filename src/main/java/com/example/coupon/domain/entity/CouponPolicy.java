package com.example.coupon.domain.entity;

import com.example.coupon.domain.SellerType;
import com.example.coupon.domain.dto.CouponPolicyDto;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "coupon")
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class CouponPolicy {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String title;

  @Enumerated(EnumType.STRING)
  private SellerType sellerType;

  private Long sellerId;

  private LocalDateTime createDate;

  private LocalDateTime updateDate;

  @Builder
  public CouponPolicy(String title, SellerType sellerType, Long sellerId) {
    this.title = title;
    this.sellerType = sellerType;
    this.sellerId = sellerId;
    this.createDate = LocalDateTime.now();
    this.updateDate = LocalDateTime.now();
  }

  protected CouponPolicy(CouponPolicyDto dto) {
    this.id = dto.getId();
    this.title = dto.getName();
    this.sellerType = dto.getSellerType();
    this.sellerId = dto.getSellerId();
    this.createDate = dto.getCreateDate();
    this.updateDate = dto.getUpdateDate();
  }

  public static CouponPolicy ofDto(CouponPolicyDto dto) {
    return new CouponPolicy(dto);
  }

}
