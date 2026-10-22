package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.zj.adlib.d3c;
import com.zj.adlib.o3c;
import com.zj.adlib.v3c;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class zag implements DialogInterface.OnClickListener {
    public static zag a(Activity activity, @Nullable Intent intent, int i) {
        return new d3c(intent, activity, i);
    }

    public static zag b(@NonNull Fragment fragment, @Nullable Intent intent, int i) {
        return new o3c(intent, fragment, i);
    }

    public static zag c(@NonNull LifecycleFragment lifecycleFragment, @Nullable Intent intent, int i) {
        return new v3c(intent, lifecycleFragment, 2);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        try {
            zaa();
        } catch (ActivityNotFoundException e) {
            Log.e("DialogRedirect", true == Build.FINGERPRINT.contains("generic") ? "Failed to start resolution intent. This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store." : "Failed to start resolution intent.", e);
        } finally {
            dialogInterface.dismiss();
        }
    }

    public abstract void zaa();
}
