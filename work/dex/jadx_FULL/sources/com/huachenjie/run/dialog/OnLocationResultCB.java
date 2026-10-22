package com.huachenjie.run.dialog;

import com.alibaba.triver.embed.video.fullscreenvideo.TriverEmbedVideoView;
import huachenjie.sdk.map.lib_base.HCJAddressInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\t\u001a\u00020\u0004H&¨\u0006\n"}, d2 = {"Lcom/huachenjie/run/dialog/OnLocationResultCB;", "", "Lhuachenjie/sdk/map/lib_base/HCJAddressInfo;", "hcjAddressInfo", "", "m", "", "code", TriverEmbedVideoView.b, "onComplete", "run_release"}, k = 1, mv = {1, 8, 0})
public interface OnLocationResultCB {
    void m(@Nullable HCJAddressInfo hcjAddressInfo);

    void onComplete();

    void onError(int code);
}
