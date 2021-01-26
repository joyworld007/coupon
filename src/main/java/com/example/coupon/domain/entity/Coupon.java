package com.example.coupon.domain.entity;

import com.example.coupon.domain.SellerType;
import com.example.coupon.domain.dto.CouponDto;
import java.time.LocalDateTime;
import javax.persistence.Column;
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
public class Coupon {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @Enumerated(EnumType.STRING)
  @Column(name = "seller_type")
  private SellerType sellerType;

  private Long sellerId;

  private LocalDateTime createDate;

  private LocalDateTime updateDate;

  @Builder
  public Coupon(String name, SellerType sellerType, Long sellerId) {
    this.name = name;
    this.sellerType = sellerType;
    this.sellerId = sellerId;
    this.createDate = LocalDateTime.now();
    this.updateDate = LocalDateTime.now();
  }

  protected Coupon(CouponDto dto) {
    this.id = dto.getId();
    this.name = dto.getName();
    this.sellerType = dto.getSellerType();
    this.sellerId = dto.getSellerId();
    this.createDate = dto.getCreateDate();
    this.updateDate = dto.getUpdateDate();
  }

  public static Coupon ofDto(CouponDto dto) {
    return new Coupon(dto);
  }

}
