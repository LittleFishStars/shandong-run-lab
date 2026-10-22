package com.kwad.sdk.api;

import androidx.annotation.Keep;
import com.kwad.sdk.api.core.KsAdSdkApi;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@KsAdSdkApi
@Keep
public interface KsInnerAd {

    @KsAdSdkApi
    @Keep
    public interface KsInnerAdInteractionListener {
        @KsAdSdkApi
        @Keep
        void onAdClicked(KsInnerAd ksInnerAd);

        @KsAdSdkApi
        @Keep
        void onAdShow(KsInnerAd ksInnerAd);
    }

    @Keep
    @Retention(RetentionPolicy.SOURCE)
    public @interface KsInnerAdType {
        public static final int AGGREGATION = 1;
        public static final int REFLOW = 2;
        public static final int UNKNOWN = 0;
    }

    int getType();
}
