/* 前后端桥：pywebview 桌面壳（window.pywebview.api）或 HTTP 降级（POST /api） */
export const Bridge = {
  ready: false,
  mode: '未知',

  async waitReady(timeoutMs = 15000) {
    if (this.ready) return true;
    const t0 = Date.now();
    while (Date.now() - t0 < timeoutMs) {
      if (window.pywebview && window.pywebview.api && typeof window.pywebview.api.ping === 'function') {
        try {
          const r = await window.pywebview.api.ping();
          if (r && r.ok) { this.ready = true; this.mode = 'desktop'; return true; }
        } catch (_) { /* 代理还没接好 */ }
      }
      // 浏览器 HTTP 降级：没有 pywebview 注入时就别干等，直接走 /api
      if (!window.pywebview && Date.now() - t0 > 1200 && location.protocol.startsWith('http')) {
        this.ready = true;
        this.mode = 'http';
        return true;
      }
      await new Promise((r) => setTimeout(r, 120));
    }
    if (!window.pywebview && location.protocol.startsWith('http')) {
      this.ready = true;
      this.mode = 'http';
      return true;
    }
    return false;
  },

  async call(method, ...args) {
    if (!this.ready) await this.waitReady();
    if (window.pywebview && window.pywebview.api && typeof window.pywebview.api[method] === 'function') {
      const out = await window.pywebview.api[method](...args);
      if (out !== undefined) return out;
      this.ready = false;
      if (await this.waitReady(5000)) return await window.pywebview.api[method](...args);
    }
    if (!location.protocol.startsWith('http')) {
      throw new Error('桌面桥未就绪（window.pywebview 不存在，且非 HTTP 模式）');
    }
    const r = await fetch('/api', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ method, args }),
    });
    return await r.json();
  },
};
