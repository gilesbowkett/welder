(ns welder.core
  (:require [clojure.string :as string]))

(def word-list (string/split-lines (slurp "resources/welder-word-list.txt")))

; usage; define this var with your tiles, then call something
; like (take 10 (lengthwise))
(def gold-tiles ["p" "m" "r" "n"])

(defn in? 
  "true if seq contains element"
  [seq element]  
  (boolean (some #(= element %) seq)))
  ; upgrade to some? when upgrading to latest clojure!

(defn is-gold? [word]
  (let [letters (string/split word #"")]
    (every? #(true? %) (map #(in? letters %) gold-tiles))))

(defn golden-words []
  (filter is-gold? word-list))

(defn lengthwise []
  (reverse (sort-by count (golden-words))))

(defn find-sub [pattern]
  (filter #(re-find (re-pattern pattern) %) (golden-words)))

(defn ending-in [substring]
  (find-sub (str substring "$")))

(defn starting-with [substring]
  (find-sub (str "^" substring)))

(defn containing [substring]
  (find-sub substring))

; determine if word contains substrings which are also in the word list
(defn sub-words [word]
  (vec (filter (fn [subword]
                   (and (< 3 (.length subword))
                        (not (= word subword))))
               (for [start (range 0 5), end (range 4 9)] (subs word start end)))))

(defn risks [word]
  (filter (fn [sub-word] (in? word-list sub-word)) (sub-words word)))

; fixme
;   entering "r" twice does not give you words with two Rs in them
;     this got me the subset with two Ls
;     (filter (fn [word] (re-find #"l.*l" word)) (golden-words))

