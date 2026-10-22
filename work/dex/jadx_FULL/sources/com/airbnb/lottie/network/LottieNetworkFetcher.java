package com.airbnb.lottie.network;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface LottieNetworkFetcher {
    @NonNull
    @WorkerThread
    LottieFetchResult a(@NonNull String str) throws IOException;
}
