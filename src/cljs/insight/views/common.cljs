(ns insight.views.common
  (:require [re-frame.core :as rf]))

(defn header []
  [:header [:h1 "Insight"]])

(defn tabs []
  [:div.row.tabs
   [:div.col.s12
    [:ul.tabs
     [:li.tab.col.s3 [:a [:a {:href "#/"} "Home"]]]
     [:li.tab.col.s3 [:a [:a {:href "#/register"} "Register"]]]
     [:li.tab.col.s3 [:a [:a {:href "#/search"} "Search"]]]]]])

(defn footer []
  ;; http://materializecss.com/footer.html
  [:footer.page-footer
   [:div.container
    [:div.row [:h5 "Developed by Gryff!n Software Development LLP"]
     [:h6 "All rights reserved"]]]])
