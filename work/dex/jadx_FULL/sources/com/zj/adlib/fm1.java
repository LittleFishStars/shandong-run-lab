package com.zj.adlib;

import android.accounts.Account;
import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.collection.ArraySet;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@VisibleForTesting
@KeepForSdk
public final class fm1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f41706a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final Account f16567a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final View f16568a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final yb8 f16569a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Integer f16570a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f16571a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Map f16572a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Set f16573a;
    public final String b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Set f16574b;

    @KeepForSdk
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public Account f41707a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public ArraySet f16575a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public yb8 f16576a = yb8.f45991a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public String f16577a;
        public String b;

        @NonNull
        @KeepForSdk
        public fm1 a() {
            return new fm1(this.f41707a, this.f16575a, null, 0, null, this.f16577a, this.b, this.f16576a, false);
        }

        @NonNull
        @CanIgnoreReturnValue
        @KeepForSdk
        public a b(@NonNull String str) {
            this.f16577a = str;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public final a c(@NonNull Collection collection) {
            if (this.f16575a == null) {
                this.f16575a = new ArraySet();
            }
            this.f16575a.addAll(collection);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public final a d(@Nullable Account account) {
            this.f41707a = account;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public final a e(@NonNull String str) {
            this.b = str;
            return this;
        }
    }

    @KeepForSdk
    public fm1(@NonNull Account account, @NonNull Set<Scope> set, @NonNull Map<Api<?>, c1c> map, int i, @Nullable View view, @NonNull String str, @NonNull String str2, @Nullable yb8 yb8Var) {
        this(account, set, map, i, view, str, str2, yb8Var, false);
    }

    @NonNull
    @KeepForSdk
    public static fm1 a(@NonNull Context context) {
        return new GoogleApiClient.a(context).p();
    }

    @androidx.annotation.Nullable
    @KeepForSdk
    public Account b() {
        return this.f16567a;
    }

    @androidx.annotation.Nullable
    @KeepForSdk
    @Deprecated
    public String c() {
        Account account = this.f16567a;
        if (account != null) {
            return account.name;
        }
        return null;
    }

    @NonNull
    @KeepForSdk
    public Account d() {
        Account account = this.f16567a;
        return account != null ? account : new Account("<<default account>>", ys.f46104a);
    }

    @NonNull
    @KeepForSdk
    public Set<Scope> e() {
        return this.f16574b;
    }

    @NonNull
    @KeepForSdk
    public Set<Scope> f(@NonNull Api<?> api) {
        c1c c1cVar = (c1c) this.f16572a.get(api);
        if (c1cVar == null || c1cVar.f40882a.isEmpty()) {
            return this.f16573a;
        }
        HashSet hashSet = new HashSet(this.f16573a);
        hashSet.addAll(c1cVar.f40882a);
        return hashSet;
    }

    @KeepForSdk
    public int g() {
        return this.f41706a;
    }

    @NonNull
    @KeepForSdk
    public String h() {
        return this.f16571a;
    }

    @NonNull
    @KeepForSdk
    public Set<Scope> i() {
        return this.f16573a;
    }

    @androidx.annotation.Nullable
    @KeepForSdk
    public View j() {
        return this.f16568a;
    }

    @NonNull
    public final yb8 k() {
        return this.f16569a;
    }

    @androidx.annotation.Nullable
    public final Integer l() {
        return this.f16570a;
    }

    @androidx.annotation.Nullable
    public final String m() {
        return this.b;
    }

    @NonNull
    public final Map n() {
        return this.f16572a;
    }

    public final void o(@NonNull Integer num) {
        this.f16570a = num;
    }

    public fm1(@Nullable Account account, @NonNull Set set, @NonNull Map map, int i, @Nullable View view, @NonNull String str, @NonNull String str2, @Nullable yb8 yb8Var, boolean z) {
        this.f16567a = account;
        Set setEmptySet = set == null ? Collections.emptySet() : Collections.unmodifiableSet(set);
        this.f16573a = setEmptySet;
        map = map == null ? Collections.emptyMap() : map;
        this.f16572a = map;
        this.f16568a = view;
        this.f41706a = i;
        this.f16571a = str;
        this.b = str2;
        this.f16569a = yb8Var == null ? yb8.f45991a : yb8Var;
        HashSet hashSet = new HashSet(setEmptySet);
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            hashSet.addAll(((c1c) it.next()).f40882a);
        }
        this.f16574b = Collections.unmodifiableSet(hashSet);
    }
}
