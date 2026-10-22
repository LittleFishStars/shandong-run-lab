package com.ipd.dsp.internal.z0;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.R;
import com.ipd.dsp.open.BaseProxyActivity;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class e {
    public static void a(Context context, com.ipd.dsp.internal.e1.d dVar) {
        Intent intent = new Intent(context, (Class<?>) BaseProxyActivity.class);
        intent.putExtra(com.ipd.dsp.internal.s0.b.b, a.class.getName());
        intent.putExtra("TB", R.style.Theme_AppCompat_DayNight_DarkActionBar);
        intent.putExtra(com.ipd.dsp.internal.s0.b.e, true);
        intent.putExtra("data", dVar);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    public static void b(Context context, int i, com.ipd.dsp.internal.e1.d dVar, boolean z, String str) {
        Intent intent = new Intent(context, (Class<?>) BaseProxyActivity.class);
        intent.putExtra(com.ipd.dsp.internal.s0.b.b, d.class.getName());
        intent.putExtra("TB", R.style.Theme_AppCompat_NoActionBar);
        intent.putExtra("be", i);
        intent.putExtra("uuid", str);
        intent.putExtra("data", dVar);
        intent.putExtra("isVolumeOn", z);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    public static void a(Context context, int i, com.ipd.dsp.internal.e1.d dVar, boolean z, String str) {
        Intent intent = new Intent(context, (Class<?>) BaseProxyActivity.class);
        intent.putExtra(com.ipd.dsp.internal.s0.b.b, c.class.getName());
        intent.putExtra("TB", com.ipd.dsp.R.style.IPD_APPCOMPAT_TRANSLUCENT);
        intent.putExtra(com.ipd.dsp.internal.s0.b.d, true);
        intent.putExtra("be", i);
        intent.putExtra("data", dVar);
        intent.putExtra("isVolumeOn", z);
        intent.putExtra("uuid", str);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }
}
