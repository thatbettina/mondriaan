(ns mondriaan.core
  (:require [reagent.core :as reagent :refer [atom]]))

(enable-console-print!)

(println "Edits to this text should show up in your developer console.")

;; define your app data so that it doesn't get over-written on reload

(defonce app-state (atom {:text "Hello world!"}))

(defn line [x1 y1 x2 y2]
  [:line {:x1 x1 :y1 y1 :x2 x2 :y2 y2 :stroke-width 6 :stroke "black"}])



(defn rect [x y width height fill]
  [:rect {:x x :y y :width width :height height :fill fill}])

(defn canvas []
  [:svg {:width 500 :height 500}
   [rect 50 50 100 100 "red"]
   [rect 350 150 65 233 "blue"]
   [rect 200 420 70 70 "yellow"]

   ;; horizontal
   ;;         y1      y2
   [line 0    50 500  50]
   [line 0   150 500 150]
   [line 200 383 500 383]

   ;; vertical
   ;;    x1    x2
   [line 50 50 50 500]
   [line 350 0 350 500]
   [line 200 0 200 500]

   ])

(defn hello-world []
  [:div [:h1 "Mondriaan"]
        [:p "First Attempt to Mondriaan"]
        [canvas]])


(reagent/render-component [hello-world]
                          (. js/document (getElementById "app")))


(defn on-js-reload [])
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
