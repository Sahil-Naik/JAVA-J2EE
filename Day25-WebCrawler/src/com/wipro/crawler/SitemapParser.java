package com.wipro.crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class SitemapParser {
    public static void main(String[] args) {
        String sitemapUrl = "http://localhost:9090/server-bank/bank/";
        Set<String> urls = new HashSet<>();

        try {
            Document document = Jsoup.connect(sitemapUrl).get();
            Elements locs = document.select("loc"); // Select all <loc> elements

            for (Element loc : locs) {
                urls.add(loc.text());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Total sub-URLs found in sitemap: " + urls.size());
    }
}