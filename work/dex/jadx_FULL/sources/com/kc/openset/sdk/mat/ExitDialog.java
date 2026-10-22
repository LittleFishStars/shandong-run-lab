package com.kc.openset.sdk.mat;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class ExitDialog extends AlertDialog implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f39934a;
    private OnExitClickListener b;
    private OnContinueListener c;

    @Keep
    public interface OnContinueListener {
        void onContinue();
    }

    @Keep
    public interface OnExitClickListener {
        void onExitClick();
    }

    static {
        OSETSDKProtected.interface11(4914);
    }

    public ExitDialog(Context context) {
        super(context);
    }

    public native ExitDialog a(String str);

    public native void a(OnExitClickListener onExitClickListener);

    @Override // android.view.View.OnClickListener
    public native void onClick(View view);

    @Override // android.app.AlertDialog, android.app.Dialog
    public native void onCreate(Bundle bundle);
}
