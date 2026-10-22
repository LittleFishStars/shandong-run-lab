package com.zj.adlib;

import com.huachenjie.base.R;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0004\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\u0006\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0005J \u0010\u000b\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002J\u0016\u0010\f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002J\u000e\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0002¨\u0006\u0010"}, d2 = {"Lcom/zj/adlib/ug9;", "", "", "specialAbility", "d", "(Ljava/lang/Integer;)I", "c", "", "attitudeName", "section", "starLevel", "a", "b", "e", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
public final class ug9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ug9 f45145a = new ug9();

    @JvmStatic
    public static final int c(@Nullable Integer specialAbility) {
        if (specialAbility != null && specialAbility.intValue() == 1) {
            return R.color.user_attribute_wind;
        }
        if (specialAbility != null && specialAbility.intValue() == 2) {
            return R.color.user_attribute_fire;
        }
        if (specialAbility != null && specialAbility.intValue() == 3) {
            return R.color.user_attribute_gem;
        }
        return (specialAbility != null && specialAbility.intValue() == 4) ? R.color.user_attribute_water : R.color.user_attribute_water;
    }

    @JvmStatic
    public static final int d(@Nullable Integer specialAbility) {
        if (specialAbility != null && specialAbility.intValue() == 1) {
            return R.drawable.ic_attribute_wind;
        }
        if (specialAbility != null && specialAbility.intValue() == 2) {
            return R.drawable.ic_attribute_fire;
        }
        if (specialAbility != null && specialAbility.intValue() == 3) {
            return R.drawable.ic_attribute_gem;
        }
        return (specialAbility != null && specialAbility.intValue() == 4) ? R.drawable.ic_attribute_water : R.drawable.ic_attribute_wind;
    }

    @NotNull
    public final String a(@Nullable String attitudeName, int section, int starLevel) {
        if (attitudeName != null) {
            if (attitudeName.length() > 0) {
                return attitudeName + "# " + b(section, starLevel);
            }
        }
        return String.valueOf(b(section, starLevel));
    }

    @NotNull
    public final String b(int section, int starLevel) {
        if (section == 1) {
            return "星痕青";
        }
        if (section == 2) {
            return "星痕银";
        }
        if (section == 3) {
            return "星痕金";
        }
        if (section == 4) {
            return "星痕钻";
        }
        if (section != 5) {
            return "";
        }
        return "星痕星" + e(starLevel);
    }

    @NotNull
    public final String e(int starLevel) {
        switch (starLevel) {
            case 1:
                return "一";
            case 2:
                return "二";
            case 3:
                return "三";
            case 4:
                return "四";
            case 5:
                return "五";
            case 6:
                return "六";
            case 7:
                return "七";
            case 8:
                return "八";
            case 9:
                return "九";
            default:
                return "";
        }
    }
}
