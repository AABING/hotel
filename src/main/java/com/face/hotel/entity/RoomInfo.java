package com.face.hotel.entity;

import lombok.Data;

import javax.persistence.Id;

/**
 * Description: 客房信息表
 *
 * @author LiBingxiang
 * @version 1.0
 * @date 2020/01/21 23:45
 * @since JDK 1.8
 */
@Data
public class RoomInfo {

  @Id
  private Long id;

  private Long uId;

  private String roomNumber;

  private String type;

  private Integer price;

  private Integer max;

  private String location;

  private Integer status;

  private String equipment;

  private Long staffId;

  private String note;

}
