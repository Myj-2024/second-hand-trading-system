# 二手物品交易管理系统（second-hand-trade-system）

> 一套基于 Spring Boot + Vue 的前后端分离二手物品交易后台管理系统，提供商品、用户、订单、分类、留言等核心管理功能。

## 项目预览

### 后台主页

![主页预览](https://bu.dusays.com/2026/01/31/697db45ab806f.png)

### 核心功能页面

| 模块     | 预览图                                                       |
| -------- | ------------------------------------------------------------ |
| 用户管理 | ![用户管理](https://bu.dusays.com/2026/01/31/697db47ce36cc.png) |
| 商品管理 | ![商品管理](https://bu.dusays.com/2026/01/31/697db4d58f52b.png) |
| 分类管理 | ![分类管理](https://bu.dusays.com/2026/01/31/697db502473ab.png) |
| 订单管理 | ![订单管理](https://bu.dusays.com/2026/01/31/697db52ddb330.png) |
| 留言管理 | ![留言管理](https://bu.dusays.com/2026/01/31/697db5587d8c9.png) |

## 技术栈

### 后端技术

- 基础框架：Spring Boot 2.7+
- 构建工具：Maven 3.6+
- 数据持久层：MyBatis 2.3.0
- 文件存储：Minio 8.2+
- 接口文档：Springdoc 1.6.14（Swagger UI）
- 运行环境：JDK 8+
- 数据库：MySQL 8.0

### 前端技术

- 基础框架：Vue 2.x
- 管理模板：vue-admin-template 4.4.0
- 构建工具：Node.js 16+ / npm
- 网络请求：Axios

## 快速开始

### 前置准备

1. 安装 JDK 8+、Maven 3.6+、Node.js 16+、MySQL 8.0
2. （可选）安装 Minio 并配置（或直接使用本地文件存储替代）
3. 克隆项目仓库

### 克隆后端项目

`git clone https://github.com/Myj-2024/second-hand-trading-system.git`

### 克隆前端项目

`git clone https://github.com/Myj-2024/second-hand-trading-system-ui.git`

### 后端部署

1.  进入后端项目目录，`cd second-hand-trading-system`

2.  导入 MySQL 数据库（项目根目录下如有 `sql` 文件夹，执行对应脚本；无则手动创建数据库，名称建议 `second_hand_trading`）
3.  配置数据库连接：修改 `src/main/resources/application.yml` 中的数据库用户名、密码
4.  （可选）配置 Minio 相关参数（文件存储路径、访问地址等）
5.  构建并启动项目

6.  后端启动成功后，访问接口文档：`http://localhost:8080/swagger-ui.html`

### 前端部署

1.  进入前端项目目录，`cd second-hand-trading-system-ui`
2.  安装项目依赖，`npm install`

3.  配置后端接口地址：修改 `src/utils/request.js` 中的 `baseURL`

```javascript
const service = axios.create({
  baseURL: 'http://localhost:8080', // 后端接口基础地址，保持与后端启动端口一致
  timeout: 5000
})
```

4. 启动前端项目，`npm run dev`

5. 前端启动成功后，访问：`http://localhost:9528`（默认账号：admin，密码：123456）

## 核心功能模块

1.  **文件上传模块**：支持商品图片、用户头像等文件上传，返回访问URL
2.  **用户管理模块**：用户分页查询、新增、修改、密码重置、批量删除、登录/登出、信息查询
3.  **商品分类模块**：分类分页查询、新增、修改、删除、分类下商品状态批量操作
4.  **商品管理模块**：商品分页查询、详情查询、新增、修改、状态切换、批量删除
5.  **订单管理模块**：订单分页查询、状态修改、详情查询
6.  **留言管理模块**：留言分页查询、关联订单查询

## 接口规范

1.  基础请求地址：`http://localhost:8080`
2.  统一响应格式：

```json
{
  "code": 200, // 响应码（200 成功，其他为异常）
  "msg": "操作成功", // 提示信息
  "data": {} // 返回数据（按需返回对象、数组、字符串等）
}
```

3.  接口调试：支持 Apifox、Postman、Swagger UI

## To Do List

- [ ] 实现用户注册功能
- [ ] 开发用户端展示和交互页面（买家/卖家前台）
- [ ] 完善支付对接功能
- [ ] 增加数据权限控制
- [ ] 优化文件存储方案，支持更多格式
- [ ] 增加系统日志和操作审计

## 许可证

本项目仅供学习和交流使用，无正式开源许可证。

## 备注

如有问题，请提交 Issue 或联系项目维护者。