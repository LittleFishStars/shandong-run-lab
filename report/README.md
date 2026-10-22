# report/ —— 分析报告 01–24

样本：`com.huachenjie.shandong_school` v8.7.7（versionCode 26101017），
SHA-256 `4e74df34c08cab0f7b5a1903e5dc204d7a0bf69d56e085731191ea0f909dd470`。

## 编号与主题

| 号 | 主题 |
|---|---|
| 01–03 | 初步分析、插件与载荷、容器 DEX 静态还原 |
| 04–06 | 完整脱壳、业务协议、native 签名黑盒 |
| 07–09 | 核心业务链路、隐藏 SO、安全 SDK |
| 10–13 | 收尾、liby 结构还原、签名定位与攻破 |
| 14–15 | 加固谱系、服务端端到端验证 |
| 16–19 | 跑步链路 / 通信层 / 流程一致性核对 |
| 20–22 | 登录持久化、多用户、结算 1112 排查 |
| 23–24 | 阳光跑上传接口二次核对、反编译接口忠实性核对 |

## 路径说明（2026-10-22 之后）

报告里写的 `work/...` 是**整理前**的路径；2026-10-22 工作区按类别重组，对应关系：

| 报告里的旧路径 | 现在的位置 |
|---|---|
| `work/APP_ALL4`、`work/jadx_FULL`、`work/jadx_shell`、`work/rebuild`、`work/shell_full.dex`、`work/stars_hidden.dex` | `work/dex/…` |
| `work/allso`、`work/hidden_so3`、`work/ghidra_blob`、`work/liby_runtime`、`work/liby_segs` | `work/native/…` |
| `work/certs`、`work/blob_info`、`work/plugins`、`work/jars` | `work/evidence/…` |
| `work/dump`、`work/dump_final` | `work/dumps/…` |
| `work/notes`、`work/logs`、`work/frida` | `work/records/…` |
| `work/android-sdk`、`work/jadx_V2`、`work/rebuilt`、`work/peek`、`work/apks`、`work/jadx_plugins`、`work/reference`、`work/tools/fs` | 已清理（再生方式见 `docs/CLEANUP-2026-10-22.md`） |

`scripts/` 下的脚本已按新路径更新；`work/README.md` 有完整目录说明。
完整删除/迁移记录见 [`../docs/CLEANUP-2026-10-22.md`](../docs/CLEANUP-2026-10-22.md)。
