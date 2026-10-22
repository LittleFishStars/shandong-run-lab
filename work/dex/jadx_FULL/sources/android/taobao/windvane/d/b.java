package android.taobao.windvane.d;

import android.content.Context;
import android.taobao.windvane.base.IBridgeDelegateService;
import android.view.View;
import android.webkit.ValueCallback;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public interface b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Integer> f21207a = new ConcurrentHashMap<>();
    public static final List<Runnable> b = new ArrayList();

    Context _getContext();

    boolean _post(Runnable runnable);

    void addJsObject(String str, Object obj);

    boolean back();

    void clearCache();

    void evaluateJavascript(String str);

    void evaluateJavascript(String str, ValueCallback<String> valueCallback);

    void fireEvent(String str, String str2);

    IBridgeDelegateService getBridgeDelegate();

    Context getContext();

    String getDataOnActive();

    Object getJsObject(String str);

    String getUrl();

    String getUserAgentString();

    View getView();

    void hideLoadingView();

    void loadUrl(String str);

    void refresh();

    void setDataOnActive(String str);

    void setUserAgentString(String str);

    void showLoadingView();
}
