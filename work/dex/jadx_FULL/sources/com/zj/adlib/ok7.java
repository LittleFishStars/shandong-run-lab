package com.zj.adlib;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.DataSpec;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class ok7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f43768a = "rtp://0.0.0.0";

    public static DataSpec a(int i) {
        return new DataSpec(Uri.parse(gj9.H("%s:%d", f43768a, Integer.valueOf(i))));
    }
}
