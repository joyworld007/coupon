package com.example.coupon.domain.converter;

import com.example.coupon.common.BaseConverter;
import com.example.coupon.domain.dto.CouponDto;
import com.example.coupon.domain.entity.Coupon;

public class CouponConverter extends BaseConverter<CouponDto, Coupon> {

    public CouponConverter() {
        super(Coupon::ofDto, CouponDto::ofEntity);
    }
}
