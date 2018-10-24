
留言板API文档

| Api名 | 名称 | 返回值 | 返回值 |请求方式|
| --- | --- | --- | --- | --- |
| message/findBySelection | 通过是否为精选查询所有留言 | Message对象或者Null |  int32(0/1)  |  POST  |
| message/list | 查询所有留言 | Message对象或者Null | Null |  POST  |
| message/findByUserId | 通过用户Id查询预约留言 | Message对象或者Null |  UserId  |  POST  |
| message/add | 插入留言 | 1：成功，0：失败 |  UserId&留言内容  |  POST  |
| message/delete | 删除留言 | 1：成功，0：失败 |  MessageId  |  POST  |
| message/beselect | 设置留言为精选 | 1：成功，0：失败 |  MessageId  |  POST  |
| message/noselect | 设置留言为非精选 | 1：成功，0：失败 |  MessageId  |  POST  |
