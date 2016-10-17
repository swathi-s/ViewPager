package com.example.swathi.viewpager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.test.suitebuilder.TestMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by user on 10/17/2016.
 */

public class CustomSwipeAdapter extends PagerAdapter {

    private int[] image_resources = {R.drawable.ford,R.drawable.honda,R.drawable.jeep,R.drawable.moon_lander,R.drawable.porche,R.drawable.rust_bucket,R.drawable.toyoto};

    private Context context;

    private LayoutInflater layoutInflater;

    public CustomSwipeAdapter(Context context)
    {
        this.context = context;
    }
    @Override
    public int getCount() {
        return image_resources.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == (LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View item_view = layoutInflater.inflate(R.layout.swipe_layout,container,false);

        ImageView imageView = (ImageView) item_view.findViewById(R.id.image_view);

        TextView textView = (TextView) item_view.findViewById(R.id.image_count);

        imageView.setImageResource(image_resources[position]);

        textView.setText("Image : "+position);

        container.addView(item_view);

        return item_view;

        //return super.instantiateItem(container, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }
}
