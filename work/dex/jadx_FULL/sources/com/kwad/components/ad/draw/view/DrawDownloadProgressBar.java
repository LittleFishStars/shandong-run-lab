package com.kwad.components.ad.draw.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.sdk.R;
import com.kwad.sdk.wrapper.m;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class DrawDownloadProgressBar extends FrameLayout {
    private TextProgressBar gl;
    private View gm;
    private Context mContext;

    public DrawDownloadProgressBar(@NonNull Context context) {
        super(context);
        B(context);
    }

    private void B(Context context) {
        this.mContext = context;
        m.inflate(context, R.layout.ksad_draw_download_bar, this);
        this.gl = (TextProgressBar) findViewById(R.id.ksad_download_progress);
        View viewFindViewById = findViewById(R.id.ksad_download_progress_cover);
        this.gm = viewFindViewById;
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.draw.view.DrawDownloadProgressBar.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DrawDownloadProgressBar.this.performClick();
            }
        });
    }

    public final void e(String str, int i) {
        if (i == 0 || i == getMax()) {
            this.gm.setVisibility(0);
        } else {
            this.gm.setVisibility(8);
        }
        this.gl.e(str, i);
    }

    public int getMax() {
        return this.gl.getMax();
    }

    public void setTextColor(int i) {
        this.gl.setTextColor(i);
    }

    public void setTextSize(int i) {
        this.gl.setTextDimen(com.kwad.sdk.c.a.a.a(getContext(), i));
    }

    public DrawDownloadProgressBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        B(context);
    }

    public DrawDownloadProgressBar(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        B(context);
    }
}
