# Mycounter —— 简单计算器

一个基于 Android 平台的轻量级计算器应用，使用 Java 编写，遵循 Material Design 规范，提供完整的基础运算与常用数学功能。

## 📌 功能列表

- **基础运算**：加法（`+`）、减法（`-`）、乘法（`*`）、除法（`/`）
- **数学函数**：开方（`√`）、倒数（`1/x`）
- **操作控制**：全清（`AC`）、删除（`⬅`）、小数点（`.`）

## ⚙️ 技术栈

- **语言**：Java（JDK 11）
- **平台**：Android SDK 36（targetSdk = 36）
- **构建工具**：Gradle
- **UI 框架**：AndroidX + Material Design（`com.google.android.material:material`）
- **布局**：ConstraintLayout

## 🗂️ 目录结构简述

```
repo-1/
├── app/                     # 主模块
│   ├── src/
│   │   └── main/
│   │       ├── java/com/example/mycounter/MainActivity.java   # 业务逻辑
│   │       ├── res/
│   │       │   ├── layout/activity_main.xml                    # UI 局
│   │       │   └── values/strings.xml                            # 字符串资源
│   │       └── AndroidManifest.xml                               # 应用配置
│   └── build.gradle.kts                                          # 模块构建脚本
├── settings.gradle.kts                                           # 项目设置
├── gradlew                                                         # Gradle 启动脚本
└── README.md                                                       # 本文件
```

## 🛠️ 构建与运行

1. 确保已安装 JDK 11 和 Android SDK（含 Build-Tools 36）
2. 在项目根目录执行：
   ```bash
   ./gradlew assembleDebug
   ```
3. 装生成的 APK 到设备或模拟器即可运行。

> 💡 **截图占位**：  
> （此处可后续补充应用界面截图）

---

© 2025 Mycounter Project. All rights reserved.