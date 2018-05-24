package com.muncrcbanner;

import android.content.Context;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class BannerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;

    public BannerAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_munc, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //图片同理 根据索引拿bean集合的图片地址  这里简化
        if (holder instanceof ViewHolder) {
            //假如服务器返回的集合大小为10 那么10个一循环 故显示position的时候: 就是0-9 0-9 0-9...循环显示 处理点击事件的时候也同理 (position%10)显示
            ((ViewHolder) holder).tv1.setText("RecyclerViewBanner Munc1 CurrentIndex：" + position % 10);
            ((ViewHolder) holder).tv2.setText("RecyclerViewBanner Munc2 CurrentIndex：" + position % 10);
        }
    }


    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv1, tv2;

        public ViewHolder(View itemView) {
            super(itemView);
            tv1 = (TextView) itemView.findViewById(R.id.tv1);
            tv2 = (TextView) itemView.findViewById(R.id.tv2);
        }

    }


}
