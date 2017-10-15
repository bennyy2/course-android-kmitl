package kmitl.lab07.benjarat58070079.mylazyinstagram.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import kmitl.lab07.benjarat58070079.mylazyinstagram.R;
import kmitl.lab07.benjarat58070079.mylazyinstagram.model.ListPosts;


class Holder extends RecyclerView.ViewHolder{
    public ImageView image;

    public TextView like;
    public TextView comment;

    public Holder(View itemView){
        super(itemView);
        image = (ImageView) itemView.findViewById(R.id.image);
        like = (TextView) itemView.findViewById(R.id.like);
        comment = (TextView) itemView.findViewById(R.id.comment);



    }

}

//8.
public class PostAdapter extends RecyclerView.Adapter<Holder> {

    //which data u want to show
    private List<ListPosts> data;

    private Context context;

    public PostAdapter(Context context) {
        this.context = context;
        data = new ArrayList<>();
    }

    public void setData(List<ListPosts> data) {
        this.data = data;
    }


    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        //9.holder is each item
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.post_item, null);

        Holder holder = new Holder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        String url = data.get(position).getUrl();
        String getlike = data.get(position).getLike();
        String getcomment = data.get(position).getComment();
        //context get from activity
        Glide.with(context)
                .load(url)
                .into(holder.image);

        TextView like = holder.like;
        TextView comment = holder.comment;
        like.setText(getlike);
        comment.setText(getcomment);

    }

    @Override
    public int getItemCount() {
        return this.data.size();
    }
}
