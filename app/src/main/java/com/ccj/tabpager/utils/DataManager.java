package com.ccj.tabpager.utils;

import android.content.Context;
import android.util.Log;

import com.ccj.tabpager.R;
import com.ccj.tabpager.bean.DemoModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class DataManager {

    public static List<DemoModel> loadData(Context context) {
        return loadData(context, 200);
    }

    /**
     * 模拟加载数据的操作
     */
    public static List<DemoModel> loadData(Context context, int num) {
        List<String> originList = Arrays.asList(context.getResources().getStringArray(R.array.country_names));
        List<DemoModel> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            int type = (int) (Math.random() * 3);
            DemoModel model = new DemoModel();
            switch (type) {
                case 0:
                    model.type = 1;
                    model.content = originList.get(i);
                    break;
                case 1:
                    model.type = 3;
                    model.content = originList.get(i);
                    break;
                case 2:
                    model.type = 2;
                    model.content = originList.get(i);
                    break;
                default:
            }
            list.add(model);
        }

        for (int i = 0; i < list.size(); i++) {
            Log.d("DataManager", "[" + i + "]" + list.get(i).content);
        }
        return list;
    }
}
