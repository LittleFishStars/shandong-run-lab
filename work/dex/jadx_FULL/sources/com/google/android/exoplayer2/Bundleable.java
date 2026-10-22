package com.google.android.exoplayer2;

import android.os.Bundle;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface Bundleable {

    public interface Creator<T extends Bundleable> {
        T a(Bundle bundle);
    }

    Bundle toBundle();
}
