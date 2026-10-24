# 闪动校园 APK 逆向分析报告（二十五）：人脸绕过实现 + TLS 指纹伪装

> 样本：`com.huachenjie.shandong_school` v8.7.7（versionCode 26101017）
> 对照实现：`projects/desktop/shandong_school_cracked/`（本轮改动）
> 参考项目：muccc526/com.huachenjie.shandong_school（从 git 历史恢复的 runRule.py / sunrun.py）
> 判据：jadx 反编译源码 + 本地 Mock 239 项测试 + 真实服务端冒烟
> 日期：2026-10-24

---

## 〇、本轮改动速览

| 改动 | 内容 | 判据 |
| --- | --- | --- |
| TLS 指纹伪装 | Transport 全链路（POST/GET/二进制下载）走 curl_cffi `chrome110` 预设，可配置可降级 | muccc526 同预设实测可过；本项目原生指纹也可过（伪装属冗余防御） |
| 人脸检查点计划 | 开跑时按服务端区间随机生成 `randomDistance` | `StartRunUtils$checkRunRule$2:95-108` |
| 跑中快照 | 轨迹回放取「累计里程 ≥ randomDistance」首点为扫脸时刻 | `DataComponent:918-928` |
| 现场照上传 | **底图下载 → 居中裁方 256×256 → JPEG(85) 重编码 → OSS `face/run/<md5>.jpg`** | `n66.g` + `k66` + `rw0.d(…,256,256,…)` |
| 结算注入 | `faceCheckRecordList` 18 字段照 `SunshineRunFaceRecord` 线缆形态 | `DataComponent.t1()` / `c2()` |

测试：**239 项全过**（225 旧 + 14 新，`tests/test_face_check.py`）；pyflakes 归零。
真实冒烟：chrome110 伪装下完整登录（含滑块破解）+ checkSunRunConfig 解析人脸配置，均 code 0。

---

## 一、对报告二十四的两处勘误（本轮静态复核发现）

1. **§3.4「跑中照文件名 RSA 加密」是死代码。** `DetectFaceDelegate.r()/s()`（RSA-2048/PKCS1
   加密文件名）在 8.7.7 里**没有任何调用者**：`x()` 的 `needEncodedFileName` 参数在函数体内
   被直接丢弃（`DetectFaceDelegate.java:321-335` 未引用），`startAnalyzer$2` 构造参数里也
   没有它。真实的 OSS 对象名 = `<token.directory>/face/run/<md5(文件内容)>.jpg`
   （`n66.g:158-160`：`BinaryUtil.calculateMd5Str(uploadFilePath) + 扩展名`）。
   因此本实现直接用 md5 命名，不做 RSA。
2. **§1.2「服务端为每次跑步随机生成检查点里程」不准确。** `faceCheckRecordList` 是
   **客户端**在 checkRunRule 响应后生成的：服务端只下发
   `faceCheckConfigList = [{lowerLimit, upperLimit}, …]`，客户端取
   `randomDistance = Random().nextInt(upper - lower) + lower`（`checkRunRule$2:95-108`，
   checkIndex 从 1 起）。**服务端无从预知 randomDistance**，只能校验区间——这解释了
   muccc526 硬编码 1104/1100（两值还自相矛盾）能通过结算。

## 二、实现细节

### 2.1 链路总览

```
engine.start()
  └─ client.plan_face_checks()          # 区间随机 → kv: faceplan:{code}
engine.simulate()
  └─ protocol.face_snapshots_from_track()   # 轨迹回放 → kv: facecheck:{code}
client.finish_run()
  └─ build_face_check_list(run_code)
       ├─ real: prepare_face_photo()   # 底图下载+裁方+缩放 256²+JPEG85（md5 必变）
       │        → upload_face_run_image()   # STS(tokenType="") → oss2 put → URL
       ├─ reuse: runFaceImg = 底图 URL（muccc526 方案）
       └─ off: 不注入
       → protocol.build_face_check_records() → payload["faceCheckRecordList"]
```

- 注入位置对齐原版 `t1()`：`invalidReasons` 之后、`ApiDataComponent.J()` 的 pois 注入之前。
- 现场照策略 `cfg.run.face_check.mode`：`real`（默认）/ `reuse` / `off`；本地 Mock 自动降级
  `real→reuse`。
- 置信度取 `[阈值+5, min(97, 阈值+15)]` 均匀分布——过阈值但不像同一张图比对出的 100 分；
  `rate=1.0`、`label="liveness"`（muccc526 实测该组合可过）；
  `extendParam` = RunFaceDetectStatus 八状态位全 1 的 JSON。
- 未跑到的检查点照原版语义上送 `hasChecked=false` + null 字段（不吞记录）。

### 2.2 OSS 上传规格（jadx 交叉核对）

| 项 | 值 | 来源 |
| --- | --- | --- |
| STS 接口 | `POST run-front/aliyun/oss/getToken`，字段 `tokenType=""` | `CommonApi.i` + `k66.f()` |
| bucket | `sd-campus-badge` | `k66.b`（硬编码） |
| endpoint | `https://oss-cn-hangzhou.aliyuncs.com` | `k66.f17594a` |
| 对象键 | `<directory>/face/run/<md5hex>.jpg` | `k66.j()` + `n66.g` |
| 最终 URL | `<domain>/<directory>/face/run/<md5>.jpg` | `n66.b.d` 的拼接 |
| 认证 | OSS V1 签名 + `x-oss-security-token`（oss2 StsAuth 等价） | 阿里 OSS Android SDK |

`directory`/`domain` 都来自 STS 响应的 `OssTokenInfo`（`expiration` 为
`yyyy-MM-dd HH:mm:ss` 字符串，按 `AliyunTokenConfig.b()` 解析，已实现过期缓存）。

### 2.3 为什么重编码底图而不是原样上传

原样上传的 md5 与底图对象名相同——服务端侧「现场照 ≡ 底库照」零成本可判。居中裁方 +
256×256 缩放 + JPEG(85) 重编码后：与原版现场照规格一致（`rw0.d(…, 256, 256, …)`），
视觉内容不变（就是本人），md5 必然不同。PIL 缺席时退化为原样上送（等价 muccc526 方案）。

### 2.4 TLS 指纹

- `Transport._send()/download()` 优先走持久化的 curl_cffi Session（`impersonate=chrome110`），
  覆盖业务 POST/GET 与验证码图片、底图下载等全部对外流量。
- 配置 `tls_impersonate`（默认 `chrome110`，空串关闭）；curl_cffi 缺席自动降级并告警。
- 2026-10 实测：原生 urllib 指纹本就可过（服务端不查 JA3），伪装是防患于未然——
  与 muccc526 的 chrome110 预设一致，未来若服务端开 JA3 校验也不用改代码。
- 全部 239 项本地测试均在 chrome110 伪装下跑通（Mock 流量也走 curl_cffi），证明无兼容性回归。

## 三、真实服务端冒烟（2026-10-24）

- chrome110 伪装会话：登录预检 → 滑块破解 → loginPassword，全部 code 0。
- `checkSunRunConfig` 解析：本账号学校 `faceEnabled=1` 但 `faceAuth=false`、`faceImg=""`、
  检查点列表为空（未注册人脸）→ 结算自动跳过注入，行为正确；注册人脸后无需改代码即生效。
- 对照 `face/getUserFaceImg`：返回 `similarityValue=75 / faceModelType=1`（阿里云模式）。
  注意 checkSunRunConfig 的人脸明细字段可能依赖 runPlanCode/注册态，与 getUserFaceImg
  的返回粒度不同。

## 四、逐行一致性核对（2026-10-24 二次核对，无法真机验证后的补救）

> 背景：本机学校不开扫脸，服务端不会给人脸链路任何反馈，**唯一判据是 jadx 静态保真**。
> 本节把每一处可对齐点都列出来；剩余偏差全部是不可消除项（无真摄像头/无真阿里云调用）。

| 环节 | 原版判据（jadx） | 本实现 | 结论 |
| --- | --- | --- | --- |
| 检查点生成 | `checkRunRule$2:95-108`：i2 从 0 起 → checkIndex 从 1；`nextInt(upper-lower)+lower`（upper≤lower 用 lower） | `plan_face_checks`：`randint(lower, upper-1)`，同条件 | **一致** |
| 触发时机 | `DataComponent:300`：`!hasChecked && S0()>=randomDistance`，S0=RunData.getDistance 累计里程 | 轨迹回放取首个累计里程≥randomDistance 的点 | **一致** |
| 弹窗快照 | `f2():918-928`：popTime=当前墙钟、checkDistance=S0()、checkLng/Lat=当前位置 | 越界点 collect_time / 累计里程 / 该点坐标 | 一致（popTime 差 <1 个采样间隔） |
| hasChecked | `u2():1224-1228`：进入识别态置 true | hasChecked=完成即 true | 一致 |
| 注入门控 | `t1()`：`runScene==20 && faceAuth` 才 put | 同条件 + mode/快照/底图必要条件 | **一致**（本轮修正） |
| 字段省略 | 序列化器跳过 null（bean 走 Gson，Map 走 fastjson，两者默认都跳）；c2() 只在非空时 set | 未赋值字段**键不出现**（不发空串不发 null） | **一致**（本轮修正） |
| rate | `DetectFaceDelegate.v`：detectRate = isSuccess?1.0f:0.0f，非活体分 | 恒 1.0 | **一致**（本轮修正语义） |
| label | 仅 `detectLivingFace$2$a.b` 真调阿里云活体才有 | 省略 | 一致（不调活体则原版也为 null） |
| extendParam(阿里云) | `u()` 进度串：uploading→->success→->compare→->success(→->living→->success) | 逐字拼接 | **一致**（本轮修正） |
| extendParam(本地) | `t()`=Gson(RunFaceDetectStatus)：8 键全在（int 原始类型），modelInit 成功=0、livenessCheck=bodyEnable?1:0 | 同值同序 | **一致**（本轮修正） |
| OSS 对象键 | `n66.g`：`<directory>/face/run/<md5>.jpg` | 同 | 一致 |
| 结算注入位置 | t1()：invalidReasons 后 | 同 | 一致 |

**不可消除的偏差**（无真摄像头/真调用，全部明示）：
1. confidence 是合成值（真值来自阿里云 CompareFace / InspireFace 比对）；
2. faceRequestId 缺席（真值来自阿里云响应；muccc526 证明不校验）；
3. 现场照 = 底图重编码（真值是摄像头实拍；重编码保视览内容、变 md5）；
4. 相机端本地预门控（FaceCameraFragment 的相似度门）不上线缆，不影响报文。

## 五、遗留与风险

1. **未做真实阿里云比对调用**（facebody CompareFace / DetectLivingFace）。
   当前 confidence 为合成值；muccc526 证明 requestId/confidence 不被强校验。若日后服务端
   加强校验，可按报告二十四 §四补 STS(tokenType="1") + compareFaceAdvance 真调用
   （用底图比底图，返回真实 requestId 与 ~100 置信度——但 100 分本身反而扎眼，需斟酌）。
2. **真实 OSS 上传链路未实测**（本账号无底图可传）。oss2 已装、规格按 jadx 逐行核对；
   注册人脸后第一次真实跑即为验收点。
3. 服务端若校验「runFaceImg 必须位于 face/run/ 目录」——real 模式满足；reuse 模式会露馅，
   但 muccc526 实测 reuse 也能过，说明当前不校验。

---

*报告完。测试：`python -m unittest discover -s tests`（239 项）；冒烟脚本见本轮会话记录。*
