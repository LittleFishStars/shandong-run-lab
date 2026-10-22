package com.ltmb.ltadsdk.api.ad;

import com.aliyun.vod.log.core.AliyunLogCommon;
import com.ltmb.ltadsdk.api.AdBidLossInfo;
import com.ltmb.ltadsdk.api.AdBidWinInfo;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0016\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0004H&J\b\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH&J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\fH&J\b\u0010\u000f\u001a\u00020\u000eH&J\b\u0010\u0010\u001a\u00020\u0005H&¨\u0006\u0011"}, d2 = {"Lcom/ltmb/ltadsdk/api/ad/ClientBiddingAd;", "", "", "getEcpm", "", "", "getExt", "", "destroy", "Lcom/ltmb/ltadsdk/api/AdBidLossInfo;", AliyunLogCommon.LogLevel.INFO, "notifyBidLoss", "Lcom/ltmb/ltadsdk/api/AdBidWinInfo;", "notifyBidWin", "", "isValid", "getAdCodeId", "ADAarBuild_ltmbRelease"}, k = 1, mv = {1, 4, 0})
public interface ClientBiddingAd {
    void destroy();

    @NotNull
    String getAdCodeId();

    int getEcpm();

    @Nullable
    Map<String, Object> getExt();

    boolean isValid();

    void notifyBidLoss(@NotNull AdBidLossInfo info);

    void notifyBidWin(@NotNull AdBidWinInfo info);
}
