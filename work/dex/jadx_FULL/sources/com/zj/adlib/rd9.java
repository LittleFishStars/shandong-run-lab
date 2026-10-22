package com.zj.adlib;

import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.ttml.TtmlStyle;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class rd9 implements Subtitle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final od9 f44427a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Map<String, TtmlStyle> f19273a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final long[] f19274a;
    public final Map<String, pd9> b;
    public final Map<String, String> c;

    public rd9(od9 od9Var, Map<String, TtmlStyle> map, Map<String, pd9> map2, Map<String, String> map3) {
        this.f44427a = od9Var;
        this.b = map2;
        this.c = map3;
        this.f19273a = map != null ? Collections.unmodifiableMap(map) : Collections.emptyMap();
        this.f19274a = od9Var.j();
    }

    @VisibleForTesting
    public Map<String, TtmlStyle> a() {
        return this.f19273a;
    }

    @VisibleForTesting
    public od9 b() {
        return this.f44427a;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public List<Cue> getCues(long j) {
        return this.f44427a.h(j, this.f19273a, this.b, this.c);
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public long getEventTime(int i) {
        return this.f19274a[i];
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getEventTimeCount() {
        return this.f19274a.length;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getNextEventTimeIndex(long j) {
        int iF = gj9.f(this.f19274a, j, false, false);
        if (iF < this.f19274a.length) {
            return iF;
        }
        return -1;
    }
}
