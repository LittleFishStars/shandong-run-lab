package defpackage;

import com.zj.adlib.kh4;
import com.zj.adlib.m89;
import com.zj.adlib.rt9;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00052\u00020\u0001:\u0001\bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0006H&¨\u0006\t"}, d2 = {"LWakelockPlusApi;", "", "Lcom/zj/adlib/m89;", "msg", "", "a", "Lcom/zj/adlib/kh4;", "b", "Companion", "wakelock_plus_release"}, k = 1, mv = {1, 7, 1})
public interface WakelockPlusApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f21169a;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004R#\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"LWakelockPlusApi$Companion;", "", "Lio/flutter/plugin/common/BinaryMessenger;", "binaryMessenger", "LWakelockPlusApi;", "api", "", "d", "Lio/flutter/plugin/common/MessageCodec;", "a", "Lkotlin/Lazy;", "c", "()Lio/flutter/plugin/common/MessageCodec;", "codec", "<init>", "()V", "wakelock_plus_release"}, k = 1, mv = {1, 7, 1})
    public static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f21169a = new Companion();

        /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
        @NotNull
        public static final Lazy<rt9> codec = LazyKt.lazy(new Function0<rt9>() { // from class: WakelockPlusApi$Companion$codec$2
            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final rt9 m0invoke() {
                return rt9.f44535a;
            }
        });

        public static final void e(WakelockPlusApi wakelockPlusApi, Object obj, BasicMessageChannel.Reply reply) {
        }

        public static final void f(WakelockPlusApi wakelockPlusApi, Object obj, BasicMessageChannel.Reply reply) {
        }

        @NotNull
        public final MessageCodec<Object> c() {
        }

        public final void d(@NotNull BinaryMessenger binaryMessenger, @Nullable WakelockPlusApi api) {
        }
    }

    void a(@NotNull m89 msg);

    @NotNull
    kh4 b();
}
