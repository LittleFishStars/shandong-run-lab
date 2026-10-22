package com.kc.openset.sdk.mat;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.sdk.apiad.tools.c;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class AwardsTipDialog extends AlertDialog implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private OnActionClickListener f39932a;
    private c b;

    @Keep
    public interface OnActionClickListener {
        void onContinueVideo();

        void onFasterAward();
    }

    @Keep
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f39933a;
        final TextView b;
        final AwardsTipDialog c;

        static {
            OSETSDKProtected.interface11(4910);
        }

        public a(AwardsTipDialog awardsTipDialog, int i, TextView textView) {
            this.c = awardsTipDialog;
            this.f39933a = i;
            this.b = textView;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    static {
        OSETSDKProtected.interface11(4911);
    }

    public AwardsTipDialog(Context context) {
        super(context);
    }

    public static native /* synthetic */ OnActionClickListener a(AwardsTipDialog awardsTipDialog);

    private native void a(TextView textView, int i);

    public static native /* synthetic */ void a(AwardsTipDialog awardsTipDialog, TextView textView, int i);

    public native AwardsTipDialog a(c cVar);

    public native AwardsTipDialog a(OnActionClickListener onActionClickListener);

    @Override // android.view.View.OnClickListener
    public native void onClick(View view);

    @Override // android.app.AlertDialog, android.app.Dialog
    public native void onCreate(Bundle bundle);
}
