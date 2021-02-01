package com.example.coupon.domain.entity;

import com.example.coupon.domain.SellerType;
import com.example.coupon.domain.dto.CouponPolicyDto;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "coupon_policy")
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class CouponPolicy {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @Enumerated(EnumType.STRING)
  private SellerType sellerType;

  private Long sellerId;

  private LocalDateTime createDate;

  private LocalDateTime updateDate;

  @OneToMany(mappedBy = "couponPolicy", fetch = FetchType.LAZY)
  private List<Coupon> couponList = new ArrayList<>();

  @Builder
  public CouponPolicy(String name, SellerType sellerType, Long sellerId) {
    this.name = name;
    this.sellerType = sellerType;
    this.sellerId = sellerId;
    this.createDate = LocalDateTime.now();
    this.updateDate = LocalDateTime.now();
  }

  protected CouponPolicy(CouponPolicyDto dto) {
    this.id = dto.getId();
    this.name = dto.getName();
    this.sellerType = dto.getSellerType();
    this.sellerId = dto.getSellerId();
    this.createDate = dto.getCreateDate();
    this.updateDate = dto.getUpdateDate();
  }

  public static CouponPolicy ofDto(CouponPolicyDto dto) {
    return new CouponPolicy(dto);
  }

}
