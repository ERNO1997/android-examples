package cu.erno.example;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import cu.erno.example.adapter.OnItemClickListener;
import cu.erno.example.adapter.RecyclerViewAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Load recyclerView
        RecyclerView recycler = findViewById(R.id.recycler);

        // Create the adapter and set the items
        RecyclerViewAdapter adapter = new RecyclerViewAdapter();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            list.add(i);
        }
        adapter.submitList(list);
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int num) {
                Intent intent = new Intent(MainActivity.this, AnotherActivity.class);
                intent.putExtra("num", num);
                startActivity(intent);
            }
        });

        // Get ready the list
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(adapter);
    }
}
