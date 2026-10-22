package com.ltmb.ltadsdk.api.internal;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J3\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00018\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/ltmb/ltadsdk/api/internal/AdCallback;", "T", "", "data", "", "code", "", "message", "", "onCall", "(Ljava/lang/Object;Ljava/lang/Integer;Ljava/lang/String;)V", "ADAarBuild_ltmbRelease"}, k = 1, mv = {1, 4, 0})
public interface AdCallback<T> {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void onCall$default(AdCallback adCallback, Object obj, Integer num, String str, int i, Object obj2) {
            if (obj2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onCall");
            }
            if ((i & 1) != 0) {
                obj = null;
            }
            if ((i & 2) != 0) {
                num = 0;
            }
            if ((i & 4) != 0) {
                str = null;
            }
            adCallback.onCall(obj, num, str);
        }
    }

    void onCall(@Nullable T data, @Nullable Integer code, @Nullable String message);
}
