package com.seven.library.view.recycler.listener;

import java.io.Serializable;

/**
 * item长按事件
 * Created by Seven on 2017/3/10.
 */
public interface OnItemLongClickListener<Item extends Serializable> {

    void onItemLongClick(Item item, int position);
}
