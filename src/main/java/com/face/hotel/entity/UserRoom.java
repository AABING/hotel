package com.face.hotel.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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

  /**
   * 用户ID
   */
  @ApiModelProperty("用户ID")
  private Long userId;


  /**
   * 房间ID
   */
  @ApiModelProperty("房间ID")
  private Long roomId;


  /**
   * 预定时间
   */
  @ApiModelProperty("预定时间")
  private Timestamp scheduledTime;


  /**
   * 入住时间
   */
  @ApiModelProperty("入住时间")
  private Timestamp checkInTime;


  /**
   * 退房时间（用户选择那天的12点）
   */
  @ApiModelProperty("退房时间（用户选择那天的12点）")
  private Integer checkOutTime;
  // private Integer duration;

  /**
   * 是否生效（前台人证识别成功后生效，即不再退款。当天18点以后未退订自动生效）
   */
  @ApiModelProperty("是否生效（前台人证识别成功后生效，即不再退款。当天18点以后未退订自动生效）")
  private Integer effect;

  /**
   * 是否结清消费金额（查一下用户信息表debt，如果未结清则不可退房）
   */
  @ApiModelProperty("是否结清消费金额（查一下用户信息表debt，如果未结清则不可退房）")
  private Integer clearing;

  /**
   * 用户是否需要停车位：0（不需要），1（需要）
   */
  @ApiModelProperty("用户是否需要停车位：0（不需要），1（需要）")
  private Integer Vehicle;

}
