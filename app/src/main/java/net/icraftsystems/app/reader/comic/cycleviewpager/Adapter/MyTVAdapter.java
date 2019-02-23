package net.icraftsystems.app.reader.comic.cycleviewpager.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import net.icraftsystems.app.reader.comic.cycleviewpager.Model.MoviesModel;
import net.icraftsystems.app.reader.comic.cycleviewpager.R;

import java.util.List;

public class MyTVAdapter extends PagerAdapter {

    Context context;
    List<MoviesModel> moviesModelList;


    public MyTVAdapter(Context context, List<MoviesModel> moviesModelList) {
        this.context = context;
        this.moviesModelList = moviesModelList;
    }



    @Override
    public int getCount() {
        return moviesModelList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view.equals(o);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_item, container, false);

        ImageView movie_image = view.findViewById(R.id.movie_image);
        TextView movie_title = view.findViewById(R.id.movie_title);
        TextView movie_description = view.findViewById(R.id.movie_description);

        FloatingActionButton btn_fav = view.findViewById(R.id.btn_fav);

        movie_image.setImageResource(moviesModelList.get(position).getImage());
        movie_title.setText(moviesModelList.get(position).getName());
        movie_description.setText(moviesModelList.get(position).getDescription());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(context, ""+moviesModelList.get(position).getName(), Toast.LENGTH_LONG).show();
            }
        });

        btn_fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Your Favourite is "+moviesModelList.get(position).getName(), Toast.LENGTH_LONG).show();
            }
        });

     container.addView(view);


     return view;
    }
}
