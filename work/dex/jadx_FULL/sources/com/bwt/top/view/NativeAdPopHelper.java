package com.bwt.top.view;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bwt.top.AdPlatforms;
import com.bwt.top.AdUtil;
import com.bwt.top.NativeAdListener;
import com.bwt.top.R;
import com.bwt.top.ad.bean.NativeAdInfo;
import com.bwt.top.util.ALog;
import com.bwt.top.util.DisplayUtil;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class NativeAdPopHelper implements DialogInterface.OnDismissListener, View.OnClickListener {
    private String TAG;
    private AdDialog adDialog;
    private WeakReference<Context> contextRef;
    private Handler handler;
    private boolean isGdt;
    private boolean isRunAutoClose;
    private Handler mCloseHandler;
    private long mCloseTime;
    private boolean mKeen;
    private NativeAdListener mNativeAdListener;
    private long mTemTime;
    private TextView mTvCloseTime;
    private NativeAdInfo nativeAdInfo;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f28263a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ NativeAdInfo f1482a;

        public a(ViewGroup viewGroup, NativeAdInfo nativeAdInfo) {
            this.f28263a = viewGroup;
            this.f1482a = nativeAdInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (NativeAdPopHelper.this.mCloseTime > 0) {
                this.f28263a.findViewById(R.id.layout_auto_close).setVisibility(0);
            } else {
                this.f28263a.findViewById(R.id.layout_auto_close).setVisibility(8);
            }
            if (this.f1482a.getPlatform() == null || !this.f1482a.getPlatform().equals("gdt")) {
                NativeAdPopHelper.this.autoClose();
                if (NativeAdPopHelper.this.mCloseTime > 0) {
                    this.f28263a.findViewById(R.id.layout_native_ad_pop_close_iv).setVisibility(8);
                } else {
                    this.f28263a.findViewById(R.id.layout_native_ad_pop_close_iv).setVisibility(0);
                }
            }
        }
    }

    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            try {
                if (message.what == 1) {
                    NativeAdPopHelper.this.mTvCloseTime.setText(String.valueOf(NativeAdPopHelper.this.mTemTime));
                    if (NativeAdPopHelper.this.mTemTime == 0) {
                        NativeAdPopHelper.this.closeAd();
                    } else {
                        NativeAdPopHelper.access$010(NativeAdPopHelper.this);
                        NativeAdPopHelper.this.mCloseHandler.sendEmptyMessageDelayed(1, 1000L);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public NativeAdPopHelper(Activity activity) {
        this.TAG = "NativeAdPopHelper--";
        this.mCloseHandler = new b(Looper.getMainLooper());
        if (activity != null) {
            this.contextRef = new WeakReference<>(activity);
            if (getDecorView() != null) {
                AdDialog adDialog = new AdDialog(activity);
                this.adDialog = adDialog;
                adDialog.setOnDismissListener(this);
                this.handler = new Handler();
            }
        }
    }

    public NativeAdPopHelper(Fragment fragment) {
        this(fragment.getActivity());
    }

    public static /* synthetic */ long access$010(NativeAdPopHelper nativeAdPopHelper) {
        long j = nativeAdPopHelper.mTemTime;
        nativeAdPopHelper.mTemTime = j - 1;
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void autoClose() {
        Handler handler;
        ALog.d(this.TAG, "autoClose");
        if (this.isRunAutoClose || (handler = this.mCloseHandler) == null) {
            return;
        }
        long j = this.mCloseTime;
        if (j > 0) {
            this.isRunAutoClose = true;
            this.mTemTime = j / 1000;
            handler.sendEmptyMessage(1);
        }
    }

    private View getDecorView() {
        try {
            WeakReference<Context> weakReference = this.contextRef;
            if (weakReference == null || weakReference.get() == null) {
                return null;
            }
            return ((Activity) this.contextRef.get()).getWindow().getDecorView();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void setBackgroundAlpha(boolean z, Context context) {
        boolean z2;
        View decorView;
        try {
            Window window = ((Activity) context).getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (z) {
                attributes.alpha = 0.7f;
                z2 = false;
                window.getDecorView().setEnabled(false);
                decorView = window.getDecorView();
            } else {
                attributes.alpha = 1.0f;
                z2 = true;
                window.getDecorView().setEnabled(true);
                decorView = window.getDecorView();
            }
            decorView.setFocusable(z2);
            window.addFlags(2);
            window.setAttributes(attributes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setCloseLayoutParams(ViewGroup.LayoutParams layoutParams, View view) {
        if (layoutParams == null || view == null) {
            return;
        }
        try {
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).removeRule(10);
                ((RelativeLayout.LayoutParams) layoutParams).addRule(11);
                ((RelativeLayout.LayoutParams) layoutParams).addRule(8, view.getId());
                ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = DisplayUtil.dp2px(3);
            }
            if ((view instanceof ViewGroup) && ((ViewGroup) view).getChildCount() > 0 && (((ViewGroup) view).getChildAt(0) instanceof ImageView)) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) ((ViewGroup) view).getChildAt(0).getLayoutParams();
                marginLayoutParams.topMargin = 0;
                marginLayoutParams.leftMargin = 0;
                marginLayoutParams.bottomMargin = 0;
            }
        } catch (Exception unused) {
        }
    }

    public void closeAd() {
        try {
            AdDialog adDialog = this.adDialog;
            if (adDialog != null) {
                adDialog.dismiss();
            }
        } catch (Exception unused) {
        }
    }

    public void gdtAutoClose() {
        autoClose();
    }

    public void gdtDismiss() {
        try {
            AdDialog adDialog = this.adDialog;
            if (adDialog != null) {
                this.isGdt = true;
                adDialog.dismiss();
            }
        } catch (Exception unused) {
        }
    }

    public void isKeen(boolean z) {
        this.mKeen = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.layout_native_ad_pop_close_iv || view.getId() == R.id.layout_auto_close) {
            closeAd();
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        ALog.d(this.TAG, "onDismiss");
        AdUtil.setNativeAdPopHelper(null);
        if (this.isGdt) {
            this.isGdt = false;
            return;
        }
        WeakReference<Context> weakReference = this.contextRef;
        if (weakReference != null) {
            weakReference.get();
        }
        Handler handler = this.mCloseHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.mCloseHandler = null;
        }
        NativeAdListener nativeAdListener = this.mNativeAdListener;
        if (nativeAdListener != null) {
            nativeAdListener.onAdClose(this.nativeAdInfo);
        }
        NativeAdInfo nativeAdInfo = this.nativeAdInfo;
        if (nativeAdInfo != null) {
            nativeAdInfo.release();
        }
        Handler handler2 = this.handler;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
        }
    }

    public void setCloseTime(long j) {
        this.mCloseTime = j;
    }

    public void setNativeAdListener(NativeAdListener nativeAdListener) {
        this.mNativeAdListener = nativeAdListener;
    }

    public void showNativeAd(NativeAdInfo nativeAdInfo) {
        WeakReference<Context> weakReference;
        View nativeExpressAdView;
        Log.d(this.TAG, "-- showNativeAd");
        if (nativeAdInfo == null || (weakReference = this.contextRef) == null || weakReference.get() == null) {
            return;
        }
        this.nativeAdInfo = nativeAdInfo;
        Context context = this.contextRef.get();
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.layout_native_ad_pop, (ViewGroup) null);
        View decorView = getDecorView();
        if (viewGroup == null || decorView == null || (nativeExpressAdView = nativeAdInfo.getNativeExpressAdView(viewGroup)) == null) {
            return;
        }
        ImageView imageView = (ImageView) viewGroup.findViewById(R.id.layout_native_ad_pop_close_iv);
        LinearLayout linearLayout = (LinearLayout) viewGroup.findViewById(R.id.layout_auto_close);
        imageView.setVisibility(8);
        linearLayout.setVisibility(8);
        this.mTvCloseTime = (TextView) viewGroup.findViewById(R.id.tv_close_time);
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = linearLayout.getLayoutParams();
        setCloseLayoutParams(layoutParams, nativeExpressAdView);
        setCloseLayoutParams(layoutParams2, nativeExpressAdView);
        boolean z = nativeAdInfo instanceof INativeAdPop;
        if (z) {
            nativeExpressAdView = ((INativeAdPop) nativeAdInfo).getNativePopView();
        }
        viewGroup.addView(nativeExpressAdView, 0);
        nativeAdInfo.render(viewGroup);
        if (this.mKeen) {
            imageView.setClickable(false);
            this.adDialog.setCancelable(false);
            linearLayout.setClickable(false);
        } else {
            imageView.setOnClickListener(this);
            linearLayout.setOnClickListener(this);
        }
        this.adDialog.setContentView(viewGroup);
        this.adDialog.show();
        DisplayUtil.screenWidth(context);
        int iDp2px = DisplayUtil.dp2px(123);
        if (nativeAdInfo.getPlatform().equals(AdPlatforms.gdt.name()) || z) {
            this.adDialog.setSize(-2, -2);
        } else {
            this.adDialog.setSize(-2, iDp2px);
        }
        this.handler.postDelayed(new a(viewGroup, nativeAdInfo), 300L);
    }
}
