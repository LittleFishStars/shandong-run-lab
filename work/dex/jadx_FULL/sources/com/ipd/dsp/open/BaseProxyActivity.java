package com.ipd.dsp.open;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import com.ipd.dsp.internal.c2.k;
import com.ipd.dsp.internal.c2.r;
import com.ipd.dsp.internal.s0.b;
import com.ipd.dsp.internal.s0.c;
import com.ipd.dsp.open.BaseProxyActivity;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class BaseProxyActivity extends AppCompatActivity {
    private boolean isTransparent = false;
    private c loader;

    private void applyE2ECompatibilityAndroidX(final boolean z) {
        Window window = getWindow();
        View viewFindViewById = findViewById(R.id.content);
        if (window == null || viewFindViewById == null) {
            return;
        }
        final int paddingTop = viewFindViewById.getPaddingTop();
        final int paddingBottom = viewFindViewById.getPaddingBottom();
        final int paddingLeft = viewFindViewById.getPaddingLeft();
        final int paddingRight = viewFindViewById.getPaddingRight();
        WindowCompat.setDecorFitsSystemWindows(window, false);
        ViewCompat.setOnApplyWindowInsetsListener(viewFindViewById, new OnApplyWindowInsetsListener() { // from class: com.zj.adlib.vq0
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return BaseProxyActivity.lambda$applyE2ECompatibilityAndroidX$0(paddingTop, z, paddingBottom, paddingLeft, paddingRight, view, windowInsetsCompat);
            }
        });
        try {
            WindowCompat.getInsetsController(getWindow(), getWindow().getDecorView()).setAppearanceLightStatusBars(true);
        } catch (Throwable unused) {
            getWindow().getDecorView().setSystemUiVisibility(getWindow().getDecorView().getSystemUiVisibility() | 8192);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ WindowInsetsCompat lambda$applyE2ECompatibilityAndroidX$0(int i, boolean z, int i2, int i3, int i4, View view, WindowInsetsCompat windowInsetsCompat) {
        Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
        if (z) {
            i += insets.top;
        }
        view.setPadding(i3, i, i4, i2 + insets.bottom);
        return windowInsetsCompat;
    }

    @Override // android.app.Activity
    public void finish() {
        try {
            ((ViewGroup) getWindow().getDecorView()).removeAllViews();
        } catch (Throwable th) {
            k.a("Activity", th);
        }
        super.finish();
        if (this.isTransparent) {
            overridePendingTransition(0, 0);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        c cVar = this.loader;
        if (cVar != null) {
            cVar.a(i, i2, intent);
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        boolean booleanExtra = false;
        if (Build.VERSION.SDK_INT == 26) {
            try {
                Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
                declaredField.setAccessible(true);
                ActivityInfo activityInfo = (ActivityInfo) declaredField.get(this);
                if (activityInfo != null) {
                    activityInfo.screenOrientation = -1;
                    declaredField.setAccessible(false);
                }
            } catch (Exception unused) {
            }
        }
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            if (intent != null) {
                this.isTransparent = intent.getBooleanExtra(b.d, false);
                booleanExtra = intent.getBooleanExtra(b.e, false);
            }
        } catch (Throwable unused2) {
        }
        try {
            c cVar = new c(this);
            this.loader = cVar;
            cVar.b();
            applyE2ECompatibilityAndroidX(booleanExtra);
        } catch (Throwable th) {
            r.a(th);
            c cVar2 = this.loader;
            if (cVar2 != null) {
                try {
                    cVar2.a(th);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            finish();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        c cVar = this.loader;
        if (cVar != null) {
            cVar.c();
        }
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        c cVar = this.loader;
        if (cVar != null) {
            return cVar.a(i);
        }
        return false;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(@NonNull MenuItem menuItem) {
        c cVar = this.loader;
        if (cVar != null) {
            return cVar.a(menuItem);
        }
        return false;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        c cVar = this.loader;
        if (cVar != null) {
            cVar.d();
        }
        super.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        c cVar = this.loader;
        if (cVar != null) {
            cVar.a(i, strArr, iArr);
        } else {
            super.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    @Override // android.app.Activity
    public void onRestart() {
        c cVar = this.loader;
        if (cVar != null) {
            cVar.e();
        }
        super.onRestart();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        c cVar = this.loader;
        if (cVar != null) {
            cVar.f();
        }
        super.onResume();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        c cVar = this.loader;
        if (cVar != null) {
            cVar.g();
        }
        super.onStart();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        c cVar = this.loader;
        if (cVar != null) {
            cVar.h();
        }
        super.onStop();
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        if (this.isTransparent) {
            super.overridePendingTransition(0, 0);
        } else {
            super.overridePendingTransition(i, i2);
        }
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i) {
        if (Build.VERSION.SDK_INT == 26) {
            return;
        }
        super.setRequestedOrientation(i);
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2, int i3) {
        if (this.isTransparent) {
            super.overridePendingTransition(0, 0, i3);
        } else {
            super.overridePendingTransition(i, i2, i3);
        }
    }
}
