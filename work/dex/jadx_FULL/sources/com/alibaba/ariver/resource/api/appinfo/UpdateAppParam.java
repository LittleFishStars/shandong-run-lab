package com.alibaba.ariver.resource.api.appinfo;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import com.alibaba.ariver.resource.api.models.AppInfoScene;
import com.alibaba.ariver.resource.api.prepare.UpdateMode;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class UpdateAppParam {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Pair<String, String> f24421a;

    @Nullable
    private Map<String, String> b;
    private AppInfoScene c;
    private UpdateMode d;
    private boolean e;

    @Nullable
    private Bundle f = new Bundle();

    public UpdateAppParam(String str, @Nullable String str2) {
        this.f24421a = new Pair<>(str, str2);
    }

    public String getExtra(String str) {
        return (String) this.f.get(str);
    }

    @Nullable
    public Bundle getExtras() {
        return this.f;
    }

    public AppInfoScene getQueryScene() {
        return this.c;
    }

    @Nullable
    public Map<String, String> getRequestApps() {
        return this.b;
    }

    public Pair<String, String> getRequestMainPackage() {
        return this.f24421a;
    }

    public UpdateMode getUpdateMode() {
        return this.d;
    }

    public boolean isForce() {
        return this.e;
    }

    public void setExtras(@Nullable Bundle bundle) {
        this.f = bundle;
    }

    public void setForce(boolean z) {
        this.e = z;
    }

    public void setQueryScene(AppInfoScene appInfoScene) {
        this.c = appInfoScene;
    }

    public void setRequestApps(Map<String, String> map) {
        this.b = map;
    }

    public void setUpdateMode(UpdateMode updateMode) {
        this.d = updateMode;
    }

    public String toString() {
        return "UpdateAppParam{mRequestMainPackage=" + this.f24421a + ", mQueryScene=" + this.c + ", mUpdateMode=" + this.d + ", mForce=" + this.e + '}';
    }
}
