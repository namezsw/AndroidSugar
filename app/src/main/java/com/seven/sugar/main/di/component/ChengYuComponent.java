package com.seven.sugar.main.di.component;


import com.seven.library.base.di.scope.ActivityScope;
import com.seven.sugar.base.di.component.AppComponent;
import com.seven.sugar.main.di.module.ChengYuModule;
import com.seven.sugar.main.ui.activity.ChengYuActivity;

import dagger.Component;


@ActivityScope
@Component(modules = ChengYuModule.class, dependencies = AppComponent.class)
public interface ChengYuComponent {
    void inject(ChengYuActivity activity);
}
