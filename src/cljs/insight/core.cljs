(ns insight.core
    (:require [reagent.core :as reagent]
              [re-frame.core :as re-frame]
              [re-frisk.core :refer [enable-re-frisk!]]
              [insight.events]
              [insight.subs]
              [insight.routes :as routes]
              [insight.views :as views]
              [insight.config :as config]))


(defn dev-setup []
  (when config/debug?
    (re-frame/clear-subscription-cache!)
    (enable-console-print!)
    (enable-re-frisk!)
    (println "dev mode")))

(defn mount-root []
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defn ^:export init []
  (routes/app-routes)
  (re-frame/dispatch-sync [:initialize-db])
  (dev-setup)
  (mount-root))
