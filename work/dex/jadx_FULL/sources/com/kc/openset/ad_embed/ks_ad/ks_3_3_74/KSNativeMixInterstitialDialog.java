package com.kc.openset.ad_embed.ks_ad.ks_3_3_74;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class KSNativeMixInterstitialDialog extends Dialog {
    static {
        OSETSDKProtected.interface11(4139);
    }

    public KSNativeMixInterstitialDialog(Context context, View view, double d) {
        super(context);
        setContentView(view);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        if (getWindow() != null) {
            getWindow().setBackgroundDrawableResource(R.color.transparent);
        }
        initWindowLayoutParams(context, d);
        ImageView imageView = (ImageView) view.findViewById(com.kc.openset.R.id.oset_ks_ad_dislike);
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener(this) { // from class: com.kc.openset.ad_embed.ks_ad.ks_3_3_74.KSNativeMixInterstitialDialog.1
                final KSNativeMixInterstitialDialog this$0;

                static {
                    OSETSDKProtected.interface11(4138);
                }

                {
                    this.this$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public native void onClick(View view2);
            });
        }
    }

    private native DisplayMetrics getMetrics(Context context);

    private native void initWindowLayoutParams(Context context, double d);
}
