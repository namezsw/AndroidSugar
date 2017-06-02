package com.seven.sugar.main.di.component;


import com.seven.library.base.di.scope.ActivityScope;
import com.seven.sugar.base.di.component.AppComponent;
import com.seven.sugar.main.di.module.MainModule;
import com.seven.sugar.main.ui.activity.MainActivity;

import dagger.Component;


@ActivityScope
@Component(modules = MainModule.class, dependencies = AppComponent.class)
public interface MainComponent {
    void inject(MainActivity activity);
}
