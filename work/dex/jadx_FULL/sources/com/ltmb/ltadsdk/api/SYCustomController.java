package com.ltmb.ltadsdk.api;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016J\u0010\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\rH\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u0002H\u0016¨\u0006\u0014"}, d2 = {"Lcom/ltmb/ltadsdk/api/SYCustomController;", "", "", "isCanUseLocation", "Lcom/ltmb/ltadsdk/api/SYLocation;", "getSYLocation", "isCanUsePhoneState", "", "getImei", "isCanUseWifiState", "getOaid", "isCanUseOaid", "isCanReadApplist", "", "getApplist", "isCanUseAndroidId", "getAndroidId", "isCanUseIPAddress", "<init>", "()V", "ADAarBuild_ltmbRelease"}, k = 1, mv = {1, 4, 0})
public abstract class SYCustomController {
    @NotNull
    public String getAndroidId() {
        return "";
    }

    @Nullable
    public List<String> getApplist() {
        return null;
    }

    @Nullable
    public String getImei() {
        return null;
    }

    @Nullable
    public String getOaid() {
        return null;
    }

    @Nullable
    public SYLocation getSYLocation() {
        return null;
    }

    public boolean isCanReadApplist() {
        return true;
    }

    public boolean isCanUseAndroidId() {
        return true;
    }

    public boolean isCanUseIPAddress() {
        return true;
    }

    public boolean isCanUseLocation() {
        return true;
    }

    public boolean isCanUseOaid() {
        return true;
    }

    public boolean isCanUsePhoneState() {
        return true;
    }

    public boolean isCanUseWifiState() {
        return true;
    }
}
