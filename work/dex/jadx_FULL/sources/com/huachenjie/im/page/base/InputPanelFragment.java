package com.huachenjie.im.page.base;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.blankj.utilcode.util.KeyboardUtils;
import com.hjq.permissions.Permission;
import com.huachenjie.base.widget.input_panel.audio.AudioRecordCallback;
import com.huachenjie.common.base.data_binding.BaseVMFragment;
import com.huachenjie.common.util.media_picker.MediaPicker;
import com.huachenjie.common.util.media_picker.MediaPickerLauncher;
import com.huachenjie.common.util.media_picker.MediaPickerListener;
import com.huachenjie.common.util.media_picker.MediaPickerResult;
import com.huachenjie.common.util.permission.PermissionResultListener;
import com.huachenjie.im.R;
import com.huachenjie.im.audio.ImAudioRecordCallback;
import com.huachenjie.im.databinding.FragmentInputPanelBinding;
import com.huachenjie.im.page.base.InputPanelFragment;
import com.huachenjie.im.page.emoji.EmojiInputCallback;
import com.huachenjie.im.page.emoji.EmojiPanelFragment;
import com.huachenjie.im.vm.InputPanelVM;
import com.zj.adlib.f64;
import com.zj.adlib.fv5;
import com.zj.adlib.g64;
import com.zj.adlib.i62;
import com.zj.adlib.vo6;
import com.zj.adlib.y6b;
import com.zj.adlib.yk0;
import java.io.File;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u0000m\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\t*\u0001+\u0018\u0000 02\b\u0012\u0004\u0012\u00020\u00020\u0001:\u000212B\u0007¢\u0006\u0004\b.\u0010/J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\u0003H\u0002J\u000e\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bJ&\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0003H\u0014J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0014J\u0012\u0010\u0019\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0014J\b\u0010\u001a\u001a\u00020\u0003H\u0014J\u0006\u0010\u001b\u001a\u00020\u0003J\u0006\u0010\u001c\u001a\u00020\u0003J\u000e\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001dJ\b\u0010 \u001a\u00020\u0003H\u0016R\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010$R\u0018\u0010&\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010)\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010,\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-¨\u00063"}, d2 = {"Lcom/huachenjie/im/page/base/InputPanelFragment;", "Lcom/huachenjie/common/base/data_binding/BaseVMFragment;", "Lcom/huachenjie/im/vm/InputPanelVM;", "", "initAudioPanel", "initEmojiPanel", "initKeyboardListener", "stopAudioPlay", "Landroid/view/animation/Animation;", "getShowAnimation", "showPickImage", "Lcom/huachenjie/im/page/base/InputPanelCallback;", "inputCallback", "setInputCallback", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "initViewModel", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "init", "initDataAfterView", "showAudioPanel", "showEmojiPanel", "", "text", "setInputAtMessage", "onDestroyView", "Lcom/huachenjie/common/util/media_picker/MediaPickerLauncher;", "picker", "Lcom/huachenjie/common/util/media_picker/MediaPickerLauncher;", "Lcom/huachenjie/im/page/base/InputPanelCallback;", "Lcom/huachenjie/im/page/emoji/EmojiPanelFragment;", "emojiPanelFragment", "Lcom/huachenjie/im/page/emoji/EmojiPanelFragment;", "", InputPanelFragment.HIDE_CAMERA, "Z", "com/huachenjie/im/page/base/InputPanelFragment$c", "audioRecordCallback", "Lcom/huachenjie/im/page/base/InputPanelFragment$c;", "<init>", "()V", "Companion", "a", "b", "IM_release"}, k = 1, mv = {1, 8, 0})
public final class InputPanelFragment extends BaseVMFragment<InputPanelVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String HIDE_CAMERA = "hideCamera";

    @NotNull
    private final c audioRecordCallback = new c();

    @Nullable
    private EmojiPanelFragment emojiPanelFragment;
    private boolean hideCamera;

    @Nullable
    private InputPanelCallback inputCallback;
    private MediaPickerLauncher picker;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\f"}, d2 = {"Lcom/huachenjie/im/page/base/InputPanelFragment$a;", "", "Landroid/view/View;", "v", "", "b", "e", "f", "d", y6b.f, "<init>", "(Lcom/huachenjie/im/page/base/InputPanelFragment;)V", "IM_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public static final void c(InputPanelFragment inputPanelFragment, boolean z) {
            Intrinsics.checkNotNullParameter(inputPanelFragment, "this$0");
            if (z) {
                ((InputPanelVM) ((BaseVMFragment) inputPanelFragment).mState).h().setValue(2);
                if (Intrinsics.areEqual(((InputPanelVM) ((BaseVMFragment) inputPanelFragment).mState).j().getValue(), Boolean.TRUE)) {
                    inputPanelFragment.hideInputForce();
                } else {
                    inputPanelFragment.showAudioPanel();
                }
            }
        }

        public final void b(@Nullable View v) {
            InputPanelFragment.this.stopAudioPlay();
            InputPanelCallback inputPanelCallback = InputPanelFragment.this.inputCallback;
            boolean z = false;
            if (inputPanelCallback != null && !inputPanelCallback.i()) {
                z = true;
            }
            if (z) {
                return;
            }
            Context context = InputPanelFragment.this.getContext();
            Intrinsics.checkNotNull(context);
            final InputPanelFragment inputPanelFragment = InputPanelFragment.this;
            vo6.j(context, Permission.RECORD_AUDIO, "为了您能正常录制语音消息，我们需要访问您终端设备的麦克风权限", new PermissionResultListener() { // from class: com.zj.adlib.sa4
                @Override // com.huachenjie.common.util.permission.PermissionResultListener
                public final void onResult(boolean z2) {
                    InputPanelFragment.a.c(inputPanelFragment, z2);
                }
            });
        }

        public final void d(@Nullable View v) {
            InputPanelFragment.this.stopAudioPlay();
            InputPanelFragment.this.hideInputForce();
            Boolean value = ((InputPanelVM) ((BaseVMFragment) InputPanelFragment.this).mState).o().getValue();
            Boolean bool = Boolean.FALSE;
            if (Intrinsics.areEqual(value, bool)) {
                ((InputPanelVM) ((BaseVMFragment) InputPanelFragment.this).mState).o().setValue(Boolean.TRUE);
            }
            Boolean value2 = ((InputPanelVM) ((BaseVMFragment) InputPanelFragment.this).mState).p().getValue();
            Boolean bool2 = Boolean.TRUE;
            if (Intrinsics.areEqual(value2, bool2)) {
                ((InputPanelVM) ((BaseVMFragment) InputPanelFragment.this).mState).p().setValue(bool);
            }
            if (Intrinsics.areEqual(((InputPanelVM) ((BaseVMFragment) InputPanelFragment.this).mState).l().getValue(), bool)) {
                ((InputPanelVM) ((BaseVMFragment) InputPanelFragment.this).mState).l().setValue(bool2);
            }
            if (Intrinsics.areEqual(((InputPanelVM) ((BaseVMFragment) InputPanelFragment.this).mState).m().getValue(), bool2)) {
                ((InputPanelVM) ((BaseVMFragment) InputPanelFragment.this).mState).m().setValue(bool);
            }
            boolean z = false;
            ((InputPanelVM) ((BaseVMFragment) InputPanelFragment.this).mState).h().setValue(0);
            InputPanelCallback inputPanelCallback = InputPanelFragment.this.inputCallback;
            if ((inputPanelCallback == null || inputPanelCallback.i()) ? false : true) {
                return;
            }
            InputPanelCallback inputPanelCallback2 = InputPanelFragment.this.inputCallback;
            if (inputPanelCallback2 != null && inputPanelCallback2.c()) {
                z = true;
            }
            if (z) {
                return;
            }
            InputPanelFragment.this.showPickImage();
        }

        public final void e(@Nullable View v) {
            InputPanelFragment.this.stopAudioPlay();
            InputPanelCallback inputPanelCallback = InputPanelFragment.this.inputCallback;
            boolean z = false;
            if (inputPanelCallback != null && !inputPanelCallback.i()) {
                z = true;
            }
            if (z) {
                return;
            }
            ((InputPanelVM) ((BaseVMFragment) InputPanelFragment.this).mState).h().setValue(1);
            if (Intrinsics.areEqual(((InputPanelVM) ((BaseVMFragment) InputPanelFragment.this).mState).j().getValue(), Boolean.TRUE)) {
                InputPanelFragment.this.hideInputForce();
            } else {
                InputPanelFragment.this.showEmojiPanel();
            }
        }

        public final void f(@Nullable View v) {
            FragmentInputPanelBinding fragmentInputPanelBinding;
            InputPanelFragment.this.stopAudioPlay();
            InputPanelCallback inputPanelCallback = InputPanelFragment.this.inputCallback;
            boolean z = false;
            if (inputPanelCallback != null && !inputPanelCallback.i()) {
                z = true;
            }
            if (z || (fragmentInputPanelBinding = (FragmentInputPanelBinding) InputPanelFragment.this.getBinding()) == null) {
                return;
            }
            InputPanelFragment.this.showInput(fragmentInputPanelBinding.f9719a);
        }

        public final void g(@Nullable View v) {
            InputPanelFragment.this.stopAudioPlay();
            InputPanelCallback inputPanelCallback = InputPanelFragment.this.inputCallback;
            boolean z = false;
            if (inputPanelCallback != null && !inputPanelCallback.i()) {
                z = true;
            }
            if (z) {
                return;
            }
            String value = ((InputPanelVM) ((BaseVMFragment) InputPanelFragment.this).mState).r().getValue();
            if (value == null) {
                value = "";
            }
            InputPanelCallback inputPanelCallback2 = InputPanelFragment.this.inputCallback;
            if (inputPanelCallback2 != null) {
                inputPanelCallback2.a(value);
            }
            ((InputPanelVM) ((BaseVMFragment) InputPanelFragment.this).mState).r().setValue("");
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.im.page.base.InputPanelFragment$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/im/page/base/InputPanelFragment$b;", "", "", InputPanelFragment.HIDE_CAMERA, "Lcom/huachenjie/im/page/base/InputPanelFragment;", "a", "", "HIDE_CAMERA", "Ljava/lang/String;", "<init>", "()V", "IM_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final InputPanelFragment a(boolean hideCamera) {
            InputPanelFragment inputPanelFragment = new InputPanelFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean(InputPanelFragment.HIDE_CAMERA, hideCamera);
            inputPanelFragment.setArguments(bundle);
            return inputPanelFragment;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0016¨\u0006\n"}, d2 = {"com/huachenjie/im/page/base/InputPanelFragment$c", "Lcom/huachenjie/im/audio/ImAudioRecordCallback;", "Ljava/io/File;", "audioFile", "", "duration", "", "d", "time", "b", "IM_release"}, k = 1, mv = {1, 8, 0})
    public static final class c implements ImAudioRecordCallback {
        public c() {
        }

        @Override // com.huachenjie.im.audio.ImAudioRecordCallback
        public void b(long time) {
            FragmentInputPanelBinding fragmentInputPanelBinding;
            if (time > 0 && (fragmentInputPanelBinding = (FragmentInputPanelBinding) InputPanelFragment.this.getBinding()) != null) {
                fragmentInputPanelBinding.f9716a.showCountdown(time + "秒后自动发送");
            }
        }

        @Override // com.huachenjie.im.audio.ImAudioRecordCallback
        public void d(@Nullable File audioFile, long duration) {
            FragmentInputPanelBinding fragmentInputPanelBinding = (FragmentInputPanelBinding) InputPanelFragment.this.getBinding();
            if (fragmentInputPanelBinding != null) {
                InputPanelFragment inputPanelFragment = InputPanelFragment.this;
                fragmentInputPanelBinding.f9716a.showNormal();
                if (audioFile == null || duration <= 0) {
                    if (audioFile == null && duration == -1) {
                        fv5.b("语音录制失败，请重新尝试");
                        return;
                    }
                    return;
                }
                InputPanelCallback inputPanelCallback = inputPanelFragment.inputCallback;
                if (inputPanelCallback != null) {
                    inputPanelCallback.e(audioFile, duration);
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0007"}, d2 = {"com/huachenjie/im/page/base/InputPanelFragment$d", "Lcom/huachenjie/base/widget/input_panel/audio/AudioRecordCallback;", "", "a", "", "cancel", "b", "IM_release"}, k = 1, mv = {1, 8, 0})
    public static final class d implements AudioRecordCallback {
        public d() {
        }

        @Override // com.huachenjie.base.widget.input_panel.audio.AudioRecordCallback
        public void a() {
            g64.k().p(InputPanelFragment.this.getContext(), InputPanelFragment.this.audioRecordCallback);
        }

        @Override // com.huachenjie.base.widget.input_panel.audio.AudioRecordCallback
        public void b(boolean cancel) {
            g64.k().i(cancel);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/huachenjie/im/page/base/InputPanelFragment$e", "Lcom/huachenjie/common/util/media_picker/MediaPickerListener;", "Lcom/huachenjie/common/util/media_picker/MediaPickerResult;", "result", "", "b", "IM_release"}, k = 1, mv = {1, 8, 0})
    @SourceDebugExtension({"SMAP\nInputPanelFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InputPanelFragment.kt\ncom/huachenjie/im/page/base/InputPanelFragment$initDataAfterView$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,391:1\n1855#2,2:392\n*S KotlinDebug\n*F\n+ 1 InputPanelFragment.kt\ncom/huachenjie/im/page/base/InputPanelFragment$initDataAfterView$1\n*L\n103#1:392,2\n*E\n"})
    public static final class e implements MediaPickerListener {
        public e() {
        }

        @Override // com.huachenjie.common.util.media_picker.MediaPickerListener
        public void b(@NotNull MediaPickerResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            if (!(result instanceof MediaPickerResult.Success)) {
                if ((result instanceof MediaPickerResult.a) || !(result instanceof MediaPickerResult.Error)) {
                    return;
                }
                fv5.b(((MediaPickerResult.Error) result).f());
                return;
            }
            List<String> listG = ((MediaPickerResult.Success) result).g();
            InputPanelFragment inputPanelFragment = InputPanelFragment.this;
            for (String str : listG) {
                InputPanelCallback inputPanelCallback = inputPanelFragment.inputCallback;
                if (inputPanelCallback != null) {
                    inputPanelCallback.g(str);
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\u0016¨\u0006\f"}, d2 = {"com/huachenjie/im/page/base/InputPanelFragment$f", "Lcom/huachenjie/im/page/emoji/EmojiInputCallback;", "", "emoji", "", "b", "Landroid/view/KeyEvent;", "keyEventDown", "keyEventUp", "a", "url", "c", "IM_release"}, k = 1, mv = {1, 8, 0})
    public static final class f implements EmojiInputCallback {
        public f() {
        }

        @Override // com.huachenjie.im.page.emoji.EmojiInputCallback
        public void a(@NotNull KeyEvent keyEventDown, @NotNull KeyEvent keyEventUp) {
            Intrinsics.checkNotNullParameter(keyEventDown, "keyEventDown");
            Intrinsics.checkNotNullParameter(keyEventUp, "keyEventUp");
            FragmentInputPanelBinding fragmentInputPanelBinding = (FragmentInputPanelBinding) InputPanelFragment.this.getBinding();
            if (fragmentInputPanelBinding != null) {
                fragmentInputPanelBinding.f9719a.onKeyDown(67, keyEventDown);
                fragmentInputPanelBinding.f9719a.onKeyUp(67, keyEventUp);
            }
        }

        @Override // com.huachenjie.im.page.emoji.EmojiInputCallback
        public void b(@NotNull String emoji) {
            Intrinsics.checkNotNullParameter(emoji, "emoji");
            FragmentInputPanelBinding fragmentInputPanelBinding = (FragmentInputPanelBinding) InputPanelFragment.this.getBinding();
            if (fragmentInputPanelBinding != null) {
                fragmentInputPanelBinding.f9719a.getEditableText().insert(fragmentInputPanelBinding.f9719a.getSelectionStart(), emoji);
            }
        }

        @Override // com.huachenjie.im.page.emoji.EmojiInputCallback
        public void c(@NotNull String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            InputPanelCallback inputPanelCallback = InputPanelFragment.this.inputCallback;
            if (inputPanelCallback != null) {
                inputPanelCallback.d(url);
            }
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class g implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f34570a;

        public g(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f34570a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f34570a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f34570a.invoke(obj);
        }
    }

    private final Animation getShowAnimation() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setRepeatMode(2);
        translateAnimation.setDuration(300L);
        return translateAnimation;
    }

    private final void initAudioPanel() {
        FragmentInputPanelBinding fragmentInputPanelBinding = (FragmentInputPanelBinding) getBinding();
        if (fragmentInputPanelBinding != null) {
            fragmentInputPanelBinding.f9716a.setCallback(new d());
        }
    }

    private final void initEmojiPanel() {
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        FragmentTransaction fragmentTransactionBeginTransaction = childFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "fragmentManager.beginTransaction()");
        EmojiPanelFragment emojiPanelFragmentA = EmojiPanelFragment.INSTANCE.a(new f());
        this.emojiPanelFragment = emojiPanelFragmentA;
        int i = R.id.emoji_sticker_container;
        Intrinsics.checkNotNull(emojiPanelFragmentA);
        fragmentTransactionBeginTransaction.add(i, emojiPanelFragmentA, EmojiPanelFragment.class.getName());
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
        childFragmentManager.executePendingTransactions();
    }

    private final void initKeyboardListener() {
        KeyboardUtils.p(requireActivity().getWindow(), new KeyboardUtils.OnSoftInputChangedListener() { // from class: com.zj.adlib.ra4
            @Override // com.blankj.utilcode.util.KeyboardUtils.OnSoftInputChangedListener
            public final void a(int i) {
                InputPanelFragment.initKeyboardListener$lambda$3(this.f44410a, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initKeyboardListener$lambda$3(InputPanelFragment inputPanelFragment, int i) {
        Intrinsics.checkNotNullParameter(inputPanelFragment, "this$0");
        ((InputPanelVM) ((BaseVMFragment) inputPanelFragment).mState).j().setValue(Boolean.valueOf(i > 0));
        Boolean value = ((InputPanelVM) ((BaseVMFragment) inputPanelFragment).mState).j().getValue();
        Boolean bool = Boolean.TRUE;
        if (!Intrinsics.areEqual(value, bool)) {
            ((InputPanelVM) ((BaseVMFragment) inputPanelFragment).mState).q().setValue(Boolean.FALSE);
            Integer value2 = ((InputPanelVM) ((BaseVMFragment) inputPanelFragment).mState).h().getValue();
            if (value2 != null && value2.intValue() == 1) {
                ((InputPanelVM) ((BaseVMFragment) inputPanelFragment).mState).h().setValue(0);
                inputPanelFragment.showEmojiPanel();
                return;
            }
            Integer value3 = ((InputPanelVM) ((BaseVMFragment) inputPanelFragment).mState).h().getValue();
            if (value3 != null && value3.intValue() == 2) {
                ((InputPanelVM) ((BaseVMFragment) inputPanelFragment).mState).h().setValue(0);
                inputPanelFragment.showAudioPanel();
                return;
            }
            return;
        }
        Boolean value4 = ((InputPanelVM) ((BaseVMFragment) inputPanelFragment).mState).o().getValue();
        Boolean bool2 = Boolean.FALSE;
        if (Intrinsics.areEqual(value4, bool2)) {
            ((InputPanelVM) ((BaseVMFragment) inputPanelFragment).mState).o().setValue(bool);
        }
        if (Intrinsics.areEqual(((InputPanelVM) ((BaseVMFragment) inputPanelFragment).mState).l().getValue(), bool2)) {
            ((InputPanelVM) ((BaseVMFragment) inputPanelFragment).mState).l().setValue(bool);
        }
        if (Intrinsics.areEqual(((InputPanelVM) ((BaseVMFragment) inputPanelFragment).mState).p().getValue(), bool)) {
            ((InputPanelVM) ((BaseVMFragment) inputPanelFragment).mState).p().setValue(bool2);
        }
        if (Intrinsics.areEqual(((InputPanelVM) ((BaseVMFragment) inputPanelFragment).mState).m().getValue(), bool)) {
            ((InputPanelVM) ((BaseVMFragment) inputPanelFragment).mState).m().setValue(bool2);
        }
        ((InputPanelVM) ((BaseVMFragment) inputPanelFragment).mState).h().setValue(0);
        FragmentInputPanelBinding fragmentInputPanelBinding = (FragmentInputPanelBinding) inputPanelFragment.getBinding();
        if (fragmentInputPanelBinding != null && fragmentInputPanelBinding.f34427a.getHeight() == 0) {
            ViewGroup.LayoutParams layoutParams = fragmentInputPanelBinding.f34427a.getLayoutParams();
            Intrinsics.checkNotNullExpressionValue(layoutParams, "vKeyboardSpace.layoutParams");
            layoutParams.height = i;
            fragmentInputPanelBinding.f34427a.setLayoutParams(layoutParams);
        }
        ((InputPanelVM) ((BaseVMFragment) inputPanelFragment).mState).q().setValue(bool);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showPickImage() {
        MediaPickerLauncher mediaPickerLauncher = this.picker;
        if (mediaPickerLauncher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("picker");
            mediaPickerLauncher = null;
        }
        MediaPickerLauncher mediaPickerLauncher2 = mediaPickerLauncher;
        InputPanelCallback inputPanelCallback = this.inputCallback;
        MediaPickerLauncher.Y(mediaPickerLauncher2, "为了能够正常拍摄照片并发送，我们需要访问您终端设备的相机权限", inputPanelCallback != null ? inputPanelCallback.h() : 1, 1080, 1024, false, 0.0f, 0.0f, false, 240, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stopAudioPlay() {
        f64.b().j();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment
    @Nullable
    public i62 getDataBindingConfig() {
        return new i62(Integer.valueOf(R.layout.fragment_input_panel), Integer.valueOf(yk0.p0), ((BaseVMFragment) this).mState).a(Integer.valueOf(yk0.k), new a());
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment
    public void init(@Nullable Bundle savedInstanceState) {
        Bundle arguments = getArguments();
        this.hideCamera = arguments != null ? arguments.getBoolean(HIDE_CAMERA) : false;
        ((InputPanelVM) ((BaseVMFragment) this).mState).n().setValue(Boolean.valueOf(!this.hideCamera));
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment
    public void initDataAfterView() {
        InputPanelCallback inputPanelCallback;
        this.picker = MediaPicker.v(this, new e());
        initAudioPanel();
        initEmojiPanel();
        initKeyboardListener();
        FragmentInputPanelBinding fragmentInputPanelBinding = (FragmentInputPanelBinding) getBinding();
        if (fragmentInputPanelBinding == null || (inputPanelCallback = this.inputCallback) == null) {
            return;
        }
        inputPanelCallback.b(fragmentInputPanelBinding.f9719a);
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment
    public void initViewModel() {
        ((InputPanelVM) ((BaseVMFragment) this).mState).r().observe(this, new g(new Function1<String, Unit>() { // from class: com.huachenjie.im.page.base.InputPanelFragment.initViewModel.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(String str) {
                InputPanelCallback inputPanelCallback;
                EmojiPanelFragment emojiPanelFragment = InputPanelFragment.this.emojiPanelFragment;
                if (emojiPanelFragment != null) {
                    emojiPanelFragment.changeDeleteButton(!TextUtils.isEmpty(str));
                }
                FragmentInputPanelBinding fragmentInputPanelBinding = (FragmentInputPanelBinding) InputPanelFragment.this.getBinding();
                if (fragmentInputPanelBinding == null || (inputPanelCallback = InputPanelFragment.this.inputCallback) == null) {
                    return;
                }
                inputPanelCallback.f(str, fragmentInputPanelBinding.f9719a);
            }
        }));
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Window window;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentActivity activity = getActivity();
        if (activity != null && (window = activity.getWindow()) != null) {
            window.setSoftInputMode(32);
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Window window;
        g64.k().j();
        FragmentActivity activity = getActivity();
        if (activity != null && (window = activity.getWindow()) != null) {
            KeyboardUtils.v(window);
        }
        super.onDestroyView();
    }

    public final void setInputAtMessage(@NotNull String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        ((InputPanelVM) ((BaseVMFragment) this).mState).r().setValue(text);
    }

    public final void setInputCallback(@NotNull InputPanelCallback inputCallback) {
        Intrinsics.checkNotNullParameter(inputCallback, "inputCallback");
        this.inputCallback = inputCallback;
    }

    public final void showAudioPanel() {
        Animation showAnimation = getShowAnimation();
        FragmentInputPanelBinding fragmentInputPanelBinding = (FragmentInputPanelBinding) getBinding();
        if (fragmentInputPanelBinding != null) {
            MutableLiveData<Boolean> mutableLiveDataM = ((InputPanelVM) ((BaseVMFragment) this).mState).m();
            Boolean bool = Boolean.TRUE;
            mutableLiveDataM.setValue(bool);
            fragmentInputPanelBinding.f9716a.setAnimation(showAnimation);
            Boolean value = ((InputPanelVM) ((BaseVMFragment) this).mState).o().getValue();
            Boolean bool2 = Boolean.FALSE;
            if (Intrinsics.areEqual(value, bool2)) {
                ((InputPanelVM) ((BaseVMFragment) this).mState).o().setValue(bool);
            }
            if (Intrinsics.areEqual(((InputPanelVM) ((BaseVMFragment) this).mState).p().getValue(), bool)) {
                ((InputPanelVM) ((BaseVMFragment) this).mState).p().setValue(bool2);
            }
            ((InputPanelVM) ((BaseVMFragment) this).mState).l().setValue(bool2);
        }
    }

    public final void showEmojiPanel() {
        Animation showAnimation = getShowAnimation();
        FragmentInputPanelBinding fragmentInputPanelBinding = (FragmentInputPanelBinding) getBinding();
        if (fragmentInputPanelBinding != null) {
            MutableLiveData<Boolean> mutableLiveDataP = ((InputPanelVM) ((BaseVMFragment) this).mState).p();
            Boolean bool = Boolean.TRUE;
            mutableLiveDataP.setValue(bool);
            fragmentInputPanelBinding.f9712a.setAnimation(showAnimation);
            Boolean value = ((InputPanelVM) ((BaseVMFragment) this).mState).l().getValue();
            Boolean bool2 = Boolean.FALSE;
            if (Intrinsics.areEqual(value, bool2)) {
                ((InputPanelVM) ((BaseVMFragment) this).mState).l().setValue(bool);
            }
            if (Intrinsics.areEqual(((InputPanelVM) ((BaseVMFragment) this).mState).m().getValue(), bool)) {
                ((InputPanelVM) ((BaseVMFragment) this).mState).m().setValue(bool2);
            }
            ((InputPanelVM) ((BaseVMFragment) this).mState).o().setValue(bool2);
        }
    }
}
