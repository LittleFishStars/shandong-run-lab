/*
 * 前后端桥：安卓原生桥（window.SDAndroid）优先，其次 pywebview，最后 HTTP 降级（POST /api）。
 *
 * 原生桥两种形态（见 JsApiBridge.java）：
 *   1) 异步（首选）：window.SDAndroid.callAsync(method, argsJson, cbId) -> void
 *      结果由 Java 在 UI 线程回调 window.__sdBridgeResolve(cbId, payloadJsonString)。
 *      ★ 不阻塞 JS 主线程，遮罩/转圈/点击反馈都能正常渲染。
 *   2) 同步（降级）：window.SDAndroid.call(method, argsJson) -> JSON 字符串
 *      ★ 会同步阻塞 JS 主线程直到 Python 返回，界面完全冻住，仅作兜底。
 *
 * pywebview（桌面壳，保留以兼容）：window.pywebview.api[method](...args) 返回对象
 * HTTP 降级（浏览器调试用）：POST /api  {"method": "...", "args": [...]} 返回 JSON
 */

/* ── 异步回调登记表 ── */
const pending = new Map();
let cbSeq = 0;

/* Java 侧通过 evaluateJavascript 调用此函数投递结果。
   页面刷新后旧 id 自然失效（表已清空），此处静默忽略即可。 */
window.__sdBridgeResolve = function (cbId, payload) {
  const fn = pending.get(cbId);
  if (!fn) return;
  pending.delete(cbId);
  fn(payload);
};

/* 单次桥调用超时：登录含滑块、结算上传都可能较久，给足 3 分钟。
   超时后 reject，避免页面被切走或 App 重启导致 Promise 永久悬挂。 */
const BRIDGE_TIMEOUT_MS = 180000;

function nativeCallAsync(method, argsJson) {
  return new Promise((resolve, reject) => {
    const cbId = 'cb' + (++cbSeq) + '_' + Date.now().toString(36);
    const timer = setTimeout(() => {
      pending.delete(cbId);
      reject(new Error(`桥调用超时（${method}）`));
    }, BRIDGE_TIMEOUT_MS);
    pending.set(cbId, (payload) => {
      clearTimeout(timer);
      resolve(payload);
    });
    try {
      window.SDAndroid.callAsync(method, argsJson, cbId);
    } catch (e) {
      clearTimeout(timer);
      pending.delete(cbId);
      reject(e);
    }
  });
}

export const Bridge = {
  ready: false,
  mode: '未知',

  /* 是否有原生安卓桥 */
  _hasNative() {
    return !!(window.SDAndroid && (typeof window.SDAndroid.callAsync === 'function'
      || typeof window.SDAndroid.call === 'function'));
  },

  /* 是否支持异步桥（新版 APK）；否则退化到同步 */
  _hasNativeAsync() {
    return !!(window.SDAndroid && typeof window.SDAndroid.callAsync === 'function');
  },

  /* 统一的原生桥调用：异步优先 */
  async _nativeCall(method, args) {
    const argsJson = JSON.stringify(args);
    const raw = this._hasNativeAsync()
      ? await nativeCallAsync(method, argsJson)
      : window.SDAndroid.call(method, argsJson);
    return typeof raw === 'string' ? JSON.parse(raw) : raw;
  },

  async waitReady(timeoutMs = 15000) {
    if (this.ready) return true;
    const t0 = Date.now();
    while (Date.now() - t0 < timeoutMs) {
      // 1) 安卓原生桥：存在即 ping 判定
      if (this._hasNative()) {
        try {
          const r = await this._nativeCall('ping', []);
          if (r && r.ok) { this.ready = true; this.mode = 'native'; return true; }
        } catch (_) { /* ping 失败，继续等待 */ }
      }
      // 2) pywebview 桌面壳
      if (window.pywebview && window.pywebview.api && typeof window.pywebview.api.ping === 'function') {
        try {
          const r = await window.pywebview.api.ping();
          if (r && r.ok) { this.ready = true; this.mode = 'desktop'; return true; }
        } catch (_) { /* 代理还没接好 */ }
      }
      // 3) HTTP 降级：没有原生桥/pywebview 时别干等，直接走 /api
      if (!this._hasNative() && !window.pywebview && Date.now() - t0 > 1200 && location.protocol.startsWith('http')) {
        this.ready = true;
        this.mode = 'http';
        return true;
      }
      await new Promise((r) => setTimeout(r, 120));
    }
    if (!this._hasNative() && !window.pywebview && location.protocol.startsWith('http')) {
      this.ready = true;
      this.mode = 'http';
      return true;
    }
    return false;
  },

  async call(method, ...args) {
    if (!this.ready) await this.waitReady();

    // 1) 安卓原生桥（最高优先级，异步）
    if (this._hasNative()) {
      try {
        const out = await this._nativeCall(method, args);
        if (out !== undefined) return out;
      } catch (e) {
        // 超时不重试（重试只会再等一个超时周期），其余错误重置就绪态重试一次
        if (e && /超时/.test(String((e && e.message) || e))) throw e;
        this.ready = false;
        if (await this.waitReady(5000)) return await this.call(method, ...args);
        throw new Error(`原生桥调用 ${method} 失败`);
      }
      if (this._hasNative()) return undefined;
    }

    // 2) pywebview 桌面壳
    if (window.pywebview && window.pywebview.api && typeof window.pywebview.api[method] === 'function') {
      const out = await window.pywebview.api[method](...args);
      if (out !== undefined) return out;
      this.ready = false;
      if (await this.waitReady(5000)) return await this.call(method, ...args);
    }

    // 3) HTTP 降级（浏览器调试）
    if (!location.protocol.startsWith('http')) {
      throw new Error('桥未就绪（无 SDAndroid / 无 pywebview，且非 HTTP 模式）');
    }
    const r = await fetch('/api', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ method, args }),
    });
    return await r.json();
  },
};
