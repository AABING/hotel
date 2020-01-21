package com.face.hotel.entity;

import lombok.Data;

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

  private Long id;

  private String name;

  private Integer price;

  private Integer number;

  private Long infoId;

}
