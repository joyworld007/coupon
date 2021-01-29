package com.example.coupon.service;

import com.example.coupon.domain.entity.CouponPolicy;
import org.springframework.stereotype.Service;

@Service
public interface CouponSerivce {

  CouponPolicy findById(Long id);

  void save(CouponPolicy couponPolicy);

  void delete(Long id);
}
