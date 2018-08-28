package com.github.aibet.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.aibet.R;
import com.github.aibet.models.Match;
import com.github.aibet.models.MatchGroup;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

import java.util.List;

public class MatchAdapter extends ExpandableRecyclerViewAdapter<MatchAdapter.MatchGroupViewHolder, MatchAdapter.MatchChildViewHolder> {

    public MatchAdapter(List<? extends ExpandableGroup> groups) {
        super(groups);
    }

    @Override
    public MatchGroupViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.match_group, parent, false);
        return new MatchGroupViewHolder(view);
    }

    @Override
    public MatchChildViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.match_child, parent, false);
        return new MatchChildViewHolder(view);
    }

    @Override
    public void onBindChildViewHolder(MatchChildViewHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {
        MatchGroup matchGroup = (MatchGroup) group;
        Match match = matchGroup.getItems().get(childIndex);
        holder.init(match);
    }

    @Override
    public void onBindGroupViewHolder(MatchGroupViewHolder holder, int flatPosition, ExpandableGroup group) {
        MatchGroup matchGroup = (MatchGroup) group;
        holder.init(group);
    }

    public static class MatchGroupViewHolder extends GroupViewHolder {

        TextView title;

        public MatchGroupViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_title);
        }

        public void init(ExpandableGroup group) {
            title.setText(group.getTitle());
        }
    }

    public static class MatchChildViewHolder extends ChildViewHolder {

        TextView child;

        public MatchChildViewHolder(View itemView) {
            super(itemView);
            child = itemView.findViewById(R.id.tv_match_info);
        }

        public void init(Match match) {
            child.setText(match.getId());
        }
    }
}
