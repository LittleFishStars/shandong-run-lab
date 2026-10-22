package com.kwad.components.core.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a implements View.OnClickListener {

    @Nullable
    private TextView OY;

    @Nullable
    private ImageView OZ;

    @Nullable
    private ImageView Pa;

    @Nullable
    private InterfaceC1190a Pb;
    private ViewGroup wT;

    /* JADX INFO: renamed from: com.kwad.components.core.b.a$a, reason: collision with other inner class name */
    public interface InterfaceC1190a {
        void w(View view);

        void x(View view);
    }

    public a(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(R.id.ksad_kwad_web_title_bar);
        this.wT = viewGroup2;
        if (viewGroup2 == null) {
            return;
        }
        initView();
    }

    private void initView() {
        this.OY = (TextView) this.wT.findViewById(R.id.ksad_kwad_titlebar_title);
        this.OZ = (ImageView) this.wT.findViewById(R.id.ksad_kwad_web_navi_back);
        ImageView imageView = (ImageView) this.wT.findViewById(R.id.ksad_kwad_web_navi_close);
        this.Pa = imageView;
        imageView.setOnClickListener(this);
        this.OZ.setOnClickListener(this);
    }

    public final void a(@Nullable InterfaceC1190a interfaceC1190a) {
        this.Pb = interfaceC1190a;
    }

    @MainThread
    public final void ak(boolean z) {
        ImageView imageView = this.Pa;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    @MainThread
    public final void al(boolean z) {
        ImageView imageView = this.OZ;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    public final ViewGroup ib() {
        return this.wT;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.Pb == null) {
            return;
        }
        if (view.equals(this.Pa)) {
            this.Pb.x(view);
        } else if (view.equals(this.OZ)) {
            this.Pb.w(view);
        }
    }

    public final void a(b bVar) {
        TextView textView;
        com.kwad.sdk.core.d.c.d("KsTitleBarHelper", "bindView call model: " + bVar.toString());
        if (this.wT == null || (textView = this.OY) == null) {
            return;
        }
        textView.setText(bVar.getTitle());
        int iOG = bVar.oG();
        if (iOG >= 0) {
            this.OY.setTextColor(iOG);
        }
        int iOH = bVar.oH();
        if (iOH >= 0) {
            this.OY.setBackgroundColor(iOH);
        }
    }
}
