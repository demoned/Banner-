package com.demons.banner.constants;

public interface PageStyle {

  int NORMAL = 0;

  @Deprecated
  int MULTI_PAGE = 1 << 1;
  /**
   * Requires Api Version >= 21
   */
  int MULTI_PAGE_OVERLAP = 1 << 2;

  int MULTI_PAGE_SCALE = 1 << 3;
}
