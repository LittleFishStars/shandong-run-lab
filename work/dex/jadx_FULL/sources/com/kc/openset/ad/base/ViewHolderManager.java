package com.kc.openset.ad.base;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.NativeViewConfig;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class ViewHolderManager {
    protected static volatile ViewHolderManager viewHolderManager;

    @Keep
    public static class ViewHolder {
        public static final int NO_ERROR = -1;
        private Button btnAct;
        private View containerView;
        private int errorCode = -1;
        private String errorMessage;
        private ImageView ivAdSourceImg;
        private ImageView ivClose;
        private ImageView ivIcon;
        private final NativeViewConfig mNativeViewConfig;
        private TextView tvAdSource;
        private TextView tvAppAuthorName;
        private TextView tvAppFunction;
        private TextView tvAppName;
        private TextView tvAppPrivacy;
        private TextView tvAppVersion;
        private TextView tvContent;
        private TextView tvPermission;
        private TextView tvTitle;
        private ViewGroup vgMedia;

        static {
            OSETSDKProtected.interface11(3757);
        }

        public ViewHolder(NativeViewConfig nativeViewConfig) {
            this.mNativeViewConfig = nativeViewConfig;
        }

        public static native /* synthetic */ View access$002(ViewHolder viewHolder, View view);

        public static native /* synthetic */ TextView access$1002(ViewHolder viewHolder, TextView textView);

        public static native /* synthetic */ TextView access$102(ViewHolder viewHolder, TextView textView);

        public static native /* synthetic */ TextView access$1102(ViewHolder viewHolder, TextView textView);

        public static native /* synthetic */ TextView access$1202(ViewHolder viewHolder, TextView textView);

        public static native /* synthetic */ TextView access$1302(ViewHolder viewHolder, TextView textView);

        public static native /* synthetic */ TextView access$1402(ViewHolder viewHolder, TextView textView);

        public static native /* synthetic */ TextView access$202(ViewHolder viewHolder, TextView textView);

        public static native /* synthetic */ Button access$302(ViewHolder viewHolder, Button button);

        public static native /* synthetic */ ImageView access$402(ViewHolder viewHolder, ImageView imageView);

        public static native /* synthetic */ ImageView access$502(ViewHolder viewHolder, ImageView imageView);

        public static native /* synthetic */ TextView access$602(ViewHolder viewHolder, TextView textView);

        public static native /* synthetic */ ImageView access$702(ViewHolder viewHolder, ImageView imageView);

        public static native /* synthetic */ ViewGroup access$802(ViewHolder viewHolder, ViewGroup viewGroup);

        public static native /* synthetic */ TextView access$902(ViewHolder viewHolder, TextView textView);

        public native void destroy();

        public native Button getAct();

        public native ImageView getAdImgView(Activity activity);

        public native ImageView getAdSourceImg();

        public native TextView getAppFunction();

        public native TextView getAppPrivacy();

        public native List<View> getClickViews();

        public native ImageView getCloseView();

        public native View getContainerView();

        public native int getErrorCode();

        public native String getErrorMessage();

        public native ImageView getIconView();

        public native ViewGroup getMediaView();

        public native NativeViewConfig getNativeViewConfig();

        public native TextView getPermission();

        public native void hideAdSource();

        public native void hideSourceImg();

        public native void setAct(String str);

        public native void setAppAuthorName(String str);

        public native void setAppInfoVisibility(boolean z);

        public native void setAppName(String str);

        public native void setAppVersion(String str);

        public native void setClickListener(View view, View.OnClickListener onClickListener);

        public native void setContent(String str);

        public native void setContentView(View view);

        public native void setErrorCode(int i);

        public native void setErrorMessage(String str);

        public native void setIcon(Context context, String str);

        public native void setSource(String str);

        public native void setSourceImg(Context context, String str);

        public native void setTitle(String str);
    }

    static {
        OSETSDKProtected.interface11(3758);
    }

    private ViewHolderManager() {
    }

    public static native ViewHolderManager getInstance();

    public native ViewHolder getViewHolder(Activity activity, NativeViewConfig nativeViewConfig);
}
