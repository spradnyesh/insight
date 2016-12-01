(ns insight.views
  (:require [re-frame.core :as rf]
            [insight.subs]))

(defn main-panel []
  (let [name (rf/subscribe [:name])]
    (fn []
      [:div "Hello from " @name])))
