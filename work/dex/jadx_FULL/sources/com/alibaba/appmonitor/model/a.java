package com.alibaba.appmonitor.model;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import java.util.UUID;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@com.alibaba.analytics.core.b.a.c("stat_register_temp")
public class a extends com.alibaba.analytics.core.b.b implements com.alibaba.appmonitor.pool.b {

    @com.alibaba.analytics.core.b.a.b
    private DimensionSet b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @com.alibaba.analytics.core.b.a.b
    private MeasureSet f676b;

    @com.alibaba.analytics.core.b.a.b
    private String bg;

    @com.alibaba.analytics.core.b.a.a("dimensions")
    private String bh;

    @com.alibaba.analytics.core.b.a.a("measures")
    private String bi;

    @com.alibaba.analytics.core.b.a.a("is_commit_detail")
    private boolean k;

    @com.alibaba.analytics.core.b.a.a("module")
    private String module;

    @com.alibaba.analytics.core.b.a.a("monitor_point")
    private String monitorPoint;

    @com.alibaba.analytics.core.b.a.b
    private String transactionId;

    @Deprecated
    public a() {
    }

    public synchronized String G() {
        if (this.transactionId == null) {
            this.transactionId = UUID.randomUUID().toString() + "$" + this.module + "$" + this.monitorPoint;
        }
        return this.transactionId;
    }

    public String H() {
        return this.monitorPoint;
    }

    public void X() {
        this.transactionId = null;
    }

    public boolean a(DimensionValueSet dimensionValueSet, MeasureValueSet measureValueSet) {
        DimensionSet dimensionSet = this.b;
        boolean zValid = dimensionSet != null ? dimensionSet.valid(dimensionValueSet) : true;
        MeasureSet measureSet = this.f676b;
        if (measureSet != null) {
            return zValid && measureSet.valid(measureValueSet);
        }
        return zValid;
    }

    @Override // com.alibaba.appmonitor.pool.b
    public void clean() {
        this.module = null;
        this.monitorPoint = null;
        this.bg = null;
        this.k = false;
        this.b = null;
        this.f676b = null;
        this.transactionId = null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        String str = this.bg;
        if (str == null) {
            if (aVar.bg != null) {
                return false;
            }
        } else if (!str.equals(aVar.bg)) {
            return false;
        }
        String str2 = this.module;
        if (str2 == null) {
            if (aVar.module != null) {
                return false;
            }
        } else if (!str2.equals(aVar.module)) {
            return false;
        }
        String str3 = this.monitorPoint;
        if (str3 == null) {
            if (aVar.monitorPoint != null) {
                return false;
            }
        } else if (!str3.equals(aVar.monitorPoint)) {
            return false;
        }
        return true;
    }

    @Override // com.alibaba.appmonitor.pool.b
    public void fill(Object... objArr) {
        this.module = (String) objArr[0];
        this.monitorPoint = (String) objArr[1];
        if (objArr.length > 2) {
            this.bg = (String) objArr[2];
        }
    }

    public String getModule() {
        return this.module;
    }

    public int hashCode() {
        String str = this.bg;
        int iHashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        String str2 = this.module;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.monitorPoint;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public synchronized boolean x() {
        return this.k || com.alibaba.appmonitor.c.b.a().g(this.module, this.monitorPoint);
    }

    public a(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet, boolean z) {
        this.module = str;
        this.monitorPoint = str2;
        this.b = dimensionSet;
        this.f676b = measureSet;
        this.bg = null;
        this.k = z;
        if (dimensionSet != null) {
            this.bh = JSON.toJSONString(dimensionSet);
        }
        this.bi = JSON.toJSONString(measureSet);
    }

    public DimensionSet a() {
        if (this.b == null && !TextUtils.isEmpty(this.bh)) {
            this.b = (DimensionSet) JSON.parseObject(this.bh, DimensionSet.class);
        }
        return this.b;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public MeasureSet m144a() {
        if (this.f676b == null && !TextUtils.isEmpty(this.bi)) {
            this.f676b = (MeasureSet) JSON.parseObject(this.bi, MeasureSet.class);
        }
        return this.f676b;
    }
}
