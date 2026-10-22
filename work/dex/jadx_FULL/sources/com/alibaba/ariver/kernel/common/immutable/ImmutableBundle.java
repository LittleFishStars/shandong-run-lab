package com.alibaba.ariver.kernel.common.immutable;

import android.os.Bundle;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ImmutableBundle implements Immutable<Bundle> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Bundle f24236a;

    public ImmutableBundle(Bundle bundle) {
        this.f24236a = bundle;
    }

    public boolean containsKey(String str) {
        Bundle bundle = this.f24236a;
        return bundle != null && bundle.containsKey(str);
    }

    public boolean getBoolean(String str, boolean z) {
        Bundle bundle = this.f24236a;
        return bundle != null ? bundle.getBoolean(str, z) : z;
    }

    public double getDouble(String str, double d) {
        Bundle bundle = this.f24236a;
        return bundle != null ? bundle.getDouble(str, d) : d;
    }

    public int getInt(String str, int i) {
        Bundle bundle = this.f24236a;
        return bundle != null ? bundle.getInt(str, i) : i;
    }

    public long getLong(String str, long j) {
        Bundle bundle = this.f24236a;
        return bundle != null ? bundle.getLong(str, j) : j;
    }

    public String getString(String str, String str2) {
        Bundle bundle = this.f24236a;
        return bundle != null ? bundle.getString(str, str2) : str2;
    }

    public boolean isEmpty() {
        Bundle bundle = this.f24236a;
        return bundle == null || bundle.isEmpty();
    }

    public ImmutableSet<String> keySet() {
        if (this.f24236a != null) {
            return new ImmutableSet<>(this.f24236a.keySet());
        }
        return null;
    }

    public int size() {
        Bundle bundle = this.f24236a;
        if (bundle != null) {
            return bundle.size();
        }
        return 0;
    }

    public String toString() {
        if (this.f24236a == null) {
            return "ImmutableBundle{NULL}";
        }
        return "ImmutableBundle{" + this.f24236a.toString() + "}";
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.alibaba.ariver.kernel.common.immutable.Immutable
    public Bundle mutable() {
        return new Bundle(this.f24236a);
    }
}
