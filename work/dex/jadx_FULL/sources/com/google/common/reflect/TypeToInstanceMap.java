package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotMock;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@DoNotMock("Use ImmutableTypeToInstanceMap or MutableTypeToInstanceMap")
@Beta
public interface TypeToInstanceMap<B> extends Map<TypeToken<? extends B>, B> {
    @NullableDecl
    <T extends B> T a(TypeToken<T> typeToken);

    @NullableDecl
    <T extends B> T getInstance(Class<T> cls);

    @CanIgnoreReturnValue
    @NullableDecl
    <T extends B> T k0(TypeToken<T> typeToken, @NullableDecl T t);

    @CanIgnoreReturnValue
    @NullableDecl
    <T extends B> T putInstance(Class<T> cls, @NullableDecl T t);
}
