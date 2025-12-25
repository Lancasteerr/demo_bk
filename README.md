
# Easy Blog Backend

[English](#english) | [简体中文](#简体中文)

---

## English

A blog system backend built with **Spring Boot**, providing user authentication, article management, pagination, and Redis-based caching.
Suitable for learning, personal projects, and further development.

### Features

- User registration and login
- Article CRUD operations
- Pagination support
- Redis caching
- Secure password hashing
- RESTful API design

### Tech Stack

- Java 17
- Spring Boot 3.x
- Spring Data JPA
- MySQL
- Redis
- Maven

### Project Structure

```yml
src/main/java
├─ controller   // REST APIs
├─ service      // Business logic
├─ dao          // Data access
├─ pojo         // JPA entities
├─ dto          // Data transfer objects
├─ filter       // Filter
├─ util         // Utility
├─ result       // Return code
└─ config       // Configuration
```

### Prerequisites

- JDK 17+
- MySQL 8.x
- Redis 7.x+

### Configuration

Edit `application.yml`:

```yml
spring.datasource.url=jdbc:your_MySQL_url
spring.datasource.username=root
#Change to your SQL password
spring.datasource.password=your_password

#Redis basic connection
spring.data.redis.host=localhost
spring.data.redis.port=6379
#Redis password
spring.data.redis.password=your_password
```

### Run

```bash
mvn spring-boot:run
```

or

```bash
mvn clean package
java -jar target/blog-backend.jar
```

### API Style

- RESTful APIs
- JSON responses
- Simplified pagination response (not exposing `Page` directly)

### Roadmap

-  PV count
-  Comment system
-  API documentation (Swagger / OpenAPI)
-  Rate limiting

[Frontend](https://github.com/Lancasteerr/Easy_blog_frontend)

### License

MIT License

------

## 简体中文

一个基于 **Spring Boot** 的博客系统后端项目，提供用户认证、文章管理、分页查询以及 Redis 缓存支持，适合学习、个人博客和二次开发。

### 功能特性

- 用户注册与登录
- 文章发布、修改、删除
- 文章分页查询
- Redis 缓存加速读取
- 安全的密码加密（Hash）
- RESTful API 设计

### 技术栈

- Java 17
- Spring Boot 3.x
- Spring Data JPA
- MySQL
- Redis
- Maven

### 项目结构
```yml

src/main/java
├─ controller // 接口层（REST API）
├─ service // 业务逻辑层
├─ dao // 数据访问层
├─ pojo // JPA 实体类
├─ dto // 数据传输对象
├─ filter //过滤器
├─ util //工具类
├─ result //返回值
└─ config // 配置类
```
### 环境要求

- JDK 17 或更高版本
- MySQL 8.x
- Redis 6.x+

### 配置说明

修改 `application.yml` 中的数据库和 Redis 配置：

```yml
spring.datasource.url=jdbc:your_MySQL_url
spring.datasource.username=root
#Change to your SQL password
spring.datasource.password=your_password

#Redis basic connection
spring.data.redis.host=localhost
spring.data.redis.port=6379
#Redis password
spring.data.redis.password=your_password
```

### 启动项目

使用 Maven 运行：

```bash
mvn spring-boot:run
```

或打包后运行：

```bash
mvn clean package
java -jar target/blog-backend.jar
```

### 接口规范

- RESTful API 风格
- 统一使用 JSON 返回数据
- 分页接口不直接暴露 `Page` 对象，仅返回必要字段

### Roadmap

-  浏览量统计
-  评论系统
-  Swagger / OpenAPI 文档
-  接口访问限流

[前端仓库](https://github.com/Lancasteerr/Easy_blog_frontend)

### License

MIT License