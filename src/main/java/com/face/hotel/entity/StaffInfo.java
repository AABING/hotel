package com.face.hotel.entity;

import lombok.Data;

import javax.persistence.Id;
import java.util.Date;

/**
 * @author: naipan
 * @date: 2020/1/22 14:51
 * @package_name: com.face.hotel.entity
 * @project_name: hotel
 * @description: 员工信息表
 */


@Data
public class StaffInfo {

  @Id
  private Long id;

  private String name;

  private Integer sex;

  private Date birth;

  private String cardNumber;

  private String tel;

  private String education;

  private String position;

  private Integer wage;

  private String description;

}
