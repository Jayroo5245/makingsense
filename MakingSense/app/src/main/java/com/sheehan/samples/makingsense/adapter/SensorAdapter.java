package com.sheehan.samples.makingsense.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sheehan.samples.makingsense.R;
import com.sheehan.samples.makingsense.sensor.base.SensorClass;

import java.util.List;

/**
 * Created by izm520 on 9/21/16.
 */
public class SensorAdapter extends RecyclerView.Adapter<SensorAdapter.CustomViewHolder> {
        private List<SensorClass> feedItemList;
        private Context mContext;

        public SensorAdapter(Context context, List<SensorClass> feedItemList) {
            this.feedItemList = feedItemList;
            this.mContext = context;
        }

        @Override
        public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sensor_list_item, null);

            CustomViewHolder viewHolder = new CustomViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(CustomViewHolder customViewHolder, int i) {
            SensorClass sensorClass = feedItemList.get(i);

            //Setting text view title
            //customViewHolder.textView.setText(Html.fromHtml(feedItem.getTitle()));
        }

        @Override
        public int getItemCount() {
            return (null != feedItemList ? feedItemList.size() : 0);
        }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        protected ImageView imageView;
        protected TextView textView;

        public CustomViewHolder(View view) {
            super(view);
            //this.imageView = (ImageView) view.findViewById(R.id.thumbnail);
            this.textView = (TextView) view.findViewById(R.id.title);
        }
    }
}
