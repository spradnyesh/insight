(ns insight.events
    (:require [re-frame.core :as re-frame]
              [insight.db :as db]))

(re-frame/reg-event-db
 :initialize-db
 (fn  [_ _]
   db/default-db))

(re-frame/reg-event-db
 :set-active-panel
 (fn [db [_ active-panel]]
   (assoc db :active-panel active-panel)))

(re-frame/reg-event-db
 :add-user
 (fn [db [_ user]]
   (update-in db [:users] conj user)))
