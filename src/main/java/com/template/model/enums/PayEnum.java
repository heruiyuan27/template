package com.template.model.enums;


public enum PayEnum {
    // 枚举常量（必须放在最前面）
    AliPay(1),
    UnionPay(2),
    TencentPay(3);

    // 私有属性字段
    private final int code;

    // 构造方法（必须是 private，可省略 private 修饰符）
    PayEnum(int code) {
        this.code = code;
    }

    // 对外提供访问属性的方法
    public int getCode() {
        return code;
    }

    // 可选：通过 code 值获取对应的枚举对象
    public static PayEnum fromCode(int code) {
        for (PayEnum payEnum : PayEnum.values()) {
            if (payEnum.code == code) {
                return payEnum;
            }
        }
        throw new IllegalArgumentException("Invalid status code: " + code);
    }

}
