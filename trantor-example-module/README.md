# Trantor Module

[Trantor Module](https://trantor-interactive-doc.app.terminus.io/doc/marked/developer-guide-module)

## 简介

Trantor模块逻辑上是一个 namespace ，用于划分资源作用域，并使资源可以按模块粒度分发和复用。而当自定义代码需要被部署和调用时，模块又将成为物理上存在的微服务，以分布式的方式提供服务。

模块定义是一个 trantor.yml 文件，需要放置在 api 包内的 resources 目录下，其中定义了模块的 key 、name 、package 、version 和 desc，模块 key 只能由小写字母和下划线组成。package 决定了模块根 package ，也就是定义了 Trantor 扫描模型、ServerAction 等资源的范围）。

## 内嵌模块

Trantor 模块一般来说对应一个部署单元，考虑到有一些轻量级的附属模块，为了方便部署和代码管理，允许在一个主模块中，同时内嵌多个子模块。主模块为必选模块，内嵌的子模块可以在启动时通过配置改变其启用状态。模块正常启动完成后，在交付控制台上会看到多个模块，但是在运行时，对子模块的调用都会路由到同一个 JVM。

```yaml
trantor:
  mainModule: example_module    # trantor.yml 中定义的模块 key
  embedModules:                 # trantor.yml 中定义的模块 key
    - item
    - user
  enabledModuleKeys: item,user  # 本次启用的内嵌模块 key ，多个之间用逗号分隔
```

