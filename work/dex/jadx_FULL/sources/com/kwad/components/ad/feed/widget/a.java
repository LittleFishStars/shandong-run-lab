package com.kwad.components.ad.feed.widget;

import android.content.Context;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.components.core.widget.ComplianceTextView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class a extends com.kwad.components.core.widget.b<AdResultData, AdTemplate> {
    private boolean hO;
    protected long hP;
    private float hQ;
    private float hR;
    private int hS;
    private MotionEvent hT;
    protected SimpleImageLoadingListener hU;

    public a(@NonNull Context context) {
        super(context);
        this.hS = 0;
        this.hU = new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.feed.widget.a.1
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingComplete(String str, View view, DecodedResult decodedResult) {
                com.kwad.components.ad.feed.monitor.b.a(a.this.mAdTemplate, 1, 2, str, null, SystemClock.elapsedRealtime() - a.this.hP);
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingFailed(String str, View view, FailReason failReason) {
                com.kwad.components.ad.feed.monitor.b.a(a.this.mAdTemplate, 2, 2, str, failReason.toString(), SystemClock.elapsedRealtime() - a.this.hP);
            }
        };
    }

    public final void cp() {
        if (this.hO) {
            return;
        }
        this.hO = true;
        com.kwad.components.ad.feed.monitor.b.a(this.mAdTemplate, 1, getStayTime());
    }

    public final void cq() {
        ComplianceTextView complianceTextView = (ComplianceTextView) findViewById(R.id.ksad_compliance_view);
        if (!com.kwad.sdk.core.response.helper.a.aV(this.mAdInfo)) {
            complianceTextView.setVisibility(8);
        } else {
            complianceTextView.setVisibility(0);
            complianceTextView.setAdTemplate(this.mAdTemplate);
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.hQ = motionEvent.getX();
            this.hR = motionEvent.getY();
            this.hT = MotionEvent.obtain(motionEvent);
            this.hS = 0;
        }
        if (a(motionEvent)) {
            if (!com.kwad.sdk.utils.b.a(this.hT, motionEvent, this.mAdTemplate)) {
                return true;
            }
            if (action == 3 && this.hS == 0) {
                motionEvent.setAction(1);
                this.hS = 1;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    private boolean a(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 1 || !(action != 3 || motionEvent.getX() == 0.0f || motionEvent.getY() == 0.0f)) {
            return Math.abs(motionEvent.getX() - this.hQ) > 20.0f || Math.abs(motionEvent.getY() - this.hR) > 20.0f;
        }
        return false;
    }
}
