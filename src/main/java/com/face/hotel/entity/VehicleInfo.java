package com.face.hotel.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Id;
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
    @Id
    @ApiModelProperty("停车位ID")
    private Long id;

    /**
     * 用户ID
     */
    @ApiModelProperty("用户ID")
    private Long userId;

    /**
     * 车牌号
     */
    @ApiModelProperty("车牌号")
    private String carNumber;

    /**
     * 收费率：按小时计算，费用计算方式为(用户退房时间-进入车位时间)×收费率
     */
    @ApiModelProperty("收费率：按小时计算，费用计算方式为(用户退房时间-进入车位时间)×收费率")
    private Integer chargeRates;

    /**
     * 进入车位时间
     */
    @ApiModelProperty("进入车位时间")
    private Date TimeIn;

    /**
     * 离开车位时间
     */
    @ApiModelProperty("离开车位时间")
    private Date TimeOut;

    /**
     * 停车位当前状态
     */
    @ApiModelProperty("停车位当前状态")
    private String status;
}
