package com.beizi.fusion;

import android.content.Context;
import android.text.TextUtils;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.interaction.ScopeAdCloseView;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.interaction.ScopeCapsuleCloseView;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.interaction.ScopeDlInfoTextView;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.interaction.ScopeEulerAngleView;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.interaction.ScopeInteractionArcView;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.interaction.ScopeInteractionImageView;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.interaction.ScopeInteractionTagView;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.interaction.ScopeInteractionTextView;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.interaction.ScopeInteractionVideoView;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.interaction.ScopeInteractionViewGroup;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.interaction.ScopeInteractionWebView;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.interaction.ScopeLogoView;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.interaction.ScopeMuteView;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.interaction.ScopeRegionTextView;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.interaction.ScopeShakeView;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.interaction.ScopeSlideView;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.interaction.ScopeVideoCloseView;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.prefab.ScopeArcView;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.prefab.ScopeCarouselView2;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render.ScopeEndCardContainer;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render.ScopeImageView;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render.ScopeTextView;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render.ScopeVideoView;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render.ScopeViewGroup;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render.ScopeWebView;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class fn {
    public static he a(Context context, String str, String str2) {
        String lowerCase = str.toLowerCase(Locale.ENGLISH);
        switch (lowerCase.hashCode()) {
            case -1116930131:
                if (lowerCase.equals("webcontainer")) {
                    return new ScopeEndCardContainer(context);
                }
                break;
            case -934795532:
                if (lowerCase.equals("region")) {
                    return new ScopeRegionTextView(context);
                }
                break;
            case -905948230:
                if (lowerCase.equals("sensor")) {
                    return new ScopeEulerAngleView(context);
                }
                break;
            case -793319857:
                if (lowerCase.equals("appinfo")) {
                    return new ScopeDlInfoTextView(context);
                }
                break;
            case 114586:
                if (lowerCase.equals("tag")) {
                    return new ScopeInteractionTagView(context);
                }
                break;
            case 117588:
                if (lowerCase.equals(bolts.c.k)) {
                    return !TextUtils.isEmpty(str2) ? new ScopeInteractionWebView(context) : new ScopeWebView(context);
                }
                break;
            case 2908512:
                if (lowerCase.equals("carousel")) {
                    return new ScopeCarouselView2(context);
                }
                break;
            case 3327403:
                if (lowerCase.equals("logo")) {
                    return new ScopeLogoView(context);
                }
                break;
            case 3556653:
                if (lowerCase.equals("text")) {
                    return !TextUtils.isEmpty(str2) ? new ScopeInteractionTextView(context) : new ScopeTextView(context);
                }
                break;
            case 3619493:
                lowerCase.equals("view");
                break;
            case 100313435:
                if (lowerCase.equals("image")) {
                    return !TextUtils.isEmpty(str2) ? new ScopeInteractionImageView(context) : new ScopeImageView(context);
                }
                break;
            case 109399814:
                if (lowerCase.equals("shake")) {
                    return new ScopeShakeView(context);
                }
                break;
            case 109526449:
                if (lowerCase.equals("slide")) {
                    return new ScopeSlideView(context);
                }
                break;
            case 112202875:
                if (lowerCase.equals("video")) {
                    return !TextUtils.isEmpty(str2) ? new ScopeInteractionVideoView(context) : new ScopeVideoView(context);
                }
                break;
            case 112386354:
                if (lowerCase.equals("voice")) {
                    return new ScopeMuteView(context);
                }
                break;
            case 692793219:
                if (lowerCase.equals("handarc")) {
                    ScopeInteractionArcView scopeInteractionArcView = new ScopeInteractionArcView(context);
                    scopeInteractionArcView.setDisplayMode(ScopeArcView.c.HandArc);
                    return scopeInteractionArcView;
                }
                break;
            case 902018089:
                if (lowerCase.equals("rewardclose")) {
                    return new ScopeVideoCloseView(context);
                }
                break;
            case 1091550823:
                if (lowerCase.equals("countdownclose")) {
                    return new ScopeAdCloseView(context);
                }
                break;
            case 1547952107:
                if (lowerCase.equals("capsuleclose")) {
                    return new ScopeCapsuleCloseView(context);
                }
                break;
            case 1979141156:
                if (lowerCase.equals("semiarc")) {
                    ScopeInteractionArcView scopeInteractionArcView2 = new ScopeInteractionArcView(context);
                    scopeInteractionArcView2.setDisplayMode(ScopeArcView.c.SemiArc);
                    return scopeInteractionArcView2;
                }
                break;
        }
        return !TextUtils.isEmpty(str2) ? new ScopeInteractionViewGroup(context) : new ScopeViewGroup(context);
    }
}
