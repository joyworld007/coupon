package com.example.coupon.service;

import com.example.coupon.domain.dto.CouponPolicyDto;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public interface CouponSerivce {

  @Transactional
  CouponPolicyDto findById(Long id);

  void save(CouponPolicyDto couponPolicyDto);

  void delete(Long id);
}
