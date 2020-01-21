package com.face.hotel.entity;

import lombok.Data;

import java.sql.Timestamp;

/**
 * Description: 入住信息表
 *
 * @author LiBingxiang
 * @version 1.0
 * @date 2020/01/21 23:45
 * @since JDK 1.8
 */
@Data
public class UserRoom {

  private Long userId;

  private Long roomId;

  private Timestamp scheduledTime;

  private Timestamp checkInTime;

  private Integer duration;

  private Integer effect;

  private Integer clearing;

}
