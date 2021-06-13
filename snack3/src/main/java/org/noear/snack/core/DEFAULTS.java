package org.noear.snack.core;

import org.noear.snack.from.Fromer;
import org.noear.snack.from.JsonFromer;
import org.noear.snack.from.ObjectFromer;
import org.noear.snack.to.JsonToer;
import org.noear.snack.to.ObjectToer;
import org.noear.snack.to.Toer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

/**
 * 默认值
 * */
public class DEFAULTS {
    /** 默认特性 */
    public static final int DEF_FEATURES = Feature.QuoteFieldNames.code;
    /** 默认类型的key */
    public static final String DEF_TYPE_KEY = "@type";

    /** 默认时区 */
    public static final TimeZone  DEF_TIME_ZONE = TimeZone.getDefault();
    /** 默认地区 */
    public static final Locale    DEF_LOCALE    = Locale.getDefault();
    /** 默认时间格式器 */
    public static DateFormat DEF_DATETIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", DEF_LOCALE);

    /** 默认对象来源器 */
    public static final Fromer DEF_OBJECT_FROMER = new ObjectFromer();
    /** 默认对象去处器 */
    public static final Toer DEF_OBJECT_TOER   = new ObjectToer();


    /** 默认STRING来源器 */
    public static final Fromer DEF_STRING_FROMER = new JsonFromer();
    /** 默认STRING去处器 */
    public static final Toer DEF_STRING_TOER = new JsonToer();

    /** 默认JSON去处器 */
    public static final Toer DEF_JSON_TOER = new JsonToer();


}
