package com.airbnb.lottie.network;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface LottieFetchResult extends Closeable {
    @NonNull
    InputStream K0() throws IOException;

    @Nullable
    String X();

    boolean isSuccessful();

    @Nullable
    String x0();
}
