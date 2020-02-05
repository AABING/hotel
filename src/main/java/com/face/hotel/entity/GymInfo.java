package com.face.hotel.entity;

import lombok.Data;

import javax.persistence.Id;
import java.util.Date;

/**
 * @author: naipan
 * @date: 2020/1/22 14:59
 * @package_name: com.face.hotel.entity
 * @project_name: hotel
 * @description: 健身房消费记录表
 */
@Data
public class GymInfo {

  @Id
  private Long id;

  private Long userId;

  private Date inTime;

  private Date outTime;

  private Double cost;

  private Double chargeRates;

  private String note;

}
