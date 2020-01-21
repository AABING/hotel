package com.face.hotel.entity;

import lombok.Data;

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

  private Long id;

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
