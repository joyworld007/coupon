package com.example.coupon.domain.converter;

import com.example.coupon.common.BaseConverter;
import com.example.coupon.domain.dto.CouponPolicyDto;
import com.example.coupon.domain.entity.CouponPolicy;

public class CouponPolicyConverter extends BaseConverter<CouponPolicyDto, CouponPolicy> {

  public CouponPolicyConverter() {
    super(CouponPolicy::ofDto, CouponPolicyDto::ofEntity);
  }

}
