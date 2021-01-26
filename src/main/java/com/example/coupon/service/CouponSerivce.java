package com.example.coupon.service;

import com.example.coupon.domain.entity.Coupon;
import org.springframework.stereotype.Service;

@Service
public interface CouponSerivce {

  Coupon findById(Long id);

  void save(Coupon coupon);

  void delete(Long id);
}
