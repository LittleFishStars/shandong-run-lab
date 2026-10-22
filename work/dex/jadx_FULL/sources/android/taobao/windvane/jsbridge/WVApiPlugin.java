package android.taobao.windvane.jsbridge;

import android.content.Context;
import android.content.Intent;
import android.taobao.windvane.d.b;
import android.taobao.windvane.util.TaoLog;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public abstract class WVApiPlugin {
    public static final int REQUEST_MULTI_PICK_PHOTO = 4003;
    public static final int REQUEST_PICK_PHONE = 4003;
    public static final int REQUEST_PICK_PHOTO = 4002;
    public static final int REQUEST_TAKE_PHOTO = 4001;
    protected boolean isAlive = true;
    protected Context mContext;
    protected b mWebView;
    protected Object paramObj;

    public abstract boolean execute(String str, String str2, WVCallBackContext wVCallBackContext);

    public boolean executeSafe(String str, String str2, WVCallBackContext wVCallBackContext) {
        try {
            return execute(str, str2, wVCallBackContext);
        } catch (Exception e) {
            TaoLog.e("WVJsBridge", e.getMessage());
            return false;
        }
    }

    public void initialize(Context context, b bVar) {
        this.mContext = context;
        this.mWebView = bVar;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    public void onDestroy() {
        this.isAlive = false;
    }

    public void onPause() {
        this.isAlive = false;
    }

    public void onResume() {
        this.isAlive = true;
    }

    public void onScrollChanged(int i, int i2, int i3, int i4) {
    }

    @Deprecated
    public void initialize(Context context, b bVar, Object obj) {
        initialize(context, bVar);
    }

    public void initialize(Context context, b bVar, Object obj, String str) {
        this.paramObj = obj;
        initialize(context, bVar, obj);
    }
}
