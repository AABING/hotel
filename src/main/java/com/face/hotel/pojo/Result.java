package com.face.hotel.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Description: Result
 *ResultCode
 * @author LiBingxiang
 * @version 1.0
 * @date 2020/01/31 13:56
 * @since JDK 1.8
 */
@Data
@ApiModel(description = "响应类")
public class Result<T> {
    @ApiModelProperty("响应码")
    private Integer status;

    @ApiModelProperty("响应数据")
    private T data;

    @ApiModelProperty("响应信息")
    private String massage;

    public Result() {
        this.status = ResultCode.OK;
        this.data = null;
        this.massage = "请求成功";
    }
}
