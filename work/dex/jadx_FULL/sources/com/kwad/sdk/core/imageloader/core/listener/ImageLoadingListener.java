package com.kwad.sdk.core.imageloader.core.listener;

import android.view.View;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public interface ImageLoadingListener {
    boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult);

    void onLoadingCancelled(String str, View view);

    void onLoadingComplete(String str, View view, DecodedResult decodedResult);

    void onLoadingFailed(String str, View view, FailReason failReason);

    void onLoadingStarted(String str, View view);
}
