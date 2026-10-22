package com.byazt.oc;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.byazt.me.da;
import com.byazt.nc.sp;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public interface ve {
    @Nullable
    List<String> a();

    @Nullable
    com.byazt.yf.tt c(Activity activity);

    @Nullable
    com.byazt.yf.tt c(Activity activity, Map<String, Object> map);

    @Nullable
    String c();

    void c(@NonNull Activity activity, @NonNull ViewGroup viewGroup, @NonNull List<View> list, @Nullable List<View> list2, @NonNull List<View> list3, da daVar);

    void c(Activity activity, com.byazt.dhf.c cVar);

    void c(Dialog dialog, Integer[] numArr);

    @Nullable
    com.byazt.me.c da();

    int i();

    double n();

    boolean sl();

    @Nullable
    String sp();

    com.byazt.nc.uj t();

    sp tt(Activity activity);

    sp tt(Dialog dialog, Integer[] numArr);

    @Nullable
    String tt();

    @Nullable
    String uj();

    @Nullable
    String ve();

    int x();
}
