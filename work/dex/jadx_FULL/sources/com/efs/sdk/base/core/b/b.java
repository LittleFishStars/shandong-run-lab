package com.efs.sdk.base.core.b;

import androidx.annotation.NonNull;
import com.efs.sdk.base.core.model.LogDto;
import com.efs.sdk.base.core.util.FileUtil;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.http.HttpResponse;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class b implements d {
    @Override // com.efs.sdk.base.core.b.d
    @NonNull
    public final HttpResponse a(LogDto logDto, boolean z) {
        HttpResponse httpResponseA;
        com.efs.sdk.base.core.a.c cVarA = com.efs.sdk.base.core.a.c.a();
        cVarA.d = logDto.getCp();
        cVarA.e = logDto.getDe();
        cVarA.g = logDto.getLogProtocol();
        cVarA.h = logDto.getLogType();
        cVarA.o = logDto.getBodySize();
        String strA = com.efs.sdk.base.core.config.remote.b.a().a(false);
        Log.i("efs.LogSendAction.Codelog", "send data url is ".concat(String.valueOf(strA)));
        if (logDto.getLogBodyType() == 0) {
            httpResponseA = com.efs.sdk.base.core.a.a.a().a(strA, cVarA, logDto.getData(), logDto.isLimitByFlow());
        } else {
            httpResponseA = 1 == logDto.getLogBodyType() ? com.efs.sdk.base.core.a.a.a().a(strA, cVarA, logDto.getFile(), logDto.isLimitByFlow()) : new HttpResponse();
        }
        if (httpResponseA.succ && z) {
            FileUtil.delete(logDto.getFile());
        }
        return httpResponseA;
    }
}
