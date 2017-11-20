package app.feed.mercyapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

/**
 * Created by toni on 11/19/17.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {
    private Context ctx;

    protected int lastPosition = -1;
    public HomeAdapter(Context ctx){
        this.ctx = ctx;
    }
    @Override
    public HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HomeViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.rows, null));
    }

    @Override
    public void onBindViewHolder(HomeViewHolder holder, int position) {
        Animation animation = AnimationUtils.loadAnimation(ctx, (position > lastPosition) ?
                R.anim.up_from_bottom : R.anim.down_from_top);
        holder.itemView.startAnimation(animation);
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public static class HomeViewHolder extends RecyclerView.ViewHolder{

        public HomeViewHolder(View itemView) {
            super(itemView);
        }
    }
}
