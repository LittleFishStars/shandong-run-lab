package androidx.coroutines.adapters;

import android.widget.VideoView;
import androidx.annotation.RestrictTo;
import androidx.coroutines.BindingMethod;
import androidx.coroutines.BindingMethods;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@BindingMethods({@BindingMethod(attribute = "android:onCompletion", method = "setOnCompletionListener", type = VideoView.class), @BindingMethod(attribute = "android:onError", method = "setOnErrorListener", type = VideoView.class), @BindingMethod(attribute = "android:onInfo", method = "setOnInfoListener", type = VideoView.class), @BindingMethod(attribute = "android:onPrepared", method = "setOnPreparedListener", type = VideoView.class)})
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class VideoViewBindingAdapter {
}
