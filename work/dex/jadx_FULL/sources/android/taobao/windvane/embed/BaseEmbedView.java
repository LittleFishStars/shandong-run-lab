package android.taobao.windvane.embed;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.Bitmap;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.text.TextUtils;
import android.view.View;
import com.uc.webview.export.extension.EmbedViewConfig;
import com.uc.webview.export.extension.IEmbedView;
import com.uc.webview.export.extension.IEmbedViewContainer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public abstract class BaseEmbedView extends WVApiPlugin implements IEmbedView, IEmbedViewContainer.OnParamChangedListener, IEmbedViewContainer.OnStateChangedListener, IEmbedViewContainer.OnVisibilityChangedListener {
    Context context;
    public android.taobao.windvane.d.b webView;
    public View view = null;
    public EmbedViewConfig params = null;
    public String id = "";

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        return false;
    }

    public abstract View generateView(Context context);

    public Bitmap getSnapShot() {
        return null;
    }

    public View getView() {
        View view = this.view;
        if (view != null) {
            return view;
        }
        Context context = this.context;
        if (context == null) {
            return null;
        }
        View viewGenerateView = generateView(context);
        this.view = viewGenerateView;
        return viewGenerateView;
    }

    public abstract String getViewType();

    public boolean init(String str, String str2, android.taobao.windvane.d.b bVar, EmbedViewConfig embedViewConfig) {
        String str3;
        if (!str2.equals(getViewType()) || bVar == null) {
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            str3 = "WVEmbedView";
        } else {
            str3 = "WVEmbedView_" + str;
        }
        bVar.addJsObject(str3, this);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("bridgeId", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        bVar.evaluateJavascript(String.format("javascript:window.WindVane&&window.WindVane.fireEvent('WVEmbed.Ready',%s);", jSONObject.toString()));
        this.context = bVar.getContext();
        if (bVar.getContext() instanceof MutableContextWrapper) {
            this.context = ((MutableContextWrapper) bVar.getContext()).getBaseContext();
        }
        if (!(this.context instanceof Activity)) {
            this.context = null;
        }
        this.webView = bVar;
        this.params = embedViewConfig;
        return true;
    }

    public void onAttachedToWebView() {
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public void onDestroy() {
        this.view = null;
        this.context = null;
    }

    public void onDetachedFromWebView() {
    }

    public void onParamChanged(String[] strArr, String[] strArr2) {
    }

    public void onVisibilityChanged(int i) {
    }
}
