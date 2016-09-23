package com.sheehan.samples.makingsense.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sheehan.samples.makingsense.R;
import com.sheehan.samples.makingsense.sensor.value.SensorValue;

import java.util.List;

/**
 * Created by izm520 on 9/21/16.
 */
public class SensorAdapter extends RecyclerView.Adapter<SensorAdapter.CustomViewHolder> {
    private List<SensorValue> mSensorValueList;
    private Context mContext;

    public SensorAdapter(Context context, List<SensorValue> sensorValueList) {
        this.mSensorValueList = sensorValueList;
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
        SensorValue sensorValue = mSensorValueList.get(i);

        //Setting text view title
        customViewHolder.textViewTitle.setText(sensorValue.getType().getName());
        if (sensorValue.getValue() != null && sensorValue.getValue().size() > 0) {
            customViewHolder.mHertzTextView.setText(String.valueOf(sensorValue.getValue().size()));
        } else {
            customViewHolder.mHertzTextView.setText("N/A");
        }
    }

    @Override
    public int getItemCount() {
        return (null != mSensorValueList ? mSensorValueList.size() : 0);
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewTitle;
        public TextView mHertzTextView;

        public CustomViewHolder(View view) {
            super(view);
            //this.imageView = (ImageView) view.findViewById(R.id.thumbnail);
            this.textViewTitle = (TextView) view.findViewById(R.id.title);
            mHertzTextView = (TextView) view.findViewById(R.id.hertz_labelTextView);
        }
    }
}
