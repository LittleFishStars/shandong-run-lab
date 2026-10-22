package com.huawei.hms.common.internal;

import android.app.Activity;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class ClientSettings {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f37494a;
    private String b;
    private List<Scope> c;
    private String d;
    private List<String> e;
    private String f;
    private SubAppInfo g;
    private WeakReference<Activity> h;
    private boolean i;
    private String j;
    private boolean k;

    public ClientSettings(String str, String str2, List<Scope> list, String str3, List<String> list2) {
        this.f37494a = str;
        this.b = str2;
        this.c = list;
        this.d = str3;
        this.e = list2;
    }

    public List<String> getApiName() {
        return this.e;
    }

    public String getAppID() {
        return this.d;
    }

    public String getClientClassName() {
        return this.b;
    }

    public String getClientPackageName() {
        return this.f37494a;
    }

    public Activity getCpActivity() {
        WeakReference<Activity> weakReference = this.h;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public String getCpID() {
        return this.f;
    }

    public String getInnerHmsPkg() {
        return this.j;
    }

    public List<Scope> getScopes() {
        return this.c;
    }

    public SubAppInfo getSubAppID() {
        return this.g;
    }

    public boolean isHasActivity() {
        return this.i;
    }

    public boolean isUseInnerHms() {
        return this.k;
    }

    public void setApiName(List<String> list) {
        this.e = list;
    }

    public void setAppID(String str) {
        this.d = str;
    }

    public void setClientClassName(String str) {
        this.b = str;
    }

    public void setClientPackageName(String str) {
        this.f37494a = str;
    }

    public void setCpActivity(Activity activity) {
        this.h = new WeakReference<>(activity);
        this.i = true;
    }

    public void setCpID(String str) {
        this.f = str;
    }

    public void setInnerHmsPkg(String str) {
        this.j = str;
    }

    public void setScopes(List<Scope> list) {
        this.c = list;
    }

    public void setSubAppId(SubAppInfo subAppInfo) {
        this.g = subAppInfo;
    }

    public void setUseInnerHms(boolean z) {
        this.k = z;
    }

    public ClientSettings(String str, String str2, List<Scope> list, String str3, List<String> list2, SubAppInfo subAppInfo) {
        this(str, str2, list, str3, list2);
        this.g = subAppInfo;
    }
}
