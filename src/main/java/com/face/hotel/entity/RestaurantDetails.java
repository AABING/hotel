package com.face.hotel.entity;

import lombok.Data;

import javax.persistence.Id;

/**
 * Description:
 *
 * @author LiBingxiang
 * @version 1.0
 * @date 2020/01/21 23:45
 * @since JDK 1.8
 */
@Data
public class RestaurantDetails {

  @Id
  private Long id;

  private String name;

  private Double price;

  private Integer number;

  private Double totalPrice;

  private Long infoId;

}
