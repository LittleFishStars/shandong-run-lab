package com.zj.adlib;

import com.huachenjie.works.api.RequestModel;
import com.huachenjie.works.external.bean.ChannelBean;
import huachenjie.sdk.http.PageEntity;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ#\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/zj/adlib/ti1;", "", "", "channelNum", "Lhuachenjie/sdk/http/PageEntity;", "Lcom/huachenjie/works/external/bean/ChannelBean;", "a", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
public final class ti1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ti1 f44928a = new ti1();

    @Nullable
    public final Object a(@NotNull String str, @NotNull Continuation<? super PageEntity<ChannelBean>> continuation) {
        return RequestModel.f36762a.F(1, (14 & 2) != 0 ? null : null, (14 & 4) != 0 ? null : null, (14 & 8) != 0 ? null : null, (14 & 16) != 0 ? null : str, continuation);
    }
}
