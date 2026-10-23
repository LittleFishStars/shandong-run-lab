package com.ylxc.shandong;

import android.content.Context;
import android.util.Log;
import android.webkit.JavascriptInterface;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;


import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * JS → Java → Python 的桥。
 *
 * JS 侧通过 window.SDAndroid.call(method, argsJson) 调用本类；请求被排入
 * 单线程 ExecutorService（Python 侧非重入，串行即可保证先到先得的一致语义），
 * 阻塞等待结果后以 JSON 字符串返回。任何异常都包装为 {"error": "..."}，
 * 绝不向 JS 抛未经处理的异常。
 */
public class JsApiBridge {

    private static final String TAG = "SDJsApi";

    private final Context context;
    private final HostBridge hostBridge;

    // 单线程执行器：保证 Python 侧 dispatch 串行执行
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    // Python android_api 模块缓存（懒加载 + 只初始化一次）
    private volatile PyObject pyModule;
    private volatile boolean initFailed = false;

    public JsApiBridge(Context context, HostBridge hostBridge) {
        this.context = context;
        this.hostBridge = hostBridge;
    }

    /**
     * JS 入口，注入到 window.SDAndroid。供 JS 侧使用。
     */
    @JavascriptInterface
    public String call(final String method, final String argsJson) {
        Log.d(TAG, "call: method=" + method + ", args=" + (argsJson == null ? "null" : argsJson));
        try {
            // 在单线程执行器上执行，避免 Python 侧重入
            Future<String> future = executor.submit(() -> dispatch(method, argsJson));
            // 阻塞等待结果
            return future.get();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return errorJson("interrupted", e);
        } catch (ExecutionException e) {
            // 包装 Python 侧抛出的异常
            return errorJson("execution", e.getCause() != null ? e.getCause() : e);
        } catch (Exception e) {
            return errorJson("java", e);
        }
    }

    /**
     * 构造 JSON 错误字符串：{"error": "<stage>: <msg>"}。
     */
    private String errorJson(String stage, Throwable t) {
        String msg = (t == null) ? "unknown" : String.valueOf(t);
        return errorJsonText(stage, msg);
    }

    /**
     * 构造 JSON 错误字符串：{"error": "<stage>: <text>}。
     */
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

    /**
     * 实际执行 Python 分发（运行在单线程执行器内部）。
     */
    private String dispatch(String method, String argsJson) {
        try {
            PyObject module = ensureModule();
            if (module == null) {
                return errorJsonText("python_not_ready",
                        "android_api 模块初始化失败（可能 Python 侧尚未就绪）");
            }
            // 同步调用 Python 侧 dispatch(method, args_json)
            // Chaquopy 正式 API：callAttr(name, Object...) 调用模块属性函数
            // （getAttr 是 Jython 风格，Chaquopy 17 没有）
            PyObject ret = module.callAttr(
                    "dispatch",
                    method == null ? "" : method,
                    argsJson == null ? "[]" : argsJson);
            // dispatch 返回 Python str（JSON 文本），toString() 即原样字符串
            return ret == null ? "null" : ret.toString();
        } catch (Throwable t) {
            return errorJson("python_dispatch", t);
        }
    }

    /**
     * 懒加载并初始化 android_api 模块，且向它注册 HostBridge（容错 set_host）。
     */
    private synchronized PyObject ensureModule() {
        if (pyModule != null) {
            return pyModule;
        }
        if (initFailed) {
            return null;
        }
        try {
            // Chaquopy 启动兜底：Python.isStarted() 检查，未启动则 start
            if (!Python.isStarted()) {
                Python.start(new com.chaquo.python.android.AndroidPlatform(context));
            }
            Python py = Python.getInstance();
            this.pyModule = py.getModule("android_api");

            // 首次 dispatch 前注入 host：调用 android_api.set_host(hostBridge)
            // 若该函数不存在则容错（try/catch 静默），不阻塞业务
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

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        executor.shutdown(); // 尽力关闭执行器（进程退出时兜底）
    }
}