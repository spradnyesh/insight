(ns insight.views.register
  (:require [re-frame.core :as rf]
            [insight.views.common :as vc]))

(defn register-panel []
  (let [name (rf/subscribe [:name])]
    (fn []
      [:div "This is the Register Page."])))
