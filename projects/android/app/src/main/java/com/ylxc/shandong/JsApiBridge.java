package com.ylxc.shandong;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;

import org.json.JSONObject;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * JS → Java → Python 的桥。
 *
 * 提供两种调用方式：
 *
 *  1) **异步（前端首选）**
 *     JS:   window.SDAndroid.callAsync(method, argsJson, cbId)   // 立即返回 void
 *     Java: 提交到单线程执行器执行，完成后在 UI 线程
 *           webView.evaluateJavascript("__sdBridgeResolve(cbId, <结果JSON>)")
 *     好处：JS 主线程不被占住，遮罩/转圈/点击反馈都能正常渲染。
 *
 *  2) 同步（保留兼容与降级）
 *     JS:   window.SDAndroid.call(method, argsJson) → 返回 JSON 字符串
 *     注意：它会在 JS 侧**同步等待**整个 Python 调用（future.get），
 *     期间 WebView 的 JS 主线程被占满，界面完全冻住 —— 不要用于耗时操作。
 *
 * 两者都跑在同一个单线程执行器上，保证 Python 侧 dispatch 串行、先到先得。
 * 任何异常都包装成 {"error": "<stage>: <msg>"}，绝不向 JS 抛未处理异常。
 */
public class JsApiBridge {

    private static final String TAG = "SDJsApi";

    private final Context context;
    private final HostBridge hostBridge;
    /** 用于 evaluateJavascript 回调；Activity 销毁后回调安全丢弃。 */
    private volatile WebView webView;

    // 单线程执行器：保证 Python 侧 dispatch 串行执行
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    // Python android_api 模块缓存（懒加载 + 只初始化一次）
    private volatile PyObject pyModule;
    private volatile boolean initFailed = false;

    /** 已投递但 Activity 可能已销毁时的兜底，避免向已回收的 WebView 回调。 */
    private final AtomicBoolean closed = new AtomicBoolean(false);

    public JsApiBridge(Context context, HostBridge hostBridge) {
        this.context = context;
        this.hostBridge = hostBridge;
    }

    /** 由 MainActivity 在 WebView 建好后注入，异步回调需要它。 */
    public void setWebView(WebView view) {
        this.webView = view;
    }

    // ────────────────────────── 异步入口（首选） ──────────────────────────

    /**
     * JS 入口：立即返回，结果通过 window.__sdBridgeResolve(cbId, payload) 回传。
     *
     * @param method  桥方法名
     * @param argsJson 参数 JSON 数组字符串
     * @param cbId    前端生成的回调 id（字符串，保证唯一）
     */
    @JavascriptInterface
    public void callAsync(final String method, final String argsJson, final String cbId) {
        if (cbId == null || cbId.isEmpty()) {
            Log.w(TAG, "callAsync 缺少 cbId，忽略: method=" + method);
            return;
        }
        Log.d(TAG, "callAsync: id=" + cbId + ", method=" + method);
        executor.execute(() -> {
            String payload;
            try {
                payload = dispatch(method, argsJson);
            } catch (Throwable t) {
                payload = errorJson("async", t);
            }
            deliverResult(cbId, payload);
        });
    }

    /** 把结果送回 JS（必须切到 UI 线程调 evaluateJavascript）。 */
    private void deliverResult(final String cbId, final String payload) {
        if (closed.get()) return;
        final WebView view = this.webView;
        if (view == null) {
            Log.w(TAG, "deliverResult: webView 为空，丢弃回调 " + cbId);
            return;
        }
        // 用 JSONObject.quote 生成合法的 JS 字符串字面量（含引号与转义）
        final String js = "window.__sdBridgeResolve("
                + JSONObject.quote(cbId) + ","
                + JSONObject.quote(payload == null ? "null" : payload) + ")";
        Runnable post = () -> {
            if (closed.get()) return;
            if (context instanceof Activity) {
                Activity a = (Activity) context;
                if (a.isFinishing() || a.isDestroyed()) return;
            }
            try {
                view.evaluateJavascript(js, null);
            } catch (Throwable t) {
                Log.w(TAG, "evaluateJavascript 失败: " + t);
            }
        };
        if (context instanceof Activity) {
            ((Activity) context).runOnUiThread(post);
        } else {
            view.post(post);
        }
    }

    // ────────────────────────── 同步入口（降级） ──────────────────────────

    /**
     * JS 入口（同步，会阻塞 JS 主线程）。仅供不支持 callAsync 的场景或调试使用。
     */
    @JavascriptInterface
    public String call(final String method, final String argsJson) {
        Log.d(TAG, "call(sync): method=" + method + ", args=" + (argsJson == null ? "null" : argsJson));
        try {
            Future<String> future = executor.submit(() -> dispatch(method, argsJson));
            return future.get();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return errorJson("interrupted", e);
        } catch (ExecutionException e) {
            return errorJson("execution", e.getCause() != null ? e.getCause() : e);
        } catch (Exception e) {
            return errorJson("java", e);
        }
    }

    // ────────────────────────── 公共部分 ──────────────────────────

    private String errorJson(String stage, Throwable t) {
        String msg = (t == null) ? "unknown" : String.valueOf(t);
        return errorJsonText(stage, msg);
    }

    private String errorJsonText(String stage, String text) {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"error\":\"");
        sb.append(stage == null ? "" : stage);
        sb.append(": ");
        if (text != null) {
            sb.append(text.replace("\\", "\\\\").replace("\"", "\\\""));
        }
        sb.append("\"}");
        return sb.toString();
    }

    /** 实际执行 Python 分发（运行在单线程执行器内部）。 */
    private String dispatch(String method, String argsJson) {
        try {
            PyObject module = ensureModule();
            if (module == null) {
                return errorJsonText("python_not_ready",
                        "android_api 模块初始化失败（可能 Python 侧尚未就绪）");
            }
            PyObject ret = module.callAttr(
                    "dispatch",
                    method == null ? "" : method,
                    argsJson == null ? "[]" : argsJson);
            return ret == null ? "null" : ret.toString();
        } catch (Throwable t) {
            return errorJson("python_dispatch", t);
        }
    }

    /** 懒加载并初始化 android_api 模块，并向它注册 HostBridge。 */
    private synchronized PyObject ensureModule() {
        if (pyModule != null) {
            return pyModule;
        }
        if (initFailed) {
            return null;
        }
        try {
            if (!Python.isStarted()) {
                Python.start(new com.chaquo.python.android.AndroidPlatform(context));
            }
            Python py = Python.getInstance();
            this.pyModule = py.getModule("android_api");
            try {
                this.pyModule.callAttr("set_host", hostBridge);
                Log.i(TAG, "android_api.set_host 注入完成");
            } catch (Throwable t) {
                Log.w(TAG, "android_api.set_host 不存在或失败（可忽略）: " + t);
            }
            return this.pyModule;
        } catch (Throwable t) {
            initFailed = true;
            Log.e(TAG, "初始化 android_api 模块失败", t);
            return null;
        }
    }

    /** Activity 销毁时调用：停止回调投递并关闭执行器。 */
    public void shutdown() {
        closed.set(true);
        webView = null;
        executor.shutdown();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        executor.shutdown();
    }
}
