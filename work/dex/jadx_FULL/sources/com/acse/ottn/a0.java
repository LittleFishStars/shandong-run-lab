package com.acse.ottn;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.Window;
import android.widget.Toast;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;
import androidx.appcompat.app.AppCompatActivity;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a0 extends AppCompatActivity {
    public static final String d = "BaseActivity";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Toast f22783a;
    public long b = 0;
    public AppCompatActivity c;

    public void a(AppCompatActivity appCompatActivity) {
        this.c = appCompatActivity;
    }

    public void b() {
        finish();
        overridePendingTransition(R.anim.slide_in_from_bottom, R.anim.slide_out_from_top);
        q.c(this);
    }

    public void c(Intent intent) {
        q.c(this);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_from_left);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.c == null) {
            a();
            return;
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setFlags(TTAdConstant.KEY_CLICK_AREA);
        intent.addCategory("android.intent.category.HOME");
        startActivity(intent);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (b(this)) {
            a((Activity) this);
        }
        super.onCreate(bundle);
        setRequestedOrientation(1);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Toast toast = this.f22783a;
        if (toast != null) {
            toast.cancel();
            this.f22783a = null;
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        Toast toast = this.f22783a;
        if (toast != null) {
            toast.cancel();
            this.f22783a = null;
        }
        p.l = Boolean.FALSE;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        p.l = Boolean.TRUE;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        h2.b("Memory", "max:" + ((Runtime.getRuntime().maxMemory() / 1024) / 1024) + " total:" + ((Runtime.getRuntime().totalMemory() / 1024) / 1024) + " free:" + ((Runtime.getRuntime().freeMemory() / 1024) / 1024) + " ");
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i) {
        if (b(this)) {
            return;
        }
        super.setRequestedOrientation(i);
    }

    public void a() {
        finish();
        overridePendingTransition(R.anim.slide_in_from_left, R.anim.slide_out_from_right);
        q.c(this);
    }

    public void b(Intent intent) {
        q.c(this);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_from_bottom, R.anim.slide_out_from_top);
    }

    public void a(Intent intent) {
        finish();
        q.c(this);
        c(intent);
        overridePendingTransition(R.anim.slide_in_from_left, R.anim.slide_out_from_right);
    }

    public static boolean b(Activity activity) {
        Exception e;
        boolean zBooleanValue;
        try {
            TypedArray typedArrayObtainStyledAttributes = activity.obtainStyledAttributes((int[]) Class.forName("com.android.internal.R$styleable").getField("Window").get(null));
            Method method = ActivityInfo.class.getMethod("isTranslucentOrFloating", TypedArray.class);
            method.setAccessible(true);
            zBooleanValue = ((Boolean) method.invoke(null, typedArrayObtainStyledAttributes)).booleanValue();
            try {
                method.setAccessible(false);
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
            }
        } catch (Exception e3) {
            e = e3;
            zBooleanValue = false;
        }
        return zBooleanValue;
    }

    public void a(Intent intent, int i) {
        q.c(this);
        startActivityForResult(intent, i);
        overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_from_left);
    }

    public void a(int i) {
        Window window = getWindow();
        a(this, i, 0);
        window.addFlags(2048);
        window.clearFlags(1024);
        window.getDecorView().setSystemUiVisibility(1280);
    }

    public void a(Activity activity, @ColorInt int i, @IntRange(from = 0, to = 255) int i2) {
        o4.b(activity, i, i2);
    }

    public void a(boolean z) {
        if (z) {
            getWindow().getDecorView().setSystemUiVisibility(1024);
        } else {
            getWindow().getDecorView().setSystemUiVisibility(AVMDLDataLoader.KeyIsLoaderCacheSize);
        }
    }

    public static boolean a(Activity activity) {
        try {
            Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
            declaredField.setAccessible(true);
            ((ActivityInfo) declaredField.get(activity)).screenOrientation = -1;
            declaredField.setAccessible(false);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
