package com.google.android.inner_exoplayer2;

import android.os.Bundle;
import com.google.android.inner_exoplayer2.Bundleable;
import com.google.android.inner_exoplayer2.Rating;
import com.google.android.inner_exoplayer2.util.Util;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public abstract class Rating implements Bundleable {
    static final int RATING_TYPE_HEART = 0;
    static final int RATING_TYPE_PERCENTAGE = 1;
    static final int RATING_TYPE_STAR = 2;
    static final int RATING_TYPE_THUMB = 3;
    static final int RATING_TYPE_UNSET = -1;
    static final float RATING_UNSET = -1.0f;
    static final String FIELD_RATING_TYPE = Util.intToStringMaxRadix(0);
    public static final Bundleable.Creator<Rating> CREATOR = new Bundleable.Creator() { // from class: com.zj.adlib.ya7
        @Override // com.google.android.inner_exoplayer2.Bundleable.Creator
        public final Bundleable fromBundle(Bundle bundle) {
            return Rating.fromBundle(bundle);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static Rating fromBundle(Bundle bundle) {
        int i = bundle.getInt(FIELD_RATING_TYPE, -1);
        if (i == 0) {
            return (Rating) HeartRating.CREATOR.fromBundle(bundle);
        }
        if (i == 1) {
            return (Rating) PercentageRating.CREATOR.fromBundle(bundle);
        }
        if (i == 2) {
            return (Rating) StarRating.CREATOR.fromBundle(bundle);
        }
        if (i == 3) {
            return (Rating) ThumbRating.CREATOR.fromBundle(bundle);
        }
        throw new IllegalArgumentException("Unknown RatingType: " + i);
    }

    public abstract boolean isRated();
}
