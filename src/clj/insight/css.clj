(ns insight.css
  (:require [garden.def :refer [defstyles]]))

(defstyles screen
  [:main {:min-height "50em"}]
  [:footer {:height "8em"}]
  [:.submit-buttons {:display "flex"
                     :justify-content "space-between"}])
