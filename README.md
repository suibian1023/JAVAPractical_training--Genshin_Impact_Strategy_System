# 原神攻略系统 (Genshin Impact Strategy System)

基于 [RuoYi](https://gitee.com/y_project/RuoYi) 框架构建的原神游戏数据管理与攻略平台，为《原神》玩家与内容运营人员提供一套完整的攻略管理解决方案。

## 📋 项目简介

本项目在 RuoYi 企业级开发框架基础上扩展，围绕角色、武器、圣遗物、敌人等核心数据，提供角色管理、武器推荐、圣遗物搭配、敌人信息管理等功能模块，并通过 Apache Shiro 权限控制与数据持久化保障系统的安全性与可维护性。

### 适用场景

- 原神玩家攻略资料管理与分享
- 游戏运营方的内容管理与数据维护
- 教育/培训场景的角色与玩法知识库

## 🚀 技术栈

| 类别 | 技术 | 版本 |
|------|------|------|
| 核心框架 | Spring Boot | 4.0.3 (JDK 17+) |
| 安全框架 | Apache Shiro (Jakarta) | 2.1.0 |
| 持久层 | MyBatis + Druid 连接池 | 4.0.1 / 1.2.28 |
| 前端模板 | Thymeleaf + Bootstrap + jQuery | - |
| 分页插件 | PageHelper | 2.1.1 |
| 工具库 | Fastjson, Apache POI | 1.2.83 / 4.1.2 |
| API 文档 | SpringDoc OpenAPI | 3.0.2 |

## 🏗️ 项目结构

```
├── ruoyi-admin          # Web 后端入口模块（控制器、前端模板、静态资源）
├── ruoyi-common         # 通用工具与实体基类（BaseController、分页、响应封装）
├── ruoyi-framework      # 框架支撑模块（Shiro 安全、MyBatis 配置、拦截器）
├── ruoyi-system         # 业务模块（领域模型、Service、Mapper）
├── ruoyi-generator      # 代码生成器（可选）
├── ruoyi-quartz         # 定时任务模块（可选）
├── sql                  # 数据库初始化脚本
│   ├── genshin_all.sql  # 原神业务表结构与数据
│   └── rytest.sql       # 测试数据
└── docx                 # 项目文档（需求分析、详细设计等）
```

### 模块依赖关系

```
ruoyi-admin ──→ ruoyi-framework ──→ ruoyi-common
     │
     └──→ ruoyi-system ──→ ruoyi-common
```

## ✨ 核心功能

### 角色管理系统
- 角色基础信息增删改查与 Excel 导出
- 培养路线构建页（集成推荐武器、圣遗物、配队、天赋材料）

### 武器推荐系统
- 武器信息管理（类型、星级、属性、突破材料）
- 基于角色的武器适配推荐

### 圣遗物推荐系统
- 按角色推荐圣遗物套装与主副词条配置
- 支持沙漏/杯子/头冠主词条及副词条优先级

### 敌人信息管理
- 怪物基础信息、类型、分类、描述维护

### 用户收藏系统
- 角色/推荐内容的收藏与查询管理

### 计算器系统
- 战斗/培养相关计算入口（可按需扩展）

### 权限与安全
- 基于 Apache Shiro 的认证授权与会话管理
- 细粒度权限控制（`@RequiresPermissions`）
- 操作日志记录（`@Log` 注解自动记录）
- 验证码、记住我、并发登录踢出

## 🛠️ 快速开始

### 环境要求

- JDK 17+
- Maven 3.6+
- MySQL 5.7+
- IDE（推荐 IntelliJ IDEA）

### 安装与部署

1. **克隆项目**
   ```bash
   git clone https://github.com/suibian1023/JAVAPractical_training--Genshin_Impact_Strategy_System.git
   ```

2. **初始化数据库**
   - 创建数据库（如 `genshin`）
   - 执行 `sql/genshin_all.sql` 初始化表结构与基础数据

3. **修改配置**
   - 编辑 `ruoyi-admin/src/main/resources/application.yml` 中的数据库连接信息
   - 编辑 `ruoyi-admin/src/main/resources/application-druid.yml` 调整连接池参数

4. **编译运行**
   ```bash
   mvn clean package
   java -jar ruoyi-admin/target/ruoyi-admin.jar
   ```
   或在 IDE 中直接运行 `RuoYiApplication.java`

5. **访问后台**
   - 地址：`http://localhost:8080`
   - 默认管理员账号：`admin` / `admin123`

### 首次启动配置

1. 登录系统，修改初始管理员密码
2. 配置系统参数（站点名称、首页路径等）
3. 创建角色与菜单，分配权限
4. 发布公告与测试用户管理
5. 验证原神角色/武器/材料等业务功能

## 📐 系统架构

系统采用经典的三层架构与 MVC 模式：

```
浏览器 ──→ Controller（路由/权限校验）──→ Service（业务逻辑）
                                              │
                                         Mapper（SQL 映射）
                                              │
                                          MySQL 数据库
```

- **表现层**（`ruoyi-admin`）：接收 HTTP 请求，调用 Service，返回视图或 JSON
- **业务层**（`ruoyi-system`）：封装业务规则，协调多个 Mapper 完成复杂操作
- **数据层**（`ruoyi-system` Mapper）：执行 SQL，映射结果到领域对象
- **框架层**（`ruoyi-framework`）：MyBatis 配置、Shiro 安全、拦截器、异步管理

## 📝 编码规范

- 控制器继承 `BaseController`，复用分页（`startPage`）与响应封装（`getDataTable`/`toAjax`）
- 业务方法使用 `@RequiresPermissions` 注解进行权限控制，格式 `模块:功能:操作`
- 写操作标注 `@Log` 注解，自动记录操作日志
- Service 层接口与实现分离，接口以 `I` 开头，实现以 `Impl` 结尾

## ❓ 故障排查

| 问题 | 排查方向 |
|------|----------|
| 启动失败 | 检查 JDK 版本与 Maven 依赖是否完整 |
| 数据库连接失败 | 核对 `application.yml` 中的数据库配置 |
| 登录异常 | 确认管理员账号密码，检查 Shiro 配置 |
| 权限不足 | 检查角色与菜单权限分配 |
| 页面无数据 | 检查 Controller 服务注入与模板变量 |
| SQL 执行错误 | 确认初始化脚本是否完整执行 |

## 📄 项目文档

项目文档位于 `docx/` 目录：
- `需求分析/` — 需求分析说明书、用例图、需求分析矩阵
- `详细设计/` — 数据库设计（E-R 图）、系统详细设计说明书、UML 类图、分层架构图

## 🤝 贡献指南

欢迎提交 Issue 和 Pull Request 来完善项目。建议：
1. Fork 本仓库
2. 创建特性分支 (`git checkout -b feature/AmazingFeature`)
3. 提交改动 (`git commit -m 'Add some AmazingFeature'`)
4. 推送到分支 (`git push origin feature/AmazingFeature`)
5. 提交 Pull Request

## 📜 许可证

本项目基于 MIT 许可证开源，详情见 [LICENSE](LICENSE) 文件。
