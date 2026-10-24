"""闪动校园 · 阳光跑工作台（shandong-school_cracked）。

一个完整的协议复原实现：登录 → 阳光跑 → 数据记录 → 数据上传。
所有网络行为都被收敛在 :class:`shandong_school_cracked.client.ShanDongClient` 之后，默认运行在
**本地 Mock 模式**下，不接触任何真实服务端。

包内模块一览::

    constants.py   协议常量（密钥、接口表、状态位、采集参数）
    ciphers.py     密码学多后端适配（pycryptodome / cryptography / 纯标准库）
    crypto.py      业务加解密与签名（sign / 字段加密 / 滑块 / 结算码）
    protocol.py    轨迹、步频、配速、步幅等运动数据结构
    simulator.py   模拟引擎：场景构建 + 刷步/加速度仿真（移植自 FUCK-RUN-）
    store.py       本地数据层（SQLite 三表 + 会话 + 配置）
    net.py         传输层（请求头、公共体、签名注入、错误归类）
    captcha.py     滑块验证码求解（OpenCV 优先，降级纯 Python）
    client.py      业务客户端：登录 → 阳光跑 → 记录 → 上传
    engine.py      业务编排引擎（一键跑完整链路、断点续传）
    mock.py        内置 Mock 服务端（离线端到端调试）
    bus.py         事件总线（前端实时事件流的数据源）
    app.py         应用门面（供桌面壳与 HTTP 桥共用）
    gui.py         pywebview 桌面外壳 + HTTP 降级服务
    cli.py         命令行入口

典型的库用法::

    from shandong_school_cracked.app import App

    app = App()
    app.start_mock()                      # 本地 Mock 服务端
    app.login("13800138000", "any")       # 登录
    app.run_auto(target_m=2000)           # 跑完 2 公里并上传
    print(app.status()["last"])           # 查看本次结果
"""

from .constants import APP_VERSION

#: 本工程（工作台）自身版本，与复刻的 App 版本 APP_VERSION 区分开
__version__ = "2.2.1"

__all__ = ["APP_VERSION", "__version__", "App", "ShanDongClient", "RunEngine"]


def __getattr__(name: str):
    """按需导入重型子模块，避免 `import shandong_school_cracked` 时加载网络/图形依赖。"""
    if name == "App":
        from .app import App
        return App
    if name in ("ShanDongClient", "ShandongClient"):
        from .client import ShandongClient
        return ShandongClient
    if name == "RunEngine":
        from .engine import RunEngine
        return RunEngine
    raise AttributeError(f"module 'shandong-school_cracked' has no attribute {name!r}")
