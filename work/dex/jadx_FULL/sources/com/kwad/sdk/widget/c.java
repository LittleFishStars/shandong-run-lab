package com.kwad.sdk.widget;

import android.app.Dialog;
import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.wrapper.m;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Deprecated
public class c extends Dialog {
    public c(@NonNull Context context) {
        super(m.wrapContextIfNeed(context));
        requestWindowFeature(1);
    }
}
