(ns insight.views
  (:require [re-frame.core :as rf]
            [insight.views.common :as vc]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; views

(defn home-panel []
  (let [name (rf/subscribe [:name])]
    (fn []
      [:div "This is the Home Page."])))

(defn register-panel []
  (fn []
    [:div "This is the Register Page."]))

(defn search-panel []
  (fn []
    [:div "This is the Search Page."]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; main

(defn- panels [panel-name]
  [:div.container
   [vc/header]
   [:main
    [vc/tabs]
    (case panel-name
      :home-panel [home-panel]
      :register-panel [register-panel]
      :search-panel [search-panel]
      [:div])]
   [vc/footer]])

(defn show-panel [panel-name]
  [panels panel-name])

(defn main-panel []
  (let [active-panel (rf/subscribe [:active-panel])]
    (fn []
      [show-panel @active-panel])))
