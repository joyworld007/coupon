package com.example.coupon.controller;

import com.example.coupon.domain.dto.CouponPolicyDto;
import com.example.coupon.domain.entity.CouponPolicy;
import com.example.coupon.service.CouponSerivce;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/coupon-policies")
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
        return new ResponseEntity(CouponPolicyDto.ofEntity(couponSerivce.findById(id)), HttpStatus.OK);
    }
}
