package com.king.zxing;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.king.zxing.camera.CameraManager;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class CaptureActivity extends AppCompatActivity implements OnCaptureCallback {
    public static final String t = "SCAN_RESULT";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SurfaceView f40011a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public View f15004a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ViewfinderView f15005a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f15006a;

    @Deprecated
    public CameraManager S() {
        return this.f15006a.c();
    }

    public b T() {
        return this.f15006a;
    }

    public int U() {
        return R.id.ivTorch;
    }

    public int V() {
        return R.layout.zxl_capture;
    }

    public int W() {
        return R.id.surfaceView;
    }

    public int X() {
        return R.id.viewfinderView;
    }

    public void Y() {
        b bVar = new b(this, this.f40011a, this.f15005a, this.f15004a);
        this.f15006a = bVar;
        bVar.O(this);
    }

    public boolean Z(@LayoutRes int i) {
        return true;
    }

    public void initUI() {
        this.f40011a = (SurfaceView) findViewById(W());
        int iX = X();
        if (iX != 0) {
            this.f15005a = (ViewfinderView) findViewById(iX);
        }
        int iU = U();
        if (iU != 0) {
            View viewFindViewById = findViewById(iU);
            this.f15004a = viewFindViewById;
            viewFindViewById.setVisibility(4);
        }
        Y();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        int iV = V();
        if (Z(iV)) {
            setContentView(iV);
        }
        initUI();
        this.f15006a.onCreate();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f15006a.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.f15006a.onPause();
    }

    @Override // com.king.zxing.OnCaptureCallback
    public boolean onResultCallback(String str) {
        return false;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f15006a.onResume();
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f15006a.onTouchEvent(motionEvent);
        return super.onTouchEvent(motionEvent);
    }
}
