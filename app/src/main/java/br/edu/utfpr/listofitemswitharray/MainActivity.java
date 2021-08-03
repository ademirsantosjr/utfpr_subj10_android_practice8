package br.edu.utfpr.listofitemswitharray;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listViewItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewItems = findViewById(R.id.listViewItems);

        populateListOfItems();
    }

    private void populateListOfItems() {
        String[] descriptions = getResources().getStringArray(R.array.descriptions);
        int[] quantities = getResources().getIntArray(R.array.quantities);

        ArrayList<Item> items = new ArrayList<>();

        for(int i = 0; i < descriptions.length; i++) {
           items.add(new Item(descriptions[i], quantities[i]));
        }

        ArrayAdapter<Item> adapter =
                new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1,
                        items);

        listViewItems.setAdapter(adapter);
    }
}