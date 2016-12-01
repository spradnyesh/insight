(ns insight.core
    (:require [reagent.core :as r]
              [re-frame.core :as rf]
              [insight.events]
              [insight.views :as views]
              [insight.config :as config]))


(defn dev-setup []
  (when config/debug?
    (enable-console-print!)
    (println "dev mode")))

(defn mount-root []
  (r/render [views/main-panel] (.getElementById js/document "app")))

(defn ^:export init []
  (rf/dispatch-sync [:initialize-db])
  (dev-setup)
  (mount-root))
