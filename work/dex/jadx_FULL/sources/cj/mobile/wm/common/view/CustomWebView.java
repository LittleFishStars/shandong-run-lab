package cj.mobile.wm.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.webkit.WebView;
import cj.mobile.wm.dexc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class CustomWebView extends WebView {
    public TouchCallback touchCallback;

    public interface TouchCallback {
        void touchBack();
    }

    public CustomWebView(Context context) {
        super(getFixedContext(context));
    }

    public static Context getFixedContext(Context context) {
        return context;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.touchCallback == null) {
            return false;
        }
        Log.d(dexc.dexa("TqmbtiSfmbujwf"), dexc.dexa("poJoufsdfquUpvdiFwfou;!"));
        this.touchCallback.touchBack();
        return false;
    }

    public void setTouchCallback(TouchCallback touchCallback) {
        this.touchCallback = touchCallback;
    }

    public CustomWebView(Context context, AttributeSet attributeSet) {
        super(getFixedContext(context), attributeSet);
    }

    public CustomWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
