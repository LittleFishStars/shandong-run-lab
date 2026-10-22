package com.zj.adlib;

import com.huachenjie.social_contact.R;
import com.kc.aw.lib.constants.BiddingConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004J\u0016\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004¨\u0006\u000e"}, d2 = {"Lcom/zj/adlib/tg9;", "", "", "geneType", "", "b", "(Ljava/lang/String;)Ljava/lang/Integer;", "a", "attributeCode", "c", "attributeValue", "d", "<init>", "()V", "social_contact_release"}, k = 1, mv = {1, 8, 0})
public final class tg9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final tg9 f44915a = new tg9();

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final int a(@Nullable String geneType) {
        if (geneType != null) {
            switch (geneType.hashCode()) {
                case 47664:
                    if (geneType.equals("000")) {
                        return R.drawable.ic_food_type_000;
                    }
                    break;
                case 47665:
                    if (geneType.equals("001")) {
                        return R.drawable.ic_food_type_001;
                    }
                    break;
                case 47695:
                    if (geneType.equals("010")) {
                        return R.drawable.ic_food_type_010;
                    }
                    break;
                case 47696:
                    if (geneType.equals("011")) {
                        return R.drawable.ic_food_type_011;
                    }
                    break;
                case 48625:
                    if (geneType.equals("100")) {
                        return R.drawable.ic_food_type_100;
                    }
                    break;
                case 48626:
                    if (geneType.equals("101")) {
                        return R.drawable.ic_food_type_101;
                    }
                    break;
                case 48656:
                    if (geneType.equals(BiddingConst.ADN_ID.SIGMOB)) {
                        return R.drawable.ic_food_type_110;
                    }
                    break;
                case 48657:
                    if (geneType.equals(BiddingConst.ADN_ID.MM)) {
                        return R.drawable.ic_food_type_111;
                    }
                    break;
            }
        }
        return R.drawable.ic_food_type_111;
    }

    @Nullable
    public final Integer b(@Nullable String geneType) {
        if (Intrinsics.areEqual(geneType, "0")) {
            return Integer.valueOf(R.drawable.ic_material_type_0);
        }
        if (Intrinsics.areEqual(geneType, "1")) {
            return Integer.valueOf(R.drawable.ic_material_type_1);
        }
        return null;
    }

    @NotNull
    public final String c(int attributeCode) {
        switch (attributeCode) {
            case 1:
                return "砍伐力";
            case 2:
                return "爆破力";
            case 3:
                return "举重力";
            case 4:
                return "抵御率";
            case 5:
                return "生命上限";
            case 6:
                return "异常抵抗";
            case 7:
                return "探索力";
            case 8:
                return "会心率";
            default:
                return "";
        }
    }

    @NotNull
    public final String d(int attributeCode, int attributeValue) {
        switch (attributeCode) {
            case 1:
                return String.valueOf(attributeValue);
            case 2:
                return String.valueOf(attributeValue);
            case 3:
                return String.valueOf(attributeValue);
            case 4:
                StringBuilder sb = new StringBuilder();
                sb.append(attributeValue);
                sb.append('%');
                return sb.toString();
            case 5:
                return String.valueOf(attributeValue);
            case 6:
                StringBuilder sb2 = new StringBuilder();
                sb2.append(attributeValue);
                sb2.append('%');
                return sb2.toString();
            case 7:
                return String.valueOf(attributeValue);
            case 8:
                StringBuilder sb3 = new StringBuilder();
                sb3.append(attributeValue);
                sb3.append('%');
                return sb3.toString();
            default:
                return "";
        }
    }
}
