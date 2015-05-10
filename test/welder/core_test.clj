(ns welder.core-test
  (:use midje.sweet)
  (:use [welder.core]))

(facts "about finding sub-words"
  (fact "(sub-words) finds all possible sub-words"
    (sub-words "monocarp") => ["mono",
                               "monoc",
                               "monoca",
                               "monocar",
                               "onoc",
                               "onoca",
                               "onocar",
                               "onocarp",
                               "noca",
                               "nocar",
                               "nocarp",
                               "ocar",
                               "ocarp",
                               "carp"])

  (fact "(risks) tells you which sub-words are actually in the word list"
    (risks "monocarp") => ["mono", "carp"]))

