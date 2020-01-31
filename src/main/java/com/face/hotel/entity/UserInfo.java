package com.face.hotel.entity;

import lombok.Data;

import javax.persistence.Id;

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

  @Id
  private Long id;

  private String name;

  private Integer gender;

  private Integer age;

  private String tel;

  private Integer stayNumber;

  private Integer level;

  private Double consumption;

  private Integer cardType;

  private String cardNumber;

  private String face;

  private Integer status;

  private Double debt;

  private String note;

}
