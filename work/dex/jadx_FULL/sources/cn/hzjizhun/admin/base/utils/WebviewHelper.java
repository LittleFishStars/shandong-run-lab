package cn.hzjizhun.admin.base.utils;

import android.webkit.WebView;
import com.zj.adlib.ztb;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class WebviewHelper {
    private static final String midijsCode = "(function () {\n  const disableMIDI = function () {\n    try {\n      Object.defineProperty(navigator, 'requestMIDIAccess', {\n        configurable: true,\n        writable: true,\n        value: function () {\n          console.warn('Web MIDI is disabled in Android WebView');\n          return Promise.reject(\n            new Error('Web MIDI API is not supported')\n          );\n        }\n      });\n    } catch (e) {\n      console.warn('Failed to disable Web MIDI', e);\n    }\n  };\n\n  // 尽早执行\n  disableMIDI();\n\n  // DOM 变化兜底\n  if (window.MutationObserver) {\n    new MutationObserver(disableMIDI).observe(\n      document.documentElement,\n      { childList: true, subtree: true }\n    );\n  }\n\n  // iframe / DOM Ready 兜底\n  document.addEventListener('DOMContentLoaded', disableMIDI);\n})();";

    public static void injectMIDIBlockerJS(WebView webView) {
        if (webView != null) {
            try {
                webView.post(new ztb(webView));
            } catch (Throwable unused) {
            }
        }
    }
}
