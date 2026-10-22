package com.kwad.components.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.wrapper.m;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class KsAutoCloseView extends LinearLayout implements View.OnClickListener {
    private static String Fz = "%s秒后自动关闭";
    private TextView awl;
    private ImageView awm;
    private a awn;
    private boolean awo;
    private boolean awp;
    private int countDown;

    public interface a {
        void en();

        void eo();
    }

    public KsAutoCloseView(Context context) {
        super(context);
        this.countDown = 10;
        this.awo = true;
        this.awp = false;
        A(context);
    }

    private void A(Context context) {
        m.inflate(context, R.layout.ksad_auto_close, this);
        this.awl = (TextView) findViewById(R.id.ksad_auto_close_text);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_auto_close_btn);
        this.awm = imageView;
        imageView.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(int i) {
        this.awl.setText(String.format(Fz, Integer.valueOf(i)));
    }

    public static /* synthetic */ int e(KsAutoCloseView ksAutoCloseView) {
        int i = ksAutoCloseView.countDown;
        ksAutoCloseView.countDown = i - 1;
        return i;
    }

    public final void au(int i) {
        if (i <= 0) {
            return;
        }
        this.countDown = i;
        post(new bi() { // from class: com.kwad.components.core.widget.KsAutoCloseView.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                if (KsAutoCloseView.this.awo) {
                    if (KsAutoCloseView.this.awp) {
                        KsAutoCloseView.this.postDelayed(this, 1000L);
                        return;
                    }
                    if (KsAutoCloseView.this.countDown == 0) {
                        if (KsAutoCloseView.this.awn != null) {
                            KsAutoCloseView.this.awn.en();
                        }
                    } else {
                        KsAutoCloseView ksAutoCloseView = KsAutoCloseView.this;
                        ksAutoCloseView.R(ksAutoCloseView.countDown);
                        KsAutoCloseView.e(KsAutoCloseView.this);
                        KsAutoCloseView.this.postDelayed(this, 1000L);
                    }
                }
            }
        });
    }

    public final void bq(boolean z) {
        this.awo = z;
        int i = z ? 0 : 8;
        TextView textView = this.awl;
        if (textView != null) {
            textView.setVisibility(i);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.awn != null && view.equals(this.awm)) {
            this.awn.eo();
        }
    }

    public void setCountDownPaused(boolean z) {
        this.awp = z;
    }

    public void setViewListener(a aVar) {
        this.awn = aVar;
    }

    public KsAutoCloseView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.countDown = 10;
        this.awo = true;
        this.awp = false;
        A(context);
    }

    public KsAutoCloseView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.countDown = 10;
        this.awo = true;
        this.awp = false;
        A(context);
    }

    @RequiresApi(api = 21)
    public KsAutoCloseView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.countDown = 10;
        this.awo = true;
        this.awp = false;
        A(context);
    }
}
