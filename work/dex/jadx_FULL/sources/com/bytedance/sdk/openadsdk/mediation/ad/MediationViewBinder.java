package com.bytedance.sdk.openadsdk.mediation.ad;

import com.byazt.zqa.c;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@c(c = {0, 80, 81, 82, 83, 686, 1444})
public class MediationViewBinder implements IMediationViewBinder {
    public final int callToActionId;
    public final int decriptionTextId;
    public final Map<String, Integer> extras;
    public final int groupImage1Id;
    public final int groupImage2Id;
    public final int groupImage3Id;
    public final int iconImageId;
    public final int layoutId;
    public final int logoLayoutId;
    public final int mainImageId;
    public final int mediaViewId;
    public final int shakeViewContainerId;
    public final int sourceId;
    public final int titleId;

    @c(c = {0, 80, 81, 82, 83, 686, 1563})
    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected int f29307a;
        protected int c;
        protected int da;
        protected int i;
        protected int n;
        protected int sl;
        protected int sp;
        protected int t;
        protected int tt;
        protected int u;
        protected int uj;
        protected int ve;
        protected int x;
        protected Map<String, Integer> yp;

        public Builder(int i) {
            this.yp = Collections.emptyMap();
            this.c = i;
            this.yp = new HashMap();
        }

        public Builder addExtra(String str, int i) {
            this.yp.put(str, Integer.valueOf(i));
            return this;
        }

        public Builder addExtras(Map<String, Integer> map) {
            this.yp = new HashMap(map);
            return this;
        }

        public MediationViewBinder build() {
            return new MediationViewBinder(this);
        }

        public Builder callToActionId(int i) {
            this.uj = i;
            return this;
        }

        public Builder descriptionTextId(int i) {
            this.ve = i;
            return this;
        }

        public Builder groupImage1Id(int i) {
            this.da = i;
            return this;
        }

        public Builder groupImage2Id(int i) {
            this.sl = i;
            return this;
        }

        public Builder groupImage3Id(int i) {
            this.t = i;
            return this;
        }

        public Builder iconImageId(int i) {
            this.n = i;
            return this;
        }

        public Builder logoLayoutId(int i) {
            this.i = i;
            return this;
        }

        public Builder mainImageId(int i) {
            this.f29307a = i;
            return this;
        }

        public Builder mediaViewIdId(int i) {
            this.sp = i;
            return this;
        }

        public Builder shakeViewContainerId(int i) {
            this.u = i;
            return this;
        }

        public Builder sourceId(int i) {
            this.x = i;
            return this;
        }

        public Builder titleId(int i) {
            this.tt = i;
            return this;
        }
    }

    public MediationViewBinder(Builder builder) {
        this.layoutId = builder.c;
        this.titleId = builder.tt;
        this.decriptionTextId = builder.ve;
        this.callToActionId = builder.uj;
        this.iconImageId = builder.n;
        this.mainImageId = builder.f29307a;
        this.mediaViewId = builder.sp;
        this.sourceId = builder.x;
        this.extras = builder.yp;
        this.groupImage1Id = builder.da;
        this.groupImage2Id = builder.sl;
        this.groupImage3Id = builder.t;
        this.logoLayoutId = builder.i;
        this.shakeViewContainerId = builder.u;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getCallToActionId() {
        return this.callToActionId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getDecriptionTextId() {
        return this.decriptionTextId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public Map<String, Integer> getExtras() {
        return this.extras;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getGroupImage1Id() {
        return this.groupImage1Id;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getGroupImage2Id() {
        return this.groupImage2Id;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getGroupImage3Id() {
        return this.groupImage3Id;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getIconImageId() {
        return this.iconImageId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getLayoutId() {
        return this.layoutId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getLogoLayoutId() {
        return this.logoLayoutId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getMainImageId() {
        return this.mainImageId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getMediaViewId() {
        return this.mediaViewId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getShakeViewContainerId() {
        return this.shakeViewContainerId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getSourceId() {
        return this.sourceId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getTitleId() {
        return this.titleId;
    }
}
