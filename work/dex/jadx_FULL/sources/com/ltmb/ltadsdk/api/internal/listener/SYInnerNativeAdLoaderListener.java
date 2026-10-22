package com.ltmb.ltadsdk.api.internal.listener;

import com.ltmb.ltadsdk.api.ad.AdError;
import com.ltmb.ltadsdk.api.ad.SYNativeAd;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H&¨\u0006\n"}, d2 = {"Lcom/ltmb/ltadsdk/api/internal/listener/SYInnerNativeAdLoaderListener;", "", "", "Lcom/ltmb/ltadsdk/api/ad/SYNativeAd;", "adList", "", "onNativeLoadSuccess", "Lcom/ltmb/ltadsdk/api/ad/AdError;", "error", "onNativeLoadFail", "ADAarBuild_ltmbRelease"}, k = 1, mv = {1, 4, 0})
public interface SYInnerNativeAdLoaderListener {
    void onNativeLoadFail(@NotNull AdError error);

    void onNativeLoadSuccess(@NotNull List<SYNativeAd> adList);
}
