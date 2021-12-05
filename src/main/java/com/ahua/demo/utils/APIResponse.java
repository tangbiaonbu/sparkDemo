package com.ahua.demo.utils;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 唐少
 * @version 1.0
 * @description: TODO
 * @date 2021/12/5 15:51
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class APIResponse<T> {

    private static final String SUCCESS = "success";

    private static final String FAIL = "fail";

    private static final String OTHER = "other";

    private String code;

    private T data;

    private String message;

}
