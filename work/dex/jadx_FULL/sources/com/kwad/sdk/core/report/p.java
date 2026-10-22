package com.kwad.sdk.core.report;

import android.content.Context;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class p extends c {
    public static int Pj = 1;
    private static String aWD = "CREATE TABLE IF NOT EXISTS ksad_actions (actionId varchar(60) primary key, aLog TEXT)";

    public p(@Nullable Context context, int i) {
        super(context, "ksadrep.db", i, aWD);
    }
}
