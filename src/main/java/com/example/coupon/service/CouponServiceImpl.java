package com.example.coupon.service;

import com.example.coupon.domain.entity.CouponPolicy;
import com.example.coupon.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CouponServiceImpl implements CouponSerivce {

  final CouponRepository couponRepository;

  @Override
  public CouponPolicy findById(Long id) {
    return couponRepository.findById(id).get();
  }

  @Override
  public void save(CouponPolicy couponPolicy) {
    couponRepository.save(couponPolicy);
  }

  @Override
  public void delete(Long id) {
    couponRepository.delete(findById(id));
  }
}
