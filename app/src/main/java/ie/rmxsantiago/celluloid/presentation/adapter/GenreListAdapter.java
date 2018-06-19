package ie.rmxsantiago.celluloid.presentation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import ie.rmxsantiago.celluloid.R;
import ie.rmxsantiago.celluloid.data.database.model.Genre;

public class GenreListAdapter extends RecyclerView.Adapter<GenreListAdapter.ViewHolder> {
    private List<Genre> listOfGenres;
    private Context context;

    public GenreListAdapter(List<Genre> listOfGenres) {
        this.listOfGenres = listOfGenres;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_genre_list, parent, false);

        return new GenreListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
         Genre genre = listOfGenres.get(position);
         holder.genreTitle.setText(genre.getName());
    }

    @Override
    public int getItemCount() {
        return listOfGenres.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView genreTitle;

        public ViewHolder(View view) {
            super(view);
            this.genreTitle = view.findViewById(R.id.txtviewGenreName);
        }
    }
}
