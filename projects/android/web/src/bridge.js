/*
 * 前后端桥：安卓原生桥（window.SDAndroid）优先，其次 pywebview，最后 HTTP 降级（POST /api）。
 *
 * 原生桥约定（见 JsApiBridge.kt）：
 *   window.SDAndroid.call(method, argsJson)  —— argsJson 是 JSON 数组字符串，返回 JSON 字符串（需 JSON.parse）
 * pywebview（桌面壳，保留以兼容）：window.pywebview.api[method](...args) 返回对象
 * HTTP 降级（浏览器调试用）：POST /api  {"method": "...", "args": [...]} 返回 JSON
 */
export const Bridge = {
  ready: false,
  mode: '未知',

  /* 是否有原生安卓桥（window.SDAndroid.call 是同步返回字符串的函数） */
  _hasNative() {
    return !!(window.SDAndroid && typeof window.SDAndroid.call === 'function');
  },

  async waitReady(timeoutMs = 15000) {
    if (this.ready) return true;
    const t0 = Date.now();
    while (Date.now() - t0 < timeoutMs) {
      // 1) 安卓原生桥：存在即 ping 判定
      if (this._hasNative()) {
        try {
          const raw = window.SDAndroid.call('ping', '[]');
          const r = typeof raw === 'string' ? JSON.parse(raw) : raw;
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

    // 1) 安卓原生桥（最高优先级）
    if (this._hasNative()) {
      try {
        const argsJson = JSON.stringify(args);
        const raw = window.SDAndroid.call(method, argsJson);
        // 原生桥规定返回 JSON 字符串；若返回对象（防御）直接可用
        const out = typeof raw === 'string' ? JSON.parse(raw) : raw;
        if (out !== undefined) return out;
      } catch (_) {
        // 桥调用抛错：回退到下一优先级（原生桥已就绪但该方法失败时不降级，交给内层）
        this.ready = false;
        if (await this.waitReady(5000)) return await this.call(method, ...args);
        throw new Error(`原生桥调用 ${method} 失败`);
      }
      // 原生桥存在且返回 undefined → 重置重试一次
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