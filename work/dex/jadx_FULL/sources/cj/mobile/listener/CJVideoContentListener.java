package cj.mobile.listener;

import androidx.fragment.app.Fragment;
import com.kwad.sdk.api.KsContentPage;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public interface CJVideoContentListener {
    void endVideo(KsContentPage.ContentItem contentItem);

    void onError(String str, String str2);

    void onLoad(Fragment fragment);

    void pauseVideo(KsContentPage.ContentItem contentItem);

    void resumeVideo(KsContentPage.ContentItem contentItem);

    void startVideo(KsContentPage.ContentItem contentItem);
}
