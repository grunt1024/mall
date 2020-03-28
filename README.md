# 风暴商城
使用主流技术栈开发一个商城系统。

[TOC]



## 项目搭建流程：
### 1，SpringBoot + MyBatis搭建基本骨架

| 编号 |    技术栈    |    详情    |
| :--: | :----------: | :--------: |
|  00  |    数据库    |   MySql    |
|  01  | 数据库连接池 |   Druid    |
|  02  |   ORM 框架   |  MyBatis   |
|  03  |   分页插件   | PageHelper |

- 新建接口通用返回类；

- 定义业务状态码；

- 统一处理异常；

- 完成分页查询接口;

  ```java
      @GetMapping("/list")
      public ApiResponse listBrand(@RequestParam(value = "pageNum",defaultValue = "1")  Integer pageNum, @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize){
          List<PmsBrand> list = brandService.listBrand(pageNum,pageSize);
          return new ApiResponse(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(),list);
      }
  ```



### 2，SpringBoot + MyBatis搭建基本骨架

Swagger-UI是HTML, Javascript, CSS的一个集合，可以动态地根据注解生成在线API文档；

在很久很久之前，我开发接口是这样的，先写接口文档，一个一个填写参数，然后用 postman 测试，接口调通了之后告诉前端，可以进行接口联调了...

现在用 Swagger 你就不用写接口文档了，而且可以直接在页面上进行接口测试，这种感觉怎么说呢，别问，问就是温暖。

使用流程：

- 添加swagger 依赖；
- 配置 swagger，指定使用什么规则生成 API 文档；
- 在需要生成接口文档接口上添加 Swagger注解；
- 重新运行项目，打开http://localhost:8080/swagger-ui.html；

### 3，整合Redis实现缓存功能





