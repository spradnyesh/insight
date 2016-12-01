(ns insight.subs
    (:require-macros [reagent.ratom :refer [reaction]])
    (:require [re-frame.core :as rf]))

(rf/reg-sub
 :keys
 (fn [db [_ & keys]] (get-in @db keys)))
