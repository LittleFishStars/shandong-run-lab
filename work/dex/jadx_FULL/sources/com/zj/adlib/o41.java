package com.zj.adlib;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class o41 {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ei4 f18553a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Character f18554a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f18557a;
    public Character b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f18558b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f18555a = "";

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f18559b = true;
    public boolean c = true;
    public boolean d = true;
    public boolean e = true;
    public boolean f = true;
    public boolean g = true;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Map<String, Object> f18556a = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f43663a = 7;

    public o41 a(@NonNull String str) {
        if (!this.f18556a.containsKey(str)) {
            this.f18556a.put(str, str);
        }
        return this;
    }

    public o41 b(@NonNull String... strArr) {
        for (String str : strArr) {
            a(str);
        }
        return this;
    }

    public o41 c(boolean z) {
        this.f18557a = z;
        return this;
    }

    public ss1 d() {
        return new ss1(this);
    }

    public o41 e(@IntRange(from = 1, to = 2147483647L) int i) {
        this.f43663a = i;
        return this;
    }

    public o41 f(@NonNull ei4 ei4Var) {
        this.f18553a = ei4Var;
        return this;
    }

    public o41 g(int i) {
        this.b = Character.valueOf((char) i);
        return this;
    }

    public o41 h(Character ch) {
        this.b = ch;
        return this;
    }

    public o41 i(int i) {
        this.f18554a = Character.valueOf((char) i);
        return this;
    }

    public o41 j(Character ch) {
        this.f18554a = ch;
        return this;
    }

    public o41 k(@NonNull File file) {
        this.f18555a = file.getAbsolutePath();
        return this;
    }

    public o41 l(@NonNull String str) {
        this.f18555a = str;
        return this;
    }

    public o41 m(boolean z) {
        this.e = z;
        return this;
    }

    public o41 n(boolean z) {
        this.f = z;
        return this;
    }

    public o41 o(boolean z) {
        this.d = z;
        return this;
    }

    public o41 p(boolean z) {
        this.g = z;
        return this;
    }

    public o41 q(boolean z) {
        this.c = z;
        return this;
    }

    public o41 r(boolean z) {
        this.f18559b = z;
        return this;
    }

    public o41 s(String str) {
        this.f18558b = str;
        return this;
    }
}
