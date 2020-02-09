package com.face.hotel.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Id;

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

  @Id
  private Long userId;

  private Long roomId;

  private String scheduledTime;

  private String checkInTime;

  private String checkOutTime;

  private Integer effect;

  private Integer vehicle;

}
