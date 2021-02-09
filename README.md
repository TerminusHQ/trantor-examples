# Trantor Examples

![Trantor](trantor.png)

![Trantor 0.13.0](https://img.shields.io/badge/Trantor-0.13.0-brightgreen.svg)
![JDK 1.8](https://img.shields.io/badge/JDK-1.8-orange.svg)



Trantor特性使用示例，以简单、易懂为标准。将每个概念、特性已Trantor模块的方式罗列出来。帮助新同学快速掌握基于Trantor来开发中后台系统。

> 编译运行当前Examples工程时，请将maven的settings配置为当前工程下的settings.xml

[Trantor Docs](https://trantor-docs.app.terminus.io/)

## 工程结构说明

Trantor 应用为标准 maven 工程，通常包含api和server两个子模块。
**api** 主要放置`模块声明`、`模型`、`字典`、`service interface` 、`DTO` 等可能会被其他模块依赖的内容。
**server** 主要放置逻辑实现并且是真实启动。

```
trantor-example
├── example-api
│   ├── pom.xml
|		└── src
│       ├── main
│       │   ├── java
│       │   │   └── io
│       │   │       └── terminus
│       │   │           └── trantor
│       │   │               └── example
│       │   │                   └── dictionary
│       │   │                   │   └── dictClass.java
│       │   │                   └── model
│       │   │                       └── modelClass.java
│       │   └── resources
│       │       └── trantor.yml
├── example-server
│   ├── pom.xml
|       └── src
│       ├── main
│       │   ├── java
│       │   │   └── io
│       │   │       └── terminus
│       │   │           └── trantor
│       │   │               └── example
│       │   │                   └── Application.java
│       │   └── resources
│       │       └── application.yml
└── pom.xml
```

## Trantor示例代码

考虑到初次接触trantor的同学可能来自各个业务单位或者是刚毕业的实习生，为了摒弃差异化，故采用了学校师生信息管理系统的简单逻辑来帮助大家快速入门。（因为各个模块有一定程度依赖关系，建议按照下面的顺序来学习）

* [trantor-example-module](./trantor-example-module/README.md) : trantor模块的定义
* [trantor-example-model](./trantor-example-model/README.md)  : trantor中模型的定义
* [trantor-example-view](./trantor-example-model/README.md)  : trantor中视图的定义
* [trantor-example-menu-item](./trantor-example-menu-item/README.md)  : trantor中菜单栏的定义
* [trantor-example-data-action](./trantor-example-data-action/README.md)  : trantor中数据行为的定义
* [trantor-example-server-action](./trantor-example-server-action/README.md)  : trantor中逻辑行为的定义
* [trantor-example-tree-action](./trantor-example-tree-action/README.md)  : trantor中tree-action的定义
* [trantor-example-business-dimension](./trantor-example-business-dimension/README.md)  : trantor中业务隔离的定义
* [trantor-example-dashboard](./trantor-example-dashboard/README.md)  : trantor中仪表盘的定义
* [trantor-example-dict](./trantor-example-dict/README.md)  : trantor中字典的定义
* [trantor-example-i18n](./trantor-example-i18n/README.md)  : trantor中国际化的定义
* [trantor-example-dao](./trantor-example-dao/README.md)  : trantor中datastore的定义



## 注意事项
* trantor-examples 仅仅是将各个模块放到该项目下，各个模块之间没有联系（每个模块的侧重点都不一样），不建议在trantor-examples该路径下直接上报所有模块的信息（切到各个模块的根目录，单独上报）。
* 当上报时报错说明是稳定版本的时候，不允许再次上报，只能新增版本,然后修改版本号 重新上报。