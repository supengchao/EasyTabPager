package com.ccj.tabpager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;

import com.ccj.tabpager.view.ZDMSlidingTab;


/**
 *
 * slidingview和recycleView的建造类。<br>
 * <code>
 *      builder = new ZDMListConfigBuilder(this)<br>
        .setVpager(vpager)<br>
        .setVtab(vtab)<br>
        .setRecycleAdapter(new TestAdapter(meiZhi, this))<br>
        .addTab((RecyclerView) inflater.inflate(R.layout.vpager, null),"标-题1")<br>
        .addTab((RecyclerView) inflater.inflate(R.layout.vpager, null),"标-题2")<br>
        .addTab((RecyclerView) inflater.inflate(R.layout.vpager, null),"标-题3")<br>
        .addTab((RecyclerView) inflater.inflate(R.layout.vpager, null),"标-题4")<br>
        .addTab((RecyclerView) inflater.inflate(R.layout.vpager, null),"标-题5")<br>
        .show();<br>
 *<br>
 *     </>
 * Created by ccj on 2017/3/21.
 */

public class ZDMListConfigBuilder {

    private ListConfig config;
    private ZDMSlidingTab vtab;
    private ViewPager vpager;

    public TabItem getTabItem(int position){

        return config.getTabs().get(position);

    };


    public ZDMListConfigBuilder(Context context) {
        config = new ListConfig(context);
    }

    /**
     * @param view 每一个pager的view
     * @param data 每一个pager对应的data
     * @param recycleAdapter 每一个pager对应的 adapter
     * @param positon pager的位置
     * @param title pager的title
     * @param swipRes swipLayout的Id
     * @param revrRes recycleView的Id
     * @param onSwipRefreshListener 刷新回调借口<br>
     * @return
     */
//    public ZDMListConfigBuilder addTab(View view,List data,RecyclerView.Adapter recycleAdapter, int positon, String title, int swipRes, int revrRes, OnSwipRefreshListener onSwipRefreshListener) {
//        config.addTab(view,data,recycleAdapter, positon,title,swipRes,revrRes,onSwipRefreshListener);
//        return this;
//    }

    /**
     * 设置setRecycleAdapter
     * @param baseRecycleAdapter
     * @return
     */

    public ZDMListConfigBuilder setRecycleAdapter(RecyclerView.Adapter baseRecycleAdapter) {
        config.addRecycleAdapter(baseRecycleAdapter);
        return this;
    }


    /**
     * 设置ZDMSlidingTab
     * @param vtab
     * @return
     */
    public ZDMListConfigBuilder setVtab(ZDMSlidingTab vtab) {
        this.vtab = vtab;
        return this;
    }

    /**
     * 设置 viewpager
     * @param vpager
     * @return
     */
    public ZDMListConfigBuilder setVpager(ViewPager vpager) {
        this.vpager = vpager;
        return this;
    }

    /**
     * 展示
     * @return
     */
    public ZDMListConfigBuilder show() {
        vpager.setAdapter(config.createInPagerAdapter());
        vtab.setViewPager(vpager);
        return this;
    }


}
