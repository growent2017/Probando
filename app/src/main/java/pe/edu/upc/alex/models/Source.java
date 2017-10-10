package pe.edu.upc.alex.models;

/**
 * Created by Usuario on 2/10/2017.
 */
import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.alex.network.ClearBitApi;

public class Source {
    private String id;
    private String name;
    private String description;
    private String url;
    private String category;
    private String language;
    private String country;
    private List<String> sortBysAvailable;

    public Source() {
    }

    public Source(String id, String name, String description, String url, String category, String language, String country, List<String> sortBysAvailable) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.url = url;
        this.category = category;
        this.language = language;
        this.country = country;
        this.sortBysAvailable = sortBysAvailable;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<String> getSortBysAvailable() {
        return sortBysAvailable;
    }

    public void setSortBysAvailable(List<String> sortBysAvailable) {
        this.sortBysAvailable = sortBysAvailable;
    } public String getUrlToLogo(){
        return ClearBitApi.getUrlToLogo(url);
    }
    public Bundle toBundle(){
        Bundle bundle = new Bundle();
        bundle.putString("id", id);
        bundle.putString("name", name);
        bundle.putString("description", description);
        bundle.putString("url", url);
        bundle.putString("category", category);
        bundle.putString("language", language);
        bundle.putString("country", country);
        bundle.putStringArrayList("sortBysAvailable", (ArrayList<String>) sortBysAvailable);
        return bundle;
    }
    public static Source from(Bundle bundle) {
        Source source = new Source();
        source.setId(bundle.getString("id"));
        source.setName(bundle.getString("name"));
        source.setDescription(bundle.getString("description"));
        source.setUrl(bundle.getString("url"));
        source.setCategory(bundle.getString("category"));
        source.setLanguage(bundle.getString("language"));
        source.setCountry(bundle.getString("country"));
        source.setSortBysAvailable(bundle.getStringArrayList("sortBysAvailable"));
        return source;
    }
    public static Source from(JSONObject jsonSource) {
        Source source = new Source();
        try {
            JSONArray jsonSortBysAvailable = jsonSource.getJSONArray("sortBysAvailable");
            List<String> sortBysAvailable = new ArrayList<>();
            for(int i = 0; i < jsonSortBysAvailable.length(); i++)
                sortBysAvailable.add(jsonSortBysAvailable.getString(i));

            source.setId(jsonSource.getString("id"));
            source.setName(jsonSource.getString("name"));
            source.setDescription(jsonSource.getString("description"));
            source.setUrl(jsonSource.getString("url"));
            source.setCategory(jsonSource.getString("category"));
            source.setLanguage(jsonSource.getString("language"));
            source.setCountry(jsonSource.getString("country"));
            source.setSortBysAvailable(sortBysAvailable);

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        return source;
    }

    public static List<Source> from(JSONArray jsonSources) {
        List<Source> sources = new ArrayList<>();
        for(int i = 0; i < jsonSources.length(); i++)
            try {
                sources.add(Source.from(jsonSources.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        return sources;
    }
}