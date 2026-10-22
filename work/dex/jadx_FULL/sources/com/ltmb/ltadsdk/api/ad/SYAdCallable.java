package com.ltmb.ltadsdk.api.ad;

import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0006\u001a\u00020\u00052\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0002H&J\u001e\u0010\u0007\u001a\u00020\u00052\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0002H&J\u001e\u0010\b\u001a\u00020\u00052\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0002H&J\u001e\u0010\t\u001a\u00020\u00052\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0002H&¨\u0006\n"}, d2 = {"Lcom/ltmb/ltadsdk/api/ad/SYAdCallable;", "", "", "", "map", "", "onMediaReceiveAd", "onMediaReceiveAdShow", "onMediaReceiveAdClick", "onMediaLoadAd", "ADAarBuild_ltmbRelease"}, k = 1, mv = {1, 4, 0})
public interface SYAdCallable {
    void onMediaLoadAd(@Nullable Map<String, Object> map);

    void onMediaReceiveAd(@Nullable Map<String, Object> map);

    void onMediaReceiveAdClick(@Nullable Map<String, Object> map);

    void onMediaReceiveAdShow(@Nullable Map<String, Object> map);
}
