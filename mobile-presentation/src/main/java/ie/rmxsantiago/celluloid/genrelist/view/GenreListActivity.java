package ie.rmxsantiago.celluloid.genrelist.view;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ie.rmxsantiago.celluloid.R;
import ie.rmxsantiago.celluloid.genrelist.adapter.GenreListAdapter;
import ie.rmxsantiago.celluloid.genrelist.viewmodel.GenreViewModel;
import ie.rmxsantiago.celluloid.genrelist.viewmodel.GenreViewModelFactory;
import ie.rmxsantiago.dependencyinjection.RepositoryFactory;
import ie.rmxsantiago.domain.repositories.GenreRepository;

/**
 * @author Rafael Santiago (@rmxsantiago)
 * @version 0.1
 */
public class GenreListActivity extends AppCompatActivity {
    private static final String TAG = "GenreListActivity";
    private GenreViewModel genreViewModel;


    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.recyclerListOfGenre);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);



        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        setViewModels();
        setUI();
    }

    private void setUI() {
        genreViewModel.getGenres().observe(this, list -> {
            // Update UI
            recyclerView.setAdapter(new GenreListAdapter(list));
        });
    }

    private void setViewModels() {
        GenreRepository genreRepository = RepositoryFactory.getGenreRepository(getApplication());
        GenreViewModelFactory factory = new GenreViewModelFactory(genreRepository);

        genreViewModel = ViewModelProviders.of(this, factory).get(GenreViewModel.class);
        genreViewModel.init();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
