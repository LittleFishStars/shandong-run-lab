package com.ltmb.ltadsdk.api.internal.listener;

import com.ltmb.ltadsdk.api.ad.AdError;
import com.ltmb.ltadsdk.api.ad.SYRewardVideoAd;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¨\u0006\t"}, d2 = {"Lcom/ltmb/ltadsdk/api/internal/listener/SYInnerRewardVideoAdLoaderListener;", "", "Lcom/ltmb/ltadsdk/api/ad/SYRewardVideoAd;", "ad", "", "onRewardLoadSuccess", "Lcom/ltmb/ltadsdk/api/ad/AdError;", "error", "onRewardLoadFail", "ADAarBuild_ltmbRelease"}, k = 1, mv = {1, 4, 0})
public interface SYInnerRewardVideoAdLoaderListener {
    void onRewardLoadFail(@NotNull AdError error);

    void onRewardLoadSuccess(@NotNull SYRewardVideoAd ad);
}
