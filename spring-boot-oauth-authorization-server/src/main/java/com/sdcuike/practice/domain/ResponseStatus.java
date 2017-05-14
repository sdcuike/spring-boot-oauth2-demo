package com.sdcuike.practice.domain;

import com.doctor.beaver.domain.result.BaseResult;

import lombok.Getter;

/**
 * @author sdcuike
 *         <p>
 *         Created on 2017-02-09 <br>
 *         返回状态码描述
 */
@Getter
public enum ResponseStatus {
    INTERNAL_SERVER_ERROR("-2", "Internal Spring MVC exceptions"),
    SYS_ERROR("-1", "系统异常，请稍后再试"),
    OK("0", "OK");
    private final String value;

    private final String reasonPhrase;

    private ResponseStatus(String value, String reasonPhrase) {
        this.value = value;
        this.reasonPhrase = reasonPhrase;
    }

    public <T extends BaseResult> void setResponseStatus(T result) {
        result.setReturnCode(value);
        result.setReturnMsg(reasonPhrase);
    }
}
