package com.byazt.nr;

import android.R;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.view.View;
import com.byazt.bv.BaseConstants;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_REND_FIRST_FRAME_TIME, 13})
public class tt {

    public interface c {
        void c();

        void c(Throwable th);
    }

    public static boolean c(Context context, Intent intent, c cVar) {
        if (context != null && intent != null) {
            try {
                if (!(context instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                context.startActivity(intent, ActivityOptions.makeCustomAnimation(context, 0, 0).toBundle());
                if (cVar == null) {
                    return true;
                }
                cVar.c();
                return true;
            } catch (Throwable th) {
                if (cVar != null) {
                    cVar.c(th);
                }
            }
        }
        return false;
    }

    public static void startActivity(Context context, Intent intent, boolean z) {
        if (context == null || intent == null) {
            return;
        }
        if (z) {
            intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public static boolean c(Context context, Intent intent, c cVar, boolean z) {
        if (context == null || intent == null) {
            return false;
        }
        if (z) {
            intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        }
        return c(context, intent, cVar);
    }

    public static Activity c(View view) {
        View viewFindViewById;
        Context context;
        if (view == null) {
            return null;
        }
        Context context2 = view.getContext();
        if (context2 instanceof Activity) {
            return (Activity) context2;
        }
        View rootView = view.getRootView();
        if (rootView == null || (viewFindViewById = rootView.findViewById(R.id.content)) == null || (context = viewFindViewById.getContext()) == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            Context baseContext = ((ContextWrapper) context).getBaseContext();
            if (baseContext instanceof Activity) {
                return (Activity) baseContext;
            }
        }
        return null;
    }
}
