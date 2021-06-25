package cu.erno.example;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class AnotherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);

        // Get num an show a toast with it
        int num = getIntent().getIntExtra("num", -1);
        Toast.makeText(this, "Num = " + num + " from Activity", Toast.LENGTH_SHORT).show();

        // Create fragment passing num
        SimpleFragment simpleFragment = SimpleFragment.getInstance(num);

        // Setting the fragment
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction().replace(R.id.fragment, simpleFragment);
        transaction.commit();
    }
}
