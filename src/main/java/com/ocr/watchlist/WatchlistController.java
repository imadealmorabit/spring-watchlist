package com.ocr.watchlist;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class WatchlistController {

    private List<WatchlistItem> watchlistItems = new ArrayList<WatchlistItem>();
    private static int index = 1;

    @GetMapping("/watchlistItemForm")
    public ModelAndView showWatchlistItemForm(){

        String viewName = "watchlistItemForm";

        Map<String,Object> model = new HashMap<>();

        model.put("watchlistItem", new WatchlistItem());

        return new ModelAndView(viewName,model);
    }

    @GetMapping("/watchlist")
    public ModelAndView getWatchlist(){

        watchlistItems.clear();
        watchlistItems.add(new WatchlistItem(index++, "Lion King","8.5","high","Hakuna matata!"));
        watchlistItems.add(new WatchlistItem(index++, "Frozen","7.5","medium","Let it go!"));
        watchlistItems.add(new WatchlistItem(index++, "Cars","7.1","low","Go go go!"));
        watchlistItems.add(new WatchlistItem(index++, "Wall-E","8.4","high","You are crying!"));

        String viewName = "watchlist";

        Map<String,Object> model = new HashMap<>();

        model.put("watchlistItems", watchlistItems);
        model.put("numberOfMovies", watchlistItems.size());

        return new ModelAndView(viewName,model);
    }
}
