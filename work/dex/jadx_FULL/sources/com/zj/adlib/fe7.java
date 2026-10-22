package com.zj.adlib;

import android.text.TextUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002¨\u0006\n"}, d2 = {"Lcom/zj/adlib/fe7;", "", "", "account", "", "a", "password", "b", "<init>", "()V", "login_release"}, k = 1, mv = {1, 8, 0})
public final class fe7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final fe7 f41654a = new fe7();

    public final boolean a(@Nullable String account) {
        if (TextUtils.isEmpty(account)) {
            return false;
        }
        Intrinsics.checkNotNull(account);
        return new Regex("(^\\d{11}$)|(^\\d{5,}$)").matches(account);
    }

    public final boolean b(@Nullable String password) {
        if (TextUtils.isEmpty(password)) {
            return false;
        }
        Intrinsics.checkNotNull(password);
        return new Regex("(^(?![a-zA-Z]+$)(?![A-Z0-9]+$)(?![A-Z!@#$%^&\\.]+$)(?![a-z0-9]+$)(?![a-z!@#$%^&\\.]+$)(?![0-9!@#$%^&\\.]+$)[a-zA-Z0-9!@#$%^&\\.]{8,16}$)").matches(password);
    }
}
