(ns insight.views.register
  (:require [reagent.core :as r]
            [re-frame.core :as rf]
            [bouncer.core :as b]
            [bouncer.validators :as v]
            [cljs-time.format :as ctf]
            [insight.views.common :as vc]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; helper functions

(defn validate [state]
  (b/validate state {:fname v/required
                     :lname v/required
                     :email [v/required v/email]
                     :phone v/required
                     :dob [v/required (v/datetime (:date ctf/formatters))]
                     :addr v/required}))

(defn show-errors [errors])

(defn submit [state])

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; view

(defn register-panel []
  (let [state (r/atom {})]
    (fn []
      [:div.container
       [:form
        [:div.row
         [:div.input-field.col.s6
          [:input {:type "text"
                   :placeholder "First Name"
                   :value (:fname @state)
                   :on-change #(swap! state assoc :fname (.. % -target -value))}]]
         [:div.input-field.col.s6
          [:input {:type "text"
                   :placeholder "Last Name"
                   :value (:lname @state)
                   :on-change #(swap! state assoc :lname (.. % -target -value))}]]]
        [:div.row
         [:div.input-field.col.s6
          [:input {:type "email"
                   :placeholder "Email"
                   :value (:email @state)
                   :on-change #(swap! state assoc :email (.. % -target -value))}]]
         [:div.input-field.col.s6
          [:input {:type "text"
                   :placeholder "Phone Number"
                   :value (:phone @state)
                   :on-change #(swap! state assoc :phone (.. % -target -value))}]]]
        [:div.row
         [:div.input-field.col.s6
          [:input {:type "date"
                   :placeholder "Date of Birth"
                   :value (:dob @state)
                   :on-change #(swap! state assoc :dob (.. % -target -value))}]]
         [:div.input-field.col.s6
          [:input {:type "text"
                   :placeholder "Occupation"
                   :value (:occ @state)
                   :on-change #(swap! state assoc :occ (.. % -target -value))}]]]
        [:div.row
         [:div.input-field.col.s12
          [:textarea.materialize-textarea
           {:placeholder "Address"
            :value (:addr @state)
            :on-change #(swap! state assoc :addr (.. % -target -value))}]]]
        [:div.section.submit-buttons
         [:button.btn.waves-effect.waves-light
          {:type "button"
           :on-click (fn [e]
                       (let [[errors _] (validate @state)]
                         ;; (println "@@@" errors)
                         (if errors
                           (show-errors errors)
                           (submit @state))))}
          "submit"]
         [:button.btn.waves-effect.waves-light
          {:type "button"
           :on-click #(reset! state {})}
          "reset"]]]])))
