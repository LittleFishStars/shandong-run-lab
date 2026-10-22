package com.alibaba.triver.kit.api.proxy;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.ariver.kernel.api.annotation.DefaultImpl;
import com.alibaba.ariver.kernel.common.Proxiable;
import com.alibaba.triver.kit.api.TinyApp;
import com.alibaba.triver.kit.api.widget.ITitleBar;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@DefaultImpl("com.alibaba.triver.kit.impl.TriverFollowProxyImpl")
public interface IFollowProxy extends Proxiable {

    public interface IFollowListener<T> {
        void onFailed(String str, String str2);

        void onSuccess(T t);
    }

    void checkFollowStatus(@NonNull TinyApp tinyApp, @Nullable IFollowListener iFollowListener);

    void doFollow(@NonNull TinyApp tinyApp, String str, @Nullable ITitleBar iTitleBar, @Nullable IFollowListener iFollowListener);

    void hideFollowBar(HashMap map, @Nullable IFollowListener iFollowListener);

    boolean isFavored(@NonNull TinyApp tinyApp);

    void showFollowBar(Context context, TinyApp tinyApp, View view, @NonNull HashMap map, @Nullable IFollowListener iFollowListener);

    void unFollow(@NonNull TinyApp tinyApp, @Nullable ITitleBar iTitleBar, @Nullable IFollowListener iFollowListener);

    void updateFavorStatus(@NonNull TinyApp tinyApp, Boolean bool);
}
