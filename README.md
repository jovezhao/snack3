Snack3 是一个轻量级的高性能Json框架

###序列化策略
* 使用字段（不使用属性）
* 将Map和Bean设计为：{@type:t,f1:1}，与fastjson类似
* 将集合设计为[{@type:t},[]]

#####特别类型和情况
* 日期
* 大数字
* 枚举
* 泛型类 和 泛型继承
* 集合
* 字典