(ns insight.db
  (:require [reagent.core :as r]))

(def app-db (r/atom {:name "re-frame"}))
