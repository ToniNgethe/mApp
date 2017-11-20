package app.feed.mercyapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/**
 * Created by toni on 11/19/17.
 */

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.EventsViewHolder> {

    private Context ctx;
    protected int lastPosition = -1;
    public EventsAdapter(Context ctx){
        this.ctx = ctx;
    }

    @Override
    public EventsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new EventsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_events, null));
    }

    @Override
    public void onBindViewHolder(EventsViewHolder holder, int position) {

        Animation animation = AnimationUtils.loadAnimation(ctx, (position > lastPosition) ?
                R.anim.up_from_bottom : R.anim.down_from_top);
        holder.itemView.startAnimation(animation);

        holder.setImage(ctx);

    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public static class EventsViewHolder extends RecyclerView.ViewHolder{

        private View mView;

        public EventsViewHolder(View itemView) {
            super(itemView);
            this.mView = itemView;
        }

        void setImage(final Context ctx){
            final ImageView iv = mView.findViewById(R.id.event_poster);
            new android.os.Handler().post(new Runnable() {
                @Override
                public void run() {
                    Glide
                            .with(ctx)
                            .load("https://firebasestorage.googleapis.com/v0/b/sliceapp-b4487.appspot.com/o/Events%2Fimage%3A100997_1510301640409?alt=media&token=1b7ce645-9a65-48fe-a758-fd0d3d829f68")
                            .diskCacheStrategy(DiskCacheStrategy.ALL)   // cache both original & resized image
                            .crossFade()
                            .into(iv);
                }
            });

        }
    }
}
