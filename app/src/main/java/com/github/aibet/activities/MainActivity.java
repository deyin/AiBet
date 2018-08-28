package com.github.aibet.activities;

import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.github.aibet.R;
import com.github.aibet.adapters.MatchAdapter;
import com.github.aibet.models.Match;
import com.github.aibet.models.MatchGroup;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SwipeRefreshLayout mSwipeRefresh;

    private RecyclerView mRecyclerView;
    private MatchAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initSwipeRefresh();

        mRecyclerView = findViewById(R.id.rv_matches);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        mAdapter = new MatchAdapter(getMatchGroups());
        mRecyclerView.setAdapter(mAdapter);

    }

    private List<MatchGroup> getMatchGroups() {
        List<MatchGroup> groups = new ArrayList<>();

        groups.add(getMatchGroup());
        groups.add(getMatchGroup2());

        Collections.shuffle(groups);

        return groups;
    }

    @NonNull
    private MatchGroup getMatchGroup() {
        List<Match> matches = new ArrayList<>();
        matches.add(new Match("001"));
        matches.add(new Match("002"));
        matches.add(new Match("003"));

        return new MatchGroup("08/28", matches);
    }

    @NonNull
    private MatchGroup getMatchGroup2() {
        List<Match> matches = new ArrayList<>();
        matches.add(new Match("004"));
        matches.add(new Match("005"));
        matches.add(new Match("006"));

        return new MatchGroup("08/29", matches);
    }

    private void initSwipeRefresh() {
        mSwipeRefresh = findViewById(R.id.swipe_refresh_matches);
        mSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh();
                mSwipeRefresh.setRefreshing(false);
            }
        });
    }

    private void refresh() {
        getMatchGroups();
        mAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mAdapter.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mAdapter.onRestoreInstanceState(savedInstanceState);
    }
}
