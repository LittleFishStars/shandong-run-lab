package com.kwad.components.core.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.wrapper.m;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class KsLogoView extends LinearLayout {
    private boolean awr;
    TextView aws;
    ImageView awt;
    private a awu;
    private SimpleImageLoadingListener hU;

    public interface a {
        void bK();
    }

    public KsLogoView(Context context) {
        this(context, (AttributeSet) null);
    }

    public static Bitmap a(KsLogoView ksLogoView) {
        TextView textView = ksLogoView.getTextView();
        int iCeil = ((ksLogoView.getVisibility() != 0 || textView.getText() == null || textView.getText().length() <= 0) ? 0 : ((int) Math.ceil(textView.getPaint().measureText(textView.getText().toString()))) + textView.getPaddingLeft() + textView.getPaddingRight()) + (ksLogoView.getIcon().getVisibility() == 0 ? com.kwad.sdk.c.a.a.a(ksLogoView.getContext(), 18.0f) : 0);
        int iA = com.kwad.sdk.c.a.a.a(ksLogoView.getContext(), 16.0f);
        ksLogoView.measure(iCeil, iA);
        ksLogoView.layout(0, 0, iCeil, iA);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(ksLogoView.getWidth(), ksLogoView.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawColor(0);
        ksLogoView.draw(canvas);
        return bitmapCreateBitmap;
    }

    private void init() {
        m.inflate(getContext(), R.layout.ksad_logo_layout, this);
        this.aws = (TextView) findViewById(R.id.ksad_logo_text);
        this.awt = (ImageView) findViewById(R.id.ksad_logo_icon);
        boolean z = getBackground() == null;
        this.awr = z;
        if (z) {
            this.awt.setImageDrawable(getResources().getDrawable(R.drawable.ksad_logo_gray));
            this.aws.setTextColor(-6513508);
        } else {
            this.awt.setImageDrawable(getResources().getDrawable(R.drawable.ksad_logo_white));
            this.aws.setTextColor(-1711276033);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zW() {
        this.awt.setImageDrawable(getContext().getResources().getDrawable(this.awr ? R.drawable.ksad_logo_gray : R.drawable.ksad_logo_white));
    }

    public final void bl(AdTemplate adTemplate) {
        View viewFindViewById = findViewById(R.id.ksad_logo_container);
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        String str = this.awr ? adInfoEO.adBaseInfo.adGrayMarkIcon : adInfoEO.adBaseInfo.adMarkIcon;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(adInfoEO.adBaseInfo.adSourceDescription)) {
            this.aws.setVisibility(0);
            this.aws.setText(com.kwad.sdk.core.response.helper.a.aJ(adInfoEO));
            this.awt.setVisibility(0);
            zW();
            a aVar = this.awu;
            if (aVar != null) {
                aVar.bK();
            }
        } else {
            if (TextUtils.isEmpty(adInfoEO.adBaseInfo.adSourceDescription)) {
                this.aws.setVisibility(8);
                this.aws.setText("");
            } else {
                this.aws.setText(com.kwad.sdk.core.response.helper.a.aJ(adInfoEO));
                this.aws.setVisibility(0);
            }
            if (TextUtils.isEmpty(str)) {
                this.awt.setVisibility(8);
                this.awt.setImageDrawable(null);
                a aVar2 = this.awu;
                if (aVar2 != null) {
                    aVar2.bK();
                }
            } else {
                KSImageLoader.loadFeeImage(this.awt, str, adTemplate, this.hU);
                this.awt.setVisibility(0);
            }
        }
        viewFindViewById.setVisibility(0);
    }

    public ImageView getIcon() {
        return this.awt;
    }

    public TextView getTextView() {
        return this.aws;
    }

    public void setLogoLoadFinishListener(a aVar) {
        this.awu = aVar;
    }

    public KsLogoView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KsLogoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(m.wrapContextIfNeed(context), attributeSet, i);
        this.hU = new SimpleImageLoadingListener() { // from class: com.kwad.components.core.widget.KsLogoView.1
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingComplete(String str, View view, DecodedResult decodedResult) {
                if (KsLogoView.this.awu != null) {
                    KsLogoView.this.awu.bK();
                }
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingFailed(String str, View view, FailReason failReason) {
                KsLogoView.this.zW();
                if (KsLogoView.this.awu != null) {
                    KsLogoView.this.awu.bK();
                }
            }
        };
        init();
    }

    public KsLogoView(Context context, boolean z) {
        super(m.wrapContextIfNeed(context));
        this.hU = new SimpleImageLoadingListener() { // from class: com.kwad.components.core.widget.KsLogoView.1
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingComplete(String str, View view, DecodedResult decodedResult) {
                if (KsLogoView.this.awu != null) {
                    KsLogoView.this.awu.bK();
                }
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingFailed(String str, View view, FailReason failReason) {
                KsLogoView.this.zW();
                if (KsLogoView.this.awu != null) {
                    KsLogoView.this.awu.bK();
                }
            }
        };
        if (z) {
            setBackground(getResources().getDrawable(R.drawable.ksad_splash_logo_bg));
        }
        init();
    }
}
