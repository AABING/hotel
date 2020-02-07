package com.face.hotel.entity;

import lombok.Data;

import javax.persistence.Id;
import java.util.Date;

/**
 * @author: naipan
 * @date: 2020/2/6 17:24
 * @package_name: com.face.hotel.entity
 * @project_name: hotel
 * @description:
 */

@Data
public class StaffChecking {
    @Id
    private Long id;

    private String name;

    private Date markBegin;

    private Date markEnd;

    private Integer result;

    private Long staffId;
}
