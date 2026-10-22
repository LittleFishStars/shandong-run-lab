package com.kwad.components.ad.reward;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.ad.reward.widget.RewardTaskStepView;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ac;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class h extends com.kwad.components.core.proxy.j {
    private static String tJ = "进阶奖励还差 %s 步到手，\n确认放弃吗？";
    private static String tK = "再观看%ss可获得基础奖励，\n确认放弃吗？";
    private AdTemplate mAdTemplate;
    private a tI;

    public interface a extends com.kwad.components.core.webview.tachikoma.f.c {
        void h(int i, int i2);

        void ht();
    }

    public static class b implements a {
        @Override // com.kwad.components.core.webview.tachikoma.f.c
        public void H(boolean z) {
        }

        @Override // com.kwad.components.ad.reward.h.a
        public void h(int i, int i2) {
        }

        @Override // com.kwad.components.core.webview.tachikoma.f.c
        public void hm() {
        }

        @Override // com.kwad.components.ad.reward.h.a
        public void ht() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.f.c
        public void hu() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.f.c
        public void hv() {
        }
    }

    public static c a(g gVar, @Nullable String str) {
        int i;
        AdTemplate adTemplate = gVar.mAdTemplate;
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        com.kwad.components.ad.reward.l.b.a aVar = gVar.ti;
        com.kwad.components.ad.reward.l.a.a aVar2 = gVar.tj;
        int i2 = gVar.tk;
        boolean zN = com.kwad.sdk.core.response.helper.e.n(adTemplate, com.kwad.components.ad.reward.a.b.l(com.kwad.sdk.core.response.helper.e.eO(adTemplate)));
        int i3 = 0;
        if (zN || com.kwad.sdk.core.response.helper.e.S(adTemplate)) {
            int iAg = (int) com.kwad.sdk.core.response.helper.a.ag(adInfoEO);
            int iN = com.kwad.sdk.core.response.helper.a.N(adInfoEO);
            if (iAg > iN) {
                iAg = iN;
            }
            long playDuration = gVar.sz.getPlayDuration();
            if (playDuration < (iAg * 1000) - 800 && (i = (int) (iAg - ((playDuration / 1000.0f) + 0.5f))) >= 0) {
                i3 = i;
            }
        }
        if (zN && aVar != null) {
            return c.a(aVar, adTemplate, String.valueOf(i3));
        }
        if (com.kwad.sdk.core.response.helper.e.S(adTemplate) && aVar2 != null) {
            return c.a(aVar2, adTemplate, String.valueOf(i3));
        }
        if (com.kwad.components.ad.reward.a.b.j(adInfoEO)) {
            return c.i(adInfoEO);
        }
        if (com.kwad.sdk.core.response.helper.a.cq(adInfoEO) == 1 && com.kwad.components.ad.reward.a.b.hV() == 1) {
            return c.a(adInfoEO, i2);
        }
        if (adTemplate.isNativeRewardPreview) {
            return c.h(str, i2);
        }
        if (com.kwad.sdk.core.response.helper.a.cY(adInfoEO)) {
            return c.c(adTemplate, i2);
        }
        if (com.kwad.sdk.core.response.helper.a.cN(adTemplate)) {
            return c.d(adTemplate, i2);
        }
        return com.kwad.components.ad.reward.a.b.hP() == 1 ? c.q(i2) : c.F(str);
    }

    private static View b(DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, AdTemplate adTemplate, a aVar) {
        return a(cVar.hz(), dialogFragment, layoutInflater, viewGroup, cVar, adTemplate, aVar);
    }

    private static View c(final DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, AdTemplate adTemplate, final a aVar) {
        View viewInflate = layoutInflater.inflate(R.layout.ksad_reward_order_dialog, viewGroup, false);
        KSImageLoader.loadImage((KSCornerImageView) viewInflate.findViewById(R.id.ksad_reward_order_dialog_icon), cVar.tT, adTemplate);
        ((TextView) viewInflate.findViewById(R.id.ksad_reward_order_dialog_desc)).setText(cVar.getTitle());
        viewInflate.findViewById(R.id.ksad_reward_order_dialog_btn_close).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialogFragment.dismiss();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.hv();
                }
            }
        });
        viewInflate.findViewById(R.id.ksad_reward_order_dialog_btn_view_detail).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.ht();
                }
            }
        });
        viewInflate.findViewById(R.id.ksad_reward_order_dialog_btn_deny).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialogFragment.dismiss();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.H(false);
                }
            }
        });
        return viewInflate;
    }

    private static SpannableString f(Context context, String str) {
        SpannableString spannableString = new SpannableString("再看" + str + "秒，即可获得奖励");
        int i = R.color.ksad_reward_main_color;
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(com.kwad.sdk.c.a.a.getColor(context, i));
        ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(com.kwad.sdk.c.a.a.getColor(context, i));
        StyleSpan styleSpan = new StyleSpan(1);
        int length = spannableString.length();
        spannableString.setSpan(foregroundColorSpan, 2, length - 7, 34);
        spannableString.setSpan(foregroundColorSpan2, length - 2, length, 34);
        spannableString.setSpan(styleSpan, 0, length, 34);
        return spannableString;
    }

    public static c g(String str, int i) {
        return c.h(str, i);
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public final void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        Window window = getDialog().getWindow();
        if (window == null) {
            return;
        }
        getDialog().setCanceledOnTouchOutside(false);
        window.setLayout(-1, -1);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        a aVar = this.tI;
        if (aVar != null) {
            aVar.hm();
        }
    }

    @KsJson
    public static class c extends com.kwad.sdk.core.response.a.a {
        public int style;
        public String tP;
        public String tQ;
        public String tR;
        public String tS;
        public String tT;
        public String tU;
        public String tV;
        public String tW;
        public com.kwad.components.ad.reward.l.b.a ti;
        public String title;
        public com.kwad.components.ad.reward.l.a.a tj;

        private c() {
        }

        public static c F(String str) {
            c cVar = new c();
            cVar.style = 0;
            cVar.title = str;
            cVar.tP = "关闭广告";
            cVar.tQ = "继续观看";
            return cVar;
        }

        public static c G(String str) {
            c cVar = new c();
            try {
                cVar.parseJson(new JSONObject(str));
            } catch (JSONException unused) {
            }
            return cVar;
        }

        private void H(String str) {
            this.tW = str;
        }

        public static c a(com.kwad.components.ad.reward.l.b.a aVar, AdTemplate adTemplate, String str) {
            c cVar = new c();
            cVar.style = 1;
            cVar.ti = aVar;
            cVar.tS = str;
            cVar.tT = com.kwad.sdk.core.response.helper.a.cv(com.kwad.sdk.core.response.helper.e.eO(adTemplate));
            return cVar;
        }

        public static c c(AdTemplate adTemplate, long j) {
            AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
            c cVar = new c();
            cVar.style = 8;
            cVar.tT = com.kwad.sdk.core.response.helper.a.cv(adInfoEO);
            cVar.title = String.format("再看%s秒，可获得奖励", Long.valueOf(j));
            cVar.tU = com.kwad.sdk.core.response.helper.a.cs(adInfoEO);
            cVar.tV = com.kwad.sdk.core.response.helper.a.aA(adInfoEO);
            cVar.tP = "放弃奖励";
            cVar.tQ = "继续观看";
            cVar.tR = com.kwad.sdk.core.response.helper.a.aK(com.kwad.sdk.core.response.helper.e.eO(adTemplate));
            return cVar;
        }

        public static c d(AdTemplate adTemplate, long j) {
            AdMatrixInfo.MerchantLiveReservationInfo merchantLiveReservationInfoDU = com.kwad.sdk.core.response.helper.b.dU(adTemplate);
            c cVar = new c();
            cVar.style = 8;
            cVar.tT = merchantLiveReservationInfoDU.userHeadUrl;
            cVar.title = String.format("再看%s秒，可获得奖励", Long.valueOf(j));
            cVar.tU = merchantLiveReservationInfoDU.title;
            cVar.tP = "放弃奖励";
            cVar.tQ = "继续观看";
            cVar.tR = com.kwad.sdk.core.response.helper.a.aK(com.kwad.sdk.core.response.helper.e.eO(adTemplate));
            return cVar;
        }

        public static c h(String str, int i) {
            c cVar = new c();
            cVar.style = 6;
            cVar.title = str;
            cVar.tP = "残忍离开";
            cVar.tQ = "留下看看";
            if (i > 0) {
                cVar.tW = String.valueOf(i);
            }
            return cVar;
        }

        public static c i(AdInfo adInfo) {
            c cVar = new c();
            cVar.style = 4;
            AdProductInfo adProductInfoDc = com.kwad.sdk.core.response.helper.a.dc(adInfo);
            cVar.title = com.kwad.sdk.core.response.helper.a.aA(adInfo);
            cVar.tT = adProductInfoDc.getIcon();
            return cVar;
        }

        public static c q(long j) {
            c cVar = new c();
            cVar.style = 6;
            cVar.tP = "残忍离开";
            cVar.tQ = "留下看看";
            if (j > 0) {
                cVar.H(String.valueOf(j));
            } else {
                cVar.H(null);
            }
            return cVar;
        }

        @Override // com.kwad.sdk.core.response.a.a
        public void afterParseJson(@Nullable JSONObject jSONObject) {
            super.afterParseJson(jSONObject);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("mLaunchAppTask");
            if (jSONObjectOptJSONObject != null) {
                if (this.ti == null) {
                    this.ti = new com.kwad.components.ad.reward.l.b.a();
                }
                this.ti.parseJson(jSONObjectOptJSONObject);
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("mLandPageOpenTask");
            if (jSONObjectOptJSONObject2 != null) {
                if (this.tj == null) {
                    this.tj = new com.kwad.components.ad.reward.l.a.a();
                }
                this.tj.parseJson(jSONObjectOptJSONObject2);
            }
        }

        @Override // com.kwad.sdk.core.response.a.a
        public void afterToJson(JSONObject jSONObject) {
            super.afterToJson(jSONObject);
            com.kwad.components.ad.reward.l.b.a aVar = this.ti;
            if (aVar != null) {
                ac.a(jSONObject, "mLaunchAppTask", aVar);
            }
            com.kwad.components.ad.reward.l.a.a aVar2 = this.tj;
            if (aVar2 != null) {
                ac.a(jSONObject, "mLandPageOpenTask", aVar2);
            }
        }

        public final int getStyle() {
            return this.style;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String hA() {
            return this.tT;
        }

        public final String hB() {
            return this.tU;
        }

        public final String hC() {
            return this.tV;
        }

        public final String hD() {
            return TextUtils.isEmpty(this.tW) ? "" : String.format("再看%s秒，可获得优惠", this.tW);
        }

        public final String hw() {
            return TextUtils.isEmpty(this.tP) ? "关闭广告" : this.tP;
        }

        public final String hx() {
            return TextUtils.isEmpty(this.tQ) ? "继续观看" : this.tQ;
        }

        public final com.kwad.components.ad.reward.l.b.a hy() {
            return this.ti;
        }

        public final com.kwad.components.ad.reward.l.a.a hz() {
            return this.tj;
        }

        public static c a(com.kwad.components.ad.reward.l.a.a aVar, AdTemplate adTemplate, String str) {
            c cVar = new c();
            cVar.style = 2;
            cVar.tj = aVar;
            cVar.tS = str;
            cVar.tT = com.kwad.sdk.core.response.helper.a.cv(com.kwad.sdk.core.response.helper.e.eO(adTemplate));
            return cVar;
        }

        public static c a(AdInfo adInfo, long j) {
            c cVar = new c();
            cVar.style = 5;
            AdProductInfo adProductInfoDc = com.kwad.sdk.core.response.helper.a.dc(adInfo);
            cVar.tU = com.kwad.sdk.core.response.helper.a.aA(adInfo);
            String name = adProductInfoDc.getName();
            cVar.title = name;
            if (TextUtils.isEmpty(name)) {
                cVar.title = com.kwad.sdk.core.response.helper.a.aD(adInfo);
            }
            cVar.tT = adProductInfoDc.getIcon();
            if (j > 0) {
                cVar.H(String.valueOf(j));
            } else {
                cVar.H(null);
            }
            return cVar;
        }
    }

    public static h a(Activity activity, AdTemplate adTemplate, c cVar, a aVar) {
        h hVar = new h();
        Bundle bundle = new Bundle();
        bundle.putString("key_params_json", cVar.toJson().toString());
        bundle.putString("key_template_json", adTemplate.toJson().toString());
        hVar.setArguments(bundle);
        hVar.a(aVar);
        hVar.show(activity.getFragmentManager(), "videoCloseDialog");
        return hVar;
    }

    private void a(a aVar) {
        this.tI = aVar;
    }

    @Override // com.kwad.components.core.proxy.j
    @Nullable
    public final View a(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        View viewA;
        Bundle arguments = getArguments();
        String string = arguments.getString("key_params_json");
        try {
            String string2 = arguments.getString("key_template_json");
            AdTemplate adTemplate = new AdTemplate();
            this.mAdTemplate = adTemplate;
            adTemplate.parseJson(new JSONObject(string2));
        } catch (Throwable unused) {
        }
        c cVarG = c.G(string);
        int style = cVarG.getStyle();
        if (style == 1) {
            viewA = a(this, layoutInflater, viewGroup, cVarG, this.mAdTemplate, this.tI);
        } else if (style == 2) {
            viewA = b(this, layoutInflater, viewGroup, cVarG, this.mAdTemplate, this.tI);
        } else if (style == 4) {
            viewA = c(this, layoutInflater, viewGroup, cVarG, this.mAdTemplate, this.tI);
            com.kwad.components.core.t.m.a(new com.kwad.components.core.widget.e(), (ViewGroup) viewA);
        } else if (style == 5) {
            com.kwad.components.ad.reward.n.j jVar = new com.kwad.components.ad.reward.n.j(this, this.mAdTemplate, layoutInflater, viewGroup, this.tI);
            jVar.a(cVarG);
            viewA = jVar.ib();
        } else if (style == 6) {
            viewA = a(this, layoutInflater, viewGroup, cVarG, this.tI);
        } else if (style != 8) {
            viewA = a((DialogFragment) this, layoutInflater, viewGroup, cVarG, this.tI);
        } else {
            com.kwad.components.ad.reward.n.m mVar = new com.kwad.components.ad.reward.n.m(this, this.mAdTemplate, layoutInflater, viewGroup, this.tI);
            mVar.a(cVarG);
            viewA = mVar.ib();
        }
        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.kwad.components.ad.reward.h.1
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return i == 4 && keyEvent.getAction() == 0;
            }
        });
        return viewA;
    }

    private static View a(final DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, final a aVar) {
        View viewInflate = layoutInflater.inflate(R.layout.ksad_video_close_dialog, viewGroup, false);
        ((TextView) viewInflate.findViewById(R.id.ksad_title)).setText(cVar.getTitle());
        TextView textView = (TextView) viewInflate.findViewById(R.id.ksad_close_btn);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.ksad_continue_btn);
        textView.setText(cVar.hw());
        textView2.setText(cVar.hx());
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialogFragment.dismiss();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.H(false);
                }
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialogFragment.dismiss();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.hv();
                }
            }
        });
        return viewInflate;
    }

    private View a(final h hVar, LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, c cVar, final a aVar) {
        View viewInflate = layoutInflater.inflate(R.layout.ksad_video_close_extend_dialog, viewGroup, false);
        ((TextView) viewInflate.findViewById(R.id.ksad_reward_close_extend_dialog_play_time_tips)).setText(f(viewInflate.getContext(), cVar.tW));
        TextView textView = (TextView) viewInflate.findViewById(R.id.ksad_reward_close_extend_dialog_btn_deny);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.ksad_reward_close_extend_dialog_btn_continue);
        textView.setText(cVar.hw());
        textView2.setText(cVar.hx());
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                hVar.dismiss();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.H(false);
                }
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                hVar.dismiss();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.hv();
                }
            }
        });
        return viewInflate;
    }

    private static View a(com.kwad.components.ad.reward.l.a aVar, final DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, AdTemplate adTemplate, final a aVar2) {
        String str;
        int i;
        View viewInflate = layoutInflater.inflate(R.layout.ksad_reward_task_launch_app_dialog, viewGroup, false);
        if (aVar instanceof com.kwad.components.ad.reward.l.b.a) {
            com.kwad.components.ad.reward.l.b.a.a((com.kwad.components.ad.reward.l.b.a) aVar, viewInflate.getContext(), adTemplate);
        }
        ((RewardTaskStepView) viewInflate.findViewById(R.id.ksad_reward_task_dialog_steps)).a(aVar.kW(), cVar.tS);
        KSImageLoader.loadAppIcon((ImageView) viewInflate.findViewById(R.id.ksad_reward_task_dialog_icon), cVar.hA(), adTemplate, 12);
        TextView textView = (TextView) viewInflate.findViewById(R.id.ksad_reward_task_dialog_abandon);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.ksad_reward_task_dialog_continue);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.ksad_reward_task_dialog_title);
        StringBuilder sb = new StringBuilder();
        sb.append(aVar.kX());
        String string = sb.toString();
        String str2 = cVar.tS;
        boolean zEquals = "0".equals(str2);
        if (zEquals) {
            str = String.format(tJ, string);
        } else {
            str = String.format(tK, str2);
        }
        int iIndexOf = zEquals ? str.indexOf(string) : str.indexOf(str2);
        if (iIndexOf < 0) {
            textView3.setText(str);
        } else {
            if (zEquals) {
                i = iIndexOf + 1;
            } else {
                i = str2.length() > 1 ? iIndexOf + 3 : iIndexOf + 2;
            }
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(viewInflate.getContext().getResources().getColor(R.color.ksad_reward_main_color));
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(foregroundColorSpan, iIndexOf, i, 17);
            textView3.setText(spannableString);
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialogFragment.dismiss();
                a aVar3 = aVar2;
                if (aVar3 != null) {
                    aVar3.H(false);
                }
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialogFragment.dismiss();
                a aVar3 = aVar2;
                if (aVar3 != null) {
                    aVar3.hv();
                }
            }
        });
        return viewInflate;
    }

    private static View a(DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, AdTemplate adTemplate, a aVar) {
        return a(cVar.hy(), dialogFragment, layoutInflater, viewGroup, cVar, adTemplate, aVar);
    }
}
