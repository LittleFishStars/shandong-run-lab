package com.kwad.components.ad.reward.n;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import com.kwad.components.ad.widget.KsAppTagsView;
import com.kwad.components.core.widget.KsConvertButton;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class h extends s implements View.OnClickListener {
    protected ImageView CW;

    @Nullable
    protected KsAppTagsView Da;
    protected KsConvertButton Dr;
    protected TextView Ds;

    @Nullable
    protected TextView Dt;

    @Nullable
    protected TextView Du;
    protected a Dv;

    @LayoutRes
    protected int Dw = R.layout.ksad_reward_apk_info_card_tag_item;
    protected boolean Dx = true;

    @Nullable
    protected KsLogoView mLogoView;

    public interface a {
        void jA();

        void jB();

        void jw();

        void jx();

        void jy();

        void jz();
    }

    private void as(int i) {
        KsConvertButton ksConvertButton = this.Dr;
        if (ksConvertButton == null) {
            return;
        }
        if (i == 1) {
            ksConvertButton.getCornerConf().setAllCorner(true);
        } else if (i == 2) {
            ksConvertButton.getCornerConf().cH(false).cK(false).cJ(true).cI(true);
        }
        this.Dr.postInvalidate();
    }

    private void i(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        this.mLogoView = (KsLogoView) viewGroup.findViewById(R.id.ksad_common_app_logo);
        this.CW = (ImageView) viewGroup.findViewById(R.id.ksad_common_app_icon);
        this.Ds = (TextView) viewGroup.findViewById(R.id.ksad_common_app_name);
        this.Da = (KsAppTagsView) viewGroup.findViewById(R.id.ksad_common_app_tags);
        this.Dt = (TextView) viewGroup.findViewById(R.id.ksad_common_app_desc);
        this.Du = (TextView) viewGroup.findViewById(R.id.ksad_common_app_desc2);
        this.Dr = (KsConvertButton) viewGroup.findViewById(R.id.ksad_common_app_action);
    }

    private static int lA() {
        return R.id.ksad_common_app_card_root;
    }

    public final void a(a aVar) {
        this.Dv = aVar;
    }

    public final void h(ViewGroup viewGroup) {
        super.a(viewGroup, jv(), lA());
        i(this.wT);
        ViewGroup viewGroup2 = this.wT;
        if (viewGroup2 != null) {
            viewGroup2.setOnClickListener(this);
            this.Dr.setOnClickListener(this);
            this.CW.setOnClickListener(this);
            this.Ds.setOnClickListener(this);
            TextView textView = this.Dt;
            if (textView != null) {
                textView.setOnClickListener(this);
            }
            TextView textView2 = this.Du;
            if (textView2 != null) {
                textView2.setOnClickListener(this);
            }
            KsAppTagsView ksAppTagsView = this.Da;
            if (ksAppTagsView != null) {
                ksAppTagsView.setOnClickListener(this);
            }
        }
    }

    public int jv() {
        return R.id.ksad_common_app_card_stub;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        if (view.equals(this.Dr)) {
            a aVar2 = this.Dv;
            if (aVar2 != null) {
                aVar2.jw();
                return;
            }
            return;
        }
        if (view.equals(this.CW)) {
            a aVar3 = this.Dv;
            if (aVar3 != null) {
                aVar3.jx();
                return;
            }
            return;
        }
        if (view.equals(this.Ds)) {
            a aVar4 = this.Dv;
            if (aVar4 != null) {
                aVar4.jy();
                return;
            }
            return;
        }
        if (view.equals(this.Dt) || view.equals(this.Du)) {
            a aVar5 = this.Dv;
            if (aVar5 != null) {
                aVar5.jz();
                return;
            }
            return;
        }
        if (view.equals(this.Da)) {
            a aVar6 = this.Dv;
            if (aVar6 != null) {
                aVar6.jA();
                return;
            }
            return;
        }
        if (!view.equals(this.wT) || (aVar = this.Dv) == null) {
            return;
        }
        aVar.jB();
    }

    public final void show() {
        ViewGroup viewGroup = this.wT;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final void a(r rVar) {
        super.a(rVar);
        a(com.kwad.components.ad.reward.model.a.a(rVar, this.Dx));
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0071  */
    /* JADX WARN: Code duplicated, block: B:34:0x0082  */
    /* JADX WARN: Code duplicated, block: B:38:0x008a  */
    private void a(com.kwad.components.ad.reward.model.a aVar) {
        TextView textView;
        int i;
        KsAppTagsView ksAppTagsView;
        KsConvertButton ksConvertButton;
        int i2;
        if (aVar == null) {
            return;
        }
        as(aVar.iy());
        KsLogoView ksLogoView = this.mLogoView;
        if (ksLogoView != null) {
            ksLogoView.bl(aVar.iu());
        }
        this.Ds.setText(aVar.getTitle());
        TextView textView2 = this.Dt;
        if (textView2 != null) {
            textView2.setText(aVar.hB());
        }
        TextView textView3 = this.Du;
        if (textView3 != null) {
            textView3.setText(aVar.hB());
            if (TextUtils.isEmpty(aVar.hB())) {
                i2 = 8;
                i = 8;
            } else if (aVar.ix()) {
                i = 0;
                i2 = 8;
            } else {
                i2 = 0;
                i = 8;
            }
            TextView textView4 = this.Dt;
            if (textView4 != null) {
                textView4.setVisibility(i2);
            }
            textView = this.Du;
        } else {
            textView = this.Dt;
            if (textView != null) {
                i = TextUtils.isEmpty(aVar.hB()) ? 8 : 0;
            }
            ksAppTagsView = this.Da;
            if (ksAppTagsView != null) {
                ksAppTagsView.a(aVar.iw(), this.Dw);
                this.Da.setVisibility(aVar.ix() ? 8 : 0);
            }
            ksConvertButton = this.Dr;
            if (ksConvertButton != null) {
                ksConvertButton.a(aVar.iv(), aVar.iu());
            }
            KSImageLoader.loadAppIcon(this.CW, aVar.hA(), aVar.iu(), 12);
        }
        textView.setVisibility(i);
        ksAppTagsView = this.Da;
        if (ksAppTagsView != null) {
            ksAppTagsView.a(aVar.iw(), this.Dw);
            this.Da.setVisibility(aVar.ix() ? 8 : 0);
        }
        ksConvertButton = this.Dr;
        if (ksConvertButton != null) {
            ksConvertButton.a(aVar.iv(), aVar.iu());
        }
        KSImageLoader.loadAppIcon(this.CW, aVar.hA(), aVar.iu(), 12);
    }
}
