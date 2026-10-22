package com.efs.sdk.base.core.config;

import android.content.Context;
import android.os.Message;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.efs.sdk.base.observer.IEfsReporterObserver;
import com.efs.sdk.base.processor.action.ILogEncryptAction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class GlobalEnvStruct {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f29585a;
    private String b;
    private String i;
    public Context mAppContext;
    private ILogEncryptAction q;
    private boolean c = true;
    private boolean d = false;
    private boolean e = true;
    private boolean f = false;
    private Boolean g = null;
    private boolean h = false;
    private String j = "";
    private String k = "";
    private boolean l = false;
    private boolean m = false;
    public long configRefreshDelayMills = 5000;
    private long n = 10000;
    private long o = 10000;
    private Map<String, String> p = new HashMap(5);
    private ConcurrentHashMap<Integer, List<ValueCallback<Pair<Message, Message>>>> r = new ConcurrentHashMap<>();
    private List<IEfsReporterObserver> s = new ArrayList(5);

    public void addConfigObserver(IEfsReporterObserver iEfsReporterObserver) {
        if (this.s.contains(iEfsReporterObserver)) {
            return;
        }
        this.s.add(iEfsReporterObserver);
    }

    public void addPublicParams(Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        HashMap map2 = new HashMap(this.p);
        map2.putAll(map);
        this.p = map2;
    }

    public String getAppid() {
        return this.f29585a;
    }

    public List<ValueCallback<Pair<Message, Message>>> getCallback(int i) {
        return (!this.r.containsKey(Integer.valueOf(i)) || this.r.get(Integer.valueOf(i)) == null) ? Collections.emptyList() : this.r.get(Integer.valueOf(i));
    }

    public List<IEfsReporterObserver> getEfsReporterObservers() {
        return this.s;
    }

    public String getLogDid() {
        return this.k;
    }

    public ILogEncryptAction getLogEncryptAction() {
        return this.q;
    }

    public long getLogSendDelayMills() {
        return this.n;
    }

    public long getLogSendIntervalMills() {
        return this.o;
    }

    public String getLogUid() {
        return this.j;
    }

    public Map<String, String> getPublicParamMap() {
        Map<String, String> map = this.p;
        return map == null ? Collections.emptyMap() : map;
    }

    public String getSecret() {
        return this.b;
    }

    public String getUid() {
        return this.i;
    }

    public boolean isDebug() {
        return this.f;
    }

    public boolean isEnablePaBackup() {
        return this.d;
    }

    public boolean isEnableSendLog() {
        return this.e;
    }

    public boolean isEnableWaStat() {
        return this.c;
    }

    public boolean isIntl() {
        return this.m;
    }

    public boolean isOpenCodeLog() {
        return this.l;
    }

    public boolean isPrintLogDetail() {
        return this.h;
    }

    public void registerCallback(int i, ValueCallback<Pair<Message, Message>> valueCallback) {
        if (valueCallback == null) {
            return;
        }
        List<ValueCallback<Pair<Message, Message>>> linkedList = this.r.get(Integer.valueOf(i));
        if (linkedList == null) {
            linkedList = new LinkedList<>();
            this.r.putIfAbsent(Integer.valueOf(i), linkedList);
        }
        linkedList.add(valueCallback);
    }

    public void setAppid(String str) {
        this.f29585a = str;
    }

    public void setDebug(boolean z) {
        this.f = z;
    }

    public void setEnablePaBackup(boolean z) {
        this.d = z;
    }

    public void setEnableSendLog(boolean z) {
        this.e = z;
    }

    public void setEnableWaStat(boolean z) {
        this.c = z;
    }

    public void setIsIntl(boolean z) {
        this.m = z;
    }

    public void setLogDid(String str) {
        this.k = str;
    }

    public void setLogEncryptAction(ILogEncryptAction iLogEncryptAction) {
        this.q = iLogEncryptAction;
    }

    public void setLogUid(String str) {
        this.j = str;
    }

    public void setOpenCodeLog(boolean z) {
        this.l = z;
    }

    public void setPrintLogDetail(boolean z) {
        this.h = z;
    }

    public void setSecret(String str) {
        this.b = str;
    }

    public void setUid(String str) {
        this.i = str;
    }
}
