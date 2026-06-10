1. 项目概述
本项目是一个基于 Java 开发的“原神”游戏综合攻略与数据管理系统。系统旨在为玩家提供详尽的角色图鉴、武器装备数据、秘境掉落信息以及养成资源计算等功能。底层架构采用成熟的若依（RuoYi）后台管理系统（多模块版），具备高效率的开发体验、完善的权限控制和良好的可扩展性。

2. 快速开始
环境要求
JDK: 1.8+

数据库: MySQL 5.7+

缓存: Redis

构建工具: Maven

启动步骤
克隆或下载项目代码到本地。

在 MySQL 中创建数据库，并依次导入 sql 目录下的脚本（如 genshin_all.sql 和 rytest.sql）。

打开 ruoyi-admin/src/main/resources/application-druid.yml，修改数据库连接配置（账号、密码）。

打开 ruoyi-admin/src/main/resources/application.yml，确认 Redis 配置正确。

在项目根目录执行 mvn clean install 安装依赖。

运行 ruoyi-admin 模块下的 RuoYiApplication.java 启动项目。

浏览器访问 http://localhost:80，使用默认管理员账号登录（admin / admin123）。

3. 系统架构设计
系统采用经典的分层架构设计（详细架构图见 docx/详细设计/draw图纸文件/系统分层架构图.png）：

核心框架: Spring Boot

安全框架: Apache Shiro

持久层框架: MyBatis

前端视图: Thymeleaf + Bootstrap

数据库连接池: Druid

日志管理: SLF4J + Logback

4. 核心功能模块
系统在若依基础权限（用户、角色、菜单、部门、字典）之上，扩展了丰富的原神业务模块：

角色图鉴管理 (system/character): 涵盖所有角色的基础属性、命之座、天赋等信息。

武器与圣遗物库 (system/weapon, system/artifact): 提供装备的基础属性、特效说明及推荐搭配。

资源与秘境 (system/domain, system/materials): 记录每日秘境掉落、大图怪物分布及养成材料汇总。

智能推荐系统 (system/recommendTeam, system/recommendWeapon): 为玩家提供主流的配队方案与武器优选。

资源计算器 (system/calculator, system/costs): 精确计算角色升级、天赋拉满所需的材料清单与摩拉消耗。

用户收藏 (system/favorite): 允许前端用户收藏常用的配队与角色攻略。

5. 数据库设计
数据库采用关系型设计，包含系统表与业务表两部分。完整的实体关系图可参考 docx/详细设计/db数据库设计/E-R图.png。
核心业务表主要包括：

characters: 角色基础信息数据表（业务查询核心表）。

genshin_weapon: 武器图鉴表。

genshin_artifact: 圣遗物套装数据表。

materials: 养成材料字典表。

talent_costs: 天赋升级消耗对照表。

6. API接口文档
系统集成了 Swagger 来生成和管理 API 文档。

在项目启动后，可以通过访问 http://localhost:80/swagger-ui.html 查看完整的 RESTful API 接口定义。

在接口文档中，可以直接进行接口的联调与测试（包括字典查询、数据增删改查等）。

7. 安全与权限
认证与授权: 依托 Apache Shiro 进行细粒度的权限控制（RBAC 模型），支持到按钮级别的权限拦截。

数据权限: 支持数据范围控制（全部数据、本部门及以下数据、本部门数据、仅本人数据、自定义数据）。

防范机制: 内置 XSS 过滤（XssFilter）、防重复提交拦截（RepeatSubmitInterceptor）以及 CSRF 校验机制。

8. 开发指南
代码生成: 系统内置代码生成器（ruoyi-generator），可通过后台配置表结构，一键生成 Controller、Service、Mapper 及 HTML 页面代码，大幅提升开发效率。

目录结构:

ruoyi-admin: Web服务入口与控制器。

ruoyi-system: 核心业务逻辑与数据访问层。

ruoyi-framework: 框架核心配置与安全拦截。

ruoyi-common: 通用工具类与常量。

9. 部署与运维
打包: 在项目根目录下运行 mvn clean package，在 ruoyi-admin/target 目录下会生成可执行的 jar 包。

运行脚本: 提供了便捷的启动脚本，Windows 环境下使用 ry.bat，Linux 环境下使用 ry.sh。

监控: 内置了服务器监控（ServerController）、缓存监控（CacheController）以及 Druid 数据库连接池监控，方便运维人员实时掌握系统状态。

10. 故障排除
验证码无法显示 / Redis报错: 请确保本地或服务器上的 Redis 服务已启动，且 application.yml 中的端口和密码配置正确。

数据库连接失败: 检查 MySQL 服务状态，确认 application-druid.yml 中的用户名密码是否匹配。

依赖下载失败: 尝试清理 Maven 缓存或更换阿里云 Maven 镜像源后重新导入。

11. 更新日志
v1.0.0 * 完成基础若依框架的搭建与精简。

整合原神业务模块：角色、武器、圣遗物、秘境基础 CRUD 功能。

上线角色养成计算器与推荐配队功能。

完善数据库 E-R 图与系统详细设计说明书。
