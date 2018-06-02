package ie.rmxsantiago.celluloid.presentation.view;

import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;
import ie.rmxsantiago.celluloid.R;
import ie.rmxsantiago.celluloid.data.database.model.Genre;
import ie.rmxsantiago.celluloid.presentation.viewmodel.GenreViewModel;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * @author Rafael Santiago (@rmxsantiago)
 * @version 0.1
 */
public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private GenreViewModel genreViewModel;

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textView = findViewById(R.id.txtView);


        FloatingActionButton fab = (com.google.android.material.floatingactionbutton.FloatingActionButton) findViewById(R.id.fab);
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
            String text = "";
            for (Genre genre: list) {
                text += genre.getName() + "\n";
            }

            Log.d(TAG, text);
            textView.setText(text);
        });
    }

    private void setViewModels() {
        genreViewModel = ViewModelProviders.of(this).get(GenreViewModel.class);
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
