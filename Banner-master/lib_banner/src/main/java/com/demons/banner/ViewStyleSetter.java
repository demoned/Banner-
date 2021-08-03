

package com.demons.banner;

import android.os.Build;
import androidx.annotation.RequiresApi;
import android.view.View;

public class ViewStyleSetter {

  /**
   * 为View设置圆角效果
   *
   * @param radius 圆角半径
   */
  @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
  public static void applyRoundCorner(View target, float radius) {
    if (target == null) {
      return;
    }
    target.setClipToOutline(true);// 用outline裁剪内容区域
    target.setOutlineProvider(new RoundViewOutlineProvider(radius));
  }
}
