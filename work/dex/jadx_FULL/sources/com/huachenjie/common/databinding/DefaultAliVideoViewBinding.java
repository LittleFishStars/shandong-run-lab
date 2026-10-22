package com.huachenjie.common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.huachenjie.common.R;
import com.huachenjie.common.video.VideoTextureView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public final class DefaultAliVideoViewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f33749a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f8600a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f8601a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ProgressBar f8602a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SeekBar f8603a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f8604a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final VideoTextureView f8605a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final LinearLayout f8606b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f8607b;

    @NonNull
    public final ImageView c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final LinearLayout f8608c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final TextView f8609c;

    @NonNull
    public final ImageView d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    @NonNull
    public final LinearLayout f8610d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    @NonNull
    public final TextView f8611d;

    @NonNull
    public final ImageView e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    @NonNull
    public final TextView f8612e;

    @NonNull
    public final ImageView f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    @NonNull
    public final TextView f8613f;

    @NonNull
    public final ImageView g;

    @NonNull
    public final ImageView h;

    public DefaultAliVideoViewBinding(@NonNull View rootView, @NonNull TextView dragVideoCurrentDuration, @NonNull TextView dragVideoDuration, @NonNull ImageView videoBack, @NonNull LinearLayout videoControlBarBottom, @NonNull LinearLayout videoControlBarTop, @NonNull ImageView videoControlOrientation, @NonNull ImageView videoControlPlay, @NonNull LinearLayout videoControlTimeProgress, @NonNull ImageView videoControlVolume, @NonNull ImageView videoCover, @NonNull TextView videoCurrentTime, @NonNull TextView videoDuration, @NonNull ProgressBar videoLoading, @NonNull ImageView videoMoreInfo, @NonNull ImageView videoPlayOrPause, @NonNull LinearLayout videoRemind, @NonNull ImageView videoRemindIcon, @NonNull TextView videoRemindText, @NonNull SeekBar videoSeekBar, @NonNull VideoTextureView videoTextureView, @NonNull TextView videoTitle) {
        this.f33749a = rootView;
        this.f8604a = dragVideoCurrentDuration;
        this.f8607b = dragVideoDuration;
        this.f8600a = videoBack;
        this.f8601a = videoControlBarBottom;
        this.f8606b = videoControlBarTop;
        this.b = videoControlOrientation;
        this.c = videoControlPlay;
        this.f8608c = videoControlTimeProgress;
        this.d = videoControlVolume;
        this.e = videoCover;
        this.f8609c = videoCurrentTime;
        this.f8611d = videoDuration;
        this.f8602a = videoLoading;
        this.f = videoMoreInfo;
        this.g = videoPlayOrPause;
        this.f8610d = videoRemind;
        this.h = videoRemindIcon;
        this.f8612e = videoRemindText;
        this.f8603a = videoSeekBar;
        this.f8605a = videoTextureView;
        this.f8613f = videoTitle;
    }

    @NonNull
    public static DefaultAliVideoViewBinding a(@NonNull View rootView) {
        int i = R.id.drag_video_current_duration;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.drag_video_duration;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.video_back;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
                if (imageView != null) {
                    i = R.id.video_control_bar_bottom;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                    if (linearLayout != null) {
                        i = R.id.video_control_bar_top;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                        if (linearLayout2 != null) {
                            i = R.id.video_control_orientation;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                            if (imageView2 != null) {
                                i = R.id.video_control_play;
                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                if (imageView3 != null) {
                                    i = R.id.video_control_time_progress;
                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                    if (linearLayout3 != null) {
                                        i = R.id.video_control_volume;
                                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                        if (imageView4 != null) {
                                            i = R.id.video_cover;
                                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                            if (imageView5 != null) {
                                                i = R.id.video_current_time;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                if (textView3 != null) {
                                                    i = R.id.video_duration;
                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                    if (textView4 != null) {
                                                        i = R.id.video_loading;
                                                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, i);
                                                        if (progressBar != null) {
                                                            i = R.id.video_more_info;
                                                            ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                            if (imageView6 != null) {
                                                                i = R.id.video_play_or_pause;
                                                                ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                if (imageView7 != null) {
                                                                    i = R.id.video_remind;
                                                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                    if (linearLayout4 != null) {
                                                                        i = R.id.video_remind_icon;
                                                                        ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                        if (imageView8 != null) {
                                                                            i = R.id.video_remind_text;
                                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                            if (textView5 != null) {
                                                                                i = R.id.video_seek_bar;
                                                                                SeekBar seekBar = (SeekBar) ViewBindings.findChildViewById(rootView, i);
                                                                                if (seekBar != null) {
                                                                                    i = R.id.video_texture_view;
                                                                                    VideoTextureView videoTextureView = (VideoTextureView) ViewBindings.findChildViewById(rootView, i);
                                                                                    if (videoTextureView != null) {
                                                                                        i = R.id.video_title;
                                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                        if (textView6 != null) {
                                                                                            return new DefaultAliVideoViewBinding(rootView, textView, textView2, imageView, linearLayout, linearLayout2, imageView2, imageView3, linearLayout3, imageView4, imageView5, textView3, textView4, progressBar, imageView6, imageView7, linearLayout4, imageView8, textView5, seekBar, videoTextureView, textView6);
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }

    @NonNull
    public static DefaultAliVideoViewBinding b(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        if (parent == null) {
            throw new NullPointerException("parent");
        }
        inflater.inflate(R.layout.default_ali_video_view, parent);
        return a(parent);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f33749a;
    }
}
