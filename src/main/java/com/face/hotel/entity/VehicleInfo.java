package com.face.hotel.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Id;

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
    @Id
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
     * 收费率：按小时计算，费用计算方式为(用户退房时间-进入车位时间)×收费率
     */
    @ApiModelProperty("收费率：按小时计算，费用计算方式为(用户退房时间-进入车位时间)×收费率")
    private String chargeRates;

    /**
     * 进入车位时间
     */
    @ApiModelProperty("进入车位时间")
    private String in;

    /**
     * 离开车位时间
     */
    @ApiModelProperty("离开车位时间")
    private String out;

    /**
     * 停车位当前状态(0无车，1有车，-1不可使用)
     */
    @ApiModelProperty("停车位当前状态")
    private Integer status;
}
