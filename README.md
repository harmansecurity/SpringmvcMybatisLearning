# springmvc + mybatis 学习

本项目是springmvc+mybatis入门，在学习了某马的教学视频基础上，整理出了源码，学习的过程中可以对照参考下面我提到的brain的博客，写的真的很详细，很认真。这里也附上视频下载地址：链接：`http://pan.baidu.com/s/1c2AHgWC` 密码：`wwt6`。本打算不整理的，但是也当做自己的一个学习过程，方便之后的学习。也建议大家看看[brain的博客和他的学习计划](http://brianway.github.io/category/#project)，我从中收获了很多。

**如果觉得不错，请先在这个仓库上点个 star 吧**，我会继续跟大家分享自己的学习过程。

不定时进行调整和补充，需要关注更新的请 Watch、Star、Fork

-----

## 目录

  - mybatis(由于我的是手写稿，以下分享的笔记链接是来自于brains博客。)
    - [mybatis学习笔记(1)-对原生jdbc程序中的问题总结](http://brianway.github.io/2016/03/08/mybatis-learn-1-jdbc-summary/)
    - [mybatis学习笔记(2)-mybatis概述](http://brianway.github.io/2016/03/08/mybatis-learn-2-mybatis-summary/)
    - [mybatis学习笔记(3)-入门程序一](http://brianway.github.io/2016/03/08/mybatis-learn-3-starting-1/)
    - [mybatis学习笔记(3)-入门程序二](http://brianway.github.io/2016/03/08/mybatis-learn-3-starting-2/)
    - [mybatis学习笔记(4)-开发dao方法](http://brianway.github.io/2016/03/08/mybatis-learn-4-dao/)
    - [mybatis学习笔记(5)-配置文件](http://brianway.github.io/2016/03/08/mybatis-learn-5-configuration/)
    - [mybatis学习笔记(6)-输入映射](http://brianway.github.io/2016/03/08/mybatis-learn-6-input-mapping/)
    - [mybatis学习笔记(7)-输出映射](http://brianway.github.io/2016/03/08/mybatis-learn-7-output-mapping/)
    - [mybatis学习笔记(8)-动态sql](http://brianway.github.io/2016/03/08/mybatis-learn-8-dynamic-sql/)
    - [mybatis学习笔记(9)-订单商品数据模型分析](http://brianway.github.io/2016/03/08/mybatis-learn-9-model-analysis/)
    - [mybatis学习笔记(10)-一对一查询](http://brianway.github.io/2016/03/08/mybatis-learn-10-one-to-one/)
    - [mybatis学习笔记(11)-一对多查询](http://brianway.github.io/2016/03/08/mybatis-learn-11-one-to-many/)
    - [mybatis学习笔记(12)-多对多查询](http://brianway.github.io/2016/03/08/mybatis-learn-12-many-to-many/)
    - [mybatis学习笔记(13)-延迟加载](http://brianway.github.io/2016/03/08/mybatis-learn-13-lazeloading/)
    - [mybatis学习笔记(14)-查询缓存之一级缓存](http://brianway.github.io/2016/03/08/mybatis-learn-14-Cache/)
    - [mybatis学习笔记(15)-查询缓存之二级缓存](http://brianway.github.io/2016/03/08/mybatis-learn-15-Secondary-Cache/)
    - [mybatis学习笔记(16)-mybatis整合ehcache](http://brianway.github.io/2016/03/08/mybatis-learn-16-ehcache/)
    - [mybatis学习笔记(17)-spring和mybatis整合](http://brianway.github.io/2016/03/08/mybatis-learn-17-integrate-spring/)
    - [mybatis学习笔记(18)-mybatis逆向工程](http://brianway.github.io/2016/03/08/mybatis-learn-18-Reverse-Engineering/)
  - springmvc(由于我的是手写稿，以下分享的笔记链接是来自于brains博客。)
    - [springmvc学习笔记(1)-框架原理和入门配置](http://brianway.github.io/2016/03/30/springmvc-learn-1-Frame-start/)
    - [springmvc学习笔记(2)-非注解的处理器映射器和适配器](http://brianway.github.io/2016/03/30/springmvc-learn-2-Non-annotation/)   
    - [springmvc学习笔记(3)-注解的处理器映射器和适配器](http://brianway.github.io/2016/03/30/springmvc-learn-3-Annotation/)
    - [springmvc学习笔记(4)-前端控制器](http://brianway.github.io/2016/03/30/springmvc-learn-4-Front-controller/)
    - [springmvc学习笔记(5)-入门程序小结](http://brianway.github.io/2016/03/30/springmvc-learn-5-Start-Summary/)
    - [springmvc学习笔记(6)-springmvc整合mybatis(IDEA中通过maven构建)](http://brianway.github.io/2016/03/30/springmvc-learn-6-integrate-mybatis/)
    - [springmvc学习笔记(7)-springmvc整合mybatis之mapper](http://brianway.github.io/2016/03/30/springmvc-learn-7-mapper/)
    - [springmvc学习笔记(8)-springmvc整合mybatis之service](http://brianway.github.io/2016/03/30/springmvc-learn-8-service/)
    - [springmvc学习笔记(9)-springmvc整合mybatis之controller](http://brianway.github.io/2016/03/30/springmvc-learn-9-controller/)
    - [springmvc学习笔记(10)-springmvc注解开发之商品修改功能](http://brianway.github.io/2016/03/30/springmvc-learn-10-annotation-sample/)
    - [springmvc学习笔记(11)-springmvc注解开发之简单参数绑定](http://brianway.github.io/2016/03/30/springmvc-learn-11-annotation-simple-param-binding/)
    - [springmvc学习笔记(12)-springmvc注解开发之包装类型参数绑定](http://brianway.github.io/2016/03/30/springmvc-learn-12-annotation-pack-param-binding/)
    - [springmvc学习笔记(13)-springmvc注解开发之集合类型参数绑定](http://brianway.github.io/2016/03/30/springmvc-learn-13-annotation-collection-param-binding/)
    - [springmvc学习笔记(14)-springmvc校验](http://brianway.github.io/2016/03/30/springmvc-learn-14-validation/)
    - [springmvc学习笔记(15)-数据回显](http://brianway.github.io/2016/03/30/springmvc-learn-15-data-echo/)
    - [springmvc学习笔记(16)-异常处理器](http://brianway.github.io/2016/03/30/springmvc-learn-16-exception/)
    - [springmvc学习笔记(17)-上传图片](http://brianway.github.io/2016/03/30/springmvc-learn-17-picture-upload/)
    - [springmvc学习笔记(18)-json数据交互](http://brianway.github.io/2016/03/30/springmvc-learn-18-json-interaction/)
    - [springmvc学习笔记(19)-RESTful支持](http://brianway.github.io/2016/03/30/springmvc-learn-19-RESTful-support/)
    - [springmvc学习笔记(20)-拦截器](http://brianway.github.io/2016/03/30/springmvc-learn-20-interceptor/)
    - [springmvc学习笔记(21)-springmvc整合mybatis遇到的问题及解决小结](http://brianway.github.io/2016/03/30/springmvc-learn-21-debug-summary/)
    - [springmvc学习笔记(22)-springmvc开发小结](http://brianway.github.io/2016/03/30/springmvc-learn-22-developing-summary/)

	
-----

## 安装和使用

环境准备:

- jdk 1.7+
- java ee IDE+
- mysql 5.1+
- tomcat 7+
- Navicat  for mysql

数据库导入:

- 新建一个数据库,项目中默认的数据库名为 `mybatis_test`
- 导入 [文件夹sql](/sql) 中的 [create.sql](/sql/create.sql) 创建数据表
- 导入 [文件夹sql](/sql) 中的 [data.sql](/sql/data.sql) 添加测试数据

源码导入:

- 将MybatisCode和SpringmvcMybatisCode中的任意子文件夹拷贝出来作为项目根目录,打开即可
- 每个子文件夹的项目请参考 [源码说明](#源码说明)




-----

## 源码说明

MybatisCode和SpringmvcMybatisCode是涉及到的源码，我使用的 IDE 是 Java EE IDE,以下每个子文件夹对应一个 project。

- [mybatis](/MybatisCode/mybatis):mybatis 部分前 16 篇笔记用到的源码
- [spring_mybatis](/MybatisCode/spring_mybatis):mybatis 部分笔记(17)对应的源码
- [mybatis_generator](/MybatisCode/mybatis_generator):逆向工程的源码
- [springmvc001](/SpringmvcMybatisCode/springmvc001):springmvc 前面笔记对应的配置的源码
- [**springmvc_mybatis**](/SpringmvcMybatisCode/springmvc_mybatis):**核心代码**,springmvc 和 mybatis 整合部分的笔记几乎所有的源码


-----

# 联系作者

- [Harman's Personal Website](http://harmansecurity.cn/)
- 邮箱：`lianghui_1994@163.com`

-----

# Lisence

Lisenced under [Apache 2.0 lisence](http://opensource.org/licenses/Apache-2.0)