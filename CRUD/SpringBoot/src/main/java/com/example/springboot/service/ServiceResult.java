package com.example.springboot.service;

public class ServiceResult<T> {
    private T data;
    private boolean success;
    private String message;
    private Status status;

    public ServiceResult(T data, boolean success, String message, Status status) {
        this.data = data;
        this.success = success;
        this.message = message;
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public Status getStatus() {
        return status;
    }

    public enum Status {
        OK(200), CREATED(201), NO_CONTENT(204), BAD_REQUEST(400), UNAUTHORIZED(401),
        FORBIDDEN(403), NOT_FOUND(404), CONFLICT(409), INTERNAL_SERVER_ERROR(500);

        private final int code;

        private Status(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }
    }
}
