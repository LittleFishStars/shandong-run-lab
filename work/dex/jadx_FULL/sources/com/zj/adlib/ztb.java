package com.zj.adlib;

import android.webkit.WebView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class ztb implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WebView f46339a;

    public ztb(WebView webView) {
        this.f46339a = webView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f46339a.evaluateJavascript("(function () {\n  const disableMIDI = function () {\n    try {\n      Object.defineProperty(navigator, 'requestMIDIAccess', {\n        configurable: true,\n        writable: true,\n        value: function () {\n          console.warn('Web MIDI is disabled in Android WebView');\n          return Promise.reject(\n            new Error('Web MIDI API is not supported')\n          );\n        }\n      });\n    } catch (e) {\n      console.warn('Failed to disable Web MIDI', e);\n    }\n  };\n\n  // 尽早执行\n  disableMIDI();\n\n  // DOM 变化兜底\n  if (window.MutationObserver) {\n    new MutationObserver(disableMIDI).observe(\n      document.documentElement,\n      { childList: true, subtree: true }\n    );\n  }\n\n  // iframe / DOM Ready 兜底\n  document.addEventListener('DOMContentLoaded', disableMIDI);\n})();", null);
    }
}
