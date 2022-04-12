# smbms
java框架课的作业

## 项目背景

smbms是一个超市管理系统

后续补充。。。

## 技术栈

Mybatis+SpringMVC+Spring+MySQL


## 项目实施

后续补充。。。

## MyBatis学习
### 新增一个需求 
1. 定义一个接口、方法、API
2. 定义一个Mapper.xml，写方法所对应的sql，去数据库访问
3. insert、delete、update只有int，select查询需要返回结果，sql字段映射到java的对象
4. 测速我们写的接口中的方法 junit 白盒测试

### mybatis 中的 DAO 接口和 XML 文件里的 SQL 是如何建立关系的？
https://blog.csdn.net/v123411739/article/details/105932248


### resultType 自动映射
Mybatis中使用resultType做自动映射，要注意字段名和POJO的属性名必须一致。若不一致，则需要给字段起别名，保证别名与属性名一致。

### resultMap 手动映射
查询用户表和角色表
```xml
<resultMap id="userList" type="User">
        <!--
        看的是 select user.*,
                     role.roleName
        的role.roleName 
        进行手动映射
        -->
        <result property="userRoleName" column="roleName"/>
    </resultMap>
    <select id="queryUserByUser2" resultMap="userList">
        select user.*,
               role.roleName
        from smbms_user user
        inner join
                smbms_role role
        on
            user.userRole= role.id
        where
            user.userName like CONCAT('%'
            , #{userName}
            , '%')
          and userRole = #{roleId};
    </select>
```
### 实现高级结果的映射
1. 处理一对一的关系
本系统中，一个用户user对应一个角色role。
- 首先要解决，java类怎么支持，一对一的关系。在user模型中
```java
private Role role;
```
处理这种一对一的级联查询：有两种办法：嵌套查询（执行两个sql）和  联合查询
这个是联合查询
```xml
<!--根据roleId 查询用户的角色实现resultMap的高级映射：一对一的关系-->
    <resultMap id="UserListAndRoleResult" type="User">
        <id property="id" column="id"/>
        <result property="userName" column="userName"/>
        <result property="userCode" column="userCode"/>
        <result property="gender" column="gender"/>
        <result property="userRole" column="userRole"/>
        <result property="userRoleName" column="roleName"/>
        <association property="role" javaType="Role">
            <id property="id" column="role_id"/>
            <result property="roleCode" column="roleCOde"/>
            <result property="roleName" column="roleName"/>
        </association>
    </resultMap>
    <select id="getUserListByRoleId" resultMap="UserListAndRoleResult">
        select user.*,
               role.id as role_id,role.roleCode,role.roleName
        from smbms_user as user
        inner join
            smbms_role as role
        on
            user.userRole= role.id
        where user.userRole=#{id};
    </select>
```



2. 处理一对多的关系
本系统中，一个用户对应多个地址








