package tech.qijin.commons.web.pojo;

import tech.qijin.commons.lang.constant.EnumValue;

public enum EnvEnum implements EnumValue {
    PRODUCT(1,"生产环境"), TEST(0,"测试环境");

    EnvEnum(int env, String desc) {
        this.env = env;
        this.desc = desc;
    }

    private int env;
    private String desc;

    @Override
    public int value() {
        return env;
    }

    @Override
    public String desc() {
        return desc;
    }
}
