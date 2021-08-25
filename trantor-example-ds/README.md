# Trantor DS

[Trantor Model](https://trantor-interactive-doc.app.terminus.io/doc/marked/developer-guide-model)

## 简介
 模型贯穿整个过程，为视图提供交互所需元信息（字段名称、类型、模型间关系等），为行为提供载体（出入参）
 

# 其他相关
trantor 系统默认会为每个持久化模型生成一组 action，格式为:  moduleKey_modelKey_actionName(模型定义时未指定 modelKey 时即为 ModelClassName)

