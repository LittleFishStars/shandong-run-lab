#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""闪动校园协议常量（全部来自本项目既有逆向成果，经服务端验证）

来源：
  · report/05  字段级加密（smali: com.zj.adlib.h33 / com.zj.adlib.cq）
  · report/06  signKey 字符串表还原
  · report/13  签名算法完全攻破（离线预言机 5/5 一致）
  · report/15  服务端端到端验证（服务端回显逐字节一致）
  · report/07  阳光跑链路（状态位 / 打卡 / 结算字段）

本文件是整个工程唯一的常量出口：改协议只改这里。
"""
from __future__ import annotations

from typing import Any, Dict, NamedTuple, Tuple

# ══════════════════ 版本信息 ══════════════════
APP_VERSION = "8.7.7"
BUILD_VERSION = "26101017"
APP_CODE = "SD001"
PACKAGE_NAME = "com.huachenjie.shandong_school"
USER_AGENT_PREFIX = "ShanDong"

# ══════════════════ 服务端 ══════════════════
API_HOST = "api.huachenjie.com"
BASE_URL = f"https://{API_HOST}/run-front"
OSS_CDN = "https://oss-cdn.huachenjie.com"
H5_ORIGIN = "https://mh5.huachenjie.com"

# ══════════════════ 加密密钥 ══════════════════
# 固定 IV —— 所有 AES-CBC 共用（包括签名、字段加密）
AES_IV = b"01234ABCDEF56789"

# ★ 请求签名密钥（AES-256：16 字节可见前缀 + 16 个 0x00）
#   env ∈ {9, 11} 用测试密钥，其余用生产密钥
SIGN_KEY_PROD = b"09L8MJRMJKXW8TPF" + bytes(16)
SIGN_KEY_TEST = b"Z3MDTC9JATA1SSYB" + bytes(16)
SIGN_ENV_TEST = (9, 11)

# 敏感字段加密密钥（手机号 / 密码 / 姓名 / 学号 / 学校名）
FIELD_KEY = b"F44B0282BEA83557" + bytes(16)

# 滑块验证码坐标（AES-128-ECB）
SLIDER_KEY = b"Ukp3hmSe7BmMcgbE"

# 滑块坐标补偿：先减图片基础边距取整，再加协议位移
SLIDER_MARGIN = 6.5
SLIDER_OFFSET = 16.5

# 跑步防篡改密钥（encodeRun 的拼接盐，按 env 三选一）
#   实测自 liby.so 解密代码 0x1e068 处的密钥选择逻辑（见 report/17）
ENCODE_RUN_KEY_PROD = "QCxhZB6oagpOaQ2jitHucZd8bX34ZEVp"    # 常规
ENCODE_RUN_KEY_1_10 = "STnuKS6lwrCo4OSSJup7sEMZ5SZYMNcq"    # env ∈ {1, 10}
ENCODE_RUN_KEY_9_11 = "9dLCADYy64tKQXoHYTGfrs4VlY0Yg4sI"    # env ∈ {9, 11}

# 多媒体资源解密 DES 密钥组（8 个轮换）
DES_KEYS: Tuple[bytes, ...] = (
    b"c6bd901f", b"0ddf44be", b"950e5927", b"6460d8df",
    b"11fb887f", b"117e4900", b"bd113950", b"a99f6f97",
)

# ══════════════════ 请求头默认值 ══════════════════
# 原版 r24.java:76-96：modelName = Build.MANUFACTURER + "|" + Build.MODEL
# （如 "samsung|SM-A5460"），UA 里的品牌单独取 Build.BRAND。
DEFAULT_MODEL = "samsung|SM-A5460"
DEFAULT_SYS_VER = "14"
DEFAULT_PLATFORM = "2"
DEFAULT_CHANNEL = "other"
HEADER_APP = "run-front"
HEADER_PV = "2"
HEADER_E = "0"              # 请求体字段不加密（原样上送）
HEADER_E_ENC = "1"          # 请求体字段按 ENCRYPT_FIELDS 加密后上送

# ══════════════════ 请求体字段加密（e 头）══════════════════
# APK：EncryptInterceptor 只在「请求头 e 存在且不等于 "0"」时加密请求体字段，
# 字段表由 com/zj/adlib/r24.java:104 的 h33.d(...) 注册（列表见下），
# 每个字段走 cq.c(value, key)：AES-256-CBC(PKCS7) + Base64，密钥 = FIELD_KEY。
#
# ★ 服务端实测（2026-10-17，school/firstPageSchoolList 三组对照）：
#     e=0 + 明文  → 按明文检索（正常）
#     e=1 + 明文  → 服务端解密失败，检索条件丢失（结果与明文检索不同）
#     e=1 + 密文  → 与「e=0 + 明文」逐条一致 ⇒ 密文被服务端正确解出
#   ⇒ 服务端**只看 e 头决定是否解密**。因此 @Headers({"e:1"}) 的接口
#     必须发 e=1，否则 password 会被当成明文与真实密码比对 → 1604「密码不正确」。
ENCRYPT_FIELDS: Tuple[str, ...] = (
    "terminalType", "password", "userName", "schoolName", "studentNumber",
)

# ══════════════════ 上传状态位（report/07 §4.2）══════════════════
STATE_INIT = 1        # 待上传
STATE_UPLOADING = 2   # 上传中（进程崩溃后需复位为 INIT）
STATE_FAIL = 4        # 失败（可重试）
STATE_SUCC = 8        # 成功

# ══════════════════ 运动类型 ══════════════════
SPORT_TYPE_SUN = 1     # 阳光跑
SPORT_TYPE_FREE = 2    # 自由跑

SPORT_TYPE_NAME = {SPORT_TYPE_SUN: "阳光跑", SPORT_TYPE_FREE: "自由跑"}

# ══════════════════ 无效原因（report/07 §6）══════════════════
INVALID_CHECKPOINT = 1   # 打卡点缺失
INVALID_DISTANCE = 2     # 距离不足
INVALID_PACE = 3         # 配速越界
INVALID_GPS = 25         # GPS 异常
INVALID_STRIDE = 58      # 步幅异常

INVALID_REASON_NAME = {
    INVALID_CHECKPOINT: "打卡点缺失",
    INVALID_DISTANCE: "距离不足",
    INVALID_PACE: "配速越界",
    INVALID_GPS: "GPS 异常",
    INVALID_STRIDE: "步幅异常",
}

# ══════════════════ 暂停类型（report/07 §4.6）══════════════════
PAUSE_TYPES = ("AUTO", "REST", "FACE_RECOGNITION", "NFC_CHECK")

# ══════════════════ 采集与判定参数（CommonConfig 默认值，report/07 §4.5）══════════════════
# 以下阈值与闪动校园 com.huachenjie.common.bean.CommonConfig 构造器默认值一致。
# 服务端下发 commonConfig 时会覆盖这些值，运行时以接口返回为准。
RUN_FILTER_ACCURACY = 50.0    # 常规模式精度上限（米），超出即丢弃该点
GPS_FILTER_ACCURACY = 150.0   # GPS 白名单模式精度上限（米）
MAX_SPEED_MPS = 10.438        # 点间等效速度上限（≈37.6 km/h），超出判为瞬移丢弃
VALID_DISTANCE_M = 25.0       # 打卡点判定半径（米），DataComponent 用它可以算 20 点
SENSITIVE_DISTANCE_M = 45.0   # 敏感点位半径（米）
POI_INTERVAL_S = 15           # 轨迹点上传节流间隔（秒）
STEP_INTERVAL_S = 20          # 步频分段时长（秒），Q0() % stepInterval == 0 时切段
PACE_INTERVAL_M = 50          # 配速分段距离（米），超出即封口新起一段
GPS_ABNORMAL_MAX_TIMES = 4    # GPS 异常容忍次数
GPS_STALE_MS = 15_000         # LocationService 定位失效阈值
DEFAULT_SAMPLE_S = 3.0        # 定位回调间隔（与客户端 lj0.m(...,3000L,...) 一致）
DEFAULT_UPLOAD_BATCH = 200    # 轨迹分批上传粒度（原版按 200 个一组置状态）
STRIDE_STATISTICS_M = 100     # 步幅统计间隔（米），DataComponent 每满这段就上报一次
POI_UPLOAD_MIN_POINTS = 4     # 轨迹点上传门槛：原版 size<=3 直接 onCompleted
SEGMENT_UPLOAD_MIN = 3        # 步频/配速段上传门槛：原版 size<3 不上传

# 打卡点判定半径（米）：DataComponent 用 validDistance 判定 isInFence
CHECKPOINT_HIT_RADIUS_M = VALID_DISTANCE_M


# ══════════════════ 易盾风控常量（report/07）══════════════════
HT_PROTECT_PRODUCT_ID = "YD00717730319426"
HT_PROTECT_BUSINESS_ID = "f82ca827669c5cea035c25041e0d270e"

# ══════════════════ 服务端返回码 ══════════════════
CODE_OK = 0
CODE_NEED_LOGIN = 1516       # 未登录 / 未知路径
CODE_MISSING_PARAM = 1002    # 参数缺失

# ══════════════════ 接口表 ══════════════════
# ══════════════════ 接口表 ══════════════════
# 路径/方法均取自 v8.7.7 反编译（work/dex/jadx_FULL/sources/com/huachenjie/**/*Api.java）
# 而非早期报告，避免打到不存在的路由。
#
# 传输编码：原版源码里大量接口标了 @FormUrlEncoded，但拦截器会统一改写成 JSON 体；
# 实测（auth/loginCheck）JSON 体返回 code 0，表单体返回 1004「网络可能异常」，
# 因此本项目对所有 POST 一律发 JSON。
class Endpoint(NamedTuple):
    """一个业务接口：路径 + 请求头 v/api + 是否需要 sign + HTTP 方法"""

    path: str
    v: str
    api: str
    # 标注字段：原版所有 POST 都签名（ParamsInterceptor.c()），GET 不签；保留此字段便于阅读
    need_sign: bool = False
    method: str = "POST"
    # True = APK 里标了 @Headers({"e:1"})：发 e:1 并加密 ENCRYPT_FIELDS 中的字段
    encrypt: bool = False
    # True = APK 标 @FormUrlEncoded：EncryptInterceptor 会把它改写成 JSON 体，
    #        并补 app/api/v/e/pv/k 头（e 默认空串，仅 @Headers({"e:1"}) 为 "1"）
    # False = @Body 直接发 JSON：ParamsInterceptor.h() 只补 9 指纹 + sign，不加这些头
    form: bool = True


# fmt: off
EP = {
    # ── 系统 / 全局配置 ──
    "common_config":    Endpoint("common/getConfig",        "getConfig",        "common", method="GET"),
    "detect_config":    Endpoint("detect/configV2",          "configV2",         "detect", method="GET"),
    "sync_time":        Endpoint("common/syncTime",          "syncTime",         "common", method="GET"),

    # ── 登录（均为 POST）──
    "login_check":      Endpoint("auth/loginCheck",          "loginCheck",        "auth", encrypt=True),
    "login_password":   Endpoint("auth/loginPassword",       "loginPassword",     "auth", encrypt=True),
    "login_sms_send":   Endpoint("account/sendAuthCode",     "sendAuthCode",      "account", encrypt=True),
    "login_sms":        Endpoint("account/login_v3",         "login_v3",          "account", encrypt=True),
    # account/oneClick/login：@Field geTuiToken, gyuid（两段路径 → v=oneClick）
    "login_oneclick":   Endpoint("account/oneClick/login",   "oneClick",         "account"),
    "logout":           Endpoint("account/logout",           "logout",            "account"),

    # ── 用户 / 学校 ──
    "user_info":        Endpoint("account/queryCommonUserInfo", "queryCommonUserInfo", "account"),
    # 注意：原版 20 个 *Api.java 里**没有** api/school/details，此项已删除。
    "semesters":        Endpoint("attend/semesterSelector",  "semesterSelector",  "attend"),

    # ── 围栏 / 规则 ──
    "fence_list":       Endpoint("school/querySchoolFences", "querySchoolFences", "school"),
    "fence_filter":     Endpoint("school/filterUsableFence", "filterUsableFence", "school", form=False),
    "sunrun_abstract":  Endpoint("run/querySunRunAbstractInfoV2", "querySunRunAbstractInfoV2", "run"),
    "sunrun_config":    Endpoint("run/checkSunRunConfig",    "checkSunRunConfig", "run"),
    "precheck_in":      Endpoint("run/getPreRunCheckIn",     "getPreRunCheckIn",  "run"),
    # run/plan/selectList：两段路径 → v=plan
    "plan_list":        Endpoint("run/plan/selectList",      "plan",              "run"),

    # ── 跑步主链路 ──
    "start_sun_run":    Endpoint("run/startSunRun_v2",       "startSunRun_v2",    "run"),
    "start_free_run":   Endpoint("run/startFreeRun",         "startFreeRun",      "run"),
    "resume_run":       Endpoint("run/resume",               "resume",            "run"),
    # @Body 直接发 JSON 的接口（ParamsInterceptor.h()：只补 9 指纹 + sign）
    "upload_record":    Endpoint("run/uploadRunRecord",      "uploadRunRecord",   "run", True, form=False),
    "upload_pace":     Endpoint("run/uploadPaceRecord",     "uploadPaceRecord",  "run", form=False),
    "upload_step":     Endpoint("run/uploadStepsRecord",    "uploadStepsRecord", "run", form=False),
    "upload_stride":   Endpoint("run/uploadStrideRecord",   "uploadStrideRecord", "run", form=False),
    "upload_passpoint": Endpoint("run/uploadPassPoint",      "uploadPassPoint",   "run", form=False),
    "finish_sun_run":   Endpoint("run/finishSunRun_v2",      "finishSunRun_v2",   "run", form=False),
    "finish_free_run":  Endpoint("run/finishFreeRun",        "finishFreeRun",     "run", form=False),
    "abnormal_finish":  Endpoint("run/abnormalFinishSunRun", "abnormalFinishSunRun", "run", form=False),
    # 活动跑（sportType != 1）的异常结束；原版 aw8.a() → ISunshineApi.F()
    "abnormal_finish_activity": Endpoint("run/abnormalFinishActivityRun",
                                         "abnormalFinishActivityRun", "run", form=False),
    "unfinish_run":     Endpoint("run/queryUnFinishRun",     "queryUnFinishRun",  "run"),
    # run/nfc/verification-status：两段路径 → v=nfc
    "nfc_status":       Endpoint("run/nfc/verification-status", "nfc",            "run"),

    # ── 记录 / 排行 ──
    "run_summary":      Endpoint("run/querySchoolRunSummary", "querySchoolRunSummary", "run"),
    "run_count":        Endpoint("run/queryRunRecordCount",  "queryRunRecordCount", "run"),
    "run_detail":       Endpoint("run/runRecordDetail",      "runRecordDetail",   "run"),
    # run/free/detail：两段路径 → v=free
    "free_detail":      Endpoint("run/free/detail",          "free",             "run"),
    "sunrun_list":      Endpoint("run/pageSunRunRecord",     "pageSunRunRecord",  "run"),
    "freerun_list":     Endpoint("run/pageFreeRunRecordList", "pageFreeRunRecordList", "run"),
    "reward_list":      Endpoint("run/listUserReward",       "listUserReward",    "run"),
    "rank_distance":    Endpoint("rank/distance",            "distance",          "rank"),
    "rank_progress":    Endpoint("rank/runProgress",         "runProgress",       "rank"),

    # ── 验证码（AJ-Captcha）──
    # 原版 20 个 *Api.java 里没有 captcha 路由，它由 H5/WebView 侧发起；
    # 这里保留同源直连（run-front/captcha/* + Origin/Referer=mh5），实测可用。
    "captcha_get":      Endpoint("captcha/get",              "get",               "captcha"),
    "captcha_check":    Endpoint("captcha/check",            "check",             "captcha"),
}
# fmt: on


def endpoint(name: str) -> Endpoint:
    """按名字取接口定义，未知名字直接抛错（避免静默打错接口）"""
    try:
        return EP[name]
    except KeyError:
        raise KeyError(f"未知接口名 {name!r}；可用：{', '.join(sorted(EP))}") from None


# ══════════════════ 结算报文默认骨架 ══════════════════
def finish_payload_skeleton() -> Dict[str, Any]:
    """finishSunRun_v2 的字段骨架（值由 runner 按本次跑步填充）

    report/07 §5.3：distance 与 dis 同时发送以兼容不同版本。
    """
    return {
        "distance": 0,
        "dis": 0,
        "duration": 0,
        "totalStep": 0,
        "sportType": SPORT_TYPE_SUN,
        "stepInterval": STEP_INTERVAL_S,
        "paceInterval": PACE_INTERVAL_M,
        "alignType": 3,
        "status": 1,
        "runImgRecord": "",
        "timestamp": "",
        "targetPoints": [],
        "pois": [],
        "stepList": [],
        "paceList": [],
        "faceCheckRecordList": [],
    }
