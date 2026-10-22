package android.taobao.windvane.embed;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.uc.webview.export.extension.EmbedViewConfig;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class b extends BaseEmbedView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    TextView f21213a;

    @Override // android.taobao.windvane.embed.BaseEmbedView, android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if (str2 == null) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            if ("setText".equals(str)) {
                TextView textView = this.f21213a;
                if (textView != null) {
                    textView.setText(jSONObject.getString("text"));
                    wVCallBackContext.success();
                }
                return true;
            }
            if ("setTextSize".equals(str)) {
                TextView textView2 = this.f21213a;
                if (textView2 != null) {
                    textView2.setTextSize(Float.valueOf(jSONObject.getString("size")).floatValue());
                    wVCallBackContext.success();
                }
                return true;
            }
            if ("setBackground".equals(str)) {
                TextView textView3 = this.f21213a;
                if (textView3 != null) {
                    textView3.setBackgroundColor(Color.parseColor(jSONObject.getString("color")));
                    wVCallBackContext.success();
                }
                return true;
            }
            if (!"setTextColor".equals(str)) {
                return false;
            }
            TextView textView4 = this.f21213a;
            if (textView4 != null) {
                textView4.setTextColor(Color.parseColor(jSONObject.getString("color")));
                wVCallBackContext.success();
            }
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // android.taobao.windvane.embed.BaseEmbedView
    public View generateView(Context context) {
        int i;
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        EmbedViewConfig embedViewConfig = this.params;
        int i2 = embedViewConfig.mWidth;
        int i3 = embedViewConfig.mHeight;
        if (context instanceof Activity) {
            Display defaultDisplay = ((Activity) context).getWindowManager().getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            i = displayMetrics.widthPixels;
        } else {
            i = 0;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) (i3 * (i / i2)));
        layoutParams.addRule(13);
        TextView textView = new TextView(context);
        this.f21213a = textView;
        textView.setBackgroundColor(-7829368);
        this.f21213a.setText("EmbedView DEMO");
        this.f21213a.setTextColor(-65536);
        this.f21213a.setTextSize(30.0f);
        this.f21213a.setGravity(17);
        relativeLayout.addView(this.f21213a, layoutParams);
        return relativeLayout;
    }

    @Override // android.taobao.windvane.embed.BaseEmbedView
    public String getViewType() {
        return "demo";
    }
}
