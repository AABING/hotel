package com.face.hotel.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Description: ResultCode
 *
 * @author LiBingxiang
 * @version 1.0
 * @date 2019/12/15 23:01
 * @since JDK 1.8
 */
@ApiModel(description = "状态码")
public class ResultCode {
    @ApiModelProperty("请求成功")
    public static final int OK = 200;

    @ApiModelProperty("获取 资源失败")
    public static final int NOT_FIND = 404;

    @ApiModelProperty("增加/修改/删除 资源失败")
    public static final int ERROR = 500;
}
