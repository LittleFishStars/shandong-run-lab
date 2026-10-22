package com.byazt.euv;

import android.app.Activity;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_LOADCONTROL_BUFFERINGTIMEOUT, 20})
public class c implements View.OnClickListener {
    public final Activity c;
    public final String tt;
    public Method uj;
    public final int ve;

    public c(@NonNull Activity activity, int i, @NonNull String str) {
        this.c = activity;
        this.tt = str;
        this.ve = i;
    }

    @NonNull
    private void c(@Nullable Activity activity, @NonNull String str) {
        try {
            Method method = activity.getClass().getMethod(this.tt, View.class);
            if (method != null) {
                this.uj = method;
                return;
            }
        } catch (NoSuchMethodException unused) {
        }
        throw new IllegalStateException("Could not find method " + this.tt + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.ve);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NonNull View view) {
        if (this.uj == null) {
            c(this.c, this.tt);
        }
        try {
            this.uj.invoke(this.c, view);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("Could not execute non-public method for android:onClick", e);
        } catch (InvocationTargetException e2) {
            throw new IllegalStateException("Could not execute method for android:onClick", e2);
        }
    }
}
