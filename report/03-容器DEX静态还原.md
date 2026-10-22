# 「闪动校园」深入分析（三）：易盾容器 DEX 的静态还原

- **承接**：[01-初步分析.md](01-初步分析.md)、[02-插件与载荷深入分析.md](02-插件与载荷深入分析.md)
- **本轮目标**：执行 02 报告第 6 节的路径 A——静态还原被易盾容器承载的主 DEX，取回应用自有 Java 代码
- **结论**：**容器格式已完全逆向，18 个内嵌 DEX 已重建并成功反编译（74,469 个 Java 文件）**；
  但 `type_ids` 的字符串池映射存在系统性偏差，导致部分类型名退化（详见 §4）

---

## 0. 本轮结论摘要

| 项目 | 结果 |
|---|---|
| 容器格式 | **完全逆向**：多 DEX 拼接 + 每 DEX 独立的 `[私有头][string_ids][type_ids][proto_ids][私有块][field_ids][method_ids][class_defs][data]` |
| 定位到的 DEX | **18 个**（含首个 85,240 与其余 17 个） |
| 重建结果 | 全部 18 个 DEX 写入 `work/rebuilt/`，`dexdump`/jadx 均可加载 |
| 反编译产出 | **74,469 个 Java 文件**（`work/jadx_full/`） |
| 应用自有代码 | **381 个 `com.huachenjie.*` 类**，覆盖 `run`/`sport`/`college`/`mall`/`channel`/`works`/`mine`/`ad` 等业务包 |
| 已恢复的类总量 | 约 **11 万个 class_def**（18 个 DEX 的 `class_defs` 之和） |
| 遗留问题 | `type_ids` 边界/字符串池映射偏差 → 部分类型名与类名退化为 `defpackage`（约 87% 文件），**代码主体仍可读** |

---

## 1. 容器格式逆向（本轮核心成果）

### 1.1 识别出的布局

```
classes.dex = [易盾壳 DEX: 0 .. 79,616]
            + [容器载荷: 79,616 .. 141,103,628]
                 ├─ DEX#1  @ 基址 B1
                 │    ├─ 0x0000 .. 0x1004   容器私有头（加密，4,100 字节；其中 0..112 即"被毁的 DEX 头"）
                 │    ├─ 0x1004               string_ids   (u32 数组，每项 = 基址 + 偏移 → 合法 string_data_item)
                 │    ├─ 紧随其后             type_ids     (u32 数组，严格递增且 < string 数)
                 │    ├─ 紧随其后             proto_ids    (12 字节记录)
                 │    ├─ 私有块（大小因 DEX 而异：560 / 2,584 / 15,048 / 19,064 / 21,152 … 实测 8 种）
                 │    ├─                      field_ids    (8 字节记录)
                 │    ├─                      method_ids   (8 字节记录)
                 │    ├─                      class_defs   (32 字节记录)
                 │    └─                      data         (string_data / code_item / class_data / …)
                 ├─ DEX#2  @ 基址 B2 …
                 └─ …
```

**关键点**：容器**没有**破坏 DEX 的节区数据，只是
（a）把 112 字节头连同其后 3,988 字节一起加密，
（b）在 `string_ids` 与 `type_ids` 之间、以及 `proto_ids` 与 `field_ids` 之间插入不定长私有块，
（c）销毁了 `map_list`。

### 1.2 定位全部 DEX 基址的方法

`type_ids` 是一个「严格递增且值 < string 数」的 u32 数组，在整包里表现为长递增序列。
对此类序列做如下反解即可得到基址：

```
给定递增表起点 T 与表内最大值 V：
  S = V + 1                      # 猜测 string 数
  A = T - 4*S                    # 数组起点应为 T - 4S
  B = A - 4100                   # 容器布局：string_ids 在基址 + 4,100
  校验：B + 表中每个值 是否都落在合法 string_data_item 上 → 是则 (B, S) 成立
```

据此扫描出 **18 个基址**：

| # | 基址 | string 数 | type 数 | proto 数 | field 数 | method 数 | class_defs |
|---|---|---|---|---|---|---|---|
| 1 | 85,240 | 70,145 | 11,330 | 15,756 | 65,208 | 63,774 | 8,953 |
| 2 | 9,471,640 | 50,083 | 10,322 | 16,565 | 25,245 | 65,056 | 8,856 |
| 3 | 19,947,144 | 24,988 | 8,170 | 9,290 | 17,198 | 42,542 | 6,664 |
| 4 | 25,354,800 | 72,370 | 12,497 | 16,004 | 64,384 | 62,932 | 10,194 |
| 5 | 35,085,468 | 55,074 | 9,729 | 15,337 | 56,047 | 63,434 | 7,392 |
| 6 | 43,339,524 | 66,977 | 10,189 | 14,067 | 58,165 | 63,825 | 8,720 |
| 7 | 52,959,184 | 55,392 | 12,724 | 16,104 | 62,668 | 63,382 | 10,593 |
| 8 | 62,015,996 | 78,517 | 10,719 | 15,776 | 60,016 | 63,207 | 8,012 |
| 9 | 71,416,572 | 45,293 | 5,329 | 6,828 | 65,484 | 28,599 | 3,758 |
| 10 | 76,162,292 | 34,721 | 2,525 | 3,101 | 65,501 | 11,353 | 1,493 |
| 11 | 79,192,760 | 46,951 | 6,180 | 7,463 | 65,495 | 30,093 | 4,659 |
| 12 | 84,097,708 | 38,475 | 3,127 | 3,933 | 65,480 | 14,104 | 1,967 |
| 13 | 87,828,640 | 43,217 | 3,569 | 4,311 | 65,347 | 15,727 | 2,010 |
| 14 | 91,969,492 | 38,839 | 2,933 | 3,835 | 65,468 | 14,727 | 1,888 |
| 15 | 95,789,236 | 78,655 | 12,777 | 15,186 | 61,956 | 63,551 | 10,084 |
| 16 | 105,733,280 | 56,873 | 13,853 | 13,107 | 65,098 | 63,656 | 11,797 |
| 17 | 115,337,660 | 51,644 | 11,851 | — | — | — | —（未闭合） |
| 18 | 123,813,664 | 62,154 | 10,938 | 14,176 | 65,128 | 60,453 | 8,294 |
| 19 | 133,381,204 | 50,457 | 10,472 | 11,619 | 65,461 | 50,767 | 8,552 |

### 1.3 节区边界如何做到「精确闭合」

被销毁的头与 map 都不可用，因此尺寸由**数据自身**反推，并用「链式闭合」自证：

1. `string_ids`：逐项校验 `基址 + 偏移` 是否为合法 `string_data_item` → 精确得到 string 数；
2. `type_ids`：紧随 `string_ids`，取「严格递增且 < string 数」段；
3. `proto_ids`：紧随 `type_ids`；
4. `field_ids` / `method_ids` 尺寸：解析全部 `class_data_item` 中 `encoded_field` /
   `encoded_method` 的 **uleb128 增量**，取最大索引 +1 —— 这是**精确值**，不依赖任何猜测；
5. 由 `class_defs` 起点反推 `method_ids_off`、`field_ids_off`；
6. **闭合校验**：`type_ids` 末尾 → `proto_ids` → `field_ids` 三者的偏移必须首尾相接
   （相差 0 或该 DEX 的私有块大小），闭合通过才写出 DEX。

脚本：`scripts/build_dex_from_container.py`（单 DEX，手工指定）、
`scripts/recover_all_container_dex.py`（批量 + 自动闭合校验）。

### 1.4 让 DEX 通过校验器的两个必要修补

写出的 DEX 最初被 `dexdump` 拒绝两次，均为规范细节：

| 报错 | 原因 | 修补 |
|---|---|---|
| `Non-zero padding before section of type 1 at offset 0x70` | DEX 要求头部与首个节区之间为 0 填充，而容器在那里放了加密私有头 | 把 `112 .. string_ids_off` 清零（该区无任何结构引用） |
| 同上，`type 3 at offset 0x58254` | 节区之间同样要求 0 填充 | 把 `type_ids 末尾 .. proto_ids`、`proto_ids 末尾 .. field_ids` 两处私有块清零 |

## 2. 反编译产出

```
work/rebuilt/   18 个重建 DEX（合计约 220 MB）
work/jadx_full/ 18 个 DEX 的反编译结果（74,469 个 Java 文件）
```

### 2.1 已恢复的应用自有业务代码（节选）

| 业务包 | 类数 | 代表类 |
|---|---|---|
| `com.huachenjie.common` | 100 | `bean/SportStatics`、`run_component/LocationComponent`、`bean/SignPeriod` |
| `com.huachenjie.base` | 52 | `interact/RankingInteractEvents`、`view/danmuku/DanMuView` |
| `com.huachenjie.mine` | 19 | 个人中心相关 |
| `com.huachenjie.college` | 11 | 高校/学院模块 |
| `com.huachenjie.works` | 10 | 作品/动态 |
| `com.huachenjie.channel` | 8 | 频道 |
| **`com.huachenjie.run`** | **7** | **`page/sun_run/SunshineRunActivity`、`page/run_reward/RunRewardListVM`、`page/settings/RunSettingsActivity`** |
| `com.huachenjie.mall` | 7 | 商城 |
| `com.huachenjie.ad` | 6 | 广告 |
| `com.huachenjie.sport` | 4 | `page/mine/huodong/run_rank/HuodongRunRanksActivity` |
| `com.huachenjie.pose_estimation` | 1 | 姿态识别（AI 运动） |

> 这正是最初用尽静态手段也拿不到的**跑步打卡/阳光跑/活动排名**业务代码。

## 3. 与初步结论的关系（重要修正）

- 01 报告判定「载荷 = 易盾自定义容器，索引区被抽取/加密」——**该判定在方向上正确**：
  容器确实是自定义格式（多 DEX + 私有块 + 被毁头部）。
- 但 01 报告进一步推断「索引区不在明文中」——**这一点被本轮推翻**：索引区一直都在明文里，
  只是**节区之间插入了不定长私有块**、且 `string_ids` 偏移是 4,100 而非 112，
  导致按标准 DEX 直接解析时处处错位。

## 4. 已知限制与遗留问题（务必如实记录）

反编译结果存在**类型名退化**，原因已定位但尚未完全解决：

1. **`type_ids` 与字符串池的映射存在偏差**。以 DEX#8（基址 62,015,996）为例，
   其 `type_ids` 段内约 **88.8%** 的元素指向合法类型描述符，另有约 **11.2%**
   指向 `MODE_SCROLLABLE`、`MOTION_PHOTO_ATTRIBUTE_NAMES`、`KEY_SOURCE`
   这类 **资源/属性名**。这意味着容器在重排字符串池时改动了部分类型的下标基准。
2. **后果**：jadx 仍能逐类反编译，但被污染的类型会退化成无意义类名
   （`PlayerView_scrubber_dragged_size` 等），并伴随
   `Unknown type string: "MOTION_PHOTO_ATTRIBUTE_NAMES"` 之类的单方法级错误。
   统计：**9,294 个文件有正常包名，65,175 个落在 `defpackage/`**。
3. 已备好标定脚手架：`scripts/calibrate_container_dex.py`
   —— 思路是对 `string_ids` 长度做 0..64 项回退，联立求解
   「`type_ids` 描述符占比 + `proto_ids` shorty 占比 + 节区闭合」的最优解。
   当前阈值下 DEX#8 仍不收敛，需要把「资源名被顶替」这一现象显式建模
   （例如允许类型项指向同名的泛型签名串或做池内重映射）。

**因此**：本轮交付的是「**容器格式已通、代码主体已可读、类型名部分失真**」，
而非完美还原。若需要高质量结果，仍建议：
- 在外接设备上运行时 dump（可拿到完全正确的 DEX），或
- 继续攻关字符串池重映射规则（纯静态，脚本已就位）。

## 5. 下一步计划

1. **完成 `type_ids` 标定**：把「池内重映射」显式建模，目标是把 `defpackage` 占比从 87% 压到 <10%；
2. **利用已恢复代码开展业务分析**（当前已可用）：
   `com.huachenjie.run` / `sport` 的跑步校验、上报字段、活动排名逻辑；
3. 与 [02 报告](02-插件与载荷深入分析.md)的插件侧行为对齐；
4. 需要 100% 正确结果时，外接可 root 设备做内存 dump 交叉验证。

---

## 附录：本轮新增产出

| 路径 | 内容 |
|---|---|
| `scripts/rebuild_dex.py` | 早期单 DEX 重建尝试（记录否证过程） |
| `scripts/build_dex_from_container.py` | 单个容器 DEX 的精确重建（含节区闭合校验） |
| `scripts/recover_all_container_dex.py` | 批量定位 + 重建全部内嵌 DEX |
| `scripts/calibrate_container_dex.py` | `type_ids`/`proto_ids` 联合标定脚手架（遗留问题用） |
| `work/rebuilt/*.dex` | 18 个重建出的 DEX |
| `work/jadx_full/` | 74,469 个 Java 文件（应用自有 381 个） |
| `work/recover_all.log`、`work/jadx_full.log` | 重建与反编译日志 |
