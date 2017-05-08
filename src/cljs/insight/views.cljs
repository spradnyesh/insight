(ns insight.views
  (:require [re-frame.core :as rf]
            [insight.views.common :as vc]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; views

(defn register-panel []
  (let [name (rf/subscribe [:name])]
    (fn []
      [:div "This is the Register Page."])))

(defn search-panel []
  (fn []
    [:div "This is the Search Page."]))

(defn followup-panel []
  (fn []
    [:div "This is the followup Page."]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; main

(defn- panels [panel-name]
  [:div.container
   [vc/header]
   [:main
    [vc/tabs]
    (case panel-name
      :register-panel [register-panel]
      :search-panel   [search-panel]
      :followup-panel [followup-panel]
      [:div])]
   [vc/footer]])

(defn show-panel [panel-name]
  [panels panel-name])

(defn main-panel []
  (let [active-panel (rf/subscribe [:active-panel])]
    (fn []
      [show-panel @active-panel])))
