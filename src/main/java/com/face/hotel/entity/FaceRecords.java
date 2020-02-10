package com.face.hotel.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Institution csust
 * @Author MeiyuJijieYihou
 * @Description Waiting fo development.
 * @Date 2020/1/22 下午10:22
 */
@Data
@ApiModel("人面识别记录表")
public class FaceRecords {

    /**
     * 人面识别记录ID
     */
    @ApiModelProperty("人面识别记录ID")
    private Long id;

    /**
     * 人面识别的设备ID（地下停车库出入口、停车位前配备人面识别设备）
     */
    @ApiModelProperty("人面识别的设备ID（地下停车库出入口、停车位前配备人面识别设备）")
    private Long equipmentId;

    /**
     * 设备信息
     */
    @ApiModelProperty("设备信息")
    private String faceInfo;

    /**
     * 人面试被是否通过，true：通过
     */
    @ApiModelProperty("人面试被是否通过，true：通过")
    private Boolean pass;

    /**
     * 识别成功后用户的ID，识别未成功则为null；
     */
    @ApiModelProperty("识别成功后用户的ID，识别未成功则为null；")
    private Long userId;

    /**
     * 识别成功后员工的ID，识别未成功则为null；
     */
    @ApiModelProperty("识别成功后员工的ID，识别未成功则为null；")
    private Long staffId;

    /**
     * 人面识别的时间
     */
    @ApiModelProperty("人面识别的时间")
    private Date time;

}
