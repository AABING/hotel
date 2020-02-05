package com.face.hotel.entity;

import lombok.Data;

import javax.persistence.Id;
import java.util.Date;

/**
 * @author: naipan
 * @date: 2020/1/22 15:02
 * @package_name: com.face.hotel.entity
 * @project_name: hotel
 * @description: 消费流水表
 */
@Data
public class BillInfo {

    @Id
    private Long id;

    private Double cost;

    private String name;

    private String description;

    private String fullName;

    private Date time;

    private String transactionId;

    private String shopId;

    private Integer flag;

    private Long userId;

    private String note;

}
