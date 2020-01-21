package com.face.hotel.entity;

import lombok.Data;

import java.sql.Timestamp;

/**
 * Description: 餐厅消费记录表
 *
 * @author LiBingxiang
 * @version 1.0
 * @date 2020/01/21 23:45
 * @since JDK 1.8
 */
@Data
public class RestaurantInfo {

  private Long id;

  private Long amount;

  private Timestamp time;

  private String tradeOrderNo;

  private String merchantListNo;

  private Long userId;

  private Integer clearing;

  private String note;

}
