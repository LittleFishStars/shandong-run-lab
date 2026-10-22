package com.google.android.exoplayer2.text;

import com.zj.adlib.xy1;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface TextOutput {
    void j(xy1 xy1Var);

    @Deprecated
    default void onCues(List<Cue> list) {
    }
}
