package com.example.dgsdemo;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;

import java.util.Arrays;
import java.util.List;

@DgsComponent
public class ShowsDataFetcher {

    private final List<Show> showList = Arrays.asList(
            new Show("Stranger Things", 2016),
            new Show("Ozark", 2017),
            new Show("The Crown", 2016),
            new Show("Dead to Me", 2019)
    );

    @DgsQuery
    public List<Show> shows(@InputArgument String titleFilter) {
        if (titleFilter == null) {
            return showList;
        }

        return showList.stream().filter(show -> show.title().contains(titleFilter)).toList();
    }
}
