package com.seven.sugar.base.di.component;

import com.google.gson.Gson;
import com.seven.library.base.di.component.BaseComponent;
import com.seven.library.base.di.scope.AppScope;
import com.seven.sugar.base.di.module.ApiModule;
import com.seven.sugar.base.retrofit.api.JuHeApi;

import dagger.Component;

/**
 * Created by Seven on 2017/4/10.
 */

@AppScope
@Component(modules = {ApiModule.class}, dependencies = BaseComponent.class)
public interface AppComponent {

    Gson gson();

    JuHeApi juheApi();
}
