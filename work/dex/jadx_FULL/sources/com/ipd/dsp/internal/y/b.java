package com.ipd.dsp.internal.y;

import androidx.annotation.NonNull;
import com.ipd.dsp.internal.components.glide.load.ImageHeaderParser;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<ImageHeaderParser> f38607a = new ArrayList();

    @NonNull
    public synchronized List<ImageHeaderParser> a() {
        return this.f38607a;
    }

    public synchronized void a(@NonNull ImageHeaderParser imageHeaderParser) {
        this.f38607a.add(imageHeaderParser);
    }
}
