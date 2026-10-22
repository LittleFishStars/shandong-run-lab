package com.huachenjie.common.bean;

import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R%\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/huachenjie/common/bean/StaticSuitModelBean;", "", "()V", "ipImg", "", "getIpImg", "()Ljava/lang/String;", "modelList", "Ljava/util/ArrayList;", "Lcom/huachenjie/common/bean/ModelBean;", "Lkotlin/collections/ArrayList;", "getModelList", "()Ljava/util/ArrayList;", "modelType", "", "getModelType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class StaticSuitModelBean {

    @Nullable
    private final String ipImg;

    @Nullable
    private final ArrayList<ModelBean> modelList;

    @Nullable
    private final Integer modelType;

    @Nullable
    public final String getIpImg() {
        return this.ipImg;
    }

    @Nullable
    public final ArrayList<ModelBean> getModelList() {
        return this.modelList;
    }

    @Nullable
    public final Integer getModelType() {
        return this.modelType;
    }
}
