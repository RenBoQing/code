package com.rbq.code.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author RenBoQing
 * @date 2022年03月24日 11:33
 * @Description 返回结果集配置类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    private Integer code;
    private String message;
    private T data;
    private Long count;
    public static Result<Object> success(String message) {
        return new Result(0, message, null, null);
    }

    public static Result<Object> fail(String message) {
        return new Result(1, "失败", null, null);
    }

    public static Result<Object> success() {
        return new Result(0, "success", null, null);
    }
    public static Result<Object> success(Object data,Long count) {
        return new Result(0, "success", data, count);
    }

}
