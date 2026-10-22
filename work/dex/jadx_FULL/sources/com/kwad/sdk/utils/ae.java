package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public final class ae {
    private static Handler jk = new Handler(Looper.getMainLooper());
    private static volatile boolean NK = false;

    public static void U(Context context, String str) {
        b(context, str, R.layout.ksad_toast_success);
    }

    public static void V(Context context, String str) {
        b(context, str, R.layout.ksad_content_alliance_toast_2);
    }

    public static void W(Context context, String str) {
        c(context, str, 0L);
    }

    private static void a(Context context, String str, int i, long j) {
        if (com.kwad.framework.a.a.ayO.booleanValue() && !NK) {
            NK = true;
            View viewInflate = com.kwad.sdk.wrapper.m.inflate(context, i, null);
            ((TextView) viewInflate.findViewById(R.id.ksad_message_toast_txt)).setText(str);
            Toast toast = new Toast(context.getApplicationContext());
            toast.setGravity(17, 0, 0);
            toast.setDuration(0);
            toast.setView(viewInflate);
            toast.show();
            jk.postDelayed(new bi() { // from class: com.kwad.sdk.utils.ae.1
                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    ae.access$002(false);
                }
            }, j);
        }
    }

    public static /* synthetic */ boolean access$002(boolean z) {
        NK = false;
        return false;
    }

    private static void b(Context context, String str, int i) {
        a(context, str, i, 800L);
    }

    public static void c(Context context, String str, long j) {
        a(context, str, R.layout.ksad_content_alliance_toast_2, 0L);
    }

    public static void d(Context context, String str, long j) {
        a(context, str, R.layout.ksad_toast_corner, 0L);
    }

    public static void c(Context context, String str, int i) {
        if (com.kwad.framework.a.a.ayO.booleanValue()) {
            Context applicationContext = context.getApplicationContext();
            View viewInflate = LayoutInflater.from(applicationContext).inflate(R.layout.ksad_content_alliance_toast, (ViewGroup) null);
            ((TextView) viewInflate.findViewById(R.id.ksad_message_toast_txt)).setText(str);
            Toast toast = new Toast(applicationContext);
            toast.setGravity(17, 0, 0);
            toast.setDuration(0);
            toast.setView(viewInflate);
            toast.show();
        }
    }
}
