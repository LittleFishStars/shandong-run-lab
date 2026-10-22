package com.king.zxing;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.king.zxing.camera.CameraManager;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class CaptureFragment extends Fragment implements OnCaptureCallback {
    public static final String KEY_RESULT = "SCAN_RESULT";
    private View ivTorch;
    private b mCaptureHelper;
    private View mRootView;
    private SurfaceView surfaceView;
    private ViewfinderView viewfinderView;

    public static CaptureFragment newInstance() {
        Bundle bundle = new Bundle();
        CaptureFragment captureFragment = new CaptureFragment();
        captureFragment.setArguments(bundle);
        return captureFragment;
    }

    @Deprecated
    public CameraManager getCameraManager() {
        return this.mCaptureHelper.c();
    }

    public b getCaptureHelper() {
        return this.mCaptureHelper;
    }

    public int getIvTorchId() {
        return R.id.ivTorch;
    }

    public int getLayoutId() {
        return R.layout.zxl_capture;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public int getSurfaceViewId() {
        return R.id.surfaceView;
    }

    public int getViewfinderViewId() {
        return R.id.viewfinderView;
    }

    public void initCaptureHelper() {
        b bVar = new b(this, this.surfaceView, this.viewfinderView, this.ivTorch);
        this.mCaptureHelper = bVar;
        bVar.O(this);
    }

    public void initUI() {
        this.surfaceView = (SurfaceView) this.mRootView.findViewById(getSurfaceViewId());
        int viewfinderViewId = getViewfinderViewId();
        if (viewfinderViewId != 0) {
            this.viewfinderView = (ViewfinderView) this.mRootView.findViewById(viewfinderViewId);
        }
        int ivTorchId = getIvTorchId();
        if (ivTorchId != 0) {
            View viewFindViewById = this.mRootView.findViewById(ivTorchId);
            this.ivTorch = viewFindViewById;
            viewFindViewById.setVisibility(4);
        }
        initCaptureHelper();
    }

    public boolean isContentView(@LayoutRes int i) {
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        this.mCaptureHelper.onCreate();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (isContentView(getLayoutId())) {
            this.mRootView = layoutInflater.inflate(getLayoutId(), viewGroup, false);
        }
        initUI();
        return this.mRootView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mCaptureHelper.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.mCaptureHelper.onPause();
    }

    @Override // com.king.zxing.OnCaptureCallback
    public boolean onResultCallback(String str) {
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.mCaptureHelper.onResume();
    }

    public void setRootView(View view) {
        this.mRootView = view;
    }
}
