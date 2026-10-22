package com.ltmb.ltadsdk.core.permission;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.alibaba.triver.basic.api.RequestPermission;
import com.ltmb.ltadsdk.R;
import com.ltmb.ltadsdk.pkg.d9;
import com.ltmb.ltadsdk.pkg.n7;
import com.ltmb.ltadsdk.pkg.s1;
import com.ltmb.ltadsdk.pkg.s7;
import com.ltmb.ltadsdk.pkg.u;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00042\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/ltmb/ltadsdk/core/permission/AdPermissionActivity;", "Landroid/app/Activity;", "<init>", "()V", "d", "a", "ADAarBuild_ltmbRelease"}, k = 1, mv = {1, 4, 0})
public final class AdPermissionActivity extends Activity {
    public static int b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function1<? super Boolean, Unit> f40357a;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public static final Map<Integer, Function1<Boolean, Unit>> c = new LinkedHashMap();

    /* JADX INFO: renamed from: com.ltmb.ltadsdk.core.permission.AdPermissionActivity$a, reason: from kotlin metadata */
    public static final class Companion {

        /* JADX INFO: renamed from: com.ltmb.ltadsdk.core.permission.AdPermissionActivity$a$a, reason: collision with other inner class name */
        public static final class C1321a extends Lambda implements Function1<Boolean, Unit> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Function1 f40358a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C1321a(Function1 function1) {
                super(1);
                this.f40358a = function1;
            }

            public Object invoke(Object obj) {
                this.f40358a.invoke(Boolean.valueOf(((Boolean) obj).booleanValue()));
                return Unit.INSTANCE;
            }
        }

        public final void a(@Nullable Context context, @NotNull String str, @NotNull Function1<? super Boolean, Unit> function1) {
            Intrinsics.checkNotNullParameter(str, "type");
            Intrinsics.checkNotNullParameter(function1, RenderCallContext.TYPE_CALLBACK);
            if (context == null) {
                return;
            }
            C1321a c1321a = new C1321a(function1);
            Intrinsics.checkNotNullParameter(c1321a, RenderCallContext.TYPE_CALLBACK);
            int i = AdPermissionActivity.b + 1;
            AdPermissionActivity.b = i;
            AdPermissionActivity.c.put(Integer.valueOf(i), c1321a);
            Intent intent = new Intent(context, (Class<?>) AdPermissionActivity.class);
            intent.putExtra("type", str);
            intent.putExtra("index", i);
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f40359a;
        public final /* synthetic */ AdPermissionActivity b;

        public b(View view, AdPermissionActivity adPermissionActivity) {
            this.f40359a = view;
            this.b = adPermissionActivity;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ViewGroup.LayoutParams layoutParams = this.f40359a.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = n7.c(this.b) + s7.a.a(20);
                this.f40359a.setLayoutParams(layoutParams);
            }
        }
    }

    public final void a() {
        Function1<? super Boolean, Unit> function1 = this.f40357a;
        if (function1 != null) {
        }
        if (isFinishing() || isDestroyed()) {
            return;
        }
        finish();
    }

    public final void b() {
        Function1<? super Boolean, Unit> function1 = this.f40357a;
        if (function1 != null) {
        }
        if (isFinishing() || isDestroyed()) {
            return;
        }
        finish();
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        s1 s1Var;
        super.onCreate(bundle);
        int intExtra = getIntent().getIntExtra("index", 0);
        String stringExtra = getIntent().getStringExtra("type");
        d9.d.a("type=" + stringExtra + ", index=" + intExtra);
        if (intExtra == 0) {
            finish();
            return;
        }
        Map<Integer, Function1<Boolean, Unit>> map = c;
        this.f40357a = (Function1) ((LinkedHashMap) map).get(Integer.valueOf(intExtra));
        map.remove(Integer.valueOf(intExtra));
        setContentView(R.layout.ltad_activity_permission_request);
        View viewFindViewById = findViewById(R.id.syad_ll_content);
        if (viewFindViewById != null) {
            viewFindViewById.post(new b(viewFindViewById, this));
        }
        overridePendingTransition(0, 0);
        Window window = getWindow();
        int i = Build.VERSION.SDK_INT;
        window.setStatusBarColor(0);
        window.setNavigationBarColor(0);
        View decorView = window.getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "decorView");
        decorView.setSystemUiVisibility(1280);
        if (i >= 30) {
            window.setDecorFitsSystemWindows(false);
        }
        window.setBackgroundDrawableResource(android.R.color.transparent);
        window.addFlags(32);
        window.addFlags(262144);
        Window window2 = getWindow();
        Intrinsics.checkNotNullExpressionValue(window2, "window");
        WindowManager.LayoutParams attributes = window2.getAttributes();
        attributes.screenBrightness = -1.0f;
        Window window3 = getWindow();
        Intrinsics.checkNotNullExpressionValue(window3, "window");
        window3.setAttributes(attributes);
        Intrinsics.checkNotNull(stringExtra);
        if (TextUtils.equals(stringExtra, "notify")) {
            s1.a aVar = s1.e;
            s1Var = s1.d;
        } else {
            s1Var = null;
        }
        if (s1Var == null) {
            a();
            return;
        }
        List<String> list = s1Var.a;
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (!(u.a(this, str) == 0)) {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            b();
        } else {
            d9.d.a("request permission =" + arrayList);
            Object[] array = arrayList.toArray(new String[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            requestPermissions((String[]) array, 10000);
        }
        TextView textView = (TextView) findViewById(R.id.syad_tv_pers_title);
        if (textView != null) {
            textView.setText(s1Var.c);
        }
        TextView textView2 = (TextView) findViewById(R.id.syad_tv_pers_desc);
        if (textView2 != null) {
            textView2.setText(s1Var.b);
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, @NotNull String[] strArr, @NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(strArr, RequestPermission.PERMISSIONS);
        Intrinsics.checkNotNullParameter(iArr, RequestPermission.GRANT_RESULTS);
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 10000) {
            boolean z = true;
            for (int i2 : iArr) {
                if (i2 != 0) {
                    z = false;
                }
            }
            d9 d9Var = d9.d;
            if (d9.a) {
                d9Var.a("request permission=" + ArraysKt.toMutableList(strArr) + ", result=" + z);
            }
            if (z) {
                b();
            } else {
                a();
            }
        }
    }
}
