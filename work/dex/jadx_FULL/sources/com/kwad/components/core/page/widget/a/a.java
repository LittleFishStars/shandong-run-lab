package com.kwad.components.core.page.widget.a;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.t.l;
import com.kwad.components.core.t.v;
import com.kwad.sdk.R;
import com.kwad.sdk.core.view.RoundCornerNewLayout;
import com.kwad.sdk.lib.ad.desigin.KSCoordinatorLayout;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a extends b {
    private c agl;
    private ColorDrawable agn;
    private l.a agp;
    private Handler agq;
    private h agr;
    private e agm = new e();
    private int ago = 4;
    private String ags = null;

    /* JADX INFO: Access modifiers changed from: private */
    public void by(int i) {
        View viewFindViewById;
        if (getView() == null || i < 0 || (viewFindViewById = getView().findViewById(R.id.ksad_half_bottom_container)) == null) {
            return;
        }
        viewFindViewById.setPadding(0, 0, 0, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(float f) {
        if (getView() != null) {
            FrameLayout frameLayout = (FrameLayout) getView().findViewById(R.id.ksad_half_container_content_fragment);
            if (frameLayout instanceof RoundCornerNewLayout) {
                ((RoundCornerNewLayout) frameLayout).setTopRadius(f < 1.0f ? com.kwad.sdk.c.a.a.a(getView().getContext(), this.agm.ahA) : 0);
            }
        }
    }

    private void uX() {
        if (getDialog() == null) {
            return;
        }
        e eVar = this.agm;
        if (eVar == null || eVar.ahF) {
            getDialog().getWindow().setSoftInputMode(18);
            this.agp = new l.a() { // from class: com.kwad.components.core.page.widget.a.a.1
                @Override // com.kwad.components.core.t.l.a
                public final void bz(int i) {
                    a.this.by(i);
                }

                @Override // com.kwad.components.core.t.l.a
                public final void vc() {
                    if (a.this.agq == null) {
                        a.this.agq = new Handler();
                    }
                    a.this.agq.postDelayed(new Runnable() { // from class: com.kwad.components.core.page.widget.a.a.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            a.this.by(0);
                        }
                    }, 20L);
                }
            };
            l.a(getDialog().getWindow(), this.agp);
        }
    }

    private void uY() {
        if (this.agm.ahD) {
            return;
        }
        v.c(getDialog().getWindow());
    }

    private void uZ() {
        if (this.agm.ahD) {
            getDialog().getWindow().clearFlags(2);
            getDialog().getWindow().setLayout(-1, -2);
        } else {
            v.d(getDialog().getWindow());
        }
        if (this.agm.ahC) {
            return;
        }
        Window window = getDialog().getWindow();
        e eVar = this.agm;
        getContext();
        window.setLayout(-1, (int) eVar.vn());
    }

    private void va() {
        if (getView() != null) {
            View viewFindViewById = getView().findViewById(R.id.ksad_container_coordinator_layout);
            viewFindViewById.setOnClickListener(new com.kwad.components.core.t.i() { // from class: com.kwad.components.core.page.widget.a.a.2
            });
            if (this.agm.ahC) {
                ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#80000000"));
                this.agn = colorDrawable;
                colorDrawable.setAlpha(0);
                viewFindViewById.setBackground(this.agn);
                FrameLayout frameLayout = (FrameLayout) getView().findViewById(R.id.ksad_half_container_content_fragment);
                if (frameLayout != null) {
                    frameLayout.setBackgroundColor(0);
                    if (this.agl == null) {
                        this.agl = new c();
                    }
                    this.agl.aW(true);
                    this.agl.k(0.8f);
                    c cVar = this.agl;
                    e eVar = this.agm;
                    getContext();
                    cVar.bD((int) eVar.vn());
                    ((KSCoordinatorLayout.LayoutParams) frameLayout.getLayoutParams()).setBehavior(this.agl);
                    this.agl.a(new c.a() { // from class: com.kwad.components.core.page.widget.a.a.3
                        @Override // com.kwad.components.core.page.widget.a.c.a
                        public final void bA(int i) {
                            if (i == 5) {
                                a.this.dismissAllowingStateLoss();
                            }
                            a aVar = a.this;
                            if (aVar.agD instanceof h) {
                                aVar.vb();
                            }
                            if (a.this.agr != null && i != 1) {
                                h unused = a.this.agr;
                            }
                            if (i != 1) {
                                a.this.ago = i;
                            }
                        }

                        @Override // com.kwad.components.core.page.widget.a.c.a
                        public final void i(float f) {
                            if (a.this.agr != null) {
                                h unused = a.this.agr;
                            }
                            a.this.h(f);
                        }
                    });
                }
            }
            h(0.0f);
            setCanceledOnTouchOutside(!this.agm.ahB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vb() {
        if (((h) this.agD).vo()) {
            return;
        }
        int i = this.ago;
        if (i == 3 || i == 4) {
            this.agl.setState(i);
        }
    }

    @Override // com.kwad.components.core.proxy.j, android.app.DialogFragment
    public final void dismiss() {
        if (this.agp != null && getDialog() != null && getDialog().getWindow() != null) {
            l.b(getDialog().getWindow(), this.agp);
            this.agp = null;
        }
        dismissAllowingStateLoss();
    }

    @Override // com.kwad.components.core.page.widget.a.b
    public final int getLayoutId() {
        return R.layout.ksad_half_bottom_dialog_fragment;
    }

    @Override // com.kwad.components.core.page.widget.a.b, android.app.DialogFragment, android.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        uY();
        super.onActivityCreated(bundle);
        uZ();
        va();
        uX();
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public final void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            Parcelable parcelable = getArguments().getParcelable("containerParams");
            if (parcelable instanceof e) {
                this.agm = (e) parcelable;
            }
            this.agl = this.agm.ahG;
        }
        j(this.agm.ahz);
        Map<String, String> map = this.agm.ahH;
        if (map != null) {
            this.ags = map.get("merchantLaunchToken");
        }
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        Handler handler = this.agq;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.agq = null;
        }
        super.onDestroy();
    }

    @Override // android.app.Fragment
    public final void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    @Override // com.kwad.components.core.page.widget.a.b
    public final int uW() {
        return R.style.ksad_Theme_Dialog_Popup_ContainerTransparent;
    }

    public static a a(e eVar) {
        a aVar = new a();
        Bundle bundle = new Bundle();
        bundle.putParcelable("containerParams", eVar);
        aVar.setArguments(bundle);
        return aVar;
    }
}
