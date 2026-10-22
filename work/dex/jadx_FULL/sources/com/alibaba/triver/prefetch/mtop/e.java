package com.alibaba.triver.prefetch.mtop;

import com.alibaba.triver.kit.api.network.AsyncRequestClient;
import com.alibaba.triver.kit.api.network.CommonListener;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class e extends AsyncRequestClient<ShopMtopRequestParam, String, String> {
    public e(ShopMtopRequestParam shopMtopRequestParam, CommonListener<String, String> commonListener) {
        super(shopMtopRequestParam, commonListener);
    }

    @Override // com.alibaba.triver.kit.api.network.SyncRequestClient
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public String configSuccessResponse(byte[] bArr) {
        return (bArr != null && bArr.length > 0) ? new String(bArr) : "";
    }

    @Override // com.alibaba.triver.kit.api.network.SyncRequestClient
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public String configFailureResponse(byte[] bArr) {
        return (bArr != null && bArr.length > 0) ? new String(bArr) : "";
    }
}
