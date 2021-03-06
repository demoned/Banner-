package com.demons.banner;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseBannerAdapter<T> extends RecyclerView.Adapter<BaseViewHolder<T>> {
  protected List<T> mList = new ArrayList<>();
  private boolean isCanLoop;
  public static final int MAX_VALUE = 1000;
  private BannerViewPager2.OnPageClickListener mPageClickListener;

  @NonNull
  @Override
  public final BaseViewHolder<T> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View itemView =
        LayoutInflater.from(parent.getContext()).inflate(getLayoutId(viewType), parent, false);
    BaseViewHolder<T> viewHolder = createViewHolder(parent, itemView, viewType);
    itemView.setOnClickListener(clickedView -> {
      int adapterPosition = viewHolder.getAdapterPosition();
      if (mPageClickListener != null && adapterPosition != RecyclerView.NO_POSITION) {
        int realPosition =
            BannerUtils.getRealPosition(viewHolder.getAdapterPosition(), getListSize());
        mPageClickListener.onPageClick(clickedView, realPosition);
      }
    });
    return viewHolder;
  }

  @Override
  public final void onBindViewHolder(@NonNull BaseViewHolder<T> holder, final int position) {
    int realPosition = BannerUtils.getRealPosition(position, getListSize());
    bindData(holder, mList.get(realPosition), realPosition, getListSize());
  }

  @Override
  public final int getItemViewType(int position) {
    int realPosition = BannerUtils.getRealPosition(position, getListSize());
    return getViewType(realPosition);
  }

  @Override
  public final int getItemCount() {
    if (isCanLoop && getListSize() > 1) {
      return MAX_VALUE;
    } else {
      return getListSize();
    }
  }

  List<T> getData() {
    return mList;
  }

  void setData(List<? extends T> list) {
    if (null != list) {
      mList.clear();
      mList.addAll(list);
    }
  }

  void setCanLoop(boolean canLoop) {
    isCanLoop = canLoop;
  }

  void setPageClickListener(BannerViewPager2.OnPageClickListener pageClickListener) {
    mPageClickListener = pageClickListener;
  }

  int getListSize() {
    return mList.size();
  }

  protected int getViewType(int position) {
    return 0;
  }

  public boolean isCanLoop() {
    return isCanLoop;
  }

  /**
   * Generally,there is no need to override this method in subclasses.
   *
   * This method called by {@link #onCreateViewHolder(ViewGroup, int)} to create a default {@link
   * BaseViewHolder}
   *
   * @param parent The ViewGroup into which the new View will be added after it is bound to
   * an adapter position.
   * @param itemView Item View.
   * @param viewType The view type of the new View.
   * @return ViewHolder extends {@link BaseViewHolder}.
   */
  public BaseViewHolder<T> createViewHolder(@NonNull ViewGroup parent, View itemView,
                                                                 int viewType) {
    return new BaseViewHolder<>(itemView);
  }

  /**
   * @param holder The ViewHolder which should be updated to represent the contents of the
   * item at the given position in the data set.
   * @param data Current item data.
   * @param position Current item position.
   * @param pageSize Page size of BVP,equals {@link BaseBannerAdapter#getListSize()}.
   */
  protected abstract void bindData(BaseViewHolder<T> holder, T data, int position, int pageSize);

  /**
   * @param viewType The view type of the new View.
   * @return The item view layout.
   */
  public abstract @LayoutRes
  int getLayoutId(int viewType);
}
