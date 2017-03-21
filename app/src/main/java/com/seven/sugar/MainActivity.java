package com.seven.sugar;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;

import com.seven.library.base.activity.BaseActivity;
import com.seven.library.base.presenter.IPresenter;

import butterknife.BindView;


/**
 * MainActivity
 * Created by Seven on 2017/3/20.
 */
public class MainActivity extends BaseActivity {

    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottomNavigation;

    private MenuItem menuItem;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onViewCreatedFinish(Bundle saveInstanceState) {
        //默认 >3 的选中效果会影响ViewPager的滑动切换时的效果，故利用反射去掉
        BottomNavigationViewHelper.disableShiftMode(bottomNavigation);
        bottomNavigation.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.item_news:
                                viewPager.setCurrentItem(0);
                                break;
                            case R.id.item_lib:
                                viewPager.setCurrentItem(1);
                                break;
                            case R.id.item_find:
                                viewPager.setCurrentItem(2);
                                break;
                            case R.id.item_more:
                                viewPager.setCurrentItem(3);
                                break;
                        }
                        return false;
                    }
                });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (menuItem != null) {
                    menuItem.setChecked(false);
                } else {
                    bottomNavigation.getMenu().getItem(0).setChecked(false);
                }
                menuItem = bottomNavigation.getMenu().getItem(position);
                menuItem.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        //禁止ViewPager滑动
//        viewPager.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                return true;
//            }
//        });

        setupViewPager(viewPager);
    }

    @Override
    protected IPresenter createPresenter() {
        return null;
    }

    private void setupViewPager(ViewPager viewPager) {

        MainFragment fragment1 = new MainFragment();
        MainFragment fragment2 = new MainFragment();
        MainFragment fragment3 = new MainFragment();
        MainFragment fragment4 = new MainFragment();
        Bundle args1 = new Bundle();
        args1.putString("info", "新闻");
        Bundle args2 = new Bundle();
        args2.putString("info", "图书");
        Bundle args3 = new Bundle();
        args3.putString("info", "发现");
        Bundle args4 = new Bundle();
        args4.putString("info", "更多");
        fragment1.setArguments(args1);
        fragment2.setArguments(args2);
        fragment3.setArguments(args3);
        fragment4.setArguments(args4);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(fragment1);
        adapter.addFragment(fragment2);
        adapter.addFragment(fragment3);
        adapter.addFragment(fragment4);
        viewPager.setAdapter(adapter);
    }


}
