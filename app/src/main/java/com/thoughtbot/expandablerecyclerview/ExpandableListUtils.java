package com.github.aibet.utils;

import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;

public class ExpandableListUtils {

    public static void notifyGroupDataChanged(ExpandableRecyclerViewAdapter adapter) {
        adapter.expandableList.expandedGroupIndexes = new boolean[adapter.getGroups().size()];
        for (int i = 0; i < adapter.getGroups().size(); i++) {
            adapter.expandableList.expandedGroupIndexes[i] = false;
        }
    }
}