package com.kwad.sdk.core.imageloader.core.display;

import com.kwad.sdk.core.imageloader.core.assist.LoadedFrom;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.imageaware.ImageAware;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public interface BitmapDisplayer {
    void display(DecodedResult decodedResult, ImageAware imageAware, LoadedFrom loadedFrom);
}
