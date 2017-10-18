package com.seven.library.view.recycler.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.seven.library.view.recycler.BaseViewHolder;

import java.io.Serializable;
import java.util.List;

/**
 * 加载更多适配器
 * Created by Seven on 2017/3/10.
 */
public abstract class LoadMoreAdapter<Item extends Serializable, VH extends BaseViewHolder> extends BaseAdapter<Item, VH> {
    private static final int TYPE_FOOTER = 0xBB;

    private int mFooterSize = 0;
    private View mFooterView;

    private int viewType = 0;
    private VH holder;

    public LoadMoreAdapter(Context context, List<Item> items) {
        super(context, items);
    }

    /**
     * 设置多布局的viewType
     *
     * @param position 下标
     * @return viewType
     */
    public int getMultiItemViewType(int position) {
        return 0;
    }

    /**
     * 添加尾部
     *
     * @param view 尾部布局
     */
    public void addFooter(View view) {
        mFooterView = view;
        mFooterSize = 1;
    }

    @Override
    public final int getItemViewType(int position) {
        if (position == getItemCount() - 1)//最后一个位置
        {
            viewType = TYPE_FOOTER;
        } else {
            viewType = getMultiItemViewType(position);
        }
        return viewType;
    }

    @Override
    public int getItemCount() {
        return super.getItemCount() + mFooterSize;
    }


    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_FOOTER) {
            holder = (VH) new FooterViewHolder(mFooterView);
        } else {
            holder = super.onCreateViewHolder(parent, viewType);
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        if (!(holder instanceof FooterViewHolder)) {
            super.onBindViewHolder(holder, position);
        }
    }

    /**
     * 尾部视图
     */
    static class FooterViewHolder extends BaseViewHolder {

        public FooterViewHolder(View itemView) {
            super(itemView);
//            itemView.setVisibility(View.VISIBLE);
        }
    }
}
