package com.ylxc.shandong;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.Locale;

/**
 * HostBridge 的默认实现。
 *
 * 所有需要 UI 线程的操作都通过 runOnUiThread 切回主线程执行；
 * deviceInfoJson 提供契约 §5 所需的设备指纹字段。
 */
public class HostBridgeImpl implements HostBridge {

    private final Activity activity;

    public HostBridgeImpl(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void openUrl(String url) {
        if (url == null || url.isEmpty()) {
            return;
        }
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            // 加 NEW_TASK 以防 Activity 上下文不允许直接启动
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            activity.startActivity(intent);
        } catch (Exception e) {
            // 无对应浏览器等场景，避免崩溃
            android.util.Log.w("SD", "openUrl failed: " + url, e);
        }
    }

    @Override
    public void quit() {
        activity.runOnUiThread(activity::finish);
    }

    @Override
    public void toast(final String msg) {
        activity.runOnUiThread(() -> {
            if (msg != null) {
                Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public String deviceInfoJson() {
        try {
            JSONObject o = new JSONObject();
            o.put("manufacturer", Build.MANUFACTURER);
            o.put("model", Build.MODEL);
            o.put("brand", Build.BRAND);
            o.put("release", Build.VERSION.RELEASE);
            o.put("sdkInt", Build.VERSION.SDK_INT);
            o.put("modelName", Build.MANUFACTURER + "|" + Build.MODEL);
            // 与桌面版 UA 对齐：ShanDong/<ver> (<brand>;Android <release>)
            o.put("ua", String.format(Locale.US, "ShanDong/1.0.0 (%s;Android %s)",
                    Build.BRAND, Build.VERSION.RELEASE));
            o.put("platform", "android");
            return o.toString();
        } catch (Exception e) {
            // 序列化失败返回最小对象，供上层容错
            return "{\"error\":\"deviceInfo serialization failed\"}";
        }
    }
}