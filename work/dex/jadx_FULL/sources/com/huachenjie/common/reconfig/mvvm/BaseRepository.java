package com.huachenjie.common.reconfig.mvvm;

import com.zj.adlib.lo7;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\t\u0010\nJ\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003R\u001b\u0010\b\u001a\u00028\u00008FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/common/reconfig/mvvm/BaseRepository;", "T", "", "Ljava/lang/Class;", "b", "a", "Lkotlin/Lazy;", "()Ljava/lang/Object;", "service", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
public class BaseRepository<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final Lazy service = LazyKt.lazy(new Function0<T>(this) { // from class: com.huachenjie.common.reconfig.mvvm.BaseRepository$service$2
        final /* synthetic */ BaseRepository<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
            this.this$0 = this;
        }

        public final T invoke() {
            return (T) lo7.e().d(this.this$0.b());
        }
    });

    public final T a() {
        return (T) this.service.getValue();
    }

    @NotNull
    public final Class<T> b() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        Intrinsics.checkNotNull(genericSuperclass, "null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
        Type type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
        Intrinsics.checkNotNull(type, "null cannot be cast to non-null type java.lang.Class<T of com.huachenjie.common.reconfig.mvvm.BaseRepository>");
        return (Class) type;
    }
}
