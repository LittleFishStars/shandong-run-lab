package com.kwad.components.ad.reward.n;

import android.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class j extends d implements View.OnClickListener {
    private DialogFragment DT;
    private TextView DU;
    private View DV;
    private View DW;
    private AdTemplate adTemplate;
    private TextView fM;
    private TextView kO;
    private KSCornerImageView ov;
    private TextView ow;
    private com.kwad.components.ad.reward.h.a tI;
    private ViewGroup wT;
    private View zK;

    public j(DialogFragment dialogFragment, AdTemplate adTemplate, LayoutInflater layoutInflater, ViewGroup viewGroup, com.kwad.components.ad.reward.h.a aVar) {
        this.DT = dialogFragment;
        this.adTemplate = adTemplate;
        this.tI = aVar;
        this.wT = (ViewGroup) layoutInflater.inflate(R.layout.ksad_reward_jinniu_dialog, viewGroup, false);
        initView();
    }

    private void initView() {
        this.ov = (KSCornerImageView) this.wT.findViewById(R.id.ksad_reward_jinniu_dialog_icon);
        this.kO = (TextView) this.wT.findViewById(R.id.ksad_reward_jinniu_dialog_title);
        this.fM = (TextView) this.wT.findViewById(R.id.ksad_reward_jinniu_dialog_desc);
        this.DU = (TextView) this.wT.findViewById(R.id.ksad_reward_jinniu_dialog_play_time_tips);
        this.ow = (TextView) this.wT.findViewById(R.id.ksad_reward_jinniu_dialog_detail);
        this.zK = this.wT.findViewById(R.id.ksad_reward_jinniu_dialog_btn_close);
        this.DV = this.wT.findViewById(R.id.ksad_reward_jinniu_dialog_btn_deny);
        this.DW = this.wT.findViewById(R.id.ksad_reward_jinniu_dialog_btn_continue);
        this.zK.setOnClickListener(this);
        this.DV.setOnClickListener(this);
        this.DW.setOnClickListener(this);
        this.ov.setOnClickListener(this);
        this.kO.setOnClickListener(this);
        this.fM.setOnClickListener(this);
        this.ow.setOnClickListener(this);
    }

    public final void a(com.kwad.components.ad.reward.h.c cVar) {
        KSImageLoader.loadAppIcon(this.ov, cVar.hA(), this.adTemplate, 4);
        this.kO.setText(cVar.getTitle());
        this.fM.setText(cVar.hB());
        this.DU.setText(cVar.hD());
        if (com.kwad.sdk.core.response.helper.a.cN(this.adTemplate)) {
            this.ow.setText(String.format("%s >", com.kwad.sdk.core.response.helper.a.aK(com.kwad.sdk.core.response.helper.e.eO(this.adTemplate))));
        }
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final ViewGroup ib() {
        return this.wT;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.kwad.components.ad.reward.h.a aVar;
        if (view.equals(this.zK)) {
            this.DT.dismiss();
            com.kwad.components.ad.reward.h.a aVar2 = this.tI;
            if (aVar2 != null) {
                aVar2.hv();
                return;
            }
            return;
        }
        if (view.equals(this.DV)) {
            this.DT.dismiss();
            com.kwad.components.ad.reward.h.a aVar3 = this.tI;
            if (aVar3 != null) {
                aVar3.H(false);
                return;
            }
            return;
        }
        if (view.equals(this.DW)) {
            this.DT.dismiss();
            com.kwad.components.ad.reward.h.a aVar4 = this.tI;
            if (aVar4 != null) {
                aVar4.hv();
                return;
            }
            return;
        }
        if (view.equals(this.ov)) {
            com.kwad.components.ad.reward.h.a aVar5 = this.tI;
            if (aVar5 != null) {
                aVar5.h(127, 2);
                return;
            }
            return;
        }
        if (view.equals(this.kO)) {
            com.kwad.components.ad.reward.h.a aVar6 = this.tI;
            if (aVar6 != null) {
                aVar6.h(128, 2);
                return;
            }
            return;
        }
        if (view.equals(this.fM)) {
            com.kwad.components.ad.reward.h.a aVar7 = this.tI;
            if (aVar7 != null) {
                aVar7.h(129, 2);
                return;
            }
            return;
        }
        if (!view.equals(this.ow) || (aVar = this.tI) == null) {
            return;
        }
        aVar.h(131, 2);
    }
}
