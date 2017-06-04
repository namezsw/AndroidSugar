package com.seven.sugar.chengyu.di.component;


import com.seven.library.base.di.scope.ActivityScope;
import com.seven.sugar.base.di.component.AppComponent;
import com.seven.sugar.chengyu.di.module.ChengYuModule;
import com.seven.sugar.chengyu.ui.ChengYuActivity;
import com.seven.sugar.main.ui.fragment.ChengYuFragment;

import dagger.Component;


@ActivityScope
@Component(modules = ChengYuModule.class, dependencies = AppComponent.class)
public interface ChengYuComponent {
    void inject(ChengYuActivity activity);

    void inject(ChengYuFragment fragment);
}
