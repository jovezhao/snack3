package org.noear.snack.core;

import org.noear.snack.core.exts.Act1;
import org.noear.snack.from.Fromer;
import org.noear.snack.to.Toer;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 参数配置
 * */
public class Constants {
    /**
     * 默认配置
     */
    public static final Constants def() {
        return of(
                Feature.OrderedField,
                Feature.WriteDateUseTicks,
                Feature.StringNullAsEmpty);
    }

    public static final Constants serialize() {
        return of(
                Feature.OrderedField,
                Feature.BrowserCompatible,
                Feature.WriteClassName);
    }

    public static Constants of(Feature... features) {
        Constants l = new Constants();

        for (Feature f : features) {
            l.features = Feature.config(l.features, f, true);
        }

        return l;
    }



    /**
     * 构建自己
     */
    public Constants build(Act1<Constants> builder) {
        builder.run(this);
        return this;
    }


    private SimpleDateFormat _date_format;

    public String date_format = DEFAULTS.DEF_DATE_FORMAT; //日期格式
    public String type_key = DEFAULTS.DEF_TYPE_KEY;    //类型key
    public TimeZone time_zone = DEFAULTS.DEF_TIME_ZONE;   //时区
    public Locale locale = DEFAULTS.DEF_LOCALE;      //地区
    public int features = DEFAULTS.DEF_FEATURES;    //特性

    //=================

    public Constants() {
        initialize();
    }

    protected void initialize() {
        _date_format = new SimpleDateFormat(date_format, locale);
        features = Feature.config(features, Feature.QuoteFieldNames, true);
    }

    public final String dateToString(Date date) {
        return _date_format.format(date);
    }

    /**
     * 检查是否有特性
     */
    public final boolean hasFeature(Feature feature) {
        return Feature.isEnabled(features, feature);
    }

    /**
     * null string 默认值
     */
    public final String null_string() {
        if (hasFeature(Feature.StringNullAsEmpty)) {
            return "";
        } else {
            return null;
        }
    }
}
