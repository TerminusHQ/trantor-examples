# Trantor view

[Trantor view](https://trantor-interactive-doc.app.terminus.io/doc/marked/developer-guide-view)

## 简介

视图即页面，承载终端用户的交互动作，呈现模型数据，并发起和响应行为。

在视图资源上，Trantor 提供了一套类 XML 的 DSL 来描述。这套 DSL 的设计目标有三个：

 - 尽可能使开发者无需关注布局、样式和交互，而只关心业务。
 - 可以在所见即所得和编写代码两种方式间无缝切换，双向同步。
 - 平台无关。

## 定义视图

 视图通常对应一个页面，放置在 server 模块的 src/main/resources/trantor/resources/{moduleKey}(moduleKey 即为上面 api模块 里定义的key) 目录下，
 由一个清单文件(view-manifest.json)和一系列 xml + ts/js(自定义数据容器) 文件组成。

