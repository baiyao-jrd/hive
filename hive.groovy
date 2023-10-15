// 1. 写SQL时需要注意的几个点儿
    1) 规范书写格式, 记得缩进, 尤其是在层层嵌套的sql中, 缩进能让逻辑更清晰
    2) xxx as `field`, 注意这个飘号, 别名用的是飘号, 那么在where筛选的时候也得加上飘号, 飘号代表字段
    3) rank(排序不连续, 存在重复), dense_rank(排序连续, 存在重复), row_number(排序连续, 自增) -> 这几个注意区别

// 2. Mysql的3个经典版本
    1) 5.6
    2) 5.7
    3) 8.0 -> 被oracle公司收购了 -> sql的窗口函数在8.0以后才能用

// 3. win系统下便捷安装数据库 -> 可以多版本切换Mysql
xp.cn -> phpstudy

// 4. Mysql端口号
3306

// 5. Navicat -> 连接数据库
主机(localhost), 端口(3306), 用户名, 密码

// 6. Mysql内置的四个数据库 -> 勿删
    1) information_schema
    2) mysql -> 这个库一删掉整个Mysql就无法启动了
    3) performance_schema
    4) sys

// 7. Mysql建库建表原则
理论上 -> 一个项目对应一个数据库 -> 一个项目的每一个功能对应一张表

// 8. Mysql数据类型
enum -> 枚举类型 

// 9. Mysql注释
单行注释 -> 1) -- 注释1
        -> 2) # 注释2

多行注释 -> /* 注释3 */

// 10. Mysql中最常用到的5个查询子句 -> 顺序是固定的不能颠倒
select
    *
from table
① where 子句 -> group by之前执行
② group by 子句
③ having 子句 -> 分组之后再执行
④ order by 子句 -> asc, desc
⑤ limit 子句 -> 只获取指定条数

// 11. 查询语句
    1) 查询所有信息:
        select
            *
        from a
    2) 查询指定列(字段)信息
        select
            id,
            name
        from a
    3) where子句 -> =, !=, <>, >, <, >=, <=, and(与), or(或), not(非)
        select
            *
        from a
        where name = 'baiyao';

        select
            *
        from a
        where name <> 'jrd' and age = 34;

        select
            *
        from a
        where id not in (1, 3, 5);
    4) like模糊查询 -> 1) % 代表任意字符, 数量不固定
                   -> 2) _ 代表任意某个字符
        
        // 找姓孙的
        where name like '孙%';  -> 开头 '孙%'
                                -> 结尾 '%悟空'
                                -> 中间 '%润%'

        // 找姓孙的, 同时姓名是两个字儿
        where name like '孙_';

    5) 空值判断
        where age is null;

        where age is not null;

    6) order by 子句
        order by age asc; 字典序升序 -> 排序过程中null会被当成最小值

        order by name desc, age asc; name字典序降序, age字典序升序 -> 排序过程中null会被当成最小值

    7) limit子句 -> 限制查询数量
        order by age desc limit 1; // 年龄最大的

        两个参数的 -> 开始的偏移量位置, 查询数量 -> 第一条数据的偏移量是0

        // 从偏移量1开始查询, 查询两条数据
        order by age desc limit 1, 2; // 找年龄第二大和第三大的
    
