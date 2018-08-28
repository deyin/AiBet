package com.github.aibet.models;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class MatchGroup extends ExpandableGroup<Match> {

    public MatchGroup(String title, List<Match> items) {
        super(title, items);
    }
}
