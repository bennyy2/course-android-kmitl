package kmitl.lab07.benjarat58070079.mylazyinstagram.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import kmitl.lab07.benjarat58070079.mylazyinstagram.MainActivity;
import kmitl.lab07.benjarat58070079.mylazyinstagram.R;


class Holder extends RecyclerView.ViewHolder{
    public ImageView image;

    public Holder(View itemView){
        super(itemView);
        image = (ImageView) itemView.findViewById(R.id.image);

    }

}

//8.
public class PostAdapter extends RecyclerView.Adapter<Holder> {

    //which data u want to show
    String[] data = {
            "https://raw.githubusercontent.com/iangkub/gitdemo/master/cartoon/01.jpg",
            "https://raw.githubusercontent.com/iangkub/gitdemo/master/cartoon/02.jpg",
            "https://raw.githubusercontent.com/iangkub/gitdemo/master/cartoon/03.jpg",
            "https://raw.githubusercontent.com/iangkub/gitdemo/master/cartoon/04.jpg"
    };

    private Context context;

    public PostAdapter(Context context) {
        this.context = context;
    }


    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        //9.holder is each item
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.post_item, null, false);

        Holder holder = new Holder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        ImageView image = holder.image;
        //context get from activity
        Glide.with(context)
                .load(data[position])
                .into(image);

    }

    @Override
    public int getItemCount() {

        //to get how much data we hav
        return data.length;
    }
}
