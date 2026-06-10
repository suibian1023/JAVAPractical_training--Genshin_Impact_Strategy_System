# Genshin 模块集成和运行指南

## 📋 模块说明

这是一个**原神角色管理系统**模块，包含以下功能：
- 角色管理（GenshinCharacter）
- 元素系统（GenshinDomain）
- 敌人管理（GenshinEnemy）
- 敌人调查（GenshinEnemyInvestigation）
- 敌人奖励（GenshinEnemyReward）
- 圣遗物推荐（GenshinRecommendArtifact）
- 队伍推荐（GenshinRecommendTeam）
- 武器推荐（GenshinRecommendWeapon）
- 用户收藏（GenshinUserFavorite）
- 天赋消耗（TalentCosts）

---

## 🚀 运行步骤

### 步骤 1：复制文件到项目目录

#### 1.1 复制 Controller 文件
将 `genshin\main\java\com\ruoyi\system\controller\` 下的所有文件复制到：
```
ruoyi-admin\src\main\java\com\ruoyi\web\controller\system\
```

#### 1.2 复制 Domain 文件
将 `genshin\main\java\com\ruoyi\system\domain\` 下的所有文件复制到：
```
ruoyi-system\src\main\java\com\ruoyi\system\domain\
```

#### 1.3 复制 Mapper 接口
将 `genshin\main\java\com\ruoyi\system\mapper\` 下的所有文件复制到：
```
ruoyi-system\src\main\java\com\ruoyi\system\mapper\
```

#### 1.4 复制 Service 文件
将 `genshin\main\java\com\ruoyi\system\service\` 下的所有文件（包括 impl 子目录）复制到：
```
ruoyi-system\src\main\java\com\ruoyi\system\service\
```

#### 1.5 复制 Mapper XML 文件
将 `genshin\main\resources\mapper\system\` 下的所有 .xml 文件复制到：
```
ruoyi-system\src\main\resources\mapper\system\
```

#### 1.6 复制前端模板文件
将 `genshin\main\resources\templates\` 下的所有文件复制到：
```
ruoyi-admin\src\main\resources\templates\system\
```

---

### 步骤 2：初始化数据库

#### 方法一：使用 MySQL 命令行

```bash
# 登录 MySQL
mysql -u root -pDZQ3182034163

# 选择数据库（根据你的配置，当前是 rytest）
USE rytest;

# 执行建表脚本
SOURCE D:/ruoyi/RuoYi-master/sql/genshin_module.sql;

# 退出
EXIT;
```

#### 方法二：使用数据库管理工具（Navicat/MySQL Workbench）

1. 连接到 MySQL 数据库
2. 选择数据库 `rytest`（或你在配置文件中设置的数据库）
3. 运行 SQL 文件：`D:\ruoyi\RuoYi-master\sql\genshin_module.sql`

---

### 步骤 3：配置菜单权限（可选）

如果你需要在若依系统中显示菜单，需要：

1. 登录若依系统后台
2. 进入 **系统管理 → 菜单管理**
3. 添加新菜单，例如：
   - 菜单名称：原神管理
   - 路由地址：genshin
   - 组件路径：system/character/character
4. 为每个功能添加子菜单和按钮权限

权限标识参考：
- `system:character:view` - 查看角色
- `system:character:list` - 角色列表
- `system:character:add` - 新增角色
- `system:character:edit` - 编辑角色
- `system:character:remove` - 删除角色
- `system:character:export` - 导出角色

其他模块类似，替换 character 为对应的模块名。

---

### 步骤 4：编译并运行项目

#### 方法一：使用 Maven 命令

```bash
# 进入项目根目录
cd D:\ruoyi\RuoYi-master

# 清理并编译
mvn clean package

# 运行项目
java -jar ruoyi-admin\target\ruoyi-admin.jar
```

#### 方法二：使用 IDE（推荐）

1. 用 IDEA 打开项目 `D:\ruoyi\RuoYi-master`
2. 等待 Maven 依赖下载完成
3. 找到 `RuoYiApplication.java` 主类
4. 右键 → Run 'RuoYiApplication'

---

### 步骤 5：访问系统

1. 浏览器访问：`http://localhost:80`（端口在 application.yml 中配置）
2. 使用默认账号登录：
   - 用户名：admin
   - 密码：admin123
3. 如果配置了菜单，可以在左侧菜单看到"原神管理"
4. 或者直接访问：`http://localhost/system/character`

---

## ⚠️ 常见问题

### 1. 找不到类或方法
- 确保所有文件都已正确复制到对应目录
- 检查包名是否正确
- 重新编译项目（Build → Rebuild Project）

### 2. 数据库表不存在
- 确认已执行 `genshin_module.sql` 脚本
- 检查配置文件中的数据库名称是否正确
- 当前配置使用的是 `rytest` 数据库

### 3. 404 错误
- 检查 Controller 的 `@RequestMapping` 路径
- 确认前端模板文件已复制到正确位置
- 检查权限配置是否正确

### 4. 权限不足
- 确保当前登录用户有相应的权限
- 在 **系统管理 → 角色管理** 中为角色分配权限
- 或者临时注释掉 `@RequiresPermissions` 注解进行测试

---

## 📁 文件清单

### Controller (10个文件)
- GenshinCharacterController.java
- GenshinDomainController.java
- GenshinEnemyController.java
- GenshinEnemyInvestigationController.java
- GenshinEnemyRewardController.java
- GenshinRecommendArtifactController.java
- GenshinRecommendTeamController.java
- GenshinRecommendWeaponController.java
- GenshinUserFavoriteController.java
- TalentCostsController.java

### Domain (10个文件)
- GenshinCharacter.java
- GenshinDomain.java
- GenshinEnemy.java
- GenshinEnemyInvestigation.java
- GenshinEnemyReward.java
- GenshinRecommendArtifact.java
- GenshinRecommendTeam.java
- GenshinRecommendWeapon.java
- GenshinUserFavorite.java
- TalentCosts.java

### Mapper 接口 (10个文件)
- GenshinCharacterMapper.java
- GenshinDomainMapper.java
- GenshinEnemyMapper.java
- GenshinEnemyInvestigationMapper.java
- GenshinEnemyRewardMapper.java
- GenshinRecommendArtifactMapper.java
- GenshinRecommendTeamMapper.java
- GenshinRecommendWeaponMapper.java
- GenshinUserFavoriteMapper.java
- TalentCostsMapper.java

### Service (20个文件)
- IGenshinCharacterService.java + impl/GenshinCharacterServiceImpl.java
- IGenshinDomainService.java + impl/GenshinDomainServiceImpl.java
- IGenshinEnemyService.java + impl/GenshinEnemyServiceImpl.java
- IGenshinEnemyInvestigationService.java + impl/GenshinEnemyInvestigationServiceImpl.java
- IGenshinEnemyRewardService.java + impl/GenshinEnemyRewardServiceImpl.java
- IGenshinRecommendArtifactService.java + impl/GenshinRecommendArtifactServiceImpl.java
- IGenshinRecommendTeamService.java + impl/GenshinRecommendTeamServiceImpl.java
- IGenshinRecommendWeaponService.java + impl/GenshinRecommendWeaponServiceImpl.java
- IGenshinUserFavoriteService.java + impl/GenshinUserFavoriteServiceImpl.java
- ITalentCostsService.java + impl/TalentCostsServiceImpl.java

### Mapper XML (10个文件)
- GenshinCharacterMapper.xml
- GenshinDomainMapper.xml
- GenshinEnemyMapper.xml
- GenshinEnemyInvestigationMapper.xml
- GenshinEnemyRewardMapper.xml
- GenshinRecommendArtifactMapper.xml
- GenshinRecommendTeamMapper.xml
- GenshinRecommendWeaponMapper.xml
- GenshinUserFavoriteMapper.xml
- TalentCostsMapper.xml

---

## ✅ 验证是否成功

1. 项目启动无报错
2. 能够访问角色管理页面
3. 可以进行增删改查操作
4. 数据库中能看到对应的表和数据

---

## 📞 需要帮助？

如果遇到问题，检查：
1. 控制台日志输出
2. 数据库连接是否正常
3. 文件是否完整复制
4. Maven 依赖是否正确加载

祝你运行顺利！🎮
