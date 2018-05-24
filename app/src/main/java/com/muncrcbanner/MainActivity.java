package com.muncrcbanner;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import java.util.Timer;
import java.util.TimerTask;


//这里有个注意的地方:activity_main的rc高度是100dp item_munc的高度必须和rc高度一致 需要做适配
public class MainActivity extends AppCompatActivity {
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                default:
                    break;
            }
        }
    };
    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BannerAdapter adapter = new BannerAdapter(this);
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
        final MuncLinearLayoutManager layoutManager = new MuncLinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
//      recyclerView.scrollToPosition(10);//这里有需求的话可以 上来就先定位到某个位置

        //对齐位置
        PagerSnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);

        timer = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                //每次需要执行的代码放到这里面。
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        recyclerView.smoothScrollToPosition(layoutManager.findFirstVisibleItemPosition() + 1);
                    }
                });
            }
        };
        timer.schedule(task, 3000, 3000);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (timer != null) {
            timer.cancel();
        }
        handler.removeCallbacksAndMessages(null);
    }
}
