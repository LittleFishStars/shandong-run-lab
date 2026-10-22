package com.kc.dw.platform.ad_adapter;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.alibaba.android.arouter.utils.Consts;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.kc.dw.activity.SsdRewardH5Activity;
import com.kc.dw.activity.SsdRewardVideoPlayerActivity;
import com.kc.dw.ad.a0;
import com.kc.dw.ad.nativ.i;
import com.kc.dw.core.ad.AdSlot;
import com.kc.dw.core.ad.AdType;
import com.kc.dw.core.ad.BaseAdSlot;
import com.kc.dw.core.ad.fullscreenvideo.IFullScreenMediaListener;
import com.kc.dw.core.ad.fullscreenvideo.IFullScreenVideoAd;
import com.kc.dw.core.ad.reward.RewardAdMediaListener;
import com.kc.dw.core.ad.reward.RewardInteractionListener;
import com.kc.dw.core.ad.reward.RewardVideoAd;
import com.kc.dw.core.loader.InteractionListener;
import com.kc.dw.core.safe.SafeBroadcastReceiver;
import com.kc.dw.core.utils.DownloadDialogBean;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.ResultBean;
import com.kc.dw.core.utils.b1;
import com.kc.dw.core.utils.g0;
import com.kc.dw.core.utils.j;
import com.kc.dw.core.utils.p0;
import com.kc.dw.core.utils.s1;
import com.kc.dw.core.utils.t0;
import com.kc.dw.core.utils.z;
import com.kc.dw.platform.ad_adapter.splash.ShakeResult;
import com.kc.dw.platform.ad_adapter.splash.ShakeUtil;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class a extends com.kc.dw.core.ad.a implements RewardVideoAd, IFullScreenVideoAd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f39450a;
    public h b;
    public InteractionListener c;
    public RewardAdMediaListener d;
    public i e;
    public com.kc.dw.platform.ad_adapter.reward.a f;
    public boolean g;
    public boolean h;
    public long i;
    public long j;
    public long k;
    public volatile boolean l;
    public BroadcastReceiver m;
    public volatile boolean n;
    public IFullScreenMediaListener o;

    /* JADX INFO: renamed from: com.kc.dw.platform.ad_adapter.a$a, reason: collision with other inner class name */
    @Keep
    public class C1066a extends SafeBroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f39451a;

        public C1066a(a aVar) {
            this.f39451a = aVar;
        }

        /* JADX WARN: Code duplicated, block: B:85:0x0232 A[Catch: all -> 0x0238, TRY_LEAVE, TryCatch #1 {all -> 0x0238, blocks: (B:79:0x021a, B:81:0x0220, B:83:0x0228, B:85:0x0232), top: B:116:0x021a }] */
        @Override // com.kc.dw.core.safe.SafeBroadcastReceiver
        public void a(Context context, Intent intent) {
            InteractionListener interactionListener;
            if ("broadcast_onclick".equalsIgnoreCase(intent.getAction())) {
                boolean zHasExtra = intent.hasExtra("is_reward_tmp_click");
                if (this.f39451a.f39450a.a() instanceof BaseAdSlot) {
                    ((BaseAdSlot) this.f39451a.f39450a.a()).setRewardTmpClick(zHasExtra);
                }
                int intExtra = intent.hasExtra("clk_power") ? intent.getIntExtra("clk_power", 0) : 0;
                if (intent.hasExtra("clk_act_type")) {
                    int intExtra2 = intent.getIntExtra("clk_act_type", 2);
                    if (this.f39451a.f39450a.a() instanceof BaseAdSlot) {
                        ((BaseAdSlot) this.f39451a.f39450a.a()).setClkActType(intExtra2);
                        if (intExtra >= 0) {
                            ((BaseAdSlot) this.f39451a.f39450a.a()).setClkPower(intExtra);
                        }
                    }
                }
                if (intent.hasExtra("shake_result")) {
                    try {
                        ((BaseAdSlot) this.f39451a.f39450a.a()).setShakeResult((ShakeResult) intent.getSerializableExtra("shake_result"));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                int intExtra3 = intent.hasExtra("click_reward_tmp_id") ? intent.getIntExtra("click_reward_tmp_id", 0) : 0;
                try {
                    DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                    String[] clickUrl = this.f39451a.f39450a.a().getClickUrl();
                    for (int i = 0; i < clickUrl.length; i++) {
                        String strA = g0.a(clickUrl[i], displayMetrics.widthPixels, displayMetrics.heightPixels);
                        clickUrl[i] = strA;
                        clickUrl[i] = g0.a(strA, intExtra3);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                i iVar = this.f39451a.e;
                if (iVar != null && iVar.getCbc() == 0 && (interactionListener = this.f39451a.c) != null) {
                    interactionListener.onAdClicked();
                }
                try {
                    g0.c(this.f39451a.f39450a.a().getWx_start(), intExtra3);
                    g0.c(this.f39451a.f39450a.a().getWx_succ(), intExtra3);
                    g0.c(this.f39451a.f39450a.a().getWx_fail(), intExtra3);
                    g0.c(this.f39451a.f39450a.a().getDp_start(), intExtra3);
                    g0.c(this.f39451a.f39450a.a().getDp_succ(), intExtra3);
                    g0.c(this.f39451a.f39450a.a().getDp_fail(), intExtra3);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
                com.kc.dw.core.utils.f.a(this.f39451a.f39450a, intExtra == 0 || intExtra >= 50);
                return;
            }
            if ("broadcast_onreward".equalsIgnoreCase(intent.getAction())) {
                InteractionListener interactionListener2 = this.f39451a.c;
                if (interactionListener2 instanceof RewardInteractionListener) {
                    ((RewardInteractionListener) interactionListener2).onReward(null);
                    return;
                }
                return;
            }
            if ("broadcast_onclosed".equalsIgnoreCase(intent.getAction())) {
                a aVar = this.f39451a;
                if (aVar.l) {
                    LocalBroadcastManager.getInstance(aVar.b.getContext()).unregisterReceiver(aVar.m);
                    LogUtil.d("RewardVideoAdAdapter", "onVideoActivityClosed: 激励视频广告回收资源");
                }
                InteractionListener interactionListener3 = aVar.c;
                if (interactionListener3 != null) {
                    interactionListener3.onAdClosed();
                    return;
                }
                return;
            }
            if ("broadcast_on_video_complete".equalsIgnoreCase(intent.getAction())) {
                RewardAdMediaListener rewardAdMediaListener = this.f39451a.d;
                if (rewardAdMediaListener != null) {
                    rewardAdMediaListener.onVideoCompleted();
                }
                IFullScreenMediaListener iFullScreenMediaListener = this.f39451a.o;
                if (iFullScreenMediaListener != null) {
                    iFullScreenMediaListener.onVideoCompleted();
                    return;
                }
                return;
            }
            if (!"broadcast_on_video_start".equalsIgnoreCase(intent.getAction())) {
                if ("broadcast_on_video_pause".equalsIgnoreCase(intent.getAction())) {
                    RewardAdMediaListener rewardAdMediaListener2 = this.f39451a.d;
                    if (rewardAdMediaListener2 != null) {
                        rewardAdMediaListener2.onVideoPause();
                        return;
                    }
                    return;
                }
                if ("broadcast_on_video_resume".equalsIgnoreCase(intent.getAction())) {
                    RewardAdMediaListener rewardAdMediaListener3 = this.f39451a.d;
                    if (rewardAdMediaListener3 != null) {
                        rewardAdMediaListener3.onVideoResume();
                        return;
                    }
                    return;
                }
                if ("broadcast_on_video_error".equalsIgnoreCase(intent.getAction())) {
                    this.f39451a.j = System.currentTimeMillis();
                    RewardAdMediaListener rewardAdMediaListener4 = this.f39451a.d;
                    if (rewardAdMediaListener4 != null) {
                        rewardAdMediaListener4.onVideoError();
                    }
                    com.kc.dw.platform.ad_adapter.reward.a aVar2 = this.f39451a.f;
                    if (aVar2 != null) {
                        aVar2.onAdRenderFail("激励视频渲染失败", com.kc.dw.core.exception.b.c.intValue());
                    }
                    if (this.f39451a.l) {
                        LocalBroadcastManager.getInstance(context).unregisterReceiver(this.f39451a.m);
                        LogUtil.d("RewardVideoAdAdapter", "onVideoActivityClosed: 激励视频广告回收资源");
                        return;
                    }
                    return;
                }
                return;
            }
            this.f39451a.k = System.currentTimeMillis();
            boolean zHasExtra2 = intent.hasExtra("report_exposure");
            i iVar2 = this.f39451a.e;
            iVar2.setMonitorUrl(g0.b(iVar2.getMonitorUrl(), this.f39451a.i + Consts.DOT + this.f39451a.j + Consts.DOT + this.f39451a.k));
            RewardAdMediaListener rewardAdMediaListener5 = this.f39451a.d;
            if (rewardAdMediaListener5 != null) {
                rewardAdMediaListener5.onVideoStart();
            }
            if (zHasExtra2) {
                a.a(this.f39451a);
            } else {
                try {
                    a aVar3 = this.f39451a;
                    if (aVar3.h || (aVar3.e.getAdPatternType() != 2 && this.f39451a.e.getImageUrls() != null)) {
                        a.a(this.f39451a);
                    }
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
            }
            InteractionListener interactionListener4 = this.f39451a.c;
            if (interactionListener4 != null) {
                interactionListener4.onAdExposure();
            }
        }
    }

    public a(h hVar, c cVar, i iVar, com.kc.dw.platform.ad_adapter.reward.a aVar) {
        super(null, "SSD");
        this.h = false;
        this.m = new C1066a(this);
        this.b = hVar;
        this.f39450a = cVar;
        this.e = iVar;
        this.f = aVar;
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [com.kc.dw.core.loader.a] */
    public static void a(a aVar) {
        aVar.getClass();
        try {
            if (com.kc.dw.core.utils.a.a((AdSlot) aVar.e)) {
                LogUtil.dev("RewardVideoAdAdapter", "has exp. return");
                return;
            }
            if (aVar.n) {
                return;
            }
            aVar.n = true;
            i iVar = aVar.e;
            if (iVar != null) {
                iVar.setHasExposed(true);
            }
            t0.a(aVar.b.getAdLoader().getPosId(), 3);
            String[] strArrB = g0.b(aVar.b.f39477a.getMonitorUrl(), aVar.i + Consts.DOT + aVar.j + Consts.DOT + aVar.k);
            g0.a(strArrB);
            if (strArrB != null) {
                LogUtil.d("RewardVideoAdAdapter", "send onAdExposure");
                for (String str : strArrB) {
                    if (!TextUtils.isEmpty(str)) {
                        h hVar = aVar.b;
                        z.a(aVar.b.getContext(), g0.a(g0.a(str, ((i) hVar.f39477a).getAct_type(), hVar instanceof com.kc.dw.platform.ad_adapter.reward.c ? AdType.REWARD : AdType.FULL_SCREEN_VIDEO)), new j());
                    }
                }
            }
            aVar.n = true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void a(Context context) {
        try {
            this.l = true;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("broadcast_onclick");
            intentFilter.addAction("broadcast_onreward");
            intentFilter.addAction("broadcast_onclosed");
            intentFilter.addAction("broadcast_on_video_complete");
            LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(context);
            intentFilter.addAction("broadcast_on_video_start");
            intentFilter.addAction("broadcast_on_video_pause");
            intentFilter.addAction("broadcast_on_video_resume");
            intentFilter.addAction("broadcast_on_video_error");
            localBroadcastManager.registerReceiver(this.m, intentFilter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:148:0x02d1  */
    /* JADX WARN: Code duplicated, block: B:156:0x02e7  */
    /* JADX WARN: Code duplicated, block: B:159:0x02eb  */
    /* JADX WARN: Code duplicated, block: B:187:0x02d5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:191:0x02b3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public final void b(Context context) {
        boolean zIsValid;
        boolean z;
        boolean z2;
        boolean z3;
        if (this.g) {
            LogUtil.d("RewardVideoAdAdapter", "同一个激励视频只能展示一次");
            com.kc.dw.platform.ad_adapter.reward.a aVar = this.f;
            if (aVar != null) {
                aVar.onAdRenderFail("同一个激励视频只能展示一次", com.kc.dw.core.exception.b.c.intValue());
                return;
            }
            return;
        }
        this.i = System.currentTimeMillis();
        this.b.f39477a.hashCode();
        c cVar = this.f39450a;
        a0 a0Var = cVar instanceof com.kc.dw.ad.nativ.g ? ((com.kc.dw.ad.nativ.g) cVar).g : null;
        if (a0Var != null) {
            T t = this.b.f39477a;
            if (t instanceof i) {
                if (((i) t).getImageUrls() == null || ((i) this.b.f39477a).getImageUrls().length == 0) {
                    com.kc.dw.platform.ad_adapter.reward.a aVar2 = this.f;
                    if (aVar2 != null) {
                        aVar2.onAdRenderFail("视频地址无效", com.kc.dw.core.exception.b.c.intValue());
                    }
                    LogUtil.e("RewardVideoAdAdapter", "视频地址无效");
                    return;
                }
                h hVar = this.b;
                if (hVar instanceof com.kc.dw.platform.ad_adapter.reward.c) {
                    s1.b(((i) hVar.f39477a).getEventUrl());
                }
                boolean z4 = true;
                this.g = true;
                try {
                    zIsValid = SsdRewardH5Activity.isValid(this.e.getReq_id());
                } catch (Exception unused) {
                    zIsValid = false;
                }
                if (zIsValid) {
                    h hVar2 = this.b;
                    if (hVar2 instanceof com.kc.dw.platform.ad_adapter.reward.c) {
                        this.h = true;
                        com.kc.dw.core.service.logrecord.a.a(5, "e7", hVar2);
                        a(context);
                        Intent intent = new Intent();
                        intent.setClass(context, SsdRewardH5Activity.class);
                        intent.setFlags(TTAdConstant.KEY_CLICK_AREA);
                        if (!(context instanceof Activity)) {
                            intent.addFlags(268435456);
                        }
                        context.startActivity(intent);
                        return;
                    }
                }
                i iVar = (i) this.b.f39477a;
                int i = context.getResources().getConfiguration().orientation;
                Intent intent2 = new Intent();
                intent2.setClass(context, SsdRewardVideoPlayerActivity.class);
                intent2.setFlags(TTAdConstant.KEY_CLICK_AREA);
                intent2.putExtra("orientation_key", i);
                intent2.putExtra("local_ad_id_key", this.b.f39477a.hashCode() + "");
                ShakeUtil.getInstance().a(iVar.getPosId(), iVar.getLoadedTime(), iVar.getDclk());
                if (iVar.getAdPatternType() != 2 && iVar.getImageUrls() != null) {
                    intent2.putExtra("Image_src", iVar.getImageUrls()[0]);
                }
                String[] strArr = iVar.j;
                if (strArr != null) {
                    intent2.putExtra("Video_start_key", strArr);
                }
                String[] strArr2 = iVar.k;
                if (strArr2 != null) {
                    intent2.putExtra("Video_one_quarter_key", strArr2);
                }
                String[] strArr3 = iVar.l;
                if (strArr3 != null) {
                    intent2.putExtra("Video_one_half_key", strArr3);
                }
                String[] strArr4 = iVar.m;
                if (strArr4 != null) {
                    intent2.putExtra("Video_three_quarter_key", strArr4);
                }
                String[] strArr5 = iVar.n;
                if (strArr5 != null) {
                    intent2.putExtra("Video_complete_key", strArr5);
                }
                String[] strArr6 = iVar.o;
                if (strArr6 != null) {
                    intent2.putExtra("Video_pause_key", strArr6);
                }
                String[] strArr7 = iVar.p;
                if (strArr7 != null) {
                    intent2.putExtra("Video_resume_key", strArr7);
                }
                String[] strArr8 = iVar.q;
                if (strArr8 != null) {
                    intent2.putExtra("Video_mute_key", strArr8);
                }
                String[] strArr9 = iVar.r;
                if (strArr9 != null) {
                    intent2.putExtra("Video_unmute_key", strArr9);
                }
                if (iVar.getVideo_cover() != null) {
                    intent2.putExtra("Video_cover", iVar.getVideo_cover());
                }
                String str = iVar.h;
                if (str != null) {
                    intent2.putExtra("Video_endcover", str);
                }
                long j = iVar.i;
                if (j != 0) {
                    intent2.putExtra("Video_keep_time", j);
                }
                if (!TextUtils.isEmpty(iVar.title)) {
                    intent2.putExtra("Ad_title", iVar.title);
                }
                if (!TextUtils.isEmpty(iVar.desc)) {
                    intent2.putExtra("Ad_content", iVar.desc);
                }
                if (!TextUtils.isEmpty(iVar.getFromLogo())) {
                    intent2.putExtra("From_logo", iVar.getFromLogo());
                }
                String str2 = iVar.iconUrl;
                if (str2 != null) {
                    intent2.putExtra("Ad_icon_url", str2);
                }
                if (iVar.getEventUrl() != null) {
                    intent2.putExtra("event_url", iVar.getEventUrl());
                }
                String str3 = iVar.d;
                if (TextUtils.isEmpty(str3)) {
                    str3 = iVar.getInteractionType() == 0 ? "查看详情" : "点击下载";
                }
                intent2.putExtra("Action_text", str3);
                intent2.putExtra("Clickable_range", iVar.v);
                intent2.putExtra("Close_btn", iVar.w);
                intent2.putExtra("clk_type", iVar.getAct_type());
                intent2.putExtra("power_index", iVar.getPower_index());
                intent2.putExtra("Power_index2", iVar.getPower_index2());
                intent2.putExtra("power_count", iVar.getPower_count());
                intent2.putExtra("power_delay", iVar.getPower_delay());
                intent2.putExtra("Interaction_type", iVar.getInteractionType());
                h hVar3 = this.b;
                if (hVar3 instanceof com.kc.dw.platform.ad_adapter.reward.c) {
                    intent2.putExtra("Ad_type", AdType.REWARD.value());
                    List<String> list = p0.r;
                    if ((list == null || list.isEmpty()) ? false : true) {
                        if (!TextUtils.isEmpty(iVar.getReward_tmp_url()) && iVar.getRewardTmpId() > 0 && iVar.getReward_tmp_type() > 0) {
                            b1.f39353a = iVar;
                            try {
                                z = (TextUtils.isEmpty(iVar.title) && TextUtils.isEmpty(b1.f39353a.getDesc()) && TextUtils.isEmpty(b1.f39353a.getIcon())) ? false : true;
                            } catch (Exception unused2) {
                            }
                            if (!z) {
                                z4 = false;
                            } else if (!b1.b(context)) {
                                if (b1.a(context)) {
                                    BaseAdSlot baseAdSlot = b1.f39353a;
                                    if (!((baseAdSlot == null || TextUtils.isEmpty(baseAdSlot.getDeep_link())) ? false : true)) {
                                        if (b1.f39353a.getInteractionType() == 1) {
                                            z2 = false;
                                        } else {
                                            z2 = false;
                                        }
                                        if (!z2) {
                                            if (b1.f39353a.getInteractionType() != 1) {
                                                z3 = false;
                                            } else {
                                                z3 = false;
                                            }
                                            if (!z3) {
                                                z4 = false;
                                            }
                                        }
                                    }
                                } else {
                                    try {
                                        if (b1.f39353a.getInteractionType() == 1 || b1.f39353a.getDirect_market() != 1 || TextUtils.isEmpty(b1.f39353a.getPackageName())) {
                                            z2 = false;
                                        } else {
                                            z2 = true;
                                        }
                                    } catch (Exception unused3) {
                                    }
                                    if (!z2) {
                                        try {
                                            if (b1.f39353a.getInteractionType() != 1 || b1.f39353a.getdUrl() == null) {
                                                z3 = false;
                                            } else {
                                                z3 = true;
                                            }
                                        } catch (Exception unused4) {
                                        }
                                        if (!z3) {
                                            z4 = false;
                                        }
                                    }
                                }
                            }
                        } else {
                            z4 = false;
                        }
                    } else {
                        z4 = false;
                    }
                    intent2.putExtra(SsdRewardVideoPlayerActivity.Is_showWebDialog, z4);
                } else if (hVar3 instanceof com.kc.dw.platform.ad_adapter.fullscreenvideo.a) {
                    intent2.putExtra("Ad_type", AdType.FULL_SCREEN_VIDEO.value());
                }
                intent2.putExtra("reward_tmp_url", iVar.getReward_tmp_url());
                intent2.putExtra("reward_tmp_type", iVar.getReward_tmp_type());
                intent2.putExtra("reward_tmp_time", iVar.getReward_tmp_time());
                intent2.putExtra("reward_tmp_id", iVar.getRewardTmpId());
                c cVar2 = this.f39450a;
                if (cVar2 instanceof com.kc.dw.ad.nativ.g) {
                    SsdRewardVideoPlayerActivity.setVideoMute(((com.kc.dw.ad.nativ.g) cVar2).j);
                }
                SsdRewardVideoPlayerActivity.setFullScreenAd(this.f39450a);
                DownloadDialogBean downloadDialogBean = new DownloadDialogBean();
                downloadDialogBean.setApp_name(iVar.getAppName());
                downloadDialogBean.setApp_feature(iVar.getApp_feature());
                downloadDialogBean.setApp_intro(iVar.getApp_intro());
                downloadDialogBean.setApp_privacy(iVar.getApp_privacy());
                downloadDialogBean.setApp_size(iVar.getApp_size());
                downloadDialogBean.setDeveloper(iVar.getDeveloper());
                downloadDialogBean.setPayment_types(iVar.getPayment_types());
                downloadDialogBean.setApp_permission(iVar.getApp_permission());
                downloadDialogBean.setApp_permission_url(iVar.getApp_permission_url());
                downloadDialogBean.setApp_intor_url(iVar.getApp_intor_url());
                downloadDialogBean.setApp_private_agreement(iVar.getPrivacy_agreement());
                SsdRewardVideoPlayerActivity.setDownloadDialogBean(downloadDialogBean);
                SsdRewardVideoPlayerActivity.setAdWrapper(this.b);
                a(context);
                if (!(context instanceof Activity)) {
                    intent2.addFlags(268435456);
                }
                SsdRewardVideoPlayerActivity.setMediaView(a0Var);
                context.startActivity(intent2);
                return;
            }
        }
        com.kc.dw.platform.ad_adapter.reward.a aVar3 = this.f;
        if (aVar3 != null) {
            aVar3.onAdRenderFail("视频加载失败", com.kc.dw.core.exception.b.c.intValue());
        }
        LogUtil.e("RewardVideoAdAdapter", "showAd: 请先加载视频");
    }

    @Override // com.kc.dw.core.ad.reward.RewardVideoAd
    public void destroy() {
        SsdRewardVideoPlayerActivity.clearRewardMediaView();
    }

    @Override // com.kc.dw.core.ad.a, com.kc.dw.core.ad.IAd
    public ResultBean getData() {
        ResultBean resultBean = new ResultBean();
        resultBean.setCid(this.e.getCid());
        resultBean.setCat(this.e.getCat());
        resultBean.setAderId(this.e.getAder_id());
        resultBean.setFromId(this.e.getFromId());
        resultBean.setDrawing(this.e.getDrawing());
        resultBean.setPid(this.e.getPosId());
        resultBean.setReqId(this.e.getReq_id());
        resultBean.setPrice(this.e.getEcpm());
        resultBean.setEcpm(String.valueOf(this.e.getEcpm()));
        resultBean.setS_ext(this.e.getS_ext());
        resultBean.setS_code(this.e.getS_code());
        resultBean.setSdkName("SSD");
        resultBean.setAdInfo(com.kc.dw.core.utils.a.a((BaseAdSlot) this.e));
        return resultBean;
    }

    @Override // com.kc.dw.core.ad.a, com.kc.dw.core.ad.IAd
    public boolean isAdValid() {
        int expire_timestamp = this.e.getExpire_timestamp();
        return SystemClock.uptimeMillis() - this.e.getLoadedTime() < (expire_timestamp <= 0 ? 1740000L : (long) (expire_timestamp * 1000));
    }

    @Override // com.kc.dw.core.ad.reward.RewardVideoAd, com.kc.dw.core.ad.fullscreenvideo.IFullScreenVideoAd
    public void render() {
    }

    @Override // com.kc.dw.core.ad.a, com.kc.dw.core.s2s.ISBidding
    public void sendLossNotification(Map map) {
        com.kc.dw.core.s2s.a.a(this.b.getContext(), this.e.getLossUrl(), map);
    }

    @Override // com.kc.dw.core.ad.a, com.kc.dw.core.s2s.ISBidding
    public void sendWinNotification(Map map) {
        com.kc.dw.core.s2s.a.b(this.b.getContext(), this.e.getWinUrl(), map);
    }

    @Override // com.kc.dw.core.ad.a, com.kc.dw.core.ad.IAd
    public void setInteractionListener(InteractionListener interactionListener) {
        this.c = interactionListener;
        this.f39450a.setInteractionListener(interactionListener);
    }

    @Override // com.kc.dw.core.ad.fullscreenvideo.IFullScreenVideoAd
    public void setMediaListener(IFullScreenMediaListener iFullScreenMediaListener) {
        this.o = iFullScreenMediaListener;
    }

    @Override // com.kc.dw.core.ad.reward.RewardVideoAd
    public void setMediaListener(RewardAdMediaListener rewardAdMediaListener) {
        this.d = rewardAdMediaListener;
    }

    @Override // com.kc.dw.core.ad.reward.RewardVideoAd, com.kc.dw.core.ad.fullscreenvideo.IFullScreenVideoAd
    public void showAd(Activity activity) {
        try {
            c cVar = this.f39450a;
            if (cVar instanceof com.kc.dw.ad.nativ.g) {
                ((com.kc.dw.ad.nativ.g) cVar).i = activity;
            }
            b(activity);
        } catch (Exception e) {
            e.printStackTrace();
            com.kc.dw.platform.ad_adapter.reward.a aVar = this.f;
            if (aVar != null) {
                aVar.onAdRenderFail("视频加载失败", com.kc.dw.core.exception.b.c.intValue());
            }
            LogUtil.e("RewardVideoAdAdapter", "视频加载失败");
        }
    }
}
