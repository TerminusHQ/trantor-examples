# Trantor Menu Item

[菜单项简介](https://trantor-interactive-doc.app.terminus.io/doc/marked/developer-guide-menu-item)

菜单项的配置 path:resources下的xxx-menu-item.json

`[
   {
   
     "originalKey": "唯一key",   // 必填，对应资源原标识，模块下唯一
     "name": "注册列表",               // 必填，名称
     "routingType": "Action",        // 必填，路由类型
     "desc": "这里是描述",                    // 选填，描述
     "businessDimensionKey":"terminus_trantor_demo_BusinessDimension", // 选填，应用选择菜单按照业务维度过滤（暂未实现）
     "routeKey": "terminus_trantor_demo_User_Register_List"   // 必填，路由地址
   }
 ]`
 
 
 