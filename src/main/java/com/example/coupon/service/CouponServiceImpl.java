package com.example.coupon.service;

import com.example.coupon.domain.converter.CouponPolicyConverter;
import com.example.coupon.domain.dto.CouponPolicyDto;
import com.example.coupon.domain.entity.CouponPolicy;
import com.example.coupon.repository.CouponPolicyRepository;
import java.time.LocalDateTime;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CouponServiceImpl implements CouponSerivce {

  final CouponPolicyRepository couponPolicyRepository;

  @Override
  @Transactional
  public CouponPolicyDto findById(Long id) {
    CouponPolicyConverter couponPolicyConverter = new CouponPolicyConverter();
    return couponPolicyConverter.convertFromEntity(couponPolicyRepository.findById(id).get());
  }

  @Override
  public void save(CouponPolicyDto couponPolicyDto) {
    couponPolicyDto.setCreateDate(LocalDateTime.now());
    couponPolicyDto.setUpdateDate(LocalDateTime.now());
    couponPolicyRepository.save(CouponPolicy.ofDto(couponPolicyDto));
  }

  @Override
  public void delete(Long id) {
    couponPolicyRepository.delete(couponPolicyRepository.findById(id).get());
  }
}
