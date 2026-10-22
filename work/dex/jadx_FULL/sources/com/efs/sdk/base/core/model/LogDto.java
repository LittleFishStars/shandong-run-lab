package com.efs.sdk.base.core.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.efs.sdk.base.Constants;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.http.HttpResponse;
import com.efs.sdk.base.protocol.ILogProtocol;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class LogDto {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f29606a;
    private b b = new b();
    private byte[] c;
    private File d;

    public LogDto(String str, byte b) {
        this.f29606a = new a(str, b);
    }

    private void a() {
        if (getLogBodyType() == 0 && getData() != null) {
            this.f29606a.f = getData().length;
        } else if (getLogBodyType() == 1 && getFile().exists()) {
            this.f29606a.f = getFile().length();
        }
    }

    public static LogDto buildLogDto(ILogProtocol iLogProtocol) {
        LogDto logDto = null;
        try {
            LogDto logDto2 = new LogDto(iLogProtocol.getLogType(), iLogProtocol.getLogProtocol());
            try {
                int bodyType = iLogProtocol.getBodyType();
                if (bodyType == 0) {
                    logDto2.setLogBodyType(0);
                    logDto2.setData(iLogProtocol.generate());
                    if (Constants.LOG_TYPE_CODELOGPERF.equals(logDto2.getLogType())) {
                        logDto2.setUid(ControllerCenter.getGlobalEnvStruct().getLogUid());
                        logDto2.setDid(ControllerCenter.getGlobalEnvStruct().getLogDid());
                        logDto2.setBeginTime(iLogProtocol.getLogBeginTime());
                        logDto2.setEndTime(iLogProtocol.getLogEndTime());
                    }
                } else if (bodyType != 1) {
                    Log.w("efs.base", "Can not support body type: " + iLogProtocol.getBodyType());
                } else {
                    logDto2.setLogBodyType(1);
                    logDto2.setFile(new File(iLogProtocol.getFilePath()));
                }
                return logDto2;
            } catch (Exception e) {
                e = e;
                logDto = logDto2;
                Log.e("efs.base", "log send error", e);
                return logDto;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public long getBeginTime() {
        return this.f29606a.j;
    }

    public long getBodySize() {
        a();
        return this.f29606a.f;
    }

    public String getCp() {
        return this.f29606a.d;
    }

    public byte[] getData() {
        return this.c;
    }

    public int getDe() {
        return this.f29606a.e;
    }

    public String getDid() {
        return this.f29606a.i;
    }

    public long getEndTime() {
        return this.f29606a.k;
    }

    public File getFile() {
        return this.d;
    }

    public int getLogBodyType() {
        return this.f29606a.c;
    }

    public int getLogCnt() {
        return this.f29606a.g;
    }

    public byte getLogProtocol() {
        return this.f29606a.b;
    }

    public String getLogType() {
        return this.f29606a.f29607a;
    }

    @Nullable
    public HttpResponse getResponseDto() {
        return this.b.c;
    }

    public String getUid() {
        return this.f29606a.h;
    }

    public boolean isCp() {
        return !"none".equals(this.f29606a.d);
    }

    public boolean isDe() {
        return 1 != this.f29606a.e;
    }

    public boolean isLimitByFlow() {
        return this.b.b;
    }

    public boolean isSendImediately() {
        return this.b.f29608a;
    }

    public void setBeginTime(long j) {
        this.f29606a.j = j;
    }

    public void setCp(String str) {
        this.f29606a.d = str;
    }

    public void setData(byte[] bArr) {
        this.c = bArr;
        a();
    }

    public void setDe(int i) {
        this.f29606a.e = i;
        a();
    }

    public void setDid(String str) {
        this.f29606a.i = str;
    }

    public void setEndTime(long j) {
        this.f29606a.k = j;
    }

    public void setFile(File file) {
        this.d = file;
    }

    public void setLimitByFlow(boolean z) {
        this.b.b = z;
    }

    public void setLogBodyType(int i) {
        this.f29606a.c = i;
    }

    public void setLogCnt(int i) {
        this.f29606a.g = i;
    }

    public void setResponseDto(@NonNull HttpResponse httpResponse) {
        this.b.c = httpResponse;
    }

    public void setSendImediately(boolean z) {
        this.b.f29608a = z;
    }

    public void setUid(String str) {
        this.f29606a.h = str;
    }
}
