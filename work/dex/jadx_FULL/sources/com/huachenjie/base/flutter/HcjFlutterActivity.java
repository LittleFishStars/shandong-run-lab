package com.huachenjie.base.flutter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.alipay.sdk.m.c0.d;
import com.huachenjie.base.flutter.HcjFlutterActivity;
import com.huachenjie.base.internal.AdCancelInterface;
import com.zj.adlib.vw3;
import io.flutter.embedding.android.FlutterFragmentActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \r2\u00020\u00012\u00020\u0002:\u0001\rB\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¨\u0006\u000e"}, d2 = {"Lcom/huachenjie/base/flutter/HcjFlutterActivity;", "Lio/flutter/embedding/android/FlutterFragmentActivity;", "Lcom/huachenjie/base/internal/AdCancelInterface;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "Lio/flutter/embedding/engine/FlutterEngine;", "flutterEngine", "configureFlutterEngine", "T", "<init>", "()V", "a", "base_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nHcjFlutterActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HcjFlutterActivity.kt\ncom/huachenjie/base/flutter/HcjFlutterActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,63:1\n1#2:64\n*E\n"})
public final class HcjFlutterActivity extends FlutterFragmentActivity implements AdCancelInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: com.huachenjie.base.flutter.HcjFlutterActivity$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\n"}, d2 = {"Lcom/huachenjie/base/flutter/HcjFlutterActivity$a;", "", "Landroid/content/Context;", "context", "", "cachedEngineId", "Lio/flutter/embedding/android/FlutterFragmentActivity$CachedEngineIntentBuilder;", "a", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FlutterFragmentActivity.CachedEngineIntentBuilder a(@NotNull Context context, @NotNull String cachedEngineId) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(cachedEngineId, "cachedEngineId");
            try {
                a.a(context);
            } catch (Throwable unused) {
            }
            return new FlutterFragmentActivity.CachedEngineIntentBuilder(HcjFlutterActivity.class, cachedEngineId);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void U(HcjFlutterActivity hcjFlutterActivity, MethodCall methodCall, MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(hcjFlutterActivity, "this$0");
        Intrinsics.checkNotNullParameter(methodCall, "call");
        Intrinsics.checkNotNullParameter(result, "result");
        if (Intrinsics.areEqual(methodCall.method, d.A)) {
            hcjFlutterActivity.finish();
        } else {
            result.notImplemented();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void T(FlutterEngine flutterEngine) {
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor().getBinaryMessenger(), a.STARTUP_CHANNEL);
        methodChannel.setMethodCallHandler(new MethodChannel.MethodCallHandler() { // from class: com.zj.adlib.iz3
            @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
            public final void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
                HcjFlutterActivity.U(this.f42471a, methodCall, result);
            }
        });
        Intent intent = getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("method");
            String stringExtra2 = intent.getStringExtra("arguments");
            Object objH = stringExtra2 != null ? vw3.h(stringExtra2, Object.class) : null;
            if (stringExtra != null) {
                methodChannel.invokeMethod(stringExtra, objH);
            }
        }
    }

    public void configureFlutterEngine(@NotNull FlutterEngine flutterEngine) {
        Intrinsics.checkNotNullParameter(flutterEngine, "flutterEngine");
        super.configureFlutterEngine(flutterEngine);
        T(flutterEngine);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate(@Nullable Bundle savedInstanceState) {
        try {
            a.a(this);
        } catch (Throwable unused) {
        }
        super.onCreate(savedInstanceState);
    }
}
