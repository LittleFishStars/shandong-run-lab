package com.kc.bw.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.webkit.WebView;
import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class CustomWebView extends WebView {
    public TouchCallback touchCallback;

    @Keep
    public interface TouchCallback {
        void touchBack();
    }

    public CustomWebView(Context context) {
        super(getFixedContext(context));
    }

    public CustomWebView(Context context, AttributeSet attributeSet) {
        super(getFixedContext(context), attributeSet);
    }

    public CustomWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public static Context getFixedContext(Context context) {
        return context;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.touchCallback == null) {
            return false;
        }
        Log.d(dexg.dexa("TqmbtiSfmbujwf"), dexg.dexa("poJoufsdfquUpvdiFwfou;!"));
        this.touchCallback.touchBack();
        return false;
    }

    public void setTouchCallback(TouchCallback touchCallback) {
        this.touchCallback = touchCallback;
    }
}
