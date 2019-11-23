package org.noear.snack.core;

import org.noear.snack.ONode;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 处理上下文对象
 * */
public class Context {
    /** 常量配置 */
    public final Constants config;

    /** 来源 */
    public Object source;

    /** 目标 */
    public Object target;
    public Class<?> target_clz;
    public Type     target_type;

    /**
     * 用于来源处理的构造
     */
    public Context(Constants config, Object from) {
        this.config = config;
        this.source = from;
    }

    /**
     * 用于去处的构造
     */
    public Context(Constants config, ONode node, Class<?> target_type) {
        this.config = config;
        this.source = node;

        if (target_type == null) {
            return;
        }

        if (target_type.getName().indexOf("$") > 0) {
            //
            // 临时类：
            //      (new ArrayList<UserModel>(){}).getClass()
            //      (new UserModel(){}).getClass();
            //
            Type type = target_type.getGenericSuperclass();

            if (type instanceof ParameterizedType) {
                ParameterizedType pType = (ParameterizedType) type;

                this.target_type = type;
                this.target_clz = (Class<?>) pType.getRawType();
            } else {
                this.target_type = type;
                this.target_clz = (Class<?>) type;
            }
        } else {
            this.target_type = target_type;
            this.target_clz = target_type;
        }
    }

    /**
     * 使用代理对当前上下文进行处理
     */
    public Context handle(Handler handler)  {
        try {
            handler.handle(this);
            return this;
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
}
