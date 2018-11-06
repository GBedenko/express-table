package com.bedenko.genaro.expresstable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.bedenko.genaro.expresstable.models.Candidate;
import com.bedenko.genaro.expresstable.models.CandidateAdaptor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchResultsActivity extends AppCompatActivity {

    private ListView listView;
    private String[] candidateNames;

    private String[] candidateDetails;
    public static int[] candidatePhotos = {
            R.drawable.expresstable_logo,
            R.drawable.expresstable_logo,
            R.drawable.expresstable_logo,
            R.drawable.expresstable_logo,
            R.drawable.expresstable_logo,
            R.drawable.expresstable_logo,
            R.drawable.expresstable_logo,
            R.drawable.expresstable_logo
    };
    private ArrayList<Candidate> candidates = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        candidateNames = getResources().getStringArray(R.array.candidateNames);
        candidateDetails = getResources().getStringArray(R.array.candidateDetails);
        generateCandidates();

        listView = findViewById(R.id.listViewComplex);
        listView.setAdapter(new CandidateAdaptor(this, R.layout.list_item, candidates));
        listView.setOnItemClickListener(

                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        Toast.makeText(getBaseContext(), "You clicked " + candidates.get(position), Toast.LENGTH_SHORT).show();
                    }
                }
        );


        List<String> candidateNamesNew = new ArrayList<>(Arrays.asList(candidateNames));
        ArrayAdapter<String> arrayAdapterNew = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, candidateNamesNew);
        listView.setAdapter(arrayAdapterNew);
        arrayAdapterNew.add("New Someone");
        arrayAdapterNew.notifyDataSetInvalidated();
    }

    private void generateCandidates() {

        for (int i = 0; i < candidatePhotos.length; i++) {
            candidates.add(new Candidate(candidateNames[i], candidateDetails[i], candidatePhotos[i]));
        }
    }
}
