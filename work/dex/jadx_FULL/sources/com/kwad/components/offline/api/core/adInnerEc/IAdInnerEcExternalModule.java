package com.kwad.components.offline.api.core.adInnerEc;

import android.app.Activity;
import android.content.Context;
import android.os.ResultReceiver;
import android.view.ViewStub;
import android.webkit.WebView;
import android.widget.EditText;
import com.kwad.components.offline.api.adInnerEc.login.IAdInnerEcLoginBindListener;
import com.kwad.components.offline.api.adInnerEc.login.InnerEcLoginResponse;
import com.kwad.components.offline.api.core.adInnerEc.fullAdLive.IHostLivePlayer;
import com.kwad.components.offline.api.core.adInnerEc.fullAdLive.ILiveBindOwner;
import com.kwad.components.offline.api.core.adInnerEc.fullAdLive.ILivePluginProvider;
import com.kwad.components.offline.api.core.adInnerEc.fullAdLive.model.PBHelper;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public interface IAdInnerEcExternalModule {
    ILiveBindOwner createLiveBindOwner(String str, String str2, ILivePluginProvider iLivePluginProvider);

    IHostLivePlayer createLivePlayer(String str);

    PBHelper createPBPaser();

    WebView createYodaWebViewAndInit(Activity activity, YodaWebPageListener yodaWebPageListener, ExternalExitListener externalExitListener);

    CharSequence generateBasicEmoji(CharSequence charSequence, float f);

    Map<String, String> getCurrentCookieMap();

    void handleLoginResponse(InnerEcLoginResponse innerEcLoginResponse, Activity activity);

    void inflateEmotionPanel(ViewStub viewStub, EditText editText);

    void initEmotionSdk(String str);

    void initModule();

    void loadData(boolean z);

    void onActivityDestroyed(Activity activity);

    void onActivityPaused(Activity activity);

    void onActivityResumed(Activity activity);

    void onActivityStopped(Activity activity);

    void setAdInnerEcHostProvider(IAdInnerEcHostProvider iAdInnerEcHostProvider);

    void setDebug(boolean z);

    void startLoginAuth(Activity activity, IAdInnerEcLoginBindListener iAdInnerEcLoginBindListener, String str);

    void startPay(Context context, String str, String str2, ResultReceiver resultReceiver);
}
