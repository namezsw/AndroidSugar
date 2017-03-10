package com.seven.library.view.recycler.listener;

import java.io.Serializable;

/**
 * item点击事件
 * Created by Seven on 2017/3/10.
 */
public interface OnItemClickListener<Item extends Serializable> {

    void onItemClick(Item item, int position);
}
