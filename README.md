# hx-tms-adl
### 使用技术:
技术 | 名称 | 官网
----|------|----
SpringBoot |  框架 | [https://spring.io/projects/spring-boot](https://spring.io/projects/spring-boot)
MyBatis-Plus | MyBatis增强工具  | [https://mp.baomidou.com/](https://mp.baomidou.com/)
PageHelper | MyBatis物理分页插件  | [http://git.oschina.net/free/Mybatis_PageHelper](http://git.oschina.net/free/Mybatis_PageHelper)
Redis | 分布式缓存数据库  | [https://redis.io/](https://redis.io/)
Logback | 日志组件  | [https://logback.qos.ch/](https://logback.qos.ch/)
maven | 项目构建管理  | [http://maven.apache.org/](http://maven.apache.org/)
Swagger2 | 项目API文档生成及测试工具 | [http://swagger.io/](http://swagger.io/)
Shiro | 用户权限安全管理框架 | [https://shiro.apache.org/](https://shiro.apache.org/)
MySQL | MySQL数据库 | [https://www.mysql.com/](https://www.mysql.com/)
Spring Session | Spring会话管理 | [https://spring.io/projects/spring-session](https://spring.io/projects/spring-session)
hutool-all | hutool工具 | [https://www.hutool.cn/](https://www.hutool.cn/)
## 目录结构
```
├─adl-base-model ：基础领域模型（PO,VO,TO,BO,DAO,POJO存放位置）
│  │  
│  └─src
│      ├─main
│      │  ├─java
│      │  │  └─com
│      │  │      └─huaxin
│      │  │          └─cloud
│      │  │              └─tms
│      │  │                  └─adl
│      │  │                      ├─domain
│      │  │                      │      BaseDomain.java ：所有PO的基础模型被继承
│      │  │                      │      lombok.config ：解决@Data 继承警告
│      │  │                      │      Permission.java : 权限
│      │  │                      │      Role.java ：角色
│      │  │                      │      RolePermission.java ：角色权限关联
│      │  │                      │      User.java ：用户
│      │  │                      │      UserRole.java ：用户角色关联
│      │  │                      │      
│      │  │                      └─vo
│      │  │                              LoginVO.java
│      │  │                              
│      │  └─resources
│      └─test
│          └─java
├─adl-base-rest ：基础接口模块
│  │  pom.xml
│  │  
│  └─src
│      └─main
│          ├─java
│          │  └─com
│          │      └─huaxin
│          │          └─cloud
│          │              └─tms
│          │                  └─adl
│          │                      └─rest
│          │                              LoginRest.java
│          │                              
│          └─resources
├─adl-base-service ：基础业务实现模块
│  │  pom.xml
│  │  
│  └─src
│      └─main
│          ├─java
│          │  └─com
│          │      └─huaxin
│          │          └─cloud
│          │              └─tms
│          │                  └─adl
│          │                      ├─mapper
│          │                      │      PermissionMapper.java
│          │                      │      RoleMapper.java
│          │                      │      RolePermissionMapper.java
│          │                      │      UserMapper.java
│          │                      │      UserRoleMapper.java
│          │                      │      
│          │                      └─service
│          │                          │  PermissionService.java
│          │                          │  RolePermissionService.java
│          │                          │  RoleService.java
│          │                          │  UserRoleService.java
│          │                          │  UserService.java
│          │                          │  
│          │                          └─impl
│          │                                  PermissionServiceImpl.java
│          │                                  RolePermissionServiceImpl.java
│          │                                  RoleServiceImpl.java
│          │                                  UserRoleServiceImpl.java
│          │                                  UserServiceImpl.java
│          │                                  
│          └─resources
├─adl-common ：公用类
│  │  pom.xml
│  │  
│  └─src
│      └─main
│          ├─java
│          │  └─com
│          │      └─huaxin
│          │          └─cloud
│          │              └─tms
│          │                  └─adl
│          │                      ├─enums ：公用枚举（例如状态枚举）
│          │                      │      ResultCodeEnum.java
│          │                      │      
│          │                      ├─exception：公用异常
│          │                      │      HuaxinCloudException.java
│          │                      │      
│          │                      ├─redis ：公用redis
│          │                      │      RedisUtil.java ：redis工具类
│          │                      │      
│          │                      └─rest ：公用接口返回
│          │                              HttpResult.java ：接口统一返回包装类
│          │                              
│          └─resources
├─adl-purchase-model ：采购领域模块
│  │  pom.xml
│  │  
│  └─src
│      ├─main
│      │  ├─java
│      │  └─resources
│      └─test
│          └─java
├─adl-purchase-rest ：采购接口模块
│  │  pom.xml
│  │  
│  └─src
│      ├─main
│      │  ├─java
│      │  └─resources
│      └─test
│          └─java
├─adl-purchase-service ：采购业务实现模块
│  │  pom.xml
│  │  
│  └─src
│      ├─main
│      │  ├─java
│      │  └─resources
│      └─test
│          └─java
├─adl-sale-model ： 销售领域模块
│  │  pom.xml
│  │  
│  └─src
│      ├─main
│      │  ├─java
│      │  └─resources
│      └─test
│          └─java
├─adl-sale-rest ： 销售接口模块
│  │  pom.xml
│  │  
│  └─src
│      ├─main
│      │  ├─java
│      │  └─resources
│      └─test
│          └─java
├─adl-sale-servicel ：销售业务模块
│  │  pom.xml
│  │  
│  └─src
│      ├─main
│      │  ├─java
│      │  └─resources
│      └─test
│          └─java
└─adl-starter ： 项目启动start
    │  pom.xml
    │  
    └─src
        └─main
            ├─java
            │  └─com
            │      └─huaxin
            │          └─cloud
            │              └─tms
            │                  └─adl
            │                      │  AdlStarter.java : 启动类
            │                      │  
            │                      ├─config ：基础配置
            │                      │      AdlStartConfiguration.java ：启动配置
            │                      │      CtrlExceptionHandler.java ：权限异常处理
            │                      │      MybatisPlusConfig.java ： MybatisPlus配置
            │                      │      MyRealm.java ： 自定义Realm配置
            │                      │      MySessionManager.java ：自定义Manager配置
            │                      │      RedisConfig.java ：reids配置
            │                      │      ShiroConfig.java ： Shiro配置
            │                      │      Swagger2Config.java ： Swagger配置
            │                      │      
            │                      └─handler
            │                              MyMetaObjectHandler.java ： 主启动类
            │                              
            └─resources
                │  application.yml
                │  
                └─META-INF
                        spring.factories 
```                        

## 开发环境版本说明
- JDK: OpenJDK8
- MySQL: 8.0+
- SpringBoot: 2.3.x.RELEASE

## 关于持久层
使用mybatis-plus和jpa
- mybatis-plus负责数据交互
- jpa负责项目启动时检查数据库字段自动生成字段和表结构

## 注意事项
- 实体继承BaseDomain.java
- mapper继承BaseMapper.java
- 业务接口继承IService.java
- 业务实现继承ServiceImpl.java 实现 业务接口

## 实体注解含义
常用通用注解 | 含义
----|------
@Data|生成getter、setter方法
@MappedSuperclass | 标记为父类
@JsonForma | json格式化
@ApiModelProperty | swager请求中参数描述
@NoArgsConstructor | 无参构造
@AllArgsConstructor | 全参构造
@ApiModel | 类描述

mybatis-plus注解 | 含义
----|------
@TableId(type = IdType.AUTO) | 主键自增长
@TableField | 实体类映射的数据库字段名（驼峰可不使用）
@TableName | 实体类映射的表名

jpa注解 | 含义
----|------
@Entity | 标记为实体
@Table | 实体类映射的表名
@Id | 主键标识
@GeneratedValue(strategy = GenerationType.AUTO) | 主键自增长
@Column | 实体类映射的数据库字段名（参考[https://blog.csdn.net/qq_16769857/article/details/80347459](https://blog.csdn.net/qq_16769857/article/details/80347459)）