package com.kwad.sdk.crash.online.monitor.block.a;

import android.content.Context;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.report.c;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class a extends c {
    private static String aWD = "CREATE TABLE IF NOT EXISTS ksad_block_actions (actionId varchar(60) primary key, aLog TEXT)";

    public a(@Nullable Context context, int i) {
        super(context, "ksadBlock.db", i, aWD);
    }
}
