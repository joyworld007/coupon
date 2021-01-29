package com.example.coupon.controller;

import com.example.coupon.domain.dto.CouponPolicyDto;
import com.example.coupon.domain.entity.CouponPolicy;
import com.example.coupon.service.CouponSerivce;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/coupons")
public class CouponApiController {

  final CouponSerivce couponSerivce;

  @PostMapping
  public ResponseEntity save(@RequestBody CouponPolicyDto couponPolicyDto) {
    couponPolicyDto.setCreateDate(LocalDateTime.now());
    couponPolicyDto.setUpdateDate(LocalDateTime.now());
    couponSerivce.save(CouponPolicy.ofDto(couponPolicyDto));
    return new ResponseEntity(null, HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity getCoupon(@PathVariable(value = "id") Long id) throws Exception {
    return new ResponseEntity(couponSerivce.findById(id), HttpStatus.OK);
  }
}
