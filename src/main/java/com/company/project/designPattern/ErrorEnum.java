package com.company.project.designPattern;

public enum ErrorEnum {
    SYSTEM_ERROR("系统错误，请稍候再试", 500),
    SUCCESS("操作成功", 200),
    EXISTS("内容已存在",444);

    private String message;
    private int code;

    ErrorEnum(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }
    public static ErrorEnum forEach_ErrorEnum(int index){
     ErrorEnum [] myArray = ErrorEnum.values();
        for (ErrorEnum errorEnum : myArray) {
           if(index == errorEnum.getCode()){
               return errorEnum;
           }
        }
        return null;
    }

}
