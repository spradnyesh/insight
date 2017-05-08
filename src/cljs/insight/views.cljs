(ns insight.views
  (:require [re-frame.core :as rf]
            [insight.views.common :as vc]
            [insight.views.register :as vr]
            [insight.views.search :as vs]
            [insight.views.followup :as vf]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; main

(defn- panels [panel-name]
  [:div.container
   [vc/header]
   [:main
    [vc/tabs]
    (case panel-name
      :register-panel [vr/register-panel]
      :search-panel   [vs/search-panel]
      :followup-panel [vf/followup-panel]
      [:div])]
   [vc/footer]])

(defn show-panel [panel-name]
  [panels panel-name])

(defn main-panel []
  (let [active-panel (rf/subscribe [:active-panel])]
    (fn []
      [show-panel @active-panel])))
