package com.ylxc.shandong;

/**
 * 宿主桥接口：Java → Android 系统能力。
 *
 * 该接口实现由 Java 侧（MainActivity / JsApiBridge 内部）持有，
 * 并可通过 Chaquopy 回调给 Python 侧（android_env.set_host(host)）注入本实例，
 * 用于替代桌面版 webbrowser / print / 退出等平台相关行为。
 */
public interface HostBridge {

    /** 用系统浏览器打开指定 URL。 */
    void openUrl(String url);

    /** 退出应用（finish 当前 Activity）。 */
    void quit();

    /** 弹出 Toast 提示。 */
    void toast(String msg);

    /** 返回设备指纹 JSON 字符串 {manufacturer, model, brand, release, sdkInt}。 */
    String deviceInfoJson();
}