package com.ltmb.ltadsdk.api;

import com.alibaba.ariver.kernel.RVParams;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001:\u0002 !B\u0019\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0004HÆ\u0001J\t\u0010\t\u001a\u00020\u0004HÖ\u0001J\t\u0010\n\u001a\u00020\u0002HÖ\u0001J\u0013\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\"\u0010\u0014\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u000f\u001a\u0004\b\u001c\u0010\u0011\"\u0004\b\u001d\u0010\u0013¨\u0006\""}, d2 = {"Lcom/ltmb/ltadsdk/api/AdBidLossInfo;", "", "", "component1", "", "component2", "type", "price", OperatePopupWindow.g, "toString", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "getAdnName", "()Ljava/lang/String;", "setAdnName", "(Ljava/lang/String;)V", MediationConstant.KEY_ADN_NAME, "b", "I", "getType", "()I", "setType", "(I)V", "c", "getPrice", "setPrice", "<init>", "(ILjava/lang/String;)V", "AdLoseAdn", "AdLoseType", "ADAarBuild_ltmbRelease"}, k = 1, mv = {1, 4, 0})
public final /* data */ class AdBidLossInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public String adnName;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
    public int type;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
    @NotNull
    public String price;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/ltmb/ltadsdk/api/AdBidLossInfo$AdLoseAdn;", "", "<init>", "()V", "Companion", "ADAarBuild_ltmbRelease"}, k = 1, mv = {1, 4, 0})
    public static final class AdLoseAdn {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final String f40321a = "csj";

        @NotNull
        public static final String b = "gdt";

        @NotNull
        public static final String c = MediationConstant.ADN_KS;

        @NotNull
        public static final String d = "bd";

        @NotNull
        public static final String e = "hw";

        @NotNull
        public static final String f = "jd";

        @NotNull
        public static final String g = "gm";

        @NotNull
        public static final String h = "qm";

        @NotNull
        public static final String i = "sigmob";

        @NotNull
        public static final String j = "oct";

        @NotNull
        public static final String k = "ms";

        @NotNull
        public static final String l = RVParams.BIZ_SCENARIO;

        @NotNull
        public static final String m = "asnp";

        @NotNull
        public static final String n = "other";

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b!\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b!\u0010\"R\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001c\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001c\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001c\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u001c\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R\u001c\u0010\u0017\u001a\u00020\u00028\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u001c\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006R\u001c\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006R\u001c\u0010\u001d\u001a\u00020\u00028\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006R\u001c\u0010\u001f\u001a\u00020\u00028\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006¨\u0006#"}, d2 = {"Lcom/ltmb/ltadsdk/api/AdBidLossInfo$AdLoseAdn$Companion;", "", "", "CSJ", "Ljava/lang/String;", "getCSJ", "()Ljava/lang/String;", "GDT", "getGDT", "KS", "getKS", "BD", "getBD", "HW", "getHW", "JD", "getJD", "GM", "getGM", "QM", "getQM", "SIGMOB", "getSIGMOB", "OCT", "getOCT", "MS", "getMS", "BZ", "getBZ", "ASNP", "getASNP", "OTHER", "getOTHER", "<init>", "()V", "ADAarBuild_ltmbRelease"}, k = 1, mv = {1, 4, 0})
        public static final class Companion {
            public Companion() {
            }

            @NotNull
            public final String getASNP() {
                return AdLoseAdn.m;
            }

            @NotNull
            public final String getBD() {
                return AdLoseAdn.d;
            }

            @NotNull
            public final String getBZ() {
                return AdLoseAdn.l;
            }

            @NotNull
            public final String getCSJ() {
                return AdLoseAdn.f40321a;
            }

            @NotNull
            public final String getGDT() {
                return AdLoseAdn.b;
            }

            @NotNull
            public final String getGM() {
                return AdLoseAdn.g;
            }

            @NotNull
            public final String getHW() {
                return AdLoseAdn.e;
            }

            @NotNull
            public final String getJD() {
                return AdLoseAdn.f;
            }

            @NotNull
            public final String getKS() {
                return AdLoseAdn.c;
            }

            @NotNull
            public final String getMS() {
                return AdLoseAdn.k;
            }

            @NotNull
            public final String getOCT() {
                return AdLoseAdn.j;
            }

            @NotNull
            public final String getOTHER() {
                return AdLoseAdn.n;
            }

            @NotNull
            public final String getQM() {
                return AdLoseAdn.h;
            }

            @NotNull
            public final String getSIGMOB() {
                return AdLoseAdn.i;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/ltmb/ltadsdk/api/AdBidLossInfo$AdLoseType;", "", "<init>", "()V", "Companion", "ADAarBuild_ltmbRelease"}, k = 1, mv = {1, 4, 0})
    public static final class AdLoseType {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f40322a = 100;
        public static final int b = 200;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/ltmb/ltadsdk/api/AdBidLossInfo$AdLoseType$Companion;", "", "", "Uknown", "I", "getUknown", "()I", "LowEcpm", "getLowEcpm", "Timeout", "getTimeout", "<init>", "()V", "ADAarBuild_ltmbRelease"}, k = 1, mv = {1, 4, 0})
        public static final class Companion {
            public Companion() {
            }

            public final int getLowEcpm() {
                return AdLoseType.f40322a;
            }

            public final int getTimeout() {
                return AdLoseType.b;
            }

            public final int getUknown() {
                return AdLoseType.access$getUknown$cp();
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public static final /* synthetic */ int access$getUknown$cp() {
            return 0;
        }
    }

    public AdBidLossInfo(int i, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "price");
        this.type = i;
        this.price = str;
        this.adnName = "";
    }

    public static /* synthetic */ AdBidLossInfo copy$default(AdBidLossInfo adBidLossInfo, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = adBidLossInfo.type;
        }
        if ((i2 & 2) != 0) {
            str = adBidLossInfo.price;
        }
        return adBidLossInfo.copy(i, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getType() {
        return this.type;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getPrice() {
        return this.price;
    }

    @NotNull
    public final AdBidLossInfo copy(int type, @NotNull String price) {
        Intrinsics.checkNotNullParameter(price, "price");
        return new AdBidLossInfo(type, price);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdBidLossInfo)) {
            return false;
        }
        AdBidLossInfo adBidLossInfo = (AdBidLossInfo) other;
        return this.type == adBidLossInfo.type && Intrinsics.areEqual(this.price, adBidLossInfo.price);
    }

    @NotNull
    public final String getAdnName() {
        return this.adnName;
    }

    @NotNull
    public final String getPrice() {
        return this.price;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.type) * 31;
        String str = this.price;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public final void setAdnName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.adnName = str;
    }

    public final void setPrice(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.price = str;
    }

    public final void setType(int i) {
        this.type = i;
    }

    @NotNull
    public String toString() {
        return "AdBidLossInfo(type=" + this.type + ", price=" + this.price + ")";
    }

    public /* synthetic */ AdBidLossInfo(int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? "" : str);
    }
}
