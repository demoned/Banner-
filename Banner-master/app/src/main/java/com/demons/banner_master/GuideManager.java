package com.demons.banner_master;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;

/**
 * 引导业务辅助类
 */
public class GuideManager {

  private static class GuideManagerHolder {
    public static GuideManager guideManager = new GuideManager();
  }

  public static GuideManager getInstance() {
    return GuideManagerHolder.guideManager;
  }

  public void load(Context context, Object model, ImageView image) {
    RequestOptions options = new RequestOptions()
      .centerCrop()
      .priority(Priority.HIGH)
      .diskCacheStrategy(DiskCacheStrategy.NONE);
    Glide.with(context)
      .load(model)
      .listener(new RequestListener<Drawable>() {
        @Override
        public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
          return false;
        }

        @Override
        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
          return false;
        }
      })
      .apply(options)
      .into(image);
  }
}
