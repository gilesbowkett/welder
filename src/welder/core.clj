(ns welder.core
  (:require [clojure.string :as string]))

(def word-list (string/split (slurp "resources/welder-word-list.txt") #"\n"))

(def gold-tiles ["p" "s" "l" "e"])

(defn in? 
  "true if seq contains element"
  [seq element]  
  (some #(= element %) seq))

(defn is-gold? [word]
  (let [letters (string/split word #"")]
    (every? #(true? %) (map #(in? letters %) gold-tiles))))

(def golden-words (filter is-gold? word-list))

(def lengthwise (reverse (sort-by count golden-words)))

