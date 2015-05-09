(ns welder.core
  (:require [clojure.string :as string]))

(def word-list (string/split (slurp "resources/welder-word-list.txt") #"\n"))

(def gold-tiles ["p" "m" "r" "n"])

(defn in? 
  "true if seq contains element"
  [seq element]  
  (some #(= element %) seq))

(defn is-gold? [word]
  (let [letters (string/split word #"")]
    (every? #(true? %) (map #(in? letters %) gold-tiles))))

(defn golden-words []
  (filter is-gold? word-list))

(defn lengthwise []
  (reverse (sort-by count (golden-words))))

; FIXME: dry (partial? composition?)
(defn ending-in [substring]
  (filter #(re-find (re-pattern (str substring "$")) %) (golden-words)))

(defn starting-with [substring]
  (filter #(re-find (re-pattern (str "^" substring)) %) (golden-words)))

(defn containing [substring]
  (filter #(re-find (re-pattern substring) %) (golden-words)))

; todo
;   search entire word list for particular string
;   determine if word contains substrings which are also in the word list
; fixme
;   entering "r" twice does not give you words with two Rs in them
;     this got me the subset with two Ls
;     (filter (fn [word] (re-find #"l.*l" word)) (golden-words))
