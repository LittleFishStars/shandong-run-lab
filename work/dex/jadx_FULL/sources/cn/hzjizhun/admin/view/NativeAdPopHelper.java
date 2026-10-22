package cn.hzjizhun.admin.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.hzjizhun.admin.R;
import cn.hzjizhun.admin.ad.adapter.AdapterAdLoaderImp;
import cn.hzjizhun.admin.ad.bean.AdPlatforms;
import cn.hzjizhun.admin.ad.bean.JZNativeAdInfo;
import cn.hzjizhun.admin.ad.listener.JZNativeAdListener;
import cn.hzjizhun.admin.ad.utils.JZAdUtil;
import cn.hzjizhun.admin.ddsksdddk;
import cn.hzjizhun.admin.util.ALog;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class NativeAdPopHelper implements DialogInterface.OnDismissListener, View.OnClickListener, View.OnTouchListener {
    private String TAG;
    private AdDialog adDialog;
    private WeakReference<Context> contextRef;
    private Handler handler;
    private boolean isNoChannelPlatforms;
    private boolean isRunAutoClose;
    private boolean isSetLifeCycle;
    private float mAmount;
    private Handler mCloseHandler;
    private long mCloseTime;
    private boolean mIsBackDismiss;
    private boolean mIsOutsideCancel;
    private boolean mIsViewBottomCloseView;
    private JZNativeAdListener mJZNativeAdListener;
    private boolean mKeen;
    private long mTemTime;
    private TextView mTvCloseTime;
    private INativeAdPop nativeAdInfo;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            NativeAdPopHelper.this.closeAd();
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f22753a;

        public b(ViewGroup viewGroup) {
            this.f22753a = viewGroup;
        }

        @Override // java.lang.Runnable
        public void run() {
            NativeAdPopHelper.this.setCloseView(this.f22753a);
        }
    }

    public class c implements DialogInterface.OnShowListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f22754a;

        public c(ViewGroup viewGroup) {
            this.f22754a = viewGroup;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            NativeAdPopHelper.this.renderAd(this.f22754a);
        }
    }

    public class d extends Handler {
        public d(Looper looper) {
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
                        return;
                    }
                    if (!NativeAdPopHelper.this.isSetLifeCycle || NativeAdPopHelper.this.nativeAdInfo == null || NativeAdPopHelper.this.nativeAdInfo.isActResume()) {
                        NativeAdPopHelper.access$010(NativeAdPopHelper.this);
                    }
                    NativeAdPopHelper.this.mCloseHandler.sendEmptyMessageDelayed(1, 1000L);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public NativeAdPopHelper(Activity activity) {
        this(activity, -1);
    }

    public static /* synthetic */ long access$010(NativeAdPopHelper nativeAdPopHelper) {
        long j = nativeAdPopHelper.mTemTime;
        nativeAdPopHelper.mTemTime = j - 1;
        return j;
    }

    private void autoClose() {
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
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private void initAdDialog(ViewGroup viewGroup) {
        try {
            this.adDialog.setCancelable(this.mIsBackDismiss);
            this.adDialog.setCanceledOnTouchOutside(this.mIsOutsideCancel);
            this.adDialog.setContentView(viewGroup);
            this.adDialog.setOnShowListener(new c(viewGroup));
            if (isPlatformsOfNoChannel()) {
                this.adDialog.noChannelSetTouch();
            }
            this.adDialog.show();
            this.adDialog.setDimAmount(this.mAmount);
            String platform = this.nativeAdInfo.getPlatform();
            if (!platform.equals(AdPlatforms.gdt.name()) && !platform.equals(AdPlatforms.csj.name())) {
                this.adDialog.setSize(-1, -2);
                return;
            }
            this.adDialog.setSize(-1, -2);
        } catch (Throwable unused) {
        }
    }

    private void initContentView(ViewGroup viewGroup, View view) {
        try {
            LinearLayout linearLayout = (LinearLayout) viewGroup.findViewById(R.id.layout_auto_close);
            ImageView imageView = (ImageView) viewGroup.findViewById(R.id.layout_native_ad_pop_close_iv_bottom);
            RelativeLayout relativeLayout = (RelativeLayout) viewGroup.findViewById(R.id.layoutAd);
            this.mTvCloseTime = (TextView) viewGroup.findViewById(R.id.tv_close_time);
            if (this.mIsViewBottomCloseView) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
            relativeLayout.removeAllViews();
            relativeLayout.addView(view, 0);
            byte[] bArrDecode = Base64.decode(AdapterAdLoaderImp.mCloseBitmap64, 0);
            Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
            imageView.setImageBitmap(bitmapDecodeByteArray);
            linearLayout.setVisibility(8);
            imageView.setOnClickListener(this);
            ImageView imageView2 = (ImageView) view.findViewById(R.id.layout_native_ad_pop_close_iv);
            if (imageView2 != null) {
                imageView2.setVisibility(8);
                imageView2.setImageBitmap(bitmapDecodeByteArray);
                imageView2.setOnClickListener(this);
            }
        } catch (Throwable unused) {
        }
    }

    private boolean isCloseAdView(View view) {
        try {
            return view.getId() == R.id.layout_native_ad_pop_close_iv || view.getId() == R.id.layout_native_ad_pop_close_iv_bottom;
        } catch (Throwable unused) {
        }
    }

    private boolean isPlatformsOfNoChannel() {
        try {
            String platform = this.nativeAdInfo.getPlatform();
            return (platform.equals(AdPlatforms.zhike.name()) || platform.equals(AdPlatforms.channel.name())) ? false : true;
        } catch (Throwable unused) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void renderAd(ViewGroup viewGroup) {
        try {
            this.nativeAdInfo.render(viewGroup);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCloseView(ViewGroup viewGroup) {
        try {
            viewGroup.findViewById(R.id.layout_auto_close).setVisibility(this.mCloseTime > 0 ? 0 : 8);
            ImageView imageView = (ImageView) viewGroup.findViewById(R.id.layout_native_ad_pop_close_iv_bottom);
            if (this.mIsViewBottomCloseView) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
            if (isPlatformsOfNoChannel()) {
                return;
            }
            autoClose();
            viewGroup.findViewById(R.id.layout_native_ad_pop_close_iv).setVisibility(0);
        } catch (Throwable unused) {
        }
    }

    public void closeAd() {
        try {
            AdDialog adDialog = this.adDialog;
            if (adDialog != null) {
                adDialog.dismiss();
            }
        } catch (Throwable unused) {
        }
    }

    public void isKeen(boolean z) {
        this.mKeen = z;
    }

    public void noChannelPlatformsAutoClose() {
        autoClose();
    }

    public void noChannelPlatformsDismiss() {
        try {
            AdDialog adDialog = this.adDialog;
            if (adDialog != null) {
                this.isNoChannelPlatforms = true;
                adDialog.dismiss();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (isCloseAdView(view)) {
            closeAd();
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        try {
            ALog.d(this.TAG, "onDismiss");
            JZAdUtil.removeNativeAdPopHelper(this.nativeAdInfo);
            if (this.isNoChannelPlatforms) {
                this.isNoChannelPlatforms = false;
                return;
            }
            Handler handler = this.mCloseHandler;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                this.mCloseHandler = null;
            }
            INativeAdPop iNativeAdPop = this.nativeAdInfo;
            if (iNativeAdPop != null) {
                iNativeAdPop.release();
            }
            Handler handler2 = this.handler;
            if (handler2 != null) {
                handler2.removeCallbacksAndMessages(null);
            }
            JZNativeAdListener jZNativeAdListener = this.mJZNativeAdListener;
            if (jZNativeAdListener != null) {
                jZNativeAdListener.onAdClose((JZNativeAdInfo) this.nativeAdInfo);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0 || !isCloseAdView(view)) {
            return false;
        }
        view.postDelayed(new a(), 200L);
        return false;
    }

    public void setCancelable(boolean z) {
        this.mIsBackDismiss = z;
    }

    public void setCanceledOnTouchOutside(boolean z) {
    }

    public void setCloseTime(long j) {
        this.mCloseTime = j;
    }

    public void setDimAmount(float f) {
        this.mAmount = f;
    }

    public void setIsViewBottomCloseView(boolean z) {
        this.mIsViewBottomCloseView = z;
    }

    public void setNativeAdListener(JZNativeAdListener jZNativeAdListener) {
        this.mJZNativeAdListener = jZNativeAdListener;
    }

    public void showNativeAd(INativeAdPop iNativeAdPop) {
        WeakReference<Context> weakReference;
        if (iNativeAdPop == null || (weakReference = this.contextRef) == null || weakReference.get() == null || iNativeAdPop.isReleased()) {
            return;
        }
        this.nativeAdInfo = iNativeAdPop;
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.contextRef.get()).inflate(R.layout.jz_layout_native_ad_pop, (ViewGroup) null);
        View decorView = getDecorView();
        if (viewGroup == null || decorView == null) {
            return;
        }
        RootTouchViewGroup rootTouchViewGroup = (RootTouchViewGroup) viewGroup.findViewById(R.id.rootTouchGroup);
        rootTouchViewGroup.kdsksdda = true;
        ddsksdddk.c(iNativeAdPop.getPlatformPosId(), rootTouchViewGroup);
        View nativePopView = iNativeAdPop.getNativePopView();
        if (nativePopView == null || nativePopView.getParent() != null) {
            ALog.e("信息流", "show 只能调用一次");
            return;
        }
        initContentView(viewGroup, nativePopView);
        initAdDialog(viewGroup);
        this.handler.postDelayed(new b(viewGroup), 300L);
    }

    public NativeAdPopHelper(Activity activity, int i, boolean z) {
        this(activity, i);
        this.isSetLifeCycle = z;
    }

    public NativeAdPopHelper(Activity activity, int i) {
        this.TAG = "NativeAdPopHelper--";
        this.isSetLifeCycle = true;
        this.mCloseHandler = new d(Looper.getMainLooper());
        if (activity != null) {
            this.contextRef = new WeakReference<>(activity);
            if (getDecorView() != null) {
                AdDialog adDialog = new AdDialog(activity, i);
                this.adDialog = adDialog;
                adDialog.setOnDismissListener(this);
                this.handler = new Handler();
            }
        }
    }
}
