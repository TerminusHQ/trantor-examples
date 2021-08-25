# Trantor Examples

![Trantor](trantor.png)

![Trantor 0.17.0](https://img.shields.io/badge/Trantor-0.13.0-brightgreen.svg)
![JDK 1.8](https://img.shields.io/badge/JDK-1.8-orange.svg)



Trantor特性使用示例，以简单、易懂为标准。将每个概念、特性已Trantor模块的方式罗列出来。帮助新同学快速掌握基于Trantor来开发中后台系统。

> 编译运行当前Examples工程时，请将maven的settings配置为当前工程下的settings.xml

[Trantor Docs](https://trantor-docs.app.terminus.io/)

## 工程结构说明

通常，工程包含三个模块 `module-api`、`module-impl`、`module-runtime` module-api` 用于申明模型、定义逻辑流、可编排服务等信息，可供其他工程引用，`module-impl` 包含视图、菜单项、逻辑流和可编排服务的实现等信息，
可作为服务提供服务。以下是 demo 的代码组织结构：

- trantor-example-api依赖trantor-api模块
- trantor-example-impl依赖trantor-example-api模块和trantor-sdk模块
- trantor-example-runtime依赖trantor-runtime模块

```
trantor-example
.
├── README.md
├── pom.xml
├── settings.xml
├── trantor-example-api
│   ├── pom.xml
│   ├── src
│   │   ├── main
│   │   │   ├── java
│   │   │   │   └── io
│   │   │   │       └── terminus
│   │   │   │           └── trantor
│   │   │   │               └── example
│   │   │   │                   ├── flow
│   │   │   │                   │   ├── CreateStaffFlow.java
│   │   │   │                   └── model
│   │   │   │                       ├── Staff.java
│   │   │   └── resources
│   │   │       └── trantor.yml
│   └── trantor-example-api.iml
├── trantor-example-impl
│   ├── pom.xml
│   ├── src
│   │   ├── main
│   │   │   ├── java
│   │   │   │   └── io
│   │   │   │       └── terminus
│   │   │   │           └── trantor
│   │   │   │               └── demo
│   │   │   │                   ├── flow
│   │   │   │                   │   └── impl
│   │   │   │                   │       ├── CreateStaffFlowImpl.java
│   │   │   └── resources
│   │   │       └── trantor
│   │   │           └── resources
│   │   │               └── demo
│   │   │                   └── view
│   │   │                       └── Staff
│   │   │                           └── StaffList.view.xml
│   └── trantor-example-impl.iml
├── trantor-demo-runtime
│   ├── pom.xml
│   ├── src
│   │   ├── main
│   │   │   ├── java
│   │   │   │   └── io
│   │   │   │       └── terminus
│   │   │   │           └── trantor
│   │   │   │               └── demo
│   │   │   │                   └── Application.java
│   │   │   └── resources
│   │   │       └── application.yml
│   └── trantor-example-runtime.iml
└── trantor-example.iml
```

## Trantor示例代码

考虑到初次接触trantor的同学可能来自各个业务单位或者是刚毕业的实习生，为了摒弃差异化，故采用了学校师生信息管理系统的简单逻辑来帮助大家快速入门。（因为各个模块有一定程度依赖关系，建议按照下面的顺序来学习）

* [trantor-example-business-context](./trantor-example-business-context/README.md)  : trantor中业务上下文的定
* [trantor-example-business-dimension](./trantor-example-business-dimension/README.md)  : trantor中业务隔离的定义
* [trantor-example-cache](./trantor-example-cache/README.md)  : trantor中缓存的定义
* [trantor-example-dashboard](./trantor-example-dashboard/README.md)  : trantor中仪表盘的定义
* [trantor-example-dict](./trantor-example-dict/README.md)  : trantor中字典的定义
* [trantor-example-logic](./trantor-example-logic/README.md)  : trantor中逻辑流的定义
* [trantor-example-model](./trantor-example-model/README.md)  : trantor中模型的定义
* [trantor-example-namespace](./trantor-example-namespace/README.md) : trantor业务域的定义
* [trantor-example-restapi](./trantor-example-restapi/README.md) : trantor原生api的定义
* [trantor-example-sql](./trantor-example-sql/README.md)  : trantor中sql的定义
* [trantor-example-trigger](./trantor-example-trigger/README.md)  : trantor中触发器的定义
* [trantor-example-view](./trantor-example-view/README.md)  : trantor中视图的定义



## 注意事项
* trantor-examples 仅仅是将各个模块放到该项目下，各个模块之间没有联系（每个模块的侧重点都不一样），不建议在trantor-examples该路径下直接上报所有模块的信息（切到各个模块的根目录，单独上报）。
* 当上报时报错说明是稳定版本的时候，不允许再次上报，只能新增版本,然后修改版本号 重新上报。