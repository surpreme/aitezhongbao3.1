package com.aite.a.adapter;

import android.content.Context;
import androidx.viewpager.widget.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * 首页顶部
 * Created by mayn on 2018/6/4.
 */

public class HomeTopAdapter extends PagerAdapter {
    private Context mcontext;
    private List<View> TopViews;

    public HomeTopAdapter(Context mcontext, List<View> topViews) {
        this.mcontext = mcontext;
        TopViews = topViews;
    }

    @Override
    public void finishUpdate(ViewGroup container) {
        super.finishUpdate(container);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(TopViews.get(position));
        return TopViews.get(position);
    }

    @Override
    public int getCount() {
        return TopViews.size();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
//        super.destroyItem(container, position, object);
        container.removeView(TopViews.get(position));
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
