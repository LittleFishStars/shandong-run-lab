package com.efs.sdk.base.core.c.a;

import com.efs.sdk.base.core.model.LogDto;
import com.efs.sdk.base.http.HttpResponse;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class e extends a {
    @Override // com.efs.sdk.base.core.c.a.a
    public final void a(LogDto logDto) {
        HttpResponse httpResponseA;
        if (!logDto.isSendImediately()) {
            b(logDto);
            return;
        }
        com.efs.sdk.base.core.b.e eVarA = com.efs.sdk.base.core.b.e.a();
        if (!logDto.isLimitByFlow() || com.efs.sdk.base.core.b.c.a().a(logDto.getLogType(), logDto.getBodySize())) {
            com.efs.sdk.base.core.d.f.a.f29604a.c.b();
            com.efs.sdk.base.core.d.f.a.f29604a.c.c();
            httpResponseA = eVarA.c.a(logDto, false);
        } else {
            httpResponseA = new HttpResponse();
            httpResponseA.data = "flow_limit";
        }
        logDto.setResponseDto(httpResponseA);
        b(logDto);
    }
}
