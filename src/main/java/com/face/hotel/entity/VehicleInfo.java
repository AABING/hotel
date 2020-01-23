package com.face.hotel.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Institution csust
 * @Author MeiyuJijieYihou
 * @Description 停车位信息类
 * @Date 2020/1/22 下午10:23
 */
@Data
@ApiModel("停车位信息类")
public class VehicleInfo {


    /**
     * 停车位ID
     */
    @ApiModelProperty("停车位ID")
    private Long id;

    /**
     * 用户ID
     */
    @ApiModelProperty("用户ID")
    private Long useId;

    /**
     * 车牌号
     */
    @ApiModelProperty("车牌号")
    private String carNumber;

    /**
     * 停车位编号
     */
    @ApiModelProperty("停车位编号")
    private String carportNumber;

    /**
     * 停车位类型
     */
    @ApiModelProperty("停车位类型")
    private String type;

    /**
     * 收费率
     */
    @ApiModelProperty("收费率")
    private String chargeRates;

    /**
     * 进入车位时间
     */
    @ApiModelProperty("进入车位时间")
    private Date in;

    /**
     * 离开车位时间
     */
    @ApiModelProperty("离开车位时间")
    private Date out;

    /**
     * 停车位当前状态
     */
    @ApiModelProperty("停车位当前状态")
    private String status;

    /**
     * 停车位总数
     */
    @ApiModelProperty("停车位总数")
    private Integer totalAmount;

    /**
     * 该类型停车位总数
     */
    @ApiModelProperty("该类型停车位总数")
    private Integer typeTotalAmount;

    /**
     * 目前该类型停车位剩余总数
     */
    @ApiModelProperty("目前该类型停车位剩余总数")
    private Integer typeRemnantAmount;
}
