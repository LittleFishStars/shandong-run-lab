package com.ltmb.ltadsdk.api.internal;

import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.ltmb.ltadsdk.api.SYAdInitConfig;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0004J\b\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0005"}, d2 = {"Lcom/ltmb/ltadsdk/api/internal/IAdConfigApiRequest;", "", "Lcom/ltmb/ltadsdk/api/internal/IAdConfigApiRequest$Request;", "create", "Request", "ADAarBuild_ltmbRelease"}, k = 1, mv = {1, 4, 0})
public interface IAdConfigApiRequest {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&¨\u0006\u000b"}, d2 = {"Lcom/ltmb/ltadsdk/api/internal/IAdConfigApiRequest$Request;", "", "Lcom/ltmb/ltadsdk/api/SYAdInitConfig;", "config", "", "first", "Lcom/ltmb/ltadsdk/api/internal/AdCallback;", "", RenderCallContext.TYPE_CALLBACK, "", "request", "ADAarBuild_ltmbRelease"}, k = 1, mv = {1, 4, 0})
    public interface Request {
        void request(@NotNull SYAdInitConfig config, boolean first, @NotNull AdCallback<String> callback);
    }

    @NotNull
    Request create();
}
