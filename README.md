# smbms
java框架课的作业

## 🐶项目背景

smbms是一个超市管理系统

后续补充。。。

## 🐱技术栈

Mybatis+SpringMVC+Spring+MySQL

## 🐭自己整理的关于Mybatis面试题

https://www.cnblogs.com/bearbrick0/p/16045422.html

## 🐹项目实施

后续补充。。。

## 🐰MyBatis学习
### 🦊新增一个需求 
1. 定义一个接口、方法、API
2. 定义一个Mapper.xml，写方法所对应的sql，去数据库访问
3. insert、delete、update只有int，select查询需要返回结果，sql字段映射到java的对象
4. 测速我们写的接口中的方法 junit 白盒测试

### 🐻mybatis 中的 DAO 接口和 XML 文件里的 SQL 是如何建立关系的？
https://blog.csdn.net/v123411739/article/details/105932248


### 🐼resultType 自动映射
Mybatis中使用resultType做自动映射，要注意字段名和POJO的属性名必须一致。若不一致，则需要给字段起别名，保证别名与属性名一致。

### 🐻‍❄️resultMap 手动映射
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
### 🐨实现高级结果的映射
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
测试
```java
/**
     * 根据roleId 查询用户的角色实现resultMap的高级映射：一对一的关系
     *
     * @author wanglufei
     * @date 2022/4/12 9:20 AM
     */
    @Test
    public void getUserListByRoleId_test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userListByRoleId = mapper.getUserListByRoleId(1);
        System.out.println(userListByRoleId);
        sqlSession.close();
    }
```



2. 处理一对多的关系
本系统中，一个用户对应多个地址，根据用户的id查询多个地址

```java
    //一对多
    private List<Address> addresses;
```

```xml
<!--实现一对多的手动映射-->
    <resultMap id="AddressResult" type="User">
        <id property="id" column="id"/>
        <result property="userName" column="userName"/>
        <result property="userCode" column="userCode"/>
        <result property="gender" column="gender"/>
        <result property="userRole" column="userRole"/>
        <collection property="addresses" ofType="Address">
            <id property="id" column="a_id"/>
            <result property="contact" column="contact"/>
            <result property="addressDesc" column="addressDesc"/>
            <result property="postCode" column="postCode"/>
            <result property="tel" column="tel"/>
        </collection>
    </resultMap>
    <select id="getAddressListByUserId" resultMap="AddressResult">
        select user.*, a.id as a_id, a.contact, a.addressDesc, a.postCode, a.tel
        from smbms_user user inner join smbms_address as a
        on user.id=a.userId
        where user.id=#{id}
    </select>
```
测试

```java
/**
     * 查询一个用户对应的多个地址 实现一对多的查询
     * @author wanglufei
     * @date 2022/4/12 9:53 AM
     */
    @Test
    public void getAddressListByUserId_test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> addressListByUserId = mapper.getAddressListByUserId(1);
        System.out.println(addressListByUserId);
        sqlSession.close();
    }
```



### 🐯更加全面的关于Mybatis的高级映射demo
https://github.com/bearbrick0/Mybatis_test

### 🐸关于好用的插件

我们在对其他表写完增删查改mapper接口和mapper.xml是，会要求测试。我们手写数据表的set方法很麻烦。下面这个插件，就很有帮助。
![image-20220414083344800](https://bearbrick0.oss-cn-qingdao.aliyuncs.com/images/img/202204140833152.png)

<img src="https://bearbrick0.oss-cn-qingdao.aliyuncs.com/images/img/202204140836898.png" alt="image-20220414083654205" style="zoom:50%;" />

### mybatis的缓存

#### 一级缓存
一级缓存: 基于 PerpetualCache 的 HashMap 本地缓存，其存储作用域为 Session，当 Session flush 或 close 之后，该 Session 中的所有 Cache 就将清空，
默认打开一级缓存。
#### 二级缓存

博客链接：https://www.cnblogs.com/bearbrick0/p/16045422.html

### 动态sql
- if
```xml
    <if test="title!=null">
        
    </if>
```


1. 实现多条件的查询
```xml

```
2.

















