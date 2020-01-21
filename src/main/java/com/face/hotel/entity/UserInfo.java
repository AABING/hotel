package com.face.hotel.entity;

import lombok.Data;

/**
 * Description: 用户信息表
 *
 * @author LiBingxiang
 * @version 1.0
 * @date 2020/01/21 23:45
 * @since JDK 1.8
 */
@Data
public class UserInfo {

  private Long id;

  private String name;

  private Integer gender;

  private Integer age;

  private String tel;

  private Integer stayNumber;

  private Integer level;

  private Long consumption;

  private Integer cardType;

  private String cardNumber;

  private String face;

  private Integer status;

  private Long debt;

  private String note;

}
