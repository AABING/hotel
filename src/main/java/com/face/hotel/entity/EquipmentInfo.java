package com.face.hotel.entity;

import com.sun.org.apache.xpath.internal.objects.XNumber;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Institution csust
 * @Author MeiyuJijieYihou
 * @Description 设备信息类
 * @Date 2020/1/22 下午10:21
 */
@Data
@ApiModel("设备信息")
public class EquipmentInfo {

    /**
     * 设备ID
     */
    @ApiModelProperty("设备ID")
    private Long id;

    /**
     * 设备编号
     */
    @ApiModelProperty("设备编号")
    private Long number;

    /**
     * 设备当前所在位置
     */
    @ApiModelProperty("设备当前所在位置")
    private String location;

    /**
     * 设备当前状态
     */
    @ApiModelProperty("设备当前状态")
    private String status;

    /**
     * 设备运行时间
     */
    @ApiModelProperty("设备运行时间")
    private String runTime;

    /**
     * 人面识别总次数
     */
    @ApiModelProperty("人面识别总次数")
    private Integer totalTimes;

    /**
     * 人面识别成功次数
     */
    @ApiModelProperty("人面识别成功次数")
    private Integer successTimes;
}
