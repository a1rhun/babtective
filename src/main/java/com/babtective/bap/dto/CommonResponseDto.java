package com.babtective.bap.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CommonResponseDto<T> {
    private final boolean success;
    private final int statusCode;
    private final String message;
    private final T data;

    public static <T> CommonResponseDto<T> success(int statusCode, String message, T data) {
        return CommonResponseDto.<T>builder()
                .success(true)
                .statusCode(statusCode)
                .message(message)
                .data(data)
                .build();
    }

    public static CommonResponseDto<?> fail(int statusCode, String message) {
        return CommonResponseDto.builder()
                .success(false)
                .statusCode(statusCode)
                .message(message)
                .data(null)
                .build();
    }
}
